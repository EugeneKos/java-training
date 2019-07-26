package ru.eugene.java.learn.model;

import java.util.HashMap;
import java.util.Map;

public class PlayingField {
    private final int fieldSize;
    private final int numChipWin;

    private Map<Cell, Player> field = new HashMap<>();

    public PlayingField(int fieldSize, int numChipWin) {
        this.fieldSize = fieldSize;
        this.numChipWin = numChipWin;
    }

    public boolean addPlayerIntoField(Cell cell, Player player){
        if(!field.containsKey(cell)){
            field.put(cell, player);
            return true;
        }
        return false;
    }

    public Player getPlayerByCell(Cell cell){
        return field.get(cell);
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public int getNumChipWin() {
        return numChipWin;
    }
}
