/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.corto1.classes;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Team {
    String name;
    ArrayList<Player> playerList;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
        playerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Añade un jugador al equipo, reemplaza al setter de la lista de jugadores
     * @param player 
     */
    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}
