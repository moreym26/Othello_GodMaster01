package com.example.actionMessage;

import com.example.players.GamePlayer;

/**
 * An action by which the player acknowledges that the game is over.
 *
 * @author Steven R. Vegdahl
 * @version July 2013
 */
public class GameOverAction extends GameAction {
    //Tag for logging
    private static final String TAG = "GameOverAckAction";
    // to satisfy the Serializable interface
    private static final long serialVersionUID = 4096230060363451102L;

    /**
     * constructor
     *
     * @param p
     * 		the player to sent the action
     */
    public GameOverAction(GamePlayer p) {
        super(p);
    }
}
