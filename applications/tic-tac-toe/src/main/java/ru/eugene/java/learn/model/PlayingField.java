package ru.eugene.java.learn.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayingField {
    private Map<Cell, Player> field = new HashMap<>();

    public void addPlayerIntoField(Cell cell, Player player){
        field.put(cell, player);
    }

    public Map<Cell, Player> getField() {
        return field;
    }

    public List<Player> getPlayersOnRow(int index, boolean vertical){
        List<Player> players = new LinkedList<>();
        if(index < 0 || index > 2){
            throw new IllegalArgumentException("");
        }
        for (Map.Entry<Cell, Player> entry : field.entrySet()){
            int nonChangeCoordinate;
            if(vertical){
                nonChangeCoordinate = entry.getKey().getX();
            } else {
                nonChangeCoordinate = entry.getKey().getY();
            }
            if(nonChangeCoordinate == index){
                players.add(entry.getValue());
            }
        }
        return players;
    }

    public List<Player> getPlayersOnDiagonal(boolean flag){
        List<Player> players = new LinkedList<>();
        for (Map.Entry<Cell, Player> entry : field.entrySet()){
            Cell cell = entry.getKey();
            if(flag){
                if(cell.getX() == cell.getY()){
                    players.add(entry.getValue());
                }
            } else {
                if(cell.getX() + cell.getY() == 2){
                    players.add(entry.getValue());
                }
            }
        }
        return players;
    }
}
