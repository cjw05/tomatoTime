import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;

public class ThreadCopyFile {

    /**
     * @param args
     */
    
}
/**
 * ����ִ���ļ��Ŀ�������
 * @author haokui
 *
 */
class Copyer {

    private CopyThread[] threads;// ������п����̵߳�����

    /**
     * ʹ�ö��߳�ȥ����һ�����ļ�, 1 ��ʹ�ö��߳̽��п�����ʱ��,����Ҫ֪���ļ��Ĵ�С Ȼ������̵߳�����,�����ÿ���̵߳Ĺ���������
     * 2.Ȼ�󴴽��߳�,ִ�п����Ĺ���
     * 
     * @param scrFile
     *            Դ�ļ�
     * @param desPath
     *            Ŀ��·��
     * @param threadNum
     *            Ҫʹ�õ��߳�����
     */
    public  void copy(File srcFile, String desPath, int threadNum) {
        // 1.ȡ���ļ��Ĵ�С
        long fileLeng = srcFile.length();
        System.out.println("�ļ���С:" + fileLeng);

        // 2.�����߳�����,����ÿ���̵߳Ĺ�����
        long threadPerSize = fileLeng / threadNum;

        // 3.�����ÿ���̵߳Ŀ�ʼλ�úͽ���λ��
        long startPos = 0;
        long endPos = threadPerSize;

        // ȡ��Ŀ���ļ����ļ�����Ϣ
        String fileName = srcFile.getName();
        String desPathAndFileName = desPath + File.separator + fileName;

        // ��ʼ���̵߳�����
        threads = new CopyThread[threadNum];

        for (int i = 0; i < threadNum; i++) {
            // �����һ���̳߳е�ʣ��Ĺ�����
            if (i == threadNum - 1) {
                threads[i] = new CopyThread("�����߳�" + i, srcFile,
                        desPathAndFileName, startPos, fileLeng);
            } else {
                // ����һ���߳�
                threads[i] = new CopyThread("�����߳�" + i, srcFile,
                        desPathAndFileName, startPos, endPos);
            }
            startPos += threadPerSize;
            endPos += threadPerSize;
            
        }

        // ����ͳ���߳�
        new ScheduleThread("ͳ���߳�", fileLeng,threads );
    }
}
/**
 * ����ͳ���ļ��������ȵ��߳�
 * @author haokui
 *
 */
class ScheduleThread extends Thread {
    private long fileLength; // �ļ��Ĵ�С
    private CopyThread[] threads;// ������еĿ����̵߳�����

    /**
     * ͳ�ƽ����̵߳Ĺ��췽��
     * 
     * @param name
     *            �̵߳�����
     * @param fileLeng
     *            �ļ��ĳ���
     * @param threads
     *            �����̵߳�����
     */
    public ScheduleThread(String name, long fileLength, CopyThread[] threads) {
        super(name);
        this.fileLength = fileLength;
        this.threads = threads;

        this.start();
    }

    /**
     * �ж����еĿ����߳��Ƿ��Ѿ�����
     * 
     * @return �Ƿ����
     */
    private boolean isOver() {
        if (threads != null) {
            for (CopyThread t : threads) {
                if (t.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public  void run() {
        while (!isOver()) {
            long totalSize = 0;
            for (CopyThread t : threads) {
                totalSize += t.getCopyedSize();
            }
            /**
             * ���ڸ��ƹ���Ҫ����Щ�����ʱ��������΢�ӳ�һ�£����ü����̫Ƶ���������һ���̸߳���֮�����һ�Σ������ֱ�Ӹ��ӳ�һ�¾�ok��������ȷ�Ĵ����ˡ�
             */
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double schedule = Arith.div((double) totalSize,
                    (double) fileLength, 4);
            System.err.println("�ļ��Ŀ�������:===============>" + schedule * 100
                    + "%");
        }
        System.err.println("ͳ���߳̽�����");
    }
}
/**
 * �����߳�
 * @author haokui
 *
 */
class CopyThread extends Thread {
    private File srcFile;// Դ�ļ���·��
    private String desPath;// Ŀ��·��
    private long startPos; // �߳̿����Ŀ�ʼλ��
    private long endPost;// �߳̿����Ľ���λ��
    private long alreadyCopySize;// �߳��Ѿ�������λ��

    private RandomAccessFile rin; // ��ȡ�ļ��������
    private RandomAccessFile rout;// д���ļ��������

    /**
     * ȡ�� �߳��Ѿ������ļ��Ĵ�С
     * 
     * @return �߳��Ѿ������ļ��Ĵ�С
     */
    public long getCopyedSize() {
        return alreadyCopySize - startPos;
    }

    /**
     * �̵߳Ĺ��췽��
     * 
     * @param threadName
     *            �̵߳�����
     * @param scrFile
     *            Դ�ļ�
     * @param desPathAndName
     *            Ŀ���ļ���·����������
     * @param startPos
     *            �̵߳Ŀ�ʼλ��
     * @param endPost
     *            �̵߳Ľ���λ��
     */
    public CopyThread(String threadName, File srcFile, String desPathAndName,
            long startPos, long endPos) {
        super(threadName);
        this.srcFile = srcFile;
        this.desPath = desPath;
        this.startPos = startPos;
        this.endPost = endPos;
        this.alreadyCopySize = this.startPos;

        // System.out.println(this.getName() + "��ʼλ��:" + startPos + " ����λ��:"
        // + endPos);

        // ��ʼ�����������,�����
        try {
            rin = new RandomAccessFile(srcFile, "r");
            rout = new RandomAccessFile(desPathAndName, "rw");

            // ��λ������Ŀ�ʼλ��
            rin.seek(startPos);
            rout.seek(startPos);

            // ��ʼ�߳�
            this.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void run() {
        int len = 0;
        byte[] b = new byte[1024];

        try {
            while ((alreadyCopySize < endPost) && (len = rin.read(b)) != -1) {
                alreadyCopySize = alreadyCopySize + len;
                if (alreadyCopySize >= this.endPost) {
                    int oldSize = (int) (alreadyCopySize - len);
                    len = (int) (this.endPost - oldSize);
                    alreadyCopySize = oldSize + len;
                }
                rout.write(b, 0, len);
            }
            System.out.println(this.getName() + " �ڹ���: ��ʼλ��:" + this.startPos
                    + "  ������:" + (this.endPost - this.startPos)  + " ����λ��:"
                    + this.endPost);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rin != null) {
                    rin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (rout != null) {
                    rout.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

/**
 * ����Java�ļ����Ͳ��ܹ���ȷ�ĶԸ������������㣬
 * ����������ṩ�� ȷ�ĸ��������㣬�����Ӽ��˳����������롣
 * @author haokui
 *
 */
class Arith {
    // Ĭ�ϳ������㾫��
    private static final int DEF_DIV_SCALE = 10;

    // ����಻��ʵ����
    private Arith() {
    }

    /**
     * �ṩ��ȷ�ļӷ����㡣
     * 
     * @param v1
     *            ������
     * @param v2
     *            ����
     * @return ���������ĺ�
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * �ṩ��ȷ�ļ������㡣
     * 
     * @param v1
     *            ������
     * @param v2
     *            ����
     * @return ���������Ĳ�
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * �ṩ��ȷ�ĳ˷����㡣
     * 
     * @param v1
     *            ������
     * @param v2
     *            ����
     * @return ���������Ļ�
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ�� С�����Ժ�10λ���Ժ�������������롣
     * 
     * @param v1
     *            ������
     * @param v2
     *            ����
     * @return ������������
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ �����ȣ��Ժ�������������롣
     * 
     * @param v1
     *            ������
     * @param v2
     *            ����
     * @param scale
     *            ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
     * @return ������������
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * �ṩ��ȷ��С��λ�������봦��
     * 
     * @param v
     *            ��Ҫ�������������
     * @param scale
     *            С���������λ
     * @return ���������Ľ��
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
};