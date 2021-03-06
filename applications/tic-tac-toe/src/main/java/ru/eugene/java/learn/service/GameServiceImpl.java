package ru.eugene.java.learn.service;

import ru.eugene.java.learn.model.Cell;
import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.model.State;
import ru.eugene.java.learn.util.NumberUtils;

import java.util.HashMap;
import java.util.Map;

public class GameServiceImpl implements GameService {
    private final int fieldSize;
    private final int numChipWin;

    private Map<Cell, Player> field = new HashMap<>();

    public GameServiceImpl(int fieldSize, int numChipWin) {
        if(fieldSize < 3 || numChipWin > fieldSize || numChipWin < 3){
            throw new RuntimeException("ERROR-1");
        }
        this.fieldSize = fieldSize;
        this.numChipWin = numChipWin;
    }

    @Override
    public State getStatePlayingField(Cell cell, Player player) {
        State stateAdd = addPlayerOnCell(cell, player);
        if(stateAdd != null){
            return stateAdd;
        }
        if(isRowWin(cell, player)){
            return State.WIN;
        }
        if(isColumnWin(cell, player)){
            return State.WIN;
        }
        if(isDiagonalsWin(cell, player)){
            return State.WIN;
        }
        return getDrawOrNotFinish();
    }

    private State addPlayerOnCell(Cell cell, Player player){
        State state = State.ERROR;
        if(cell.getCoordinateX() < 0 || cell.getCoordinateX() >= fieldSize){
            state.setDescription("Координата по оси x меньше 0 или больше " + fieldSize);
            return state;
        }
        if(cell.getCoordinateY() < 0 || cell.getCoordinateY() >= fieldSize){
            state.setDescription("Координата по оси y меньше 0 или больше " + fieldSize);
            return state;
        }
        if(field.containsKey(cell)){
            state.setDescription("Клетка с данными координатами занята!");
            return state;
        }
        field.put(cell, player);
        return null;
    }

    private State getDrawOrNotFinish(){
        if(field.size() == Math.pow(fieldSize, 2)){
            return State.DRAW;
        }
        return State.NOT_FINISH;
    }

    private boolean isRowWin(Cell cell, Player player){
        int coordinateX = cell.getCoordinateX();
        int coordinateY = cell.getCoordinateY();
        int numSameChips = 1;

        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> ++x, y -> y);
        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> --x, y -> y);

        return numSameChips >= numChipWin;
    }

    private boolean isColumnWin(Cell cell, Player player){
        int coordinateX = cell.getCoordinateX();
        int coordinateY = cell.getCoordinateY();
        int numSameChips = 1;

        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> x, y -> ++y);
        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> x, y -> --y);

        return numSameChips >= numChipWin;
    }

    private boolean isDiagonalsWin(Cell cell, Player player){
        int coordinateX = cell.getCoordinateX();
        int coordinateY = cell.getCoordinateY();
        int numSameChips = 1;

        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> ++x, y -> --y);
        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> --x, y -> ++y);

        if(numSameChips >= numChipWin){
            return true;
        }

        numSameChips = 1;
        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> ++x, y -> ++y);
        numSameChips = calculateSameChips(numSameChips, coordinateX, coordinateY,
                player, x -> --x, y -> --y);

        return numSameChips >= numChipWin;
    }

    private int calculateSameChips(int numSameChips, int coordinateX, int coordinateY,
                                   Player player, CoordinateOperation operationX,
                                   CoordinateOperation operationY){

        for (int i = 0; i < numChipWin; i++) {
            coordinateX = operationX.operation(coordinateX);
            coordinateY = operationY.operation(coordinateY);
            if(coordinateX < 0 || coordinateX >= fieldSize){
                return numSameChips;
            }
            if(coordinateY < 0 || coordinateY >= fieldSize){
                return numSameChips;
            }
            Player nextPlayer = field.get(new Cell(coordinateX, coordinateY));
            if(nextPlayer == null){
                return numSameChips;
            }
            if(player == nextPlayer){
                numSameChips++;
            }
        }

        return numSameChips;
    }

    @Override
    public void printPlayingField() {
        System.out.print("_|");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(NumberUtils.handleNumber(i) + "|");
        }
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(NumberUtils.handleNumber(i) + "|");
            for (int j = 0; j < fieldSize; j++) {
                Player player = field.get(new Cell(j, i));
                if(player != null){
                    System.out.print(player + "|");
                } else {
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }

    @FunctionalInterface
    private interface CoordinateOperation{
        int operation(int coordinate);
    }
}
