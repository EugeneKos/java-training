package ru.eugene.java.learn;

import ru.eugene.java.learn.model.Cell;
import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.model.State;
import ru.eugene.java.learn.service.GameService;
import ru.eugene.java.learn.service.GameServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int fieldSize = getIntFromString(bufferedReader,
                "Введите размер игрового поля: ");
        int numChipWin = getIntFromString(bufferedReader,
                "Введите количесво выиграшных одинаковых фишек: ");

        GameService gameService = new GameServiceImpl(fieldSize, numChipWin);
        State state = State.NOT_FINISH;
        boolean moveX = true;
        while (state == State.NOT_FINISH || state == State.ERROR) {
            System.out.println("Ход: " + (moveX ? "X" : "O"));
            int x = getIntFromString(bufferedReader, "Введите координату клетки по оси x: ");
            int y = getIntFromString(bufferedReader, "Введите координату клетки по оси y: ");
            if (moveX) {
                state = gameService.getStatePlayingField(new Cell(x, y), Player.X);
                if (state != State.ERROR) {
                    moveX = false;
                } else {
                    System.out.println("Клетка с данными параметрами не существует или уже заполнена!");
                }
            } else {
                state = gameService.getStatePlayingField(new Cell(x, y), Player.O);
                if (state != State.ERROR) {
                    moveX = true;
                } else {
                    System.out.println("Клетка с данными параметрами не существует или уже заполнена!");
                }
            }
            gameService.printPlayingField();
        }
        if (state == State.WIN) {
            System.out.println("Победитель игры: " + (!moveX ? "X" : "O"));
        } else {
            System.out.println("Ничья !!!");
        }
    }

    private static int getIntFromString(BufferedReader reader, String message) {
        while (true) {
            try {
                System.out.print(message);
                String text = reader.readLine();
                return Integer.parseInt(text);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода");
            }
        }
    }
}
