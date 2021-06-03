/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmad Aijaz
 */
public class dbConnectivity {
    Connection con;
    Statement stmt;
   
    List<Beneficieries>B;
    List<Donor>D;
    List<Donor>_Donor;
    List<Project>P;
    List<Beneficieries>APP;
    List<Beneficieries>SL;
    List<Volunteer>V;
    List<Volunteer>V1;
    List<Team>T;
    List<Team>T1;
    
    
    dbConnectivity() //cons
    {
        try
        {
             String s = "jdbc:sqlserver://DESKTOP-B2VGSN3;databaseName=fproj";
             con=DriverManager.getConnection(s,"dankyolopolo","yolofaith123");
             stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    List<Volunteer>getVolunteerdetail()
    {
         V=new ArrayList<Volunteer>();
        try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Volunteer");
            while(rs.next())
            {
                
               String a=rs.getString(1);
               String t=rs.getString(2);
               String o=rs.getString(3);
               int q=rs.getInt(4);
               
               Team temp=new Team();
               temp.Name=t;
               
               Organization O=new Organization();
               O.Name=o;
               Volunteer x=new Volunteer(a,O,temp,q);
               V.add(x);
            }
        }
         catch(Exception e)
        {
            System.out.println(e);
        }
        return V;
    }
    
    List<Volunteer>getVolunteerdetail1() //volunteer1
    {
         V1=new ArrayList<Volunteer>();
        try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Volunteer1");
            while(rs.next())
            {
                
               int a=rs.getInt(1);
               String t=rs.getString(2);
              // String o=rs.getString(3);
               //int q=rs.getInt(4);
               
               //Team temp=new Team();
               //temp.Name=t;
               
               //Organization O=new Organization();
               //O.Name=o;
               Volunteer x=new Volunteer(t,null,null,a);
               V1.add(x);
            }
        }
         catch(Exception e)
        {
            System.out.println(e);
        }
        return V1;
    }
    
    List<Beneficieries>getApplicants()
    {
        APP=new ArrayList<Beneficieries>();
        try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from shortlist");
            while(rs.next())
            {
               Beneficieries x=new Beneficieries();
               x.Name=rs.getString(1);
               x.Address=rs.getString(2);
               x.Phone_NO=rs.getString(3);
               x.DOB=rs.getString(4);
               x.Income=rs.getInt(5); 
               APP.add(x);
            }
        }
         catch(Exception e)
        {
            System.out.println(e);
        }
        return APP;        
    }
    
    
    boolean Add_Project (Project x)
    {
        try
        {
            String query="insert into Project1 values(?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            String a=x.Name;
            String b=x.Description;
            String c=x.O.Name;
            String d=x.T.Name;
            String e=x.Project_Manager.Name;
            int f=x.Required_Budget;
            preparedStmt.setString(1,a);
            preparedStmt.setString(2,b);
            preparedStmt.setString(3,c);
            preparedStmt.setString(4,d);
            preparedStmt.setString(5,e);
            preparedStmt.setInt(6,f);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    List<Project> getProjectdetail()
    {
        P=new ArrayList<Project>();
         try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Project1");
            
             while(rs.next())
            {
                //System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");
                String a=(rs.getString(1)); //Name
                String b=(rs.getString(2)); //Address   
                String c=(rs.getString(3)); //Organization
                Organization temp1=new Organization();
                temp1.Name=c;
                String d=(rs.getString(4)); //Team
                Team temp2=new Team();
                temp2.Name=d;
                String e=(rs.getString(5)); //Manager
                Volunteer temp3=new Volunteer();
                temp3.Name=e;
                int f=(rs.getInt(6));      //Budget
//                String g=(rs.getString(7)); //Donor
//                Donor temp=new Donor();
//                temp.Name=g;
                Project x=new Project(a,b,temp1,temp2,null,temp3,f);
                P.add(x);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         return P;
    }
    
//    boolean update_project_budget(Donor x,Project y)
//    {
//     try
//        {
//            String query="update Project1 set Project1.Budget=Project1.Budget+"+x.Donation.money+"where Budget="+y.Required_Budget;
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.executeUpdate();
//            return true;
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//        return false;   
//    }
    
    List<Donor> getdonordetail()
    {
        D=new ArrayList<Donor>();
         try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Donor");
            while(rs.next())
            {
                String a=(rs.getString(1));
                String b=(rs.getString(2));
                String c=(rs.getString(3));
                int d=(rs.getInt(4));
                Beneficieries temp1=new Beneficieries();
                temp1.Name=b;
                Project temp2=new Project();
                temp2.Name=c;
                Fund temp3=new Fund();
                temp3.money=d;
                Donor x=new Donor(temp3,temp1,temp2,a,0);
                D.add(x);
            }        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return D;
    }
    
    List<Donor> getdonor()
    {
        _Donor=new ArrayList<Donor>();
         try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Donor1");
            while(rs.next())
            {
                String a=(rs.getString(1));
                int b=(rs.getInt(2));
                Fund temp=new Fund();
                temp.money=b;
                int c=(rs.getInt(3));
                Donor x=new Donor(temp,null,null,a,c);
                _Donor.add(x);
            }        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return _Donor;
    }
    
    List<Beneficieries> getBeneficierydetail()
    {
        B=new ArrayList<Beneficieries>();
         try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Beneficiery");
            while(rs.next())
             {
                 String a=rs.getString(1);
                 String b=rs.getString(2);
                 String c=rs.getString(3);
                 String d=rs.getString(4);
                 int e=rs.getInt(5);
                 String f=rs.getString(6);
                 Donor temp=new Donor();
                 temp.Name=f;
                Beneficieries x=new Beneficieries(temp,a,b,c,d,e);
               // x.DOB=rs.getDate(4);
                B.add(x);
             }  
             }
        catch(Exception e)
        {
            System.out.println(e);
        }
         return B;
    }
    
    boolean add_beneficiery(Beneficieries x,String Project)
    {
        try
        {
            String query="insert into Beneficiery values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,x.Name);
            preparedStmt.setString(2,x.Address);
            preparedStmt.setString(3,x.Phone_NO);
            preparedStmt.setString(4,x.DOB);
            preparedStmt.setInt(5,x.Income);
            preparedStmt.setString(6,x.D.Name);
            preparedStmt.setString(7,Project);
            
        
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     return false;
    }
    
    boolean add_shortlist_app(Beneficieries x)
    {
     try
        {
            String query="insert into ShortList values(?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,x.Name);
            preparedStmt.setString(2,x.Address);
            preparedStmt.setString(3,x.Phone_NO);
            preparedStmt.setString(4,x.DOB);
            preparedStmt.setInt(5,x.Income);
        
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     return false;
    }
    
    boolean add_shortlisted(Beneficieries x)
    {
     try
        {
            String query="insert into ShortListed values(?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,x.Name);
            preparedStmt.setString(2,x.Address);
            preparedStmt.setString(3,x.Phone_NO);
            preparedStmt.setString(4,x.DOB);
            preparedStmt.setInt(5,x.Income);
        
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     return false;
    }
    boolean remove_from_shortlist(Beneficieries x)
    {
     try
        {
            String query="delete from Shortlist where Shortlist.name='"+x.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;   
    }
    
    List<Beneficieries> getshortlistinfo()
    {
        SL=new ArrayList<Beneficieries>();
        try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from shortlisted");
            while(rs.next())
            {
               Beneficieries x=new Beneficieries();
               x.Name=rs.getString(1);
               x.Address=rs.getString(2);
               x.Phone_NO=rs.getString(3);
               x.DOB=rs.getString(4);
               x.Income=rs.getInt(5); 
               SL.add(x);
            }
        }
         catch(Exception e)
        {
            System.out.println(e);
        }
        return SL; 
    }

    boolean update_donor_donation(int id,int amount)
    {
        try
           {
               String query="update Donor1 set Donor1.Donation=Donor1.Donation-"+amount+"where Donor1.id="+id;
               PreparedStatement preparedStmt = con.prepareStatement(query);
               preparedStmt.executeUpdate();
               return true;
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
           return false;   
    }
    
    boolean add_donor(Donor x)
    {
        try
        {
            String query="insert into Donor1 values(?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,x.Name);
            preparedStmt.setInt(2,x.Donation.money);
            preparedStmt.setInt(3,x.id);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     return false;
    }
    boolean update_donor(Donor x)
    {
       
         try
        {
            String query="update Donor1 set Donor1.Donation=Donor1.Donation+"+x.Donation.money+"where Donor1.id="+x.id;
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    boolean ADDDonor(Donor x)//Big donor table
    {
        try
        {
            String query="insert into Donor values(?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,x.Name);
            x.B=new Beneficieries();
            String a="NULL";
            x.B.Name=a;
            preparedStmt.setString(2,x.B.Name);
            preparedStmt.setString(3,x.P.Name);
            preparedStmt.setInt(4,x.Donation.money);
        
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     return false;
    }
    
    boolean add_team1(Team x)
    {
        
        try
        {
            String query="insert into Team1 values(?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
                preparedStmt.setInt(1,x.id);
                preparedStmt.setString(2,x.Name);
                preparedStmt.setString(3,x.Team_Leader.Name); 
                
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         return false;
    }
    
    boolean add_team(Team x)
    {
        
        try
        {
            String query="insert into Team values(?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            
                preparedStmt.setString(1,x.Team_Leader.Name);
                preparedStmt.setString(2,x.P.Name);
                preparedStmt.setString(3,x.V.Name);
                preparedStmt.setString(4,x.Name);
                
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         return false;
    }
    List<Team> getTeam()
    {
        T=new ArrayList<Team>();
         try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Team");
            while(rs.next())
            {
                
                String a=(rs.getString(1));
                Volunteer temp1=new Volunteer();
                temp1.Name=a;
                
                String b=(rs.getString(2));
                Project temp=new Project();
                temp.Name=b;
                
                String c=(rs.getString(3));
                Volunteer temp2=new Volunteer();
                temp2.Name=c;
                
                
                
                String d=(rs.getString(4));
                
                Team x=new Team(d,temp2,temp,temp1,0);
                T.add(x);
            }        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return T;
    }
    
    List<Team> getTeam1()
    {
        T1=new ArrayList<Team>();
         try
        {
            ResultSet rs;
            rs=stmt.executeQuery("select * from Team1");
            while(rs.next())
            {
                
                String a=(rs.getString(1));
                int A=parseInt(a);
                
                String b=(rs.getString(2));
                
                String c=(rs.getString(3));
                Volunteer temp2=new Volunteer();
                temp2.Name=c;
               
                Team x=new Team(b,null,null,temp2,A);
                T1.add(x);
            }        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return T1;
    }
    
     boolean add_Volunteer(Volunteer x)
    {
        try
        {
            String query="insert into Volunteer values(?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,x.Name);
            preparedStmt.setString(2,x.T.Name);
            preparedStmt.setString(3,x.O.Name);
            preparedStmt.setInt(4,x.id);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     return false;
    }
    boolean replace_volunteer_from_team(Volunteer x,Volunteer y){
        try
        {
            String query="update Team set Team.Volunteer='"+y.Name+"'where Team.Volunteer='"+x.Name+"'and Name='"+x.T.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    boolean update_teamleader_from_team1(Volunteer x)
    {
        try
        {
            String query="update Team1 set Team1.Leader='"+x.Name+"'where Team1.Name='"+x.T.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    boolean update_teamleader_from_team(Volunteer x)
    {
        try
        {
            String query="update Team set Team.Team_Leader='"+x.Name+"'where Team.Name='"+x.T.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    boolean replace_volunteer_from_volunteer(Volunteer x,Volunteer y){
        try
        {
            String query="update Volunteer set Volunteer.name='"+y.Name+"' where Volunteer.Team='"+x.T.Name+"' and Volunteer.name='"+x.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    boolean remove_volunteer_from_volunteer(Volunteer x)
    {
      try
        {
            String query="delete from Volunteer where name='"+x.Name+"' and Team ='"+x.T.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    boolean remove_volunteer_from_Team(Volunteer x)
    {
      try
        {
            String query="delete from Team where name='"+x.T.Name+"' and Volunteer ='"+x.Name+"'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}

