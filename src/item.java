import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;


public class item {
	
	
	public static String[] hq(){
		  
		  String path="musics/";
		  File file=new File(path);
		  File[] tempList = file.listFiles();
		  String h[] = new String[tempList.length];
		  System.out.println("��Ŀ¼�¶��������"+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
			  if (tempList[i].isFile()) {
				  if(tempList[i].getName().endsWith(".mp3")){
					  System.out.println("��     ����"+tempList[i]);
					  System.out.println(tempList[i].getName());
					  h[i]=tempList[i].getName();
				  }
				  
			  }
		 }
		  return h;
	}
	public int fh(){
		String path="musics/";
		  File file=new File(path);
		  File[] tempList = file.listFiles();
		  return tempList.length;
	}
	
	
	
	
	   public void fileChannelCopy(File s, File t) {

	        FileInputStream fi = null;

	        FileOutputStream fo = null;

	        FileChannel in = null;

	        FileChannel out = null;

	        try {

	            fi = new FileInputStream(s);

	            fo = new FileOutputStream(t);

	            in = fi.getChannel();//�õ���Ӧ���ļ�ͨ��

	            out = fo.getChannel();//�õ���Ӧ���ļ�ͨ��

	            in.transferTo(0, in.size(), out);//��������ͨ�������Ҵ�inͨ����ȡ��Ȼ��д��outͨ��

	        } catch (IOException e) {

	            e.printStackTrace();

	        } finally {

	            try {

	                fi.close();

	                in.close();

	                fo.close();

	                out.close();

	            } catch (IOException e) {

	                e.printStackTrace();

	            }

	        }

	    }
	   
	   
	  // try { 
      //  int bytesum = 0; 
      //     int byteread = 0; 
      //     if (f.exists()) { //�ļ�����ʱ 
      //         InputStream inStream = new FileInputStream(f); //����ԭ�ļ� 
      //         FileOutputStream fs = new FileOutputStream("musics/"+fn1); 
      //         int length; 
      //         while ( (byteread = inStream.read()) != -1) { 
       //            bytesum += byteread; //�ֽ��� �ļ���С 
      //             System.out.println(bytesum); 
     //              fs.write(byteread); 
      //         } 
      //         inStream.close(); 
      //     } 
      // } 
     //  catch (Exception e) { 
      //     System.out.println("��������ļ�����"); 
      //     e.printStackTrace(); 
      // }  
	
}
