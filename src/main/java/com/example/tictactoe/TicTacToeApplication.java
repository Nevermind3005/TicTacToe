package com.example.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        TurnLabel turnLabel = new TurnLabel();
        Logic logic = new Logic(turnLabel);
        PlayArea playArea = new PlayArea(turnLabel,logic);

        BorderPane layout = new BorderPane();

        layout.setTop(turnLabel.getView());
        layout.setCenter(playArea.getView());

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

}