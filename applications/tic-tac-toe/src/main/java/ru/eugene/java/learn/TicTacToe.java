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
        startTicTacToe();
    }

    private static void startTicTacToe(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int fieldSize = getIntFromString(bufferedReader,
                "Введите размер игрового поля: ");
        int numChipWin = getIntFromString(bufferedReader,
                "Введите количесво выиграшных одинаковых фишек: ");

        GameService gameService = new GameServiceImpl(fieldSize, numChipWin);
        gameService.printPlayingField();
        
        State state = State.NOT_FINISH;
        Player currentPlayer = Player.X;

        while (state == State.NOT_FINISH || state == State.ERROR) {
            System.out.println("Ход: " + currentPlayer);
            int x = getIntFromString(bufferedReader, "Введите координату клетки по оси x: ");
            int y = getIntFromString(bufferedReader, "Введите координату клетки по оси y: ");
            state = gameService.getStatePlayingField(new Cell(x, y), currentPlayer);
            currentPlayer = changePlayer(state, currentPlayer);
            gameService.printPlayingField();
        }

        if (state == State.WIN) {
            System.out.println("Победитель игры: " + currentPlayer);
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

    private static Player changePlayer(State state, Player current){
        if(state == State.WIN){
            return current;
        }
        if(state != State.ERROR){
            if(current == Player.X){
                return Player.O;
            }
            if(current == Player.O){
                return Player.X;
            }
        } else {
            System.out.println(state.getDescription());
        }
        return current;
    }
}
