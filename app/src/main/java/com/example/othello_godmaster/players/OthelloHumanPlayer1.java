package com.example.othello_godmaster.players;

import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.GameMainActivity;
import com.example.infoMessage.GameInfo;
import com.example.othello_godmaster.R;
import com.example.othello_godmaster.infoMessage.OthelloState;
import com.example.othello_godmaster.view.OthelloView;
import com.example.players.GameHumanPlayer;
import com.example.utilities.Logger;

public class OthelloHumanPlayer1 extends GameHumanPlayer implements View.OnTouchListener {
    //Tag for logging
    private static final String TAG = "OthelloHumanPlayer1";

    // the surface view
    private OthelloView surfaceView;

    private int layoutId;

    /**
     * constructor
     *
     * @param name the name of the player
     */
    public OthelloHumanPlayer1(String name, int layoutId) {
        super(name);
        this.layoutId = layoutId;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        OthelloState gameState = (OthelloState) game.getGameState();
        //Get XY Coordinates
        if(motionEvent != null) {
            gameState.touchX = motionEvent.getX();
            gameState.touchY = motionEvent.getY();
        }
        view.invalidate();
        if(gameState.humanGame) {
            if (gameState.isBlackTurn) {
                if (gameState.dumbMakeMove('b')) {
                    Log.d("click", "black moves");
                    gameState.setIsBlackTurn(false);
                    gameState.endGame();

                    //Checks if no move available for WHITE
                    if(!gameState.moveAvailable()){
                        gameState.setIsBlackTurn(true); //Gives turn back to black if no white moves
                    }
                    view.invalidate();
                }
            }
            else {
                if (gameState.dumbMakeMove('w')) {
                    Log.d("click", "white moves");
                    gameState.setIsBlackTurn(true);
                    gameState.endGame();

                    //Checks if no move available for BLACK
                    if(!gameState.moveAvailable()){
                        gameState.setIsBlackTurn(false); //Gives turn back to white if no black moves
                    }
                    view.invalidate();
                }
            }
            //If move isn't valid for both players, end the game
            if(!gameState.moveAvailable()){
                gameState.setIsBlackTurn(!gameState.isBlackTurn);
                if(!gameState.moveAvailable()){
                    gameState.endGame();
                }
                else gameState.setIsBlackTurn(!gameState.isBlackTurn);
            }
        }
        else if(gameState.AIGame) {
            Handler handler = new Handler();
            if ((gameState.dumbMakeMove('b') && gameState.isBlackTurn) || gameState.goAgain) {
                if (gameState.isBlackTurn) {
                    Log.d("click", "black moves");
                }
                gameState.setIsBlackTurn(false);
                gameState.endGame();
                //Checks if no move available for WHITE

                if (!gameState.moveAvailable()) {
                    gameState.setIsBlackTurn(true); //Gives turn back to black if no white moves
                }
                view.invalidate();
            }
        }
        return false;
    }

    @Override
    public View getTopView() {
        return null;
    }



    @Override
    public void setAsGui(GameMainActivity activity) {

        // Load the layout resource for the new configuration
        activity.setContentView(layoutId);

        // set the surfaceView instance variable
        surfaceView = (OthelloView)myActivity.findViewById(R.id.View);
        Logger.log("set listener","OnTouch");
        surfaceView.setOnTouchListener(this);
    }
    //holds the ui
}
