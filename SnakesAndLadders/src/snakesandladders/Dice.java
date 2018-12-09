/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import java.util.Random;

/**
 *
 * @author Tomas
 */
public class Dice {
    private Random dice;
    public Dice() {
        dice = new Random();
    }
    public int roll(int i) {
        int rollTotal = 0;
        int counter = 0;
        while(counter < i) {
            rollTotal += (dice.nextInt(6) +1);
            counter++;
        }
        return rollTotal;
    }
}
