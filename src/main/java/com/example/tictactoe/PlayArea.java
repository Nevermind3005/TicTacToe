package com.example.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class PlayArea {

    private TurnLabel turn;
    private Logic logic;
    private GridPane layout;

    public PlayArea(TurnLabel turn,Logic logic){
        this.turn = turn;
        this.logic = logic;
        layout = new GridPane();
        initView();
    }

    private void initView() {
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));

        Button btnOne = new Button(" ");
        btnOne.setFont(Font.font("Monospaced", 40));

        Button btnTwo = new Button(" ");
        btnTwo.setFont(Font.font("Monospaced", 40));

        Button btnThree = new Button(" ");
        btnThree.setFont(Font.font("Monospaced", 40));

        Button btnFour = new Button(" ");
        btnFour.setFont(Font.font("Monospaced", 40));

        Button btnFive = new Button(" ");
        btnFive.setFont(Font.font("Monospaced", 40));

        Button btnSix = new Button(" ");
        btnSix.setFont(Font.font("Monospaced", 40));

        Button btnSeven = new Button(" ");
        btnSeven.setFont(Font.font("Monospaced", 40));

        Button btnEight = new Button(" ");
        btnEight.setFont(Font.font("Monospaced", 40));

        Button btnNine = new Button(" ");
        btnNine.setFont(Font.font("Monospaced", 40));

        layout.add(btnOne, 0, 0);
        layout.add(btnTwo, 1, 0);
        layout.add(btnThree, 2, 0);
        layout.add(btnFour, 0, 1);
        layout.add(btnFive, 1, 1);
        layout.add(btnSix, 2, 1);
        layout.add(btnSeven, 0, 2);
        layout.add(btnEight, 1, 2);
        layout.add(btnNine, 2, 2);

        btnOne.setOnAction((event) ->{
            logic.addPlayerIfAbsent(0, 0);
            btnOne.setText(String.valueOf(logic.getPlayerAtPosition(0,0)));
            gameShouldEnd();
        });

        btnTwo.setOnAction((event) ->{
            logic.addPlayerIfAbsent(0, 1);
            btnTwo.setText(String.valueOf(logic.getPlayerAtPosition(0, 1)));
            gameShouldEnd();
        });

        btnThree.setOnAction((event) ->{
            logic.addPlayerIfAbsent(0, 2);
            btnThree.setText(String.valueOf(logic.getPlayerAtPosition(0, 2)));
            gameShouldEnd();
        });

        btnFour.setOnAction((event) ->{
            logic.addPlayerIfAbsent(1, 0);
            btnFour.setText(String.valueOf(logic.getPlayerAtPosition(1, 0)));
            gameShouldEnd();
        });

        btnFive.setOnAction((event) ->{
            logic.addPlayerIfAbsent(1, 1);
            btnFive.setText(String.valueOf(logic.getPlayerAtPosition(1, 1)));
            gameShouldEnd();
        });

        btnSix.setOnAction((event) ->{
            logic.addPlayerIfAbsent(1, 2);
            btnSix.setText(String.valueOf(logic.getPlayerAtPosition(1, 2)));
            gameShouldEnd();
        });

        btnSeven.setOnAction((event) ->{
            logic.addPlayerIfAbsent(2, 0);
            btnSeven.setText(String.valueOf(logic.getPlayerAtPosition(2, 0)));
            gameShouldEnd();
        });

        btnEight.setOnAction((event) ->{
            logic.addPlayerIfAbsent(2, 1);
            btnEight.setText(String.valueOf(logic.getPlayerAtPosition(2, 1)));
            gameShouldEnd();
        });

        btnNine.setOnAction((event) ->{
            logic.addPlayerIfAbsent(2, 2);
            btnNine.setText(String.valueOf(logic.getPlayerAtPosition(2, 2)));
            gameShouldEnd();
        });

    }

    public Parent getView(){
        return layout;
    }

    private void gameShouldEnd() {
        if (logic.gameShouldEnd) {
            disablePlayArea();
        }
    }

    public void disablePlayArea() {
        for (Node node:layout.getChildren()) {
            if (node instanceof Button) {
                node.setDisable(true);
            }
        }
    }

}