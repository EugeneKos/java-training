package ru.eugene.java.learn;

import ru.eugene.java.learn.model.Cell;
import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.model.PlayingField;
import ru.eugene.java.learn.service.StateService;
import ru.eugene.java.learn.service.StateServiceImpl;

public class TicTacToe {
    public static void main(String[] args) {
        PlayingField playingField = new PlayingField();

        playingField.addPlayerIntoField(new Cell(0, 0), Player.O);
        playingField.addPlayerIntoField(new Cell(0, 1), Player.X);
        playingField.addPlayerIntoField(new Cell(0, 2), Player.O);

        playingField.addPlayerIntoField(new Cell(1, 0), Player.O);
        playingField.addPlayerIntoField(new Cell(1, 1), Player.X);
        playingField.addPlayerIntoField(new Cell(1, 2), Player.O);

        playingField.addPlayerIntoField(new Cell(2, 0), Player.X);
        playingField.addPlayerIntoField(new Cell(2, 1), Player.O);
        playingField.addPlayerIntoField(new Cell(2, 2), Player.X);

        StateService stateService = new StateServiceImpl();

        System.out.println(stateService.getStatePlayingField(playingField));

    }
}
