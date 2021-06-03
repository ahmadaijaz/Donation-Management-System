/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;

/**
 *
 * @author Ahmad Aijaz
 */
public class Donor {
 Fund Donation;
 Beneficieries B;
 Project P;
 String Name;
 int id;
 
    public Donor(Fund Donation, Beneficieries B, Project P, String Name,int id) {
        this.Donation = Donation;
        this.B = B;
        this.P = P;
        this.Name = Name;
        this.id=id;
    }   
    Donor() {
        this.Donation = null;
        this.B = null;
        this.P = null;
        this.Name = null;
    }
    public void Print_Name(javax.swing.JTextArea outputs)
    {
       outputs.setText("Name: "+Name+"\n");
    }
    public void Print_Name2()
    {
      System.out.print("Name: "+Name+"\n");
    }
    public void Print_Project(javax.swing.JTextArea outputs)
    {
        if(P.Name!=null)
        outputs.append("Project Name : "+P.Name+"\n");
    }
    public void Print_Beneficieries(javax.swing.JTextArea outputs)
    {
       if(B.Name!=null)
       {
       outputs.append("Beneficiary : "+B.Name+"\n");
       //System.out.print("Beneficiary : "+B.Name+"\n");
       }
    }
    public void Print_Donation(javax.swing.JTextArea outputs)
    {
        if(B.Name!=null)
       outputs.append("Donation : "+Donation.money+"\n");
    }
 
 
 public void add_beneficieiries(Beneficieries x)
 {
 }
 
 public void add_Project(Project x)
 {
 }
 
}
