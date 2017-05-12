package IO;

/**
 * Created by Mihnea on 10.05.2017.
 */
import java.io.*;

public class WriteAFile {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("hello foo!");
            writer.close();
        }catch (IOException e){e.printStackTrace();}
    }
}
