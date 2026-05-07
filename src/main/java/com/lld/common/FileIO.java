package com.lld.common;

import java.io.*;

public class FileIO {
    public static void setup() {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");

            if (inputFile.exists()) {
                System.setIn(new FileInputStream(inputFile));
                System.out.println("--- Reading from input.txt ---");
            }
            
            // Redirect output to output.txt (append mode or overwrite)
            PrintStream fileOut = new PrintStream(new FileOutputStream(outputFile, false));
            System.setOut(fileOut);
            
            // Optionally redirect errors too
            System.setErr(fileOut);

        } catch (IOException e) {
            System.err.println("Could not setup File IO: " + e.getMessage());
        }
    }
}
