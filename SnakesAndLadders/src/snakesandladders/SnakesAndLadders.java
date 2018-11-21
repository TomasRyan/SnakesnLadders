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
       LinkedList<BoardSquare> gameBoard = new LinkedList<BoardSquare>();
       //   generate game board, then randomises it
       //   ------------------------------------------
       //   NUMBERS ARE HARDCODED
       //   ------------------------------------------
       for(int i = 0; i < 88; i++) {
           BoardSquare newSquare = new BoardSquare();
           gameBoard.add(newSquare);
       }
       for(int y = 0; y < 6; y++) {
           int pairNumber;
           boolean isFirst;
           if(y>3) {
               pairNumber = y;
               isFirst = true;
           }
           else{
               pairNumber = y-3;
               isFirst = false;
           }
           SnakeSquare newSnake = new SnakeSquare(isFirst, pairNumber);
           LadderSquare newLadder = new LadderSquare(isFirst, pairNumber);
           gameBoard.add(newSnake);
           gameBoard.add(newLadder);
       }
       Collections.shuffle(gameBoard);
       //   ensure that 1st and last square is normal
       while(gameBoard.getFirst().getClass() != BoardSquare.class ||gameBoard.getLast().getClass() != BoardSquare.class ) {
           Collections.shuffle(gameBoard);
       }
       //   print out every square
       for(BoardSquare g : gameBoard) {
           System.out.println(g.getSquareType());
       }
    }
    
}
