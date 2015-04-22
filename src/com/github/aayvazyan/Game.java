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
        float diff = (playerX +150/2 - (float)ballY);
        System.out.println("diff :"+diff);
        move = (int) diff;
        if(diff/36f>1&&!(diff/36f<1))move=-36;
        if(diff/36f<1&&!(diff/36f>1))move=36;
        System.out.println(move);
        commander.move(move);
    }
}
