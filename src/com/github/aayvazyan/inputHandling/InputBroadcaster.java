package com.github.aayvazyan.inputHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Make sure to call start() after initialisation
 * @author Ari Michael Ayvazyan
 * @version 22.04.2015
 */
public class InputBroadcaster {
    private final LinkedList<InputHandler> inputHandlers = new LinkedList<InputHandler>();
    private final BufferedReader inReader;

    public InputBroadcaster(InputStream inputStream) {
        inReader = new BufferedReader(new InputStreamReader(inputStream));
    }
    public void addInputHandler(InputHandler... newInputHandlers){
            for (InputHandler newInp: newInputHandlers){
                inputHandlers.add(newInp);
            }
    }

    public void start(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        processReceivedMessage(inReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void processReceivedMessage(String s) {
        for (InputHandler inp : inputHandlers) {
            inp.handleInput(s);
        }
    }
}
