import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);

        Map<String, Integer> map = new HashMap<>();

        while (true) {
            String line = bfr.readLine();

            if (line == null)
                break;

            String[] entry = line.split(",");
            String publisher = entry[11];

            Integer v = map.getOrDefault(publisher, 0);
            v++;
            map.put(publisher, v);
        }

        fr.close();
        bfr.close();
    }

}