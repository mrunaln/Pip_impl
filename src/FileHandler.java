import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileHandler {
    final static String FILE_NAME = "/Users/mrunalnargunde/Desktop/Development/spring2015/RTES/Pip_impl/example/hw4_input.txt";
    final static String OUTPUT_FILE_NAME = "/Users/mrunalnargunde/Desktop/Development/spring2015/RTES/Pip_impl/example/hw4_output.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String... aArgs) throws IOException {
        FileHandler text = new FileHandler();
        List<String> lines = text.readSmallTextFile(FILE_NAME);
        log(lines);
        lines.add("This is a line added in code.");
        text.writeSmallTextFile(lines, OUTPUT_FILE_NAME);
    }


    List<String> readSmallTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }

    void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines, ENCODING);
    }


    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }


}
