package com.example.tictactoe;

public class Logic {

    private TurnLabel turnLabel;
    private char[][] area;
    public boolean gameShouldEnd;

    public Logic(TurnLabel turnLabel){
        this.area = new char [3][3];
        this.turnLabel = turnLabel;
        this.gameShouldEnd = false;
    }

    public void addToArea (int x,int y){
        area[x][y] = turnLabel.getXOrO().charAt(0);
    }

    public char getPlayerAtPosition(int x,int y){
        return area[x][y];
    }

    public void addPlayerIfAbsent(int x,int y){
        if(!String.valueOf(area[x][y]).equals(Turn.O.toString())){
            if(!String.valueOf(area[x][y]).equals(Turn.X.toString())){
                addToArea(x,y);
                turnLabel.changeAndSetTurn();
                tie();
                win();
            }
        }
    }

    public void tie(){
        int count = 0;
        for(int i = 0;i <= 2;i++){
            for(int j = 0;j<= 2;j++){
                if(String.valueOf(area[i][j]).equals(Turn.O.toString()) || String.valueOf(area[i][j]).equals(Turn.X.toString())){
                    count ++;
                }
            }
        }
        if(count == 9){
            turnLabel.setLabelTie();
        }
    }

    public boolean win(){
        if(checkLeftToRight(Turn.O)){
            turnLabel.setLabelPlayerWon(Turn.O);
            gameShouldEnd = true;
        }else if(checkLeftToRight(Turn.X)){
            turnLabel.setLabelPlayerWon(Turn.X);
            gameShouldEnd = true;
        }else if(checkRightToLeft(Turn.O)){
            turnLabel.setLabelPlayerWon(Turn.O);
            gameShouldEnd = true;
        }else if(checkRightToLeft(Turn.X)){
            turnLabel.setLabelPlayerWon(Turn.X);
            gameShouldEnd = true;
        }else{
            for(int i =0;i <= 2;i++){
                if(checkHorizontalLine(Turn.O,i)){
                    turnLabel.setLabelPlayerWon(Turn.O);
                    gameShouldEnd = true;
                }else if(checkHorizontalLine(Turn.X,i)){
                    turnLabel.setLabelPlayerWon(Turn.X);
                    gameShouldEnd = true;
                }else if(checkVerticalLine(Turn.O,i)){
                    turnLabel.setLabelPlayerWon(Turn.O);
                    gameShouldEnd = true;
                }else if(checkVerticalLine(Turn.X,i)){
                    turnLabel.setLabelPlayerWon(Turn.X);
                    gameShouldEnd = true;
                }
            }
        }
        return false;
    }

    public boolean checkLeftToRight(Turn turn){
        return String.valueOf(area[0][0]).equals(turn.toString()) && String.valueOf(area[1][1]).equals(turn.toString()) && String.valueOf(area[2][2]).equals(turn.toString());
    }

    public boolean checkRightToLeft(Turn turn){
        return String.valueOf(area[0][2]).equals(turn.toString()) && String.valueOf(area[1][1]).equals(turn.toString()) && String.valueOf(area[2][0]).equals(turn.toString());
    }

    public boolean checkHorizontalLine(Turn turn,int x){
        return String.valueOf(area[x][0]).equals(turn.toString()) && String.valueOf(area[x][1]).equals(turn.toString()) && String.valueOf(area[x][2]).equals(turn.toString());
    }

    public boolean checkVerticalLine(Turn turn,int y){
        return String.valueOf(area[0][y]).equals(turn.toString()) && String.valueOf(area[1][y]).equals(turn.toString()) && String.valueOf(area[2][y]).equals(turn.toString());
    }

}