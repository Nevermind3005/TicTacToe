package com.example.tictactoe;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TurnLabel {

    private String turn;
    private String xOrO;
    private Label turnLabel;

    public TurnLabel(){
        this.turn = "Turn: ";
        this.xOrO = Turn.X.toString();
        turnLabel = new Label(turn + getXOrO());
    }

    public Parent getView(){
        turnLabel.setFont(Font.font("Monospaced",FontWeight.BOLD, 40));
        return turnLabel;
    }

    private void changeTurn(){
        switch(xOrO){
            case"X":
                this.xOrO = Turn.O.toString();
                break;
            case"O":
                this.xOrO = Turn.X.toString();
                break;
        }
    }

    public String getXOrO(){
        return xOrO;
    }

    private void setTurnLabel(){
        turnLabel.setText(turn + getXOrO());
    }

    public void changeAndSetTurn(){
        changeTurn();
        setTurnLabel();
    }

    public void setLabelTie() {
        turnLabel.setText("Tie!");
    }

    public void setLabelPlayerWon(Turn turn) {
        turnLabel.setText(turn + " won!");
    }

}