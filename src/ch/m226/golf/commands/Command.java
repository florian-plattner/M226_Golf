package ch.m226.golf.commands;

import ch.m226.golf.Game;

/**
 * The interface used to for commands.
 */
public interface Command{
    boolean use (Game game, String[] args);
}
