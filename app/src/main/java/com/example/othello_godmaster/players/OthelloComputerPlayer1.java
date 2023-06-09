package com.example.othello_godmaster.players;


import android.os.Handler;
import android.util.Log;

import com.example.infoMessage.GameInfo;
import com.example.infoMessage.IllegalMoveInfo;
import com.example.infoMessage.NotYourTurnInfo;
import com.example.othello_godmaster.actionMessage.OthelloMoveAction;
import com.example.othello_godmaster.infoMessage.OthelloState;
import com.example.players.GameComputerPlayer;

//EASY AI



public class OthelloComputerPlayer1 extends GameComputerPlayer {
    public OthelloComputerPlayer1(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) return;
        //Ignore illegal move info too
        if (info instanceof IllegalMoveInfo) return;
        //just in case there is any other types of info, ignore it
        if(!(info instanceof OthelloState)){
            return;
        }

        OthelloState othelloState = new OthelloState((OthelloState) info);

        sleep(3);
            int[] a = othelloState.dumbAIMove();
            game.sendAction(new OthelloMoveAction(this, a[0], a[1]));
        }
    }




