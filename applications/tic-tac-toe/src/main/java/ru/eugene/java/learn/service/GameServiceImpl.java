package ru.eugene.java.learn.service;

import ru.eugene.java.learn.model.Cell;
import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.model.State;

import java.util.HashMap;
import java.util.Map;

public class GameServiceImpl implements GameService {
    private final int fieldSize;
    private final int numChipWin;

    private Map<Cell, Player> field = new HashMap<>();

    public GameServiceImpl(int fieldSize, int numChipWin) {
        if(fieldSize < 3 || numChipWin > fieldSize){
            throw new RuntimeException("ERROR-1");
        }
        this.fieldSize = fieldSize;
        this.numChipWin = numChipWin;
    }

    @Override
    public State getStatePlayingField(Cell cell, Player player) {
        if(!addPlayerOnCell(cell, player)){
            return State.ERROR;
        }
        if(checkRow(cell, player)){
            return State.WIN;
        }
        if(checkColumn(cell, player)){
            return State.WIN;
        }

        return getDrawOrNotFinish();
    }

    private boolean addPlayerOnCell(Cell cell, Player player){
        if(cell.getCoordinateX() < 0 || cell.getCoordinateX() >= fieldSize){
            return false;
        }
        if(cell.getCoordinateY() < 0 || cell.getCoordinateY() >= fieldSize){
            return false;
        }
        if(field.containsKey(cell)){
            return false;
        }
        field.put(cell, player);
        return true;
    }

    private State getDrawOrNotFinish(){
        if(field.size() == Math.pow(fieldSize, 2)){
            return State.DRAW;
        }
        return State.NOT_FINISH;
    }

    private boolean checkRow(Cell cell, Player player){
        int coordinateX = cell.getCoordinateX();
        int coordinateY = cell.getCoordinateY();
        int count = 0;
        for (int i = 0; i < numChipWin; i++) {
            coordinateX++;
            if(coordinateX >= fieldSize){
                break;
            }
            count = counter(count, coordinateX, coordinateY, player);
        }
        for (int i = 0; i < numChipWin; i++) {
            coordinateX--;
            if(coordinateX < 0){
                break;
            }
            count = counter(count, coordinateX, coordinateY, player);
        }
        return count >= numChipWin;
    }

    private boolean checkColumn(Cell cell, Player player){
        int coordinateX = cell.getCoordinateX();
        int coordinateY = cell.getCoordinateY();
        int count = 0;
        for (int i = 0; i < numChipWin; i++) {
            coordinateY++;
            if(coordinateY >= fieldSize){
                break;
            }
            count = counter(count, coordinateX, coordinateY, player);
        }
        for (int i = 0; i < numChipWin; i++) {
            coordinateY--;
            if(coordinateY < 0){
                break;
            }
            count = counter(count, coordinateX, coordinateY, player);
        }
        return count >= numChipWin;
    }

    private int counter(int count, int coordinateX, int coordinateY, Player player){
        Player nextPlayer = field.get(new Cell(coordinateX, coordinateY));
        if(nextPlayer == null){
            return count;
        }
        if(player == nextPlayer){
            count++;
        }
        return count;
    }

    private boolean checkDiagonals(Cell cell){
        return false;
    }

}
