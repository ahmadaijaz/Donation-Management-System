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
public class Project {
    String Name;
    String Description;
    Organization O;
    Team T;
    Donor D;
    Volunteer Project_Manager;
    int Required_Budget;

    public Project(String Name, String Description, Organization O, Team T, Donor D, Volunteer Project_Manager, int Required_Budget) {
        this.Name = Name;
        this.Description = Description;
        this.O = O;
        this.T = T;
        this.D = D;
        this.Project_Manager = Project_Manager;
        this.Required_Budget = Required_Budget;
    }

   

    Project() {
      this.Name = null;
        this.Description = null;
        this.O = null;
        this.T = null;
        this.D = null;
        this.Project_Manager = null;
        this.Required_Budget = 0;  
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void update_donor_list(Donor x)
    {
        
    }
    public void Print_details(javax.swing.JTextArea output)
    {
        output.setText("Name : "+Name+"\n");
        output.append("Description : "+Description+"\n");
        output.append("Organization : "+O.Name+"\n");
        output.append("Team : "+T.Name+"\n");
        output.append("Project_Manager : "+Project_Manager.Name+"\n");
        output.append("Required Budget : "+Required_Budget+"\n");
        output.append("Donors : "+D.Name+"\n");
        
//        int size=D_name.size();   
//        for (int i = 0; i < size; i++) {
//            System.out.print(D_name.get(i)+"\n");    
//        }
    }
    public void Print_details2()
    {
        System.out.print("Name : "+Name+"\n");
        System.out.print("Description : "+Description+"\n");
        System.out.print("Organization : "+O.Name+"\n");
        System.out.print("Team : "+T.Name+"\n");
        System.out.print("Project_Manager : "+Project_Manager.Name+"\n");
        System.out.print("Required Budget : "+Required_Budget+"\n");
        System.out.print("Donors : "+D.Name+"\n");
        
//        int size=D_name.size();   
//        for (int i = 0; i < size; i++) {
//            System.out.print(D_name.get(i)+"\n");    
//        }
    }
    }
