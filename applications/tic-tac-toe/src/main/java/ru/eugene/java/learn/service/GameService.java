package ru.eugene.java.learn.service;

import ru.eugene.java.learn.model.Cell;
import ru.eugene.java.learn.model.Player;
import ru.eugene.java.learn.model.State;

public interface GameService {
    State getStatePlayingField(Cell cell, Player player);
}
