/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *
 * @author Tomas
 */
public class Player {
    /**
 *  String name = n:    Player name, can be inputed or defaulted
 *  integer position = p:   player position on the board
 */
    public Player(String n) {
        this.name = n;
        this.position = 0;
    }
    public void AddMovement(int s) {
        this.position += s;
    }
    /**
 *  returns position on the board
 */
    public int getPosition() {
        return this.position;
    }    
    public String getName() {
        return this.name;
    } 
}
