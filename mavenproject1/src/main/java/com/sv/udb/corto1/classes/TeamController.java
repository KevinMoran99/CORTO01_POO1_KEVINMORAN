/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.corto1.classes;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Estudiante
 */
public class TeamController {
    private ArrayList<Team> teamList;

    public TeamController() {
        teamList = new ArrayList<>();
    }
    
    public String addTeam (String name) {
        try {
            teamList.add(new Team(name));
            return "OK";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
    
    public void addPlayer (Team selectedTeam, Player player) {
        for (Team team : teamList) 
            if (selectedTeam == team)
                team.addPlayer(player);
        
    }
    
    public boolean hasTeams () {
        return !teamList.isEmpty();
    }
    
    public DefaultComboBoxModel getTeams () {
        DefaultComboBoxModel teams = new DefaultComboBoxModel();
        
        for (Team team : teamList) {
            teams.addElement(team);
        }
        
        return teams;
    }
}
