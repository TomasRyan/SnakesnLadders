/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Tomas Ryan
 * k00243524
 * Main method of the game of snakes and ladders
 */
public class SnakesAndLadders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GameLoop gameLoop = new GameLoop();
       gameLoop.PrintBoard();
       while(gameLoop.loop() == false) {
           //System.out.println("You got this far");
           //gameLoop.PrintBoard();
           //gameLoop.PrintPlayerPos();
       }
       System.out.println("We did it!");
    }
    
}
