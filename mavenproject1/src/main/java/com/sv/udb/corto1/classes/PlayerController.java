/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.corto1.classes;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador del modelo de jugadores.
 * @author Estudiante
 */
public class PlayerController {
    ArrayList<Player> playerList;

    /**
     * Constructor. Inicializa la lista de jugadores.
     */
    public PlayerController() {
        playerList = new ArrayList<>();
    }
    
    /**
     * Registra a un jugador.
     * @param name El nombre del jugador.
     * @param age La edad del jugador.
     * @param height La altura del jugador.
     * @param weight El peso del jugador.
     * @return "OK", si el jugador fue agregado exitosamente; ó "ERROR" si ocurre un error al realizar la operación.
     */
    public Player addPlayer(String name, int age, double height, double weight) {
        Player player = null;
        try {
            player = new Player(name, age, height, weight);
            playerList.add(player);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }
    
    /**
     * Devuelve la lista de todos los jugadores regitrados.
     * @return Un DefaultTableModel que contiene la lista de todos los jugadores registrados, organizando cada dato en una columna diferente.
     */
    public DefaultTableModel getPlayers () {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Estatura");
        model.addColumn("Peso");
        
        for (Player player : playerList) {
            model.addRow(new Object[]{player.getName(), player.getAge(), player.getHeight(), player.getWeight()});
        }
        
        return model;
    }
    
    /**
     * Devuelve los nombres de los jugadores con "datos sobresalientes".
     * @return Un array del tipo String que contiene los nombres de: 1.El jugador más alto. 2.El jugador más joven. 3.El jugador más pesado. 
     */
    public String[] getStadistics () {
        //Contenido de este array:
        //El primero será el más alto, el segundo el más joven y el tercero el más pesado
        String[] stadistics = new String[3];
        
        //Obteniendo al más alto
        double heightLimit = 0;
        for (Player player : playerList) {
            if (player.getHeight() > heightLimit) {
                stadistics[0] = player.getName();
                heightLimit = player.getHeight();
            }
        }
        
        //Obteniendo al más joven
        double ageLimit = 100;
        for (Player player : playerList) {
            if (player.getAge() < ageLimit) {
                stadistics[1] = player.getName();
                ageLimit = player.getAge();
            }
        }
        
        //Obteniendo al más pesado
        double weightLimit = 0;
        for (Player player : playerList) {
            if (player.getWeight() > weightLimit) {
                stadistics[2] = player.getName();
                weightLimit = player.getWeight();
            }
        }
        
        return stadistics;
    }
    
}
