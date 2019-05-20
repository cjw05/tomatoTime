import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.Scrollbar;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.AudioDeviceFactory;
import javazoom.jl.player.Player;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.sound.midi.Soundbank;
import javax.sound.sampled.*;

import java.sql.Struct;
import java.text.SimpleDateFormat;

public class TomatoFrame extends JFrame implements ActionListener {

	item it;
	Thread tt;
	String fn;
	JPanel p1;
	boolean fb=true;
	private int iy=0;
	boolean uu=true;
	boolean ui=true;
	boolean tr=false;
	boolean xh=true;
	boolean qr1;
	bfq bfq1;
	public Player player;
	int countt=0;
	int timess=0;
	int min,second;
	JSlider yl;
	Soundbank sb;
	AudioInputStream audioInputStream;
	ItemListener itemlistener;
	static boolean running,pause;
	JButton tj,aj,startt,bf1,sc,zt;
	JLabel l2,l3,l4;
	JLabel l1;
	JTextField yll;
	JList<String> gq;
	String[] h=it.hq();
	JRadioButton loop1,random1;
	private DocumentListener documentListener;
	private ChangeListener changeListener;
	TrayIcon trayIcon = null;  
	MouseListener mouselistener;
	boolean zxh1=true;
	boolean be=false;
	static TomatoFrame e1;
	AudioSystem as;
	
	public TomatoFrame(){
		super();
		zxh();
		init();
	}
	String sj="番茄钟";
	public void zxh(){
		//最小化
		if(zxh1){
		if (SystemTray.isSupported())
        {  
            SystemTray tray = SystemTray.getSystemTray();
            PopupMenu popup = new PopupMenu();
            Image image = Toolkit.getDefaultToolkit().getImage("image/add.JPG");
            MenuItem defaultItem = new MenuItem("打开");  
            defaultItem.addActionListener(new ActionListener() {  
            	  
                public void actionPerformed(ActionEvent e) {  
                	
            		e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            		e1.setVisible(true);
                }  
            }); 
            
            
            defaultItem.addActionListener(this);  
            MenuItem exitItem = new MenuItem("退出");  
            exitItem.addActionListener(new ActionListener() {  
  
                public void actionPerformed(ActionEvent e) {
                	if(countt!=0){
                	try {
						rz();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	}
                    System.exit(0);  
                }  
            });  
  
            popup.add(defaultItem);  
            popup.add(exitItem); 
            trayIcon = new TrayIcon(image, sj, popup);// 创建trayIcon  
            trayIcon.addActionListener(this);//给小图标加上监听器，默认的就是监听双击。  
//如果偶想监听单击啥的  就加mouselistener  
            
            try {  
                tray.add(trayIcon);  
                zxh1=false;
            } catch (AWTException e1) {  
                e1.printStackTrace();  
            }  
        }
		
		}
	}
	private void rz() throws IOException{
			FileWriter fw = null;  
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    	String date = df.format(new Date());
			try {  
			//如果文件存在，则追加内容；如果文件不存在，则创建文件  
			File f=new File("./日记.txt");  
			fw = new FileWriter(f, true);  
			} catch (IOException e) {  
			e.printStackTrace();  
			}  
			PrintWriter pw = new PrintWriter(fw);  
			String a=date+"结束\t\t"+"今天学习了"+countt+"个番茄钟。明天继续努力！！！";
			pw.println(a);  
			pw.flush();  
			try {  
			fw.flush();  
			pw.close();  
			fw.close();  
			} catch (IOException e) {  
			e.printStackTrace();  
			}    
		
	
		/*String encoding = "UTF-8";
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	String date = df.format(new Date());
    	File fw=new File("./日记.txt"	);
    	Long filelength=fw.length();
   	 byte[] filecontent = new byte[filelength.intValue()];  
    	 InputStreamReader isr = new InputStreamReader(new FileInputStream(fw), "UTF-8");
    	 BufferedReader br=new BufferedReader(isr);
    	 String line=null;
    	 String a="";
    	 while((line=br.readLine()) !=null){
    		 a+=line+"\n";
    	 }*/

    	 
    	 
    	 
    	 
	}
	private void While(boolean b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==zt){
			
				if(be){
				bfq1.zt();
				fb=true;
				be=false;
				}else{
					String[] zdl={"知道了"};
					JOptionPane.showOptionDialog(new JFrame().getContentPane(), 
							"还没开始呢怎么停止！", "提示",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,null, zdl, null);
				}
				
			
		}
		if(e.getSource()==sc){
			String a="musics/"+h[gq.getSelectedIndex()];
			File f=new File(a);
			f.delete();
			gq.setListData(it.hq());
		}
		if(e.getSource()==bf1){
			System.out.println("播放1");
			if(fb){
				System.out.println("播放");
			bfq1=new bfq();
			bfq1.start();
			be=true;
			
			}
			
			
		}
		if(e.getSource()==tj){
			addm();
			
		}
		
		if(e.getSource()==startt){
			boolean y=true;
			
			if(y=true){
				new djs().start();
				
				y=false;
			
			}	
			if(startt.getText()=="开始番茄钟"){
				running=true;
				pause=false;
				fb=true;
				startt.setText("暂停番茄钟");
				setExtendedState(JFrame.ICONIFIED);
			}else if(startt.getText()=="暂停番茄钟"){
				
				zt();
				
			}else if(startt.getText()=="继续番茄钟"){
				jx();
				setExtendedState(JFrame.ICONIFIED);
			}
		}
		
	}
	
	public void tjyl() throws Exception, IOException{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
			    new File("music/"+h[iy]));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-50.0f); // Reduce volume by 10 decibels.
			clip.start();
	}
	
	public void init(){
		jtq();
		mb();
		
	}
	
	public void jtq(){
		//监听器
		changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                System.out.println("stateChanged called");
                // update textField when the slider value changes
                if (event.getSource() instanceof JSlider) {
                    JSlider source = (JSlider) event.getSource();
                    yll.setText("" + source.getValue());
                    System.out.println(source.getValue());
                    
                    
                    
                }
            }
        };
        
        itemlistener=new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItemSelectable()==loop1){
					xh=true;
					System.out.println("yyyy");
				}
				if(e.getItemSelectable()==random1){
					xh=false;
					System.out.println("fffff");
				}
			}
		};
        
	}
	
	public void playm(String fn){
		this.fn=fn;
	}
	
	public void play() {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(fn));
            player = new Player(buffer);
            player.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public void mb(){
		it=new item();
		this.setBounds(50, 200,1200,500);
		this.setTitle("番茄钟");
		this.setBackground(Color.WHITE);
		p1=new JPanel();
		tj=new JButton("添加歌曲");
		tj.addActionListener(this);
		sc=new JButton("删除歌曲");
		sc.addActionListener(this);
		ButtonGroup bf=new ButtonGroup();  
		random1=new JRadioButton("随机播放");
		random1.addItemListener(itemlistener);
		loop1=new JRadioButton("顺序播放",true); 
		loop1.addItemListener(itemlistener);
		zt=new JButton("停止播放");
		zt.addActionListener(this);
		yl=new JSlider();
		yll=new JTextField("100");
		yl.setValue(100);
		yl.setPaintTicks(true);
		yl.addChangeListener(changeListener);
		yll.setEnabled(false);
		bf1=new JButton("开始播放");
		bf1.addActionListener(this);
		p1.add(yl);
		p1.add(yll); 
		if(it.fh()==0){
			JLabel gq=new JLabel("当前文件夹里没有文件，请加入音乐文件或不需要音乐使用！");
			bf1.setEnabled(false);
			zt.setEnabled(false);
			sc.setEnabled(false);
			p1.add(gq);
		}
		else{
		gq=new JList<String>(it.hq());
		gq.setSelectedIndex(0);
		bf1.setEnabled(true);
		zt.setEnabled(true);
		sc.setEnabled(true);
		p1.add(gq);
		}
		
		bf.add(random1);  
        bf.add(loop1);  
        
		p1.add(tj);
		p1.add(sc);
		p1.add(bf1);
		p1.add(zt);
		p1.add(random1);
		p1.add(loop1);
		p1.setBackground(Color.black);
		p1.setVisible(true);
		
		JPanel p2=new JPanel();
		
		startt=new JButton("开始番茄钟");
		l1=new JLabel("00:00");
		l2=new JLabel("现在是学习时间");
		l3=new JLabel("现在是第"+countt+"个番茄钟");
		Font f = new Font("宋体",Font.PLAIN,32); 
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		startt.addActionListener(this);
		
		p2.add(l2);
		p2.add(l1,BorderLayout.CENTER);
		p2.add(startt, BorderLayout.NORTH);
		p2.add(l3);
		p2.setVisible(true);
		p2.setBounds(0, 201, 400, 300);
		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.SOUTH);
		
		System.out.println("初始化");
		
		
		
	}
	
	public void sc1(){
		
		Copyer copyer = new Copyer();
		String a="musics/"+h[gq.getSelectedIndex()];
		File f=new File(a);
		copyer.copy(f, "recycle/", 20);
	
	}
	
	public void ts2(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		e1=new TomatoFrame();
		e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		e1.setVisible(true);
	}

	
	
	

	public void jx(){
		tr=false;
		startt.setText("暂停番茄钟");
	}
	public void zt(){
			tr=true;
			startt.setText("继续番茄钟");
			ts();
			
	}
	
	
	public String addm(){
		//添加歌曲
		System.out.println("wwww");
		JFileChooser jf = new JFileChooser(); 
		FileNameExtensionFilter filter = new FileNameExtensionFilter("选择添加的音乐（目前只支持MP3和）","mp3");
		jf.setCurrentDirectory(new File("E:/"));
		jf.setFileFilter(filter);
		jf.showOpenDialog(this);
		File f =  jf.getSelectedFile();
		if(f==null){
			System.out.println("取消添加歌曲");
			return null;
		}else{  
		String s = f.getAbsolutePath();
		String fn1=f.getName();
		Copyer copyer = new Copyer();
        copyer.copy(f, "musics/", 10);
		gq.setListData(it.hq());
		
		return s;
		}
	}
	
	
	public void ts(){
		//弹出提示框
		Object[] options = {"狠心暂停！"};
		int qr=JOptionPane.showOptionDialog(new JFrame().getContentPane(), 
				"番茄钟不推荐暂停！", "严重提醒！",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		
			
		}
	

	class djs extends Thread{
	public void run() {
		
		// TODO Auto-generated method stub
		while(true){
		while(running){
			while(tr){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			xuexi();
           	 sj=l2.getText()+l1.getText();
			trayIcon.setToolTip(sj);;
			try{
				sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		while(pause){
			while(tr){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			xiuxi();
			try{
				sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		}
	}
	}
	
	class bfq extends Thread{
		
		public void run(){
			if(fb){
			while(true){
				yq();
			}
			}
		}
		private void zt(){
			this.stop();
			System.out.println("暂停？");
		}
		private void yq() {
			// TODO Auto-generated method stub
			fb=false;
			if(xh==true){
				for(iy=gq.getSelectedIndex();iy<h.length;iy++){
					gq.setSelectedIndex(iy);
					playm("musics/"+h[iy]);
					play();
					
					if(iy==h.length-1){
						gq.setSelectedIndex(0);
					}
				}
			}else if(xh==false){
				Random random=new Random();
				int rn = random.nextInt(h.length) ;
				System.out.println("随机"+rn);
				gq.setSelectedIndex(rn);
				playm("musics/"+h[rn]);
				play();
			}
			
		}
		
	}
	
	class tx extends Thread{
		public void run(String a){
			playm(a);
			play();
		}
		
		
		
		
	}
	
	public int initTime(int a){
		int times=0;
		if(a==1){
			times=1501;
			countt++;
			l3.setText("现在是第"+countt+"个番茄钟");;
			new tx().run("tx/xuexi.mp3");
			
		}
		if(a==2){
			times=301;
			new tx().run("tx/xiuxi.mp3");
		}
		if(a==3){
			times=1801;
			new tx().run("tx/xiuxi.mp3");
		}
		return times;
	}
	
	public void xuexi(){
		timess--;
		second=timess % 60;
		min=(timess-second)/60;
		if(timess>0){
			if(second<10 || min<10){
				if(second<10 && min<10){
					l1.setText("0"+min+":0"+second);
				}else if(second<10){
					l1.setText(min+":0"+second);
				}else if(min<10){
					l1.setText("0"+min+":"+second);
				}
			}else{
		    l1.setText(min+":"+second);
			}
		}
		if(countt!=0){
			if(timess<=0){
				if(countt==4 || countt==8 || countt==12){
					timess=initTime(3);
					qh1();
					l2.setText("现在是休息时间");
				}else{
					timess=initTime(2);
					qh1();
					l2.setText("现在是休息时间");
				}
				if(countt!=0){
					
				}
			}
		}else if(countt==0){
			timess=initTime(1);
		}
		
	}
	
	public void xiuxi(){
		timess--;
		second=timess % 60;
		min=(timess-second)/60;
		if(timess>0){
			if(second<10 || min<10){
				if(second<10 && min<10){
					l1.setText("0"+min+":0"+second);
				}else if(second<10){
					l1.setText(min+":0"+second);
				}else if(min<10){
					l1.setText("0"+min+":"+second);
				}
			}else{
		    l1.setText(min+":"+second);
			}
		}
		if(timess<=0){
			timess=initTime(1);
			qh2();
			l2.setText("现在是学习时间");
			System.out.println("暂停结束");
		}
	}
	
	public void qh1(){
		running=false;
		pause=true;
		tr=false;
	}
	public void qh2(){
		running=true;
		pause=false;
		tr=false;
		
	}
	
}
