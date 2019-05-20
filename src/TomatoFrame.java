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
	String sj="������";
	public void zxh(){
		//��С��
		if(zxh1){
		if (SystemTray.isSupported())
        {  
            SystemTray tray = SystemTray.getSystemTray();
            PopupMenu popup = new PopupMenu();
            Image image = Toolkit.getDefaultToolkit().getImage("image/add.JPG");
            MenuItem defaultItem = new MenuItem("��");  
            defaultItem.addActionListener(new ActionListener() {  
            	  
                public void actionPerformed(ActionEvent e) {  
                	
            		e1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            		e1.setVisible(true);
                }  
            }); 
            
            
            defaultItem.addActionListener(this);  
            MenuItem exitItem = new MenuItem("�˳�");  
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
            trayIcon = new TrayIcon(image, sj, popup);// ����trayIcon  
            trayIcon.addActionListener(this);//��Сͼ����ϼ�������Ĭ�ϵľ��Ǽ���˫����  
//���ż���������ɶ��  �ͼ�mouselistener  
            
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
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	    	String date = df.format(new Date());
			try {  
			//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�  
			File f=new File("./�ռ�.txt");  
			fw = new FileWriter(f, true);  
			} catch (IOException e) {  
			e.printStackTrace();  
			}  
			PrintWriter pw = new PrintWriter(fw);  
			String a=date+"����\t\t"+"����ѧϰ��"+countt+"�������ӡ��������Ŭ��������";
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
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
    	String date = df.format(new Date());
    	File fw=new File("./�ռ�.txt"	);
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
					String[] zdl={"֪����"};
					JOptionPane.showOptionDialog(new JFrame().getContentPane(), 
							"��û��ʼ����ôֹͣ��", "��ʾ",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,null, zdl, null);
				}
				
			
		}
		if(e.getSource()==sc){
			String a="musics/"+h[gq.getSelectedIndex()];
			File f=new File(a);
			f.delete();
			gq.setListData(it.hq());
		}
		if(e.getSource()==bf1){
			System.out.println("����1");
			if(fb){
				System.out.println("����");
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
			if(startt.getText()=="��ʼ������"){
				running=true;
				pause=false;
				fb=true;
				startt.setText("��ͣ������");
				setExtendedState(JFrame.ICONIFIED);
			}else if(startt.getText()=="��ͣ������"){
				
				zt();
				
			}else if(startt.getText()=="����������"){
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
		//������
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
		this.setTitle("������");
		this.setBackground(Color.WHITE);
		p1=new JPanel();
		tj=new JButton("��Ӹ���");
		tj.addActionListener(this);
		sc=new JButton("ɾ������");
		sc.addActionListener(this);
		ButtonGroup bf=new ButtonGroup();  
		random1=new JRadioButton("�������");
		random1.addItemListener(itemlistener);
		loop1=new JRadioButton("˳�򲥷�",true); 
		loop1.addItemListener(itemlistener);
		zt=new JButton("ֹͣ����");
		zt.addActionListener(this);
		yl=new JSlider();
		yll=new JTextField("100");
		yl.setValue(100);
		yl.setPaintTicks(true);
		yl.addChangeListener(changeListener);
		yll.setEnabled(false);
		bf1=new JButton("��ʼ����");
		bf1.addActionListener(this);
		p1.add(yl);
		p1.add(yll); 
		if(it.fh()==0){
			JLabel gq=new JLabel("��ǰ�ļ�����û���ļ�������������ļ�����Ҫ����ʹ�ã�");
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
		
		startt=new JButton("��ʼ������");
		l1=new JLabel("00:00");
		l2=new JLabel("������ѧϰʱ��");
		l3=new JLabel("�����ǵ�"+countt+"��������");
		Font f = new Font("����",Font.PLAIN,32); 
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
		
		System.out.println("��ʼ��");
		
		
		
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
		startt.setText("��ͣ������");
	}
	public void zt(){
			tr=true;
			startt.setText("����������");
			ts();
			
	}
	
	
	public String addm(){
		//��Ӹ���
		System.out.println("wwww");
		JFileChooser jf = new JFileChooser(); 
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ѡ����ӵ����֣�Ŀǰֻ֧��MP3�ͣ�","mp3");
		jf.setCurrentDirectory(new File("E:/"));
		jf.setFileFilter(filter);
		jf.showOpenDialog(this);
		File f =  jf.getSelectedFile();
		if(f==null){
			System.out.println("ȡ����Ӹ���");
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
		//������ʾ��
		Object[] options = {"������ͣ��"};
		int qr=JOptionPane.showOptionDialog(new JFrame().getContentPane(), 
				"�����Ӳ��Ƽ���ͣ��", "�������ѣ�",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		
			
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
			System.out.println("��ͣ��");
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
				System.out.println("���"+rn);
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
			l3.setText("�����ǵ�"+countt+"��������");;
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
					l2.setText("��������Ϣʱ��");
				}else{
					timess=initTime(2);
					qh1();
					l2.setText("��������Ϣʱ��");
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
			l2.setText("������ѧϰʱ��");
			System.out.println("��ͣ����");
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
