package ru.eugene.java.learn;

import ru.eugene.java.learn.model.Cell;
import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.service.GameService;
import ru.eugene.java.learn.service.GameServiceImpl;

public class TicTacToe {
    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl(3, 3);

        System.out.println(gameService.getStatePlayingField(new Cell(0, 0), Player.X));
        System.out.println(gameService.getStatePlayingField(new Cell(0, 1), Player.X));
        System.out.println(gameService.getStatePlayingField(new Cell(0, 2), Player.O));

        System.out.println(gameService.getStatePlayingField(new Cell(1, 0), Player.X));
        System.out.println(gameService.getStatePlayingField(new Cell(1, 1), Player.O));
        System.out.println(gameService.getStatePlayingField(new Cell(1, 2), Player.O));

        System.out.println(gameService.getStatePlayingField(new Cell(2, 0), Player.X));
        System.out.println(gameService.getStatePlayingField(new Cell(2, 1), Player.O));
        System.out.println(gameService.getStatePlayingField(new Cell(2, 2), Player.X));
    }
}
