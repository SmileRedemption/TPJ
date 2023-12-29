package Lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private final List<String> lines = new ArrayList<>();
    private int currentMaxCount = 0;

    public void readFileAndGetTask(String fileName) {

        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            dataInputStream = new DataInputStream(fileInputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                int count = (line.split(" ")).length;

                if (count > currentMaxCount) {
                    lines.clear();
                    lines.add(line);
                    currentMaxCount = count;
                } else if (count == currentMaxCount) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (Exception ignored) {
            }
        }
    }

    public int getCountOfWordsInMaxLine() {
        return currentMaxCount;
    }

    public List<String> getMaxLines() {
        return lines;
    }
}