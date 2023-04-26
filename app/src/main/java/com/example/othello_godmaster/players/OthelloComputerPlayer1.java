package com.example.othello_godmaster.players;

import android.os.Handler;
import android.util.Log;

import com.example.infoMessage.GameInfo;
import com.example.infoMessage.IllegalMoveInfo;
import com.example.infoMessage.NotYourTurnInfo;
import com.example.othello_godmaster.infoMessage.OthelloState;
import com.example.players.GameComputerPlayer;

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
        if (!othelloState.getIsBlackTurn()) {

                Handler handler = new Handler();


                    //White AI move
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (!othelloState.isDumb) {
                                othelloState.godAIMove();
                            } else {
                                othelloState.dumbAIMove();
                            }
                            othelloState.endGame();
                            view.invalidate();
                            if(!othelloState.isBlackTurn){ Log.d("click", "white moves");}
                            othelloState.setIsBlackTurn(true);
                            if(!othelloState.moveAvailable()){
                                othelloState.setGoAgain(true);
                            }
                        }
                    }, 2000);
                    othelloState.setGoAgain(false);
                }

            }           
        }



