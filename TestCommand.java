import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCommand 
{
    static public ArrayList<String> commandList = new ArrayList<>();

    static public ArrayList<String> readTestCommandFile(String filename)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line); // Print each line of the file
            commandList.add(line);
        }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return commandList;
    }
}

