package Domain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import javax.swing.*;
import UI.StaffManagementUI;

public class LeaveApplication {
	 private String staffname;
     private String staffid;
     private String fromdate;
     private String todate;
     
   
 	
 	public LeaveApplication(String staffid,String staffname,String fromdate,String todate)  {
 		this.staffname = staffname;
 		this.staffid = staffid;
 		this.fromdate = fromdate;
 		this.fromdate = fromdate;
 	}
 	
   

	
	public void setStaffID(String staffid) {
		// TODO Auto-generated method stub
		this.staffid = staffid;
	}
	
	public String getStaffID(){
		return staffid;
	}

	public void setStaffName(String staffname) {
		// TODO Auto-generated method stub
		this.staffname = staffname;
	}
	
	public String getStaffName(){
		return staffname;
	}

	public void setFromDate(String fromdate) {
		// TODO Auto-generated method stub
		this.fromdate = fromdate;
	}
    
	public String getFromDate(){
		return fromdate;
	}
	
	public void setToDate(String todate) {
		// TODO Auto-generated method stub
		this.todate = todate;
	}
     
     public String getToDate(){
    	 return todate;
     }




	public boolean equals(String staffid, String staffname,String fromdate,String todate) {
		// TODO Auto-generated method stub
		return true;
	}
} 
