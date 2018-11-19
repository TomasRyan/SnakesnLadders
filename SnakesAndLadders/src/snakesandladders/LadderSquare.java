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
public class LadderSquare extends BoardSquare{
    private boolean firstInPair;
    private int connectedSquare;
    public LadderSquare(boolean p, int s) {
        this.firstInPair = p;
        this.connectedSquare = s;
        this.squareType = "Ladder";
    }
    public int getPairNumber() {
        return this.connectedSquare;
    }
}
