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
 *  Each player has its own enum tied to it 
 */
    private enum PlayerEnum {
        PLAYER1(),
        PLAYER2(),
        PLAYER3(),
        PLAYER4();
        
        private String name;
        private int position;
    /**
 *  String name = n:    Player name, can be inputed or defaulted
 *  int position = p:   player position on the board
 */
        PlayerEnum(String n, int p) {
            this.name = n;
            this.position = p;
        }        
    /**
 *  AddMovement(int s) adds the movement/dice roll (int s) to the players position
 */
        public void AddMovement(int s) {
            this.position += s;
        }
    /**
 *  returns position on the board
 */
        public int getPosition() {
            return this.position;
        }    
    }
}
