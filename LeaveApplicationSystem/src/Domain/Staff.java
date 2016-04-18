package Domain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import javax.swing.*;
import UI.StaffManagementUI;

public class Staff  {
	
	
     private String staffname;
     private String staffid;
     private String gender;
     private String supervisor;
     
   
 	
 	public Staff(String staffid,String staffname,String gender,String supervisor)  {
 		this.staffname = staffname;
 		this.staffid = staffid;
 		this.gender = gender;
 		this.supervisor = supervisor;
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

	public void setGender(String gender) {
		// TODO Auto-generated method stub
		this.gender = gender;
	}
    
	public String getGender(){
		return gender;
	}
	
	public void setSupervisor(String supervisor) {
		// TODO Auto-generated method stub
		this.supervisor = supervisor;
	}
     
     public String getSupervisor(){
    	 return supervisor;
     }




	public boolean equals(String staffid, String staffname,String gender,String supervisor) {
		// TODO Auto-generated method stub
		return true;
	}
     
}

