/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Ahmad Aijaz
 */
public class Beneficieries {
    Donor D;
    String Name;
    String Address;
    String Phone_NO;
    String DOB;
    int Income;
    Beneficieries() {
    }
    
    
    public void update_donor(Donor D)
    {
        
    }

    public Beneficieries(Donor D, String Name, String Address, String Phone_NO, String DOB, int Income) {
        this.D = D;
        this.Name = Name;
        this.Address = Address;
        this.Phone_NO = Phone_NO;
        this.DOB = DOB;
        this.Income = Income;
    }

    
    
    public void Print_Details(javax.swing.JTextArea output)
    {
        output.setText("Name: "+Name+"\n");
        output.append("Address: "+Address+"\n");
        output.append("Phone_NO: "+Phone_NO+"\n");
        output.append("DOB: "+DOB+"\n");
        output.append("Salary: "+Income+"\n");
    }
    public void Print_Donors(javax.swing.JTextArea output)
    {
        if (D.Name!=null)
        output.append("Donor: "+D.Name+"\n");
    }
}
