package com.github.aayvazyan;

/**
 * @author Ari Michael Ayvazyan
 * @version 22.04.2015
 */
public class Game {

    private final Commander commander;
    public int playerV;
    public int playerX;

    public int cpuX;
    public int cpuV;

    public float ballX;
    public float ballY;
    public float ballXV;
    public float ballYV;

    public Game(Commander commander) {
        this.commander = commander;
    }

    public void onUpdate() {
        int move = 0;
        System.out.println("PreviousMove: "+playerV);
        System.out.println("curentPos: "+playerX);
        int playerX = this.playerX + 75;
        float diff = (playerX - (float) ballY);
        if(ballXV>0)diff=playerX-300;
        if (diff > 36) move = -36;
        else if (diff < -36) move = 36;
        System.out.println("Moving: "+move);
        commander.move(move);
    }
}
