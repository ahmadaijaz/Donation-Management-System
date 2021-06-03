/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmad Aijaz
 */
public class Organization {
    String Name;
    List<Volunteer> V;
    List<Volunteer> V1;
    List<Project> P;
    List<Team> T;
    List<Team> T1;
    List<Donor> D;
    List<Donor> Donor;
    
    List<Beneficieries>Applicants;
    List<Beneficieries>SL;
    List<Beneficieries>B;
    dbConnectivity db;

    public Organization() {
    }
    
    
    public Organization(dbConnectivity db) {
        this.db=db;
        this.P = db.getProjectdetail();
        this.D = db.getdonordetail();
        this.Applicants = db.getApplicants();
        this.B = db.getBeneficierydetail();
        this.V=db.getVolunteerdetail();
        this.T=db.getTeam();
        this.T1=db.getTeam1();
        this.Donor=db.getdonor();
        this.SL=db.getshortlistinfo();
        this.V1=db.getVolunteerdetail1();
    }
    
    public void ViewProjectbymanager(String a,javax.swing.JTextArea output)
    {
        //P.get(0).Print_details(output);
        //System.out.print(P.size());
        for(int i=0;i<P.size();i++)
        {
            //System.out.print(P.get(i).Project_Manager.Name+ " ");
            if(P.get(i).Project_Manager.Name.equalsIgnoreCase(a))
            {  
                P.get(i).Print_details(output);
                break;
            }
        }
    }
    
    public void ViewProjectbyname(String a,javax.swing.JTextArea output)
    {
        for(int i=0;i<P.size();i++)
        {
            if(P.get(i).Name.equals(a))
            {  
                P.get(i).Print_details(output);
            }
        }
    }
    public void ViewProjectDonor1(String a,javax.swing.JTextArea output)
    {
        output.append("Donors : "+"\n");
        for(int i=0;i<D.size();i++)
        {
            if(D.get(i).P.Name.equals(a))
            {  
                output.append(D.get(i).Name+"\n");
            }
        }
    }
    
    public void ViewProjectDonor2(String a,javax.swing.JTextArea output)
    {
        String temp=new String();
        
        for(int i=0;i<P.size();i++)
        {
            if(P.get(i).Project_Manager.Name.equalsIgnoreCase(a))
            {  
                temp=P.get(i).Name;
               // output.append(D.get(i).Name+"\n");
            }
        }
        ViewProjectDonor1(temp,output);
    }
    
    
    public void ViewDonor(String a,javax.swing.JTextArea output)
    {
        for(int i=0;i<D.size();i++)
        {
            if(D.get(i).Name.equals(a))
            {  
                D.get(i).Print_Name(output);
                break;
            }
        }
         for(int i=0;i<D.size();i++)
        {
            //System.out.print(D.get(i).Name);
            if(D.get(i).Name.equalsIgnoreCase(a))
            {   
                D.get(i).Print_Beneficieries(output);
            }
        }
         for(int i=0;i<D.size();i++)
        {
            if(D.get(i).Name.equalsIgnoreCase(a))
            {  
                D.get(i).Print_Project(output);
            }
        }
         int Donation=0;
          for(int i=0;i<D.size();i++)
        {
            if(D.get(i).Name.equalsIgnoreCase(a))
            {  
               Donation=Donation+D.get(i).Donation.money;
            }
        }
        output.append("Donation : "+Donation+"\n");  
    }
    
    
    public void ViewBeneficieries(String a,javax.swing.JTextArea output)
    {
        for(int i=0;i<D.size();i++)
        {
            if(B.get(i).Name.equals(a))
            {  
                B.get(i).Print_Details(output);
                break;
            }
        }
        for(int i=0;i<D.size();i++)
        {
            if(B.get(i).Name.equals(a))
            {  
                B.get(i).Print_Donors(output);
            }
        }
    }
    
    
    public void add_project(Project x,javax.swing.JTextArea output)
    {
        int flag=1;
        for(int i=0;i<P.size();i++)
        {
            if (P.get(i).Name.equalsIgnoreCase(x.Name))
            {
               flag=0; 
            }
        }
        if (flag==1)
        {   
            for (int i=0;i<T1.size();i++)
            {
                //&& (T.get(i).Team_Leader.Name.equalsIgnoreCase(x.Project_Manager.Name)
                if((T1.get(i).Name.equalsIgnoreCase(x.T.Name)))
                {
                    flag=1;
                    break;
                }
                flag=0;
            }
        }
//         if(flag==1)
//        {
//            for (int i=0;i<D.size();i++)
//            {
//                if(D.get(i).Name.equalsIgnoreCase(x.D.Name))
//                {
//                    flag=1;
//                    break;
//                }
//                flag=0;
//            }
//        }
        
        if (flag==1)
        {
            db.Add_Project(x);
            P.add(x);
            output.setText("Project has been added");
        }
        if (flag==0)
        {
            output.setText("Project could not be added");
        }
    }
    
    
     public void add_donor(Donor x,javax.swing.JTextArea output)
    {
        int flag=1;
        //System.out.print(Donor.size());
        for(int i=0;i<Donor.size();i++)
        {
            if(Donor.get(i).Name.equalsIgnoreCase(x.Name))
            {
             x.id=Donor.get(i).id;
             D.add(x);
             db.update_donor(x);
             db.ADDDonor(x);
             flag=2;
             output.setText("Donor is updated");
             break;
            }
        }
        if(flag==1)
        {
            x.id=Donor.size()+1;
            Donor.add(x);
            db.add_donor(x);
            db.ADDDonor(x);
            output.setText("Donor is added");
        }
    }
     
     
     public void add_applicant(Beneficieries x,javax.swing.JTextArea output)
    {
        int flag=1;
        for(int i=0;i<Applicants.size();i++)
        {
            if(Applicants.get(i).Name.equalsIgnoreCase(x.Name))
            {
                flag=0;
                break;
            }
        }
        if(flag==1)
        {
            Applicants.add(x);    
            db.add_shortlist_app(x);
            output.setText("Applicant is added");
        }
        if(flag==0)
        {
            output.setText("Applicant is not added");
        }
        
        
    }
     
     public void select_applicant(Beneficieries x,javax.swing.JTextArea output)
     {
         int flag=0;
         System.out.print(Applicants.size());
         for(int i=0;i<Applicants.size();i++)
         {
             if(Applicants.get(i).Name.equalsIgnoreCase(x.Name))
             {
                 if(Applicants.get(i).Income<45000)
                 {
                     SL.add(Applicants.get(i));
                     db.add_shortlisted(Applicants.get(i));
                     db.remove_from_shortlist(Applicants.get(i));
                     Applicants.remove(Applicants.get(i));
                     output.setText("Applicant Selected");
                     flag=1;
                     break;
                 }
             }
             if(flag==0)
             {
                  output.setText("Applicant is not Selected");
             }
         }
     }
     
    public void allocate_team(Team x,javax.swing.JTextArea output)
    {
        int flag=0;
        
        for(int i=0;i<T.size();i++)
        {
            if(T.get(i).Name.equalsIgnoreCase(x.Name))
            {
                flag=0;
                break;
            }
            flag=1;
        }
        if(flag==0)
        {
            output.setText("Team could not be allocated");
        }
        if(flag==1)
        {
            for(int i=0;i<V.size();i++)
            {
                if(V.get(i).Name.equalsIgnoreCase(x.Team_Leader.Name))
                {
                    int size=T1.size()+1;
                    x.id=size;
                    T.add(x);
                    db.add_team1(x);
                    output.setText("Team has been allocated");
                    break;
                }
            }
        }
        
        
    }
    
    public void Add_team_member(Volunteer x,javax.swing.JTextArea output)
    {
     int flag=0;
     String TL=new String();
     String Project=new String();
        for (int i=0;i<V1.size();i++)
        {
            if(V1.get(i).Name.equalsIgnoreCase(x.Name))
            {
                flag=1;
                break;
            }
        }
        
        if(flag==1)
        {
            flag=0;
            for (int i=0;i<T1.size();i++)
            {
                if(T1.get(i).Name.equalsIgnoreCase(x.T.Name))
                {
                    TL=T.get(i).Team_Leader.Name;
                    Project=T.get(i).P.Name;
                    flag=1;
                    break;
                }
            }
        }
        if(flag==1)
        {
            for (int i=0;i<V.size();i++)
            {
                if(V.get(i).Name.equalsIgnoreCase(x.Name) && V.get(i).T.Name.equalsIgnoreCase(x.T.Name))
                {
                    flag=0;
                    break;
                }
            }
        }
        if(flag==1)
        {
            Project p=new Project();
            p.Name=Project;
            Volunteer v=new Volunteer();
            v.Name=TL;
            Team temp=new Team(x.T.Name,x,p,v,0);
            T.add(temp);
            db.add_team(temp);
            
            
            String e="DMS";  
            x.O=new Organization();
            x.O.Name=e;
            
            int size=V.size()+1;
            x.id=size;
            V.add(x);
            db.add_Volunteer(x);
            output.setText("Volunteer has been added");
        }
        if(flag==0)
        {
             output.setText("Team could not be allocated");
        }
     
    }
    
    public void replace_team_member(Volunteer x,Volunteer y,javax.swing.JTextArea output)
    {
        int flag=0;
         for (int i=0;i<V1.size();i++)
        {
            if(V1.get(i).Name.equalsIgnoreCase(x.Name))
            {
                x.id=V.get(i).id;
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            flag=0;
            for (int i=0;i<V1.size();i++)
        {
            if(V1.get(i).Name.equalsIgnoreCase(y.Name))
            {
                flag=1;
                break;
            }
        }
        }
        if(flag==1)
        {
            flag=0;
            for (int i=0;i<T.size();i++)
        {
            if(T.get(i).Name.equalsIgnoreCase(x.T.Name))
            {
                flag=1;
                break;
            }
        }
        }
        if(flag==1)
        {
            for (int i=0;i<V.size();i++)
        {
            if((V.get(i).Name.equalsIgnoreCase(y.Name)) &&( V.get(i).T.Name.equalsIgnoreCase(y.T.Name)) )
            {
                flag=0;
                break;
            }
        }
        }
        if(flag==1)
        {
            for(int i=0;i<T.size();i++)
            {
                if(T.get(i).Name.equalsIgnoreCase(x.T.Name))
            {
                    
                    Team temp=new Team(T.get(i).Name,y,T.get(i).P,T.get(i).Team_Leader,T.get(i).id);
                    T.add(temp);
                    T.remove(T.get(i));
                    
                    db.replace_volunteer_from_team(x,y);
                    break;
            }
            }
            
            for(int i=0;i<V.size();i++)
            {
               if ((V.get(i).Name.equalsIgnoreCase(x.Name)) &&( V.get(i).T.Name.equalsIgnoreCase(x.T.Name)) )
            {
                    y.id=V.get(i).id;
                    V.add(y);
                    V.remove(V.get(i));
                    
                    db.replace_volunteer_from_volunteer(x,y);
                    break;
            }
           
            }
            output.setText("Team member has been replaced");
        }
    
        if(flag==0)
        {
            output.setText("Team member could not be replaced");
        }
    }
    
    public void remove_member(Volunteer x,javax.swing.JTextArea output)
    {  
        int flag=0;
       
         for (int i=0;i<V1.size();i++)
        {
            if(V1.get(i).Name.equalsIgnoreCase(x.Name))
            {
                x.id=V.get(i).id;
                flag=1;
                break;
            }
        }
         
         if(flag==1)
         {
             flag=0;
             for(int i=0;i<T1.size();i++)
             {
                 if((T1.get(i).Name.equalsIgnoreCase(x.T.Name)))
                 {
                     flag=1;
                     break;
                 }
             }
         }
         if(flag==1)
         {
        for(int i=0;i<V.size();i++)
        {
            if((V.get(i).Name.equalsIgnoreCase(x.Name)) && (V.get(i).T.Name.equalsIgnoreCase(x.T.Name)))
            {
                V.remove(V.get(i));
                db.remove_volunteer_from_volunteer(x);
            }
        }
        for(int i=0;i<T.size();i++)
        {
            if((T.get(i).Name.equalsIgnoreCase(x.T.Name)) && (T.get(i).V.Name.equalsIgnoreCase(x.Name)))
            {
                T.remove(T.get(i));
                db.remove_volunteer_from_Team(x);
            }
        }
            output.setText("Team Member is deleted");
         }
         if(flag==0)
         {
             output.setText("Team Member could not be deleted");
         }
    }
    
    
    
    public void update_team_lead(Volunteer x,javax.swing.JTextArea output)
    {  
        int flag=0;
       
         for (int i=0;i<V1.size();i++)
        {
            if(V1.get(i).Name.equalsIgnoreCase(x.Name))
            {
                x.id=V.get(i).id;
                flag=1;
                break;
            }
        }
         
         if(flag==1)
         {
             flag=0;
             for(int i=0;i<T1.size();i++)
             {
                 if((T1.get(i).Name.equalsIgnoreCase(x.T.Name)))
                 {
                     flag=1;
                     break;
                 }
             }
         }
         
         if(flag==1)
         {
             for(int i=0;i<T1.size();i++)
             {
                 if((T1.get(i).Name.equalsIgnoreCase(x.T.Name)) && (T1.get(i).Team_Leader.Name.equalsIgnoreCase(x.Name)))
                 {
                     flag=0;
                     break;
                 }
             }
         }
        
         if(flag==1)
         {
             db.update_teamleader_from_team1(x);
             db.update_teamleader_from_team(x);
             output.setText("Team Leader is updated");
         }
         
         if(flag==0)
         {
             output.setText("Team Leader is not updated");
         }
    }
    
    
    void issue_donation(String name,int amount,String Project,javax.swing.JTextArea output)
    {
        int total=0;
        int flag=0;
        int id=0;
        Beneficieries temp=new Beneficieries();
        for(int i=0;i<SL.size();i++)
        {
            if(SL.get(i).Name.equalsIgnoreCase(name))
            {
                flag=1;
                temp.Name=SL.get(i).Name;
                temp.Address=SL.get(i).Address;
                temp.Phone_NO=SL.get(i).Phone_NO;
                temp.DOB= SL.get(i).DOB;
                temp.Income=SL.get(i).Income;
                break;
            }
        }
        if(flag==1){
            flag=0;
         for(int i=0;i<D.size();i++)
        {
            
            if(D.get(i).P.Name.equalsIgnoreCase(Project))
            {
                temp.D=new Donor();
                temp.D.Name=D.get(i).Name;
                flag=1;
                break;
            }
            
        }
         if(flag==1)
         {
             flag=0;
             for(int i=0;i<D.size();i++)
             {
                 if(D.get(i).P.Name.equalsIgnoreCase(Project));
                 {
                     total=total+D.get(i).Donation.money;
                 }
             }
             if(total>amount)
             {
                 flag=1;
             }
         }
         if(flag==1)
         {
             B.add(temp);
             
        for(int i=0;i<Donor.size();i++)
        {
            if(Donor.get(i).Name.equalsIgnoreCase(temp.D.Name))
            {
                Donor.get(i).Donation.money=Donor.get(i).Donation.money-amount;
                id=Donor.get(i).id;
                break;
            }
        }
             db.add_beneficiery(temp, Project);
             db.update_donor_donation(id,amount);
             output.setText("Beneficiary is added");
         }
         if(flag==0)
         {
             output.setText("Beneficiary is not added");
         }
        }
    }
    
    
    void print_teams_name(javax.swing.JTextArea output)
    {
        for(int i=0;i<T1.size();i++)
        {
            output.append(T1.get(i).Name+"\n");
        }
    }
    
    void print_volunteer_name(javax.swing.JTextArea output)
    {
        for(int i=0;i<V1.size();i++)
        {
            output.append(V1.get(i).Name+"\n");
        }
    }
    
    void view_donor(javax.swing.JTextArea output)
    {
         for(int i=0;i<Donor.size();i++)
        {
            output.append(Donor.get(i).Name+"\n");
        }
    }
    
    void view_applicant(javax.swing.JTextArea output)
    {
        for(int i=0;i<Applicants.size();i++)
        {
            output.append(Applicants.get(i).Name+"\n");
        }
    }
    void view_shortlisted(javax.swing.JTextArea output)
    {
        for(int i=0;i<SL.size();i++)
        {
            output.append(SL.get(i).Name+"\n");
        }
    }
    void ViewBeneficierieslist(javax.swing.JTextArea output)
    {
        for(int i=0;i<B.size();i++)
        {
            output.append(B.get(i).Name+"\n");
        }
    }
}
