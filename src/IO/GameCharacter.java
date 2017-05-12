package IO;
import java.io.*;
/**
 * Created by Mihnea on 09.05.2017.
 */
public class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponList="";
        for(int i=0;i<weapons.length;i++) {
            weaponList +=weapons[i]+" ";
        }
        return weaponList;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }
}

class GameServerTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(70,"Elf",new String[]{"bow,","sword,","dust"});
        GameCharacter two = new GameCharacter(140,"Necromancer",new String[]{"scythe,","codex book,","sword"});
        GameCharacter three = new GameCharacter(200,"Wizard", new String[]{"orb,","staff,","wand"});

        one.setPower(5000);
        two.setPower(6000);
        three.setPower(20000);

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }catch (IOException e){e.printStackTrace();}
        one=null;
        two=null;
        three=null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("One: "+oneRestore.getType()+", "+oneRestore.getPower()+" Power, uses: "+oneRestore.getWeapons());
            System.out.println("Two: "+twoRestore.getType()+", "+twoRestore.getPower()+" Power, uses: "+twoRestore.getWeapons());
            System.out.println("Three: "+threeRestore.getType()+", "+threeRestore.getPower()+" Power, uses: "+threeRestore.getWeapons());

        }catch (IOException | ClassNotFoundException e) {e.printStackTrace();}


    }
}
