package util;

import java.util.*;
import java.io.*;

public class Fileio {
    private String movieFile = "Data/movies.txt";
    private String seriesFile = "Data/series.txt";

    public List<String> loadMovies() {
        return loadFile(movieFile);
    }

    public List<String> loadSeries() {
        return loadFile(seriesFile);
    }

    private List<String> loadFile(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Fejl: ikke fundet!!!1");
        }
        return lines;
    }
}