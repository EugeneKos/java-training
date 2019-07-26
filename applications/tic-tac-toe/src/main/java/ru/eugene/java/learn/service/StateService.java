package ru.eugene.java.learn.service;

import ru.eugene.java.learn.model.PlayingField;
import ru.eugene.java.learn.model.State;

public interface StateService {
    State getStatePlayingField(PlayingField playingField);
}
