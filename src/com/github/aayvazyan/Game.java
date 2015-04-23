package com.github.aayvazyan;

/**
 * @author Ari Michael Ayvazyan
 * @version 22.04.2015
 */
public class Game {
    private int height = 600;
    private int width = 800;
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
        //Calculate formula of the ball
        float goTo = calcBallDest(height,width,ballX,ballY,ballXV,ballYV,15);
        int move = 0;
        int playerX = this.playerX + 75;
        move=-speedLimiter(playerX - (int)goTo);
        System.out.println("Moving: " + move);
        commander.move(move);
    }
    int speedLimiter(int desiredSpeed){
        int move = desiredSpeed;
        if (desiredSpeed > 36) move = 36;
        else if (desiredSpeed < -36) move = -36;
        return move;
    }
    int calcBallDest(int height, int width, float ballX, float ballY, float ballXV, float ballYV, int widthOffset) {
        float tmpX = ballX;
        float tmpY = ballY;
        width-=widthOffset;

        if (ballXV >= 0) {
            while (tmpX <= width) {
//            while ((tmpY>0&&tmpY<height)){
                tmpX += ballXV;
                tmpY += ballYV;
                if (tmpY < 0) {
                    tmpY = tmpY * (-1);
                    ballYV *= -1;
                } else if (tmpY > height) {
                    tmpY = height * 2 - tmpY;
                    ballYV *= -1;
                }
//            }
            }
            ballXV*=-1;
//            ballYV*=-1;
        }
        while (tmpX > widthOffset) {
//            while ((tmpY>0&&tmpY<height)){
            tmpX += ballXV;
            tmpY += ballYV;
            if (tmpY < 0) {
                tmpY = tmpY * (-1);
                ballYV *= -1;
            } else if (tmpY > height) {
                tmpY = height * 2 - tmpY;
                ballYV *= -1;
            }
//            }
        }
        return (int) tmpY;
//        return (int)height/2;
    }
}
