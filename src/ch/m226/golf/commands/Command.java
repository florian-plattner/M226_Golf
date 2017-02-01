package ch.m226.golf.commands;

import ch.m226.golf.Game;

public interface Command{
    boolean use (Game game, String[] args);
}
