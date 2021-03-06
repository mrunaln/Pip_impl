package utils;

import model.OutputSchedule;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    final static String INPUT_FILE_NAME = "/Users/mrunalnargunde/Desktop/Development/spring2015/RTES/Pip_impl/example/hw4_input.txt";
    final static String OUTPUT_FILE_NAME = "/Users/mrunalnargunde/Desktop/Development/spring2015/RTES/Pip_impl/example/hw4_output.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;

    public List<String> getInputTasks() {
        FileHandler text = new FileHandler();
        List<String> lines = null;
        try {
             lines = text.readSmallTextFile(INPUT_FILE_NAME);
        }catch (Exception e){
            System.out.println("Exception " + e);
        }
        return lines;
    }

    public void printOutputSchedule(List<OutputSchedule> outputSchedule) {
        FileHandler text = new FileHandler();
        List<String> lines = new ArrayList<String>(outputSchedule.size() + 1);
        lines.add(0, "Time \t Job \t\t Action \t Priority \t ");
        for(int i =1 ; i < outputSchedule.size(); i ++)
          lines.add(i, outputSchedule.get(i).toString());

        try {
            text.writeSmallTextFile(lines, OUTPUT_FILE_NAME);
        }catch(Exception e){
            System.out.println("Exception " + e);
        }
    }

    List<String> readSmallTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }

    void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines, ENCODING);
    }
}
