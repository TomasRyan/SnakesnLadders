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
 * @author Tomas
 */
public class GameLoop {
    private LinkedList<Player> playerList;
    private LinkedList<BoardSquare> gameBoard;
    private Dice dice;
    
    public GameLoop() {
        playerList = new LinkedList<Player>();
        NewPlayer("Player 1");
        NewPlayer("Player2");
        MakeBoard();
        this.dice = new Dice();
    }
    
    private void NewPlayer(String p) {
        Player newPlayer = new Player(p);
        this.playerList.add(newPlayer);
    }
    
    public void MakeBoard() {
       this.gameBoard = new LinkedList<BoardSquare>();
       //   generate game board, then randomises it
       //   ------------------------------------------
       //   NUMBERS ARE HARDCODED
       //   ------------------------------------------
       for(int i = 0; i < 88; i++) {
           BoardSquare newSquare = new BoardSquare();
           this.gameBoard.add(newSquare);
       }
       for(int y = 1; y <= 6; y++) {
           int pairNumber;
           boolean isFirst;
           if(y>3) {
               pairNumber = y-3;
               isFirst = false;
           }
           else{
               pairNumber = y;
               isFirst = true;
           }
           SnakeSquare newSnake = new SnakeSquare(isFirst, pairNumber);
           LadderSquare newLadder = new LadderSquare(isFirst, pairNumber);
           this.gameBoard.add(newSnake);
           this.gameBoard.add(newLadder);
       }
       ShuffleBoard();
       //   ensure that 1st and last square is normal
       while(this.gameBoard.getFirst().getClass() != BoardSquare.class ||this.gameBoard.getLast().getClass() != BoardSquare.class ) {
           ShuffleBoard();
       }
    }
    
    //   print out every square
    public void PrintBoard() {
       for(BoardSquare g : this.gameBoard) {
           System.out.println(g.getSquareType());
       }
       for(int i = 0; i < this.gameBoard.size(); i++) {
           if(i%10 == 0) {
               System.out.println();
           }
           if(this.gameBoard.get(i).getSquareType() == "Ladder") {
                System.out.print("L ");
           }
           else if(this.gameBoard.get(i).getSquareType() == "Snake") {
                System.out.print("S ");
           }
           else {
               System.out.print("O ");
           }
       }
       System.out.println();
    }
    
    public void PrintPlayerPos() {
       for(Player p : this.playerList) {
           System.out.println(p.getName());
           System.out.println(p.getPosition());
       }
    }
    
    public boolean loop() {
        for(Player p:this.playerList) {
            p.AddMovement(this.dice.roll(1));
            if(p.getPosition() >= this.gameBoard.size()) {
                System.out.println("gaem ova");
                return true;
            }
            if(this.gameBoard.get(p.getPosition()).getSquareType() == "Snake" && this.gameBoard.get(p.getPosition()).GetFirst() == false) {
                
                SnakeMove(p, this.gameBoard.get(p.getPosition()).getPairNumber());
                return false;
            }
            else if(this.gameBoard.get(p.getPosition()).getSquareType() == "Ladder" && this.gameBoard.get(p.getPosition()).GetFirst() == true) {
                LadderMove(p, this.gameBoard.get(p.getPosition()).getPairNumber());
                return false;
            }  
        }
        return false;
    }
    
    private void SnakeMove(Player p, int pair) {
        System.out.println("Snake");
        System.out.println(pair);
        System.out.println(p.getName());
        System.out.println("Position: " + p.getPosition());
        if(this.gameBoard.get(p.getPosition()).GetFirst() == false) {
        int snakeDiff = 0;
        for(int i = p.getPosition()-1; i > 0; i--) {
            if(this.gameBoard.get(i).getSquareType() == "Snake") {
                if(this.gameBoard.get(i).getPairNumber() == pair) {
                    System.out.println("Pair check: " + this.gameBoard.get(i).getPairNumber() + " " + pair);
                    System.out.println("This should be it");
                    System.out.println("Printing i: " + i);
                    System.out.println("Printing p pos: " + p.getPosition());
                    snakeDiff = i - p.getPosition();
                    p.AddMovement(snakeDiff);
                }
            }
        }
        System.out.println("Change: " + snakeDiff);
        System.out.println("Position: " + p.getPosition());
        }
    }
    
    private void LadderMove(Player p, int pair) {
        System.out.println("Ladder");
        System.out.println(pair);
        System.out.println(p.getName());
        System.out.println("Position: " + p.getPosition());
        if(this.gameBoard.get(p.getPosition()).GetFirst() == true) {
        int ladderDiff = 0;
        //search the array backwards for secound ladder
        for(int i = p.getPosition()+1; i < this.gameBoard.size(); i++) {
            if(this.gameBoard.get(i).getSquareType() == "Ladder") {
                if(this.gameBoard.get(i).getPairNumber() == pair) {
                    System.out.println("This should be it");
                    System.out.println("Pair check: " + this.gameBoard.get(i).getPairNumber() + " " + pair);
                    System.out.println("Printing i: " + i);
                    System.out.println("Printing p pos: " + p.getPosition());
                    ladderDiff = i - p.getPosition();
                    p.AddMovement(ladderDiff);
                }
            }
        }
        System.out.println("Change: " + ladderDiff);
        System.out.println("Position: " + p.getPosition());
        }
    }
    
    private void ShuffleBoard() {
        Collections.shuffle(this.gameBoard);
    }
}


