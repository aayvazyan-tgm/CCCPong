package com.github.aayvazyan;

import com.github.aayvazyan.inputHandling.GameUpdater;
import com.github.aayvazyan.inputHandling.InputBroadcaster;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            //Establish the connection
            final Socket pongSocket = new Socket("localhost", 7000);
            final OutputStream outputStream = pongSocket.getOutputStream();
            final InputStream inputStream = pongSocket.getInputStream();
            //Setup the game
            Game game = new Game(new Commander(outputStream));
            //Setup the received input broadcaster
            InputBroadcaster inputBroadcaster = new InputBroadcaster(inputStream);
            //Add the input handlers
            inputBroadcaster.addInputHandler(new GameUpdater(game));
            //start receiving the input
            inputBroadcaster.start();
            //The game is running

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
