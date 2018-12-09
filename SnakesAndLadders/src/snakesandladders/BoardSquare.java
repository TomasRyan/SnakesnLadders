/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *
 * @author Tomas
 * 
 */
public class BoardSquare implements Board{
    public String squareType;
    public BoardSquare() {
        this.squareType = "Plain";
    }
    /**
 *  returns square type
 */
    public String getSquareType() {
        return this.squareType;
    }

    public int getPairNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean GetFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
