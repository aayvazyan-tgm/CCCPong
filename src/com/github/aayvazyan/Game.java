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
        float diff = (playerX+75 - (float)ballY);
        move = (int) -diff;
        float div=diff/36f;
        if(div>1&&div>-1)move=-36;
        if(div<1&&div<-1)move=36;
        commander.move(move);
    }
}
