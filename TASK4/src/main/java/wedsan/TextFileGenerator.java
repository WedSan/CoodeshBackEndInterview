package wedsan;

import java.io.*;

public class TextFileGenerator {

    public File generateFile(String text, String fileName){
        File file = new File(fileName);

        try{
            FileWriter fl = new FileWriter(file);
            fl.write(text);
            fl.close();
        } catch (IOException e) {
            throw new RuntimeException("Error to save json in file: "+e.getMessage(), e);
        }
        return file;
    }
}
