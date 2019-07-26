package ru.eugene.java.learn.service;

import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.model.PlayingField;
import ru.eugene.java.learn.model.State;

import java.util.List;

public class StateServiceImpl implements StateService {
    @Override
    public State getStatePlayingField(PlayingField playingField) {
        if(playingField.getField().size() < 9){
            return State.NOT_FINISH;
        }
        if(getStateOnRow(playingField, true) == State.WIN){
            return State.WIN;
        }
        if(getStateOnRow(playingField, false) == State.WIN){
            return State.WIN;
        }
        return getStateOnDiagonal(playingField);
    }

    private State getStateOnRow(PlayingField playingField, boolean vertical){
        for (int i = 0; i < 3; i++) {
            List<Player> players = playingField.getPlayersOnRow(i, vertical);
            if(equalsPlayers(players)){
                return State.WIN;
            }
        }
        return State.DRAW;
    }

    private State getStateOnDiagonal(PlayingField playingField){
        if(equalsPlayers(playingField.getPlayersOnDiagonal(true))){
            return State.WIN;
        }
        if(equalsPlayers(playingField.getPlayersOnDiagonal(false))){
            return State.WIN;
        }
        return State.DRAW;
    }

    private boolean equalsPlayers(List<Player> players){
        Player first = players.get(0);
        for (int i = 1; i < 3; i++) {
            if(first != players.get(i)){
                return false;
            }
        }
        return true;
    }
}
