package com.example.scripts;

import java.io.FileWriter;
import java.io.IOException;

public class CSVwriter {

    public void writeStringsOnCSV(String string){
        try {
            FileWriter writer = new FileWriter("D://file.csv");

            writer.write(string);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
