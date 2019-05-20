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
		  System.out.println("该目录下对象个数："+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
			  if (tempList[i].isFile()) {
				  if(tempList[i].getName().endsWith(".mp3")){
					  System.out.println("文     件："+tempList[i]);
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

	            in = fi.getChannel();//得到对应的文件通道

	            out = fo.getChannel();//得到对应的文件通道

	            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

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
      //     if (f.exists()) { //文件存在时 
      //         InputStream inStream = new FileInputStream(f); //读入原文件 
      //         FileOutputStream fs = new FileOutputStream("musics/"+fn1); 
      //         int length; 
      //         while ( (byteread = inStream.read()) != -1) { 
       //            bytesum += byteread; //字节数 文件大小 
      //             System.out.println(bytesum); 
     //              fs.write(byteread); 
      //         } 
      //         inStream.close(); 
      //     } 
      // } 
     //  catch (Exception e) { 
      //     System.out.println("添加音乐文件出错"); 
      //     e.printStackTrace(); 
      // }  
	
}
