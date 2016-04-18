package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Domain.LeaveApplication;
import Domain.Staff;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.Test;

public class StaffManagementUI extends JFrame{
	   
	  static ArrayList<Staff> staff = new ArrayList<Staff>();
	  static ArrayList<LeaveApplication> applyleave = new ArrayList<LeaveApplication>();
	
	  public  StaffManagementUI(){
		  JFrame frame1 = new JFrame("CreateStaff");
		  frame1.setSize(500,300);
		  frame1.setLocation(100,100);
		  
		  JPanel panel = new JPanel();
     	  panel.setLayout(new BorderLayout(50,50));
     	  frame1.add(panel);
          
          JPanel panel1 = new JPanel();
          panel.add(panel1,BorderLayout.NORTH);
          
          JPanel panel2 = new JPanel();
          panel2.setLayout(new GridLayout(6,2));
          panel.add(panel2,BorderLayout.CENTER);
          
          JLabel silabel = new JLabel("StaffID",SwingConstants.CENTER);
          JTextField textfield1 = new JTextField("",10);
          JLabel snlabel = new JLabel("StaffName",SwingConstants.CENTER);
          JTextField textfield2 = new JTextField("",10);
          JLabel glabel = new JLabel("Gender",SwingConstants.CENTER);
          JTextField textfield3 = new JTextField("",10);
          JLabel slabel = new JLabel("Supervisor",SwingConstants.CENTER);
          JLabel slabel1 = new JLabel("",SwingConstants.CENTER);
          //JTextField textfield4 = new JTextField("",10);
          JButton save = new JButton("SAVE");
          JButton back = new JButton("DELETE STAFF");
          
          
          panel2.add(silabel);
          panel2.add(textfield1);
          panel2.add(snlabel);
          panel2.add(textfield2);
          panel2.add(glabel);
          panel2.add(textfield3);
          panel2.add(slabel);
          panel2.add(slabel1);
          panel2.add(save);
          panel2.add(back);
          

          
          
          
          ActionListener actionlistern1 = new ActionListener(){
          	
     		 public void actionPerformed(ActionEvent e){
     			 if (textfield1.getText().length() == 0 ||textfield2.getText().length() == 0 ||textfield3.getText().length() == 0){
     				 JOptionPane.showMessageDialog(StaffManagementUI.this,"Please input all the information");
     			 }
     			 else{
     				 JOptionPane.showMessageDialog(StaffManagementUI.this,"Save Success" );
     			 }
     			 
     			//字母转化为ascii码
      	         String a = textfield2.getText();
      	          char[] chars = a.toCharArray();
      	          for(int i = 0; i < chars.length; i++){
      	        	  if(chars.length == 0){
      	        		  slabel1.setText("N");
      	        	  }
      	        	  else{
      	        		  int b = (int)(chars[i]-1);
      	        		  char c = (char)b;
      	        		  String str = String.valueOf(c);
      	        		  slabel1.setText(str);
      	        		  
      	        	  }
      	        		  
      	          } 
     			 
     			 CreateStaff(); //Create the list

     			for(int i = 0;i<staff.size();i++){
     			
     	    	
     	    		System.out.printf((String)staff.get(i).getStaffID());
     	    		System.out.printf((String)staff.get(i).getStaffName());
     	    		System.out.printf((String)staff.get(i).getGender());
     	    		System.out.printf((String)staff.get(i).getSupervisor());
     	    	 }
            	
     		 }

			private void CreateStaff() {
				// TODO Auto-generated method stub
				
				staff.add(new Staff(textfield1.getText(), textfield2.getText(), textfield3.getText(), slabel1.getText()));
     			
     		 
			}
     	 };
     	 save.addActionListener(actionlistern1);
         
          frame1.add(panel);
          frame1.pack();
          frame1.setVisible(true);
          
          
          
    //delete staff frame      
          JFrame frame2 = new JFrame("Delete Staff");
          frame2.setSize(500,300);
          frame2.setLocation(100,400);
     	    
     	    JPanel panel3 = new JPanel();
     	    panel3.setLayout(new BorderLayout(50,50));
     	    frame2.add(panel3);
     	    
     	    JPanel panel4 = new JPanel();
     	    panel3.add(panel4,BorderLayout.NORTH);
     	    
     	    JPanel panel5 = new JPanel();
     	    panel5.setLayout(new GridLayout(5,2));
     	    JLabel label1 = new JLabel("Staff ID",SwingConstants.CENTER);
     	    JLabel label2 = new JLabel("Staff Name",SwingConstants.CENTER);
     	    JLabel label3 = new JLabel("Gender",SwingConstants.CENTER);
     	    JLabel label4 = new JLabel("Supervisor",SwingConstants.CENTER);
     	    JTextField textfield5 = new JTextField("",20);
     	    JTextField textfield6 = new JTextField("",20);
     	    JTextField textfield7 = new JTextField("",20);
     	    JTextField textfield8 = new JTextField("",20);
     	    JButton dbutton = new JButton("Delete");
     	    JButton bbutton = new JButton("Back");
     	    panel5.add(label1);
     	    panel5.add(textfield5);
     	    panel5.add(label2);
     	    panel5.add(textfield6);
     	    panel5.add(label3);
    	    panel5.add(textfield7);
    	    panel5.add(label4);
     	    panel5.add(textfield8);
     	    panel5.add(dbutton); 
     	    panel5.add(bbutton);
     	    panel3.add(panel5,BorderLayout.CENTER);
     	    
     	    
     	 ActionListener actionlistern3 = new ActionListener(){
   		 public void actionPerformed(ActionEvent e){
   			JOptionPane.showMessageDialog(StaffManagementUI.this,"The Staff`s Supervisor Have Been Sent The Notify E-mail");
   			
   		//	System.out.println(staff.size());
   			
   	   	for(int i = 0;i<staff.size();i++){
   			  if (staff.get(i).equals(textfield5.getText(),textfield6.getText(),textfield7.getText(),textfield8.getText()))
   				{
   				staff.remove(i);
   				}
   			  
   	    	 }
   		 
   		for(int i = 0;i<staff.size();i++){
 			
   			    System.out.printf((String)staff.get(i).getStaffID());
	    		System.out.printf((String)staff.get(i).getStaffName());
	    		System.out.printf((String)staff.get(i).getGender());
	    		System.out.printf((String)staff.get(i).getSupervisor());
	    	 }
    	
		 }
   		 
   	 };
   	 dbutton.addActionListener(actionlistern3);
 
   	ActionListener actionlistern2 = new ActionListener(){
		 public void actionPerformed(ActionEvent e){
			 
 			 frame2.setVisible(true);
		 }
	 };
	 back.addActionListener(actionlistern2);
	 
	 
//system entrance
	 JFrame frameety = new JFrame("System Entrance");
	  frameety.setSize(500,300);
	  frameety.setLocation(100,100);
	  
	  JPanel panelety = new JPanel();
	  panelety.setLayout(new BorderLayout(50,50));
     frameety.add(panelety);
     
     JPanel panelety1 = new JPanel();
     panelety.add(panelety1,BorderLayout.NORTH);
     
     JPanel panelety2 = new JPanel();
     panelety.add(panelety2,BorderLayout.CENTER);
     JButton smbutton = new JButton("Staff Management");
     JButton labutton = new JButton("Leave Application");
     panelety2.add(smbutton);
     panelety2.add(labutton);
   		 
     ActionListener actionlisternety1 = new ActionListener(){
		 public void actionPerformed(ActionEvent e){
		//framlog.setVisible(true);
			 new StaffManagementUI();
			frameety.setVisible(false);
		 }
	 };
	 smbutton.addActionListener(actionlisternety1);
	 
	  
	 
	 //back button fuction of frmae2  	 
	   	ActionListener actionlistern4 = new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 frameety.setVisible(true);
				 frame1.setVisible(false);
				 frame2.setVisible(false);
			 }
		 };
		 bbutton.addActionListener(actionlistern4); 
	 
//log in frame	 
		 JFrame framelog = new JFrame();
    	 framelog.setSize(500,300);
    	 framelog.setLocation(100,100);
   	     
   	     JPanel panellog = new JPanel();
   	     panellog.setLayout(new BorderLayout(50,50));
   	     framelog.add(panellog);
         
         JPanel panellog1 = new JPanel();
         panellog.add(panellog1,BorderLayout.NORTH);
         
         JPanel panellog2 = new JPanel();
         panellog2.setLayout(new GridLayout(3,3));
         panellog.add(panellog2,BorderLayout.CENTER);
   	     
   	     JLabel labellog1 = new JLabel("StaffName");
   	     JTextField textfieldlog1 = new JTextField("",10);
   	     JLabel labelblanklog1 = new JLabel("");
   	     JLabel labellog2 = new JLabel("Password");
	     JTextField textfieldlog2 = new JTextField("",10);
	     JLabel labelblanklog2 = new JLabel("");
	     JButton apply = new JButton("Apply");
	     JButton handle = new JButton("Handle");
	     JButton myhome = new JButton("MyHome");
	     
   	     panellog2.add(labellog1);
   	     panellog2.add(textfieldlog1);
   	     panellog2.add(labelblanklog1);
   	     panellog2.add(labellog2);
	     panellog2.add(textfieldlog2);
	     panellog2.add(labelblanklog2);
	     panellog2.add(apply);
	     panellog2.add(handle);
	     panellog2.add(myhome);

 //leave application button function
   	  ActionListener actionlisternety2 = new ActionListener(){
  		 public void actionPerformed(ActionEvent e){
  			framelog.setVisible(true);
  			setVisible(false);
  		 }
  	 };
  	 labutton.addActionListener(actionlisternety2);
   	     
//apply leave frame
	 JFrame framela = new JFrame("Leave Application");
	 framela.setSize(500,300);
	 framela.setLocation(100,100);
	  
	 JPanel panella = new JPanel();
	 panella.setLayout(new BorderLayout(50,50));
     framela.add(panella);
     
     JPanel panella1 = new JPanel();
     JLabel labella1 = new JLabel("Welcome To The LeaveApplication System");
     JButton logout = new JButton("Log Out");
     panella1.add(labella1);
     panella1.add(logout);
     panella.add(panella1,BorderLayout.NORTH);
     
     JPanel panella2 = new JPanel();
     panella2.setLayout(new GridLayout(5,2));
     JLabel labella2 = new JLabel("Staff ID");
     JLabel labella3 = new JLabel("Staff Name");
     JLabel labella4 = new JLabel("From Date");
     JLabel labella5 = new JLabel("To Date");
     JTextField textfieldla1 = new JTextField("",10);
     JTextField textfieldla2 = new JTextField("",10);
     JTextField textfieldla3 = new JTextField("",10);
     JTextField textfieldla4 = new JTextField("",10);
     JButton ok = new JButton("OK");
     panella2.add(labella2);
     panella2.add(textfieldla1);
     panella2.add(labella3);
     panella2.add(textfieldla2);
     panella2.add(labella4);
     panella2.add(textfieldla3);
     panella2.add(labella5);
     panella2.add(textfieldla4);
     panella2.add(ok);
     panella.add(panella2,BorderLayout.CENTER);
     
     ActionListener actionlisternla1 = new ActionListener(){
 		 public void actionPerformed(ActionEvent e){
 			framelog.setVisible(true);
 			
 		 }
 	 };
 	 logout.addActionListener(actionlisternla1);
 	 
 	ActionListener actionlisternla2 = new ActionListener(){
		 public void actionPerformed(ActionEvent e){
			 JOptionPane.showMessageDialog(StaffManagementUI.this,"The Application Has Been Sent To Supervisors" );
			 
			 CreateApply();
			 
			 
			 for(int i = 0;i<applyleave.size();i++){
			
				System.out.printf((String)applyleave.get(i).getStaffID());
  	    		System.out.printf((String)applyleave.get(i).getStaffName());
  	    		System.out.printf((String)applyleave.get(i).getFromDate());
  	    		System.out.printf((String)applyleave.get(i).getToDate());
  	    	 }
			
		 }

		private void CreateApply() {
			// TODO Auto-generated method stub
			applyleave.add(new LeaveApplication(textfieldla1.getText(),textfieldla2.getText(),textfieldla3.getText(),textfieldla4.getText()));
		}
	 };
	 ok.addActionListener(actionlisternla2);
 	 
	
 	 
 //apply button function	 
     ActionListener actionlisternlog1 = new ActionListener(){
 		 public void actionPerformed(ActionEvent e){
 			if(textfieldlog1.getText().equals("A")){
 				JOptionPane.showMessageDialog(StaffManagementUI.this,"You Cannot Apply Leave" );
 			}
 			else{
 				framela.setVisible(true); 
 			}
 		 }
 	 };
 	 apply.addActionListener(actionlisternlog1);
     
//handle frame
	   JFrame frameh = new JFrame("Handle Applcation");
	   frameh.setSize(500,300);
	   frameh.setLocation(100,100);
	   
	   JPanel panelh = new JPanel();
	   panelh.setLayout(new BorderLayout(50,50));
	   JPanel panelh1 = new JPanel();
	   JPanel panelh2 = new JPanel();
	   
	
	  
	   JTable table = new JTable(new DefaultTableModel(new Object[][]{{"11"},{"22"},{"33"}}, new String[]{"StaffName","FromDate","ToDate","Endorse","Decline"})){
		  @Override
		     public boolean isCellEditable(int row, int column) {
		     return false;  
		  }
	   };//column and row cannot edit
/*
	   JTable table;
	   for(int i = 0;i<applyleave.size();i++){
			
			String a1 =(String)applyleave.get(i).getStaffID();
			String a2 =	(String)applyleave.get(i).getStaffName();
			String a3 =	(String)applyleave.get(i).getFromDate();
			String a4 =	(String)applyleave.get(i).getToDate();
*/			
			
	    	 
	   
	   //add the checkbox
	  TableColumnModel tcm = table.getColumnModel();
	  tcm.getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    table.addMouseListener(new MouseAdapter(){
  	    public void mouseClicked(MouseEvent e){
  	        if(e.getClickCount() == 1){
  	            int columnIndex = table.columnAtPoint(e.getPoint()); //获取点击的列
  	            int rowIndex = table.rowAtPoint(e.getPoint()); //获取点击的行

  	            if(columnIndex == 3) {//第0列时，执行代码
  	                if(table.getValueAt(rowIndex,columnIndex) == null){ //如果未初始化，则设置为false
  	                	table.setValueAt(false, rowIndex, columnIndex);
  	                  }

  	                if(((Boolean)table.getValueAt(rowIndex,columnIndex)).booleanValue()){ //原来选中
  	                	table.setValueAt(false, rowIndex, 3); //点击后，取消选中
  	                  }
  	                else {//原来未选中
  	                	table.setValueAt(true, rowIndex, 3);
  	                  }
  	             }

  	        }
  	    }
  	});  
	   JButton logout1 = new JButton("Log out");
	   panelh.add(panelh1,BorderLayout.CENTER);
	   panelh.add(panelh2,BorderLayout.SOUTH);
	   panelh1.add(table);
	   table.setSize(panelh.getWidth(),panelh.getHeight());
	   table.setLocation(10, 10);
	   panelh2.add(logout1);
	   frameh.add(panelh);
	   
	   ActionListener actionlistern = new ActionListener(){
   		 public void actionPerformed(ActionEvent e){
   			framelog.setVisible(true);
   			setVisible(false);
   		 }
   	 };
   	 logout1.addActionListener(actionlistern);
   	 
   //handle button function	     
  	ActionListener actionlisternlog2 = new ActionListener(){
 		 public void actionPerformed(ActionEvent e){
 				frameh.setVisible(true);
 		 }
 	 };
 	 handle.addActionListener(actionlisternlog2);
  	 
 
 //myhome frame
 	 JFrame framemh = new JFrame("My Application");
	 framemh.setSize(500,300);
	 framemh.setLocation(100,100);
	  
	  JPanel panelmh = new JPanel();
	  panelmh.setLayout(new BorderLayout(50,50));
	  framemh.add(panelmh);
     
     JPanel panelmh1 = new JPanel();
     panelmh.add(panelmh1,BorderLayout.NORTH);
     
     JPanel panelmh2 = new JPanel();
     JLabel labelmh1 = new JLabel("Your Application is:");
     JLabel labelmh2 = new JLabel("");//这里显示申请成功或失败
     panelmh2.add(labelmh1);
     panelmh2.add(labelmh2);
     panelmh.add(panelmh2,BorderLayout.CENTER);
     
 //my home button function    
     ActionListener actionlisternla3 = new ActionListener(){
 		 public void actionPerformed(ActionEvent e){
 		 framemh.setVisible(true);
 			
 		 }
 	 };
 	 myhome.addActionListener(actionlisternla3);
  	 	 
	 
	  } //构造函数的结尾
	    
       
 }//class的结尾


      

