package IO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihnea on 09.05.2017.
 */
public class Box implements Serializable {
    private int width;
    private int height;
    private int length;
    private String color;

    public Box(int width, int height, int length, String color) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Box myBox1 = new Box(1,2,3,"brown");
        Box myBox2 = new Box(10,20,30,"white");

        try{
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Box.ser"))));
            os.writeObject(myBox1);
            os.writeObject(myBox2);
            os.close();
        }catch (IOException e){e.printStackTrace();}

        myBox1.setColor("green");
        myBox2.setColor("black");

        try{
           BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Box.log")));
            writer.write(myBox1.toString());
            writer.newLine();
            writer.write(myBox2.toString());
            writer.close();
        }catch (IOException e){e.printStackTrace();}
    }
}

class ReturnOfTheBoxes {
    public static void main(String[] args) {
        try {
            ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Box.ser")));
            Object object = os.readObject();
            Object object2 = os.readObject();
            Box helloBox1 = (Box) object;
            Box helloBox2 = (Box) object2;
            os.close();
            System.out.println(helloBox1+"\n"+helloBox2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Box.log"));
            String line;
            while((line=reader.readLine())!=null) {
                System.out.println(line);
            }
        }catch (IOException e){}
    }
}
