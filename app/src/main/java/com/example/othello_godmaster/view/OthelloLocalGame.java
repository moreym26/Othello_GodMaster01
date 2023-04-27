package com.example.othello_godmaster.view;

import com.example.Game;
import com.example.othello_godmaster.infoMessage.OthelloState;
import com.example.players.GamePlayer;
import com.example.utilities.GameTimer;
import com.example.utilities.Tickable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
public abstract class OthelloLocalGame implements Game, Tickable {
    //tict
    //dont forget start
    //Tag for logging
    private static final String TAG = "LocalGame";

    // the stage that the game is in
    private GameStage gameStage = GameStage.BEFORE_GAME;

    // the handler for the game's thread
    private Handler myHandler;

    // the players in the game, in order of  player number
    protected GamePlayer[] players;

    // whether the game's thread is running
    private boolean running = false;

    // the players' names, paralleling the 'players' array
    protected String[] playerNames;
    private int playerNameCount = 0; // number of players who have told us their name

    // the players are ready to start
    private boolean[] playersReady;
    private int playerReadyCount = 0; // number of players who are ready to start the game

    // the players which have acknowledged that the game is over
    private boolean[] playersFinished;
    private int playerFinishedCount = 0; // number of player who have so acknowledged

    // this game's timer and timer action
    private GameTimer myTimer = new GameTimer(this);

    // the game's state
    protected OthelloState state;

    // an enum-class that itemizes the game stages
    protected static enum GameStage {
        BEFORE_GAME, WAITING_FOR_NAMES, WAITING_FOR_READY, DURING_GAME, GAME_OVER, SETUP_PHASE
    }
}
