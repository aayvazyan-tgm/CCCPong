package com.github.aayvazyan.inputHandling;

import com.github.aayvazyan.Game;

/**
 * @author Ari Michael Ayvazyan
 * @version 22.04.2015
 */
public class GameUpdater implements InputHandler {
    private final Game game;

    public GameUpdater(Game game) {
        this.game = game;
    }

    @Override
    public void handleInput(String input) {
        System.out.println(input);
        String[] splittetInput = input.split(" ");
        switch (splittetInput[0]) {
            case "player":
                updatePlayer(Integer.parseInt(splittetInput[1]), Integer.parseInt(splittetInput[2]));
                break;
            case "cpu":
                updateCPU(Integer.parseInt(splittetInput[1]), Integer.parseInt(splittetInput[2]));
                break;
            case "ball":
                updateBall(Float.parseFloat(splittetInput[1]), Float.parseFloat(splittetInput[2]), Float.parseFloat(splittetInput[3]), Float.parseFloat(splittetInput[4]));
                break;
            case "update":
                game.onUpdate();
                break;
        }
        //Update the game class
    }

    private void updatePlayer(int pos, int v) {
        game.playerX=pos;
        game.playerV=v;
    }

    private void updateCPU(int pos, int v) {
        game.cpuX=pos;
        game.cpuV=v;
    }

    private void updateBall(float x, float y, float vx, float vy) {
        game.ballX=x;
        game.ballY=y;
        game.ballXV=vx;
        game.ballYV=vy;
    }
}
