import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    final static String FILE_NAME = "/Users/mrunalnargunde/Desktop/Development/spring2015/RTES/Pip_impl/example/hw4_input.txt";
    final static String OUTPUT_FILE_NAME = "/Users/mrunalnargunde/Desktop/Development/spring2015/RTES/Pip_impl/example/hw4_output.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;
    final static List<Tasks> allTasks = new ArrayList<Tasks>(10);

    public static void main(String... aArgs) throws IOException {
        FileHandler text = new FileHandler();
        List<String> lines = text.readSmallTextFile(FILE_NAME);
        parseLinesToTasks(lines);
        log(lines);
        text.writeSmallTextFile(lines, OUTPUT_FILE_NAME);
    }



    static void parseLinesToTasks(List<String> lines){
        int i;
        for (i=0; i < lines.size() ; i++){
                String oneTask[] = lines.get(i).split(" ");
                Tasks current_Task = new Tasks (oneTask[0].trim(),Integer.parseInt(oneTask[1].trim()), Integer.parseInt(oneTask[2].trim()),
                                                Integer.parseInt(oneTask[3].trim()), Integer.parseInt(oneTask[4].trim()));


                int no_of_resource_requests = Integer.parseInt(oneTask[5]);
                List<Resource_Regions> resource_regions = new ArrayList<Resource_Regions>( no_of_resource_requests);
                Resource_Regions current_region = null;

                int resource_counter = 6;
                while (no_of_resource_requests > 0 ){
                    current_region = new Resource_Regions(
                                        oneTask[resource_counter++],
                                        Integer.parseInt(oneTask[resource_counter++]),
                                        Integer.parseInt(oneTask[resource_counter++])
                                    );
                    resource_regions.add(current_region);
                    no_of_resource_requests--;
                }
                current_Task.resource_regions = resource_regions;
                allTasks.add(i, current_Task);
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


    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }


}
