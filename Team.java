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
public class Team {
    String Name;
    Volunteer V;
    Project P;
    Volunteer Team_Leader;
    int id;

    public Team(String Name, Volunteer V, Project P, Volunteer Team_Leader,int id) {
        this.Name = Name;
        this.V = V;
        this.P = P;
        this.Team_Leader = Team_Leader;
        this.id=id;
    }
    

    public Team() {
    }
    
    
}
