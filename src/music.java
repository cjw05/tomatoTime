import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class music{
	
	public music(){
		
	}
	
	public void im(){
		try {   
			String filename=name("1");
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));   
         
        } catch (Exception e) {   
             System.out.println(e);   
        }   
	}
	public String name(String name){
		return name;
	}
}
