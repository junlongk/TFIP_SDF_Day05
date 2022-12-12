import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String HEADER = "word,count\n";

    public static void main(String[] args) {
        String fileName = args[0];

        System.out.printf("processing: %s\n", fileName);

        // Open the file
        // Read the first 100 lines, print out each line
        // Close the file when done
        // If the file is less than 100 lines, close when done

        // File fobj = Paths.get(fileName).toFile();

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader bfr = new BufferedReader(fr);

            // String line;
            // int counter = 0;
            // String[] currLineArr;
            // int wordCounter = 0;
            // while ((line = bfr.readLine()) != null && counter < 100) {
            //     if (line.length() > 1) {
            //         currLineArr = line.trim().split(" ");
            //         wordCounter += currLineArr.length;
            //     }
            //     System.out.printf("%s\n", line);
            //     counter++;
            // }
            // System.out.printf("Total wordcount: %d\n", wordCounter);

            Map<String, Integer> wordFreq = new HashMap<>();
            int wordCount = 0;
            
            for (int i = 0; i < 100; i++) {
                String line = bfr.readLine();
                if (line.length() > 1) {
                    String[] words = line.trim().split(" ");
                    wordCount += words.length; // count total number of words

                    for (String w: words) {
                        String cleanedWords = w.replaceAll(",", "");
                        int v = wordFreq.getOrDefault(cleanedWords, 0);
                        v++;
                        wordFreq.put(cleanedWords, v);
                    }
                }
            }

            bfr.close();
            fr.close(); 

            // for (String key : wordFreq.keySet()) {
            //     System.out.printf("%s => %d\n", key, wordFreq.get(key));
            // }

            System.out.printf("Total wordcount: %d\n", wordCount);
            System.out.printf("Total number of unique words: %d\n", wordFreq.size());


            // Create CSV file
            FileOutputStream fos = new FileOutputStream(args[1]);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            osw.write(HEADER);
            for (String w: wordFreq.keySet()) {
                String outputLine = String.format("%s, %d\n", w, wordFreq.get(w));
                osw.write(outputLine);
            }

            osw.flush();
            osw.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}