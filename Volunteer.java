/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Ahmad Aijaz
 */
public class Volunteer {
    String Name;
    Organization O;
    Team T;
    int id;
    public Volunteer(String Name, Organization O, Team T,int id) {
        this.Name = Name;
        this.O = O;
        this.T = T;
        this.id=id;
    }

    public Volunteer() {
    }
    
    
}
