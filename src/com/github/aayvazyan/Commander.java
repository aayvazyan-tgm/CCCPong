package com.github.aayvazyan;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * A wrapper to send commands
 * @author Ari Michael Ayvazyan
 * @version 22.04.2015
 */
public class Commander {
    private final PrintWriter pw;

    public Commander(OutputStream outputStream) {
        pw = new PrintWriter(outputStream, true);
    }

    /**
     *
     * @param v a value between -36 and 36
     */
    public void move(int v){
        if(v>36||v<-36)throw new RuntimeException("Moved too fast: "+v);
        pw.println("move "+v);
    }
}
