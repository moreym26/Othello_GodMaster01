package com.example.othello_godmaster.view;

import com.example.GameMainActivity;
import com.example.LocalGame;
import com.example.gameConfiguration.GameConfig;
import com.example.infoMessage.GameState;
import com.example.othello_godmaster.infoMessage.OthelloState;

public class OthelloMainActivity extends GameMainActivity {
    @Override
    public GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame(GameState gameState) {
        if(gameState == null)
            return new OthelloLocalGame();
        return new OthelloLocalGame((OthelloState) gameState);
    }
    //create default config
    //create local game
    //look at tictak to
}
