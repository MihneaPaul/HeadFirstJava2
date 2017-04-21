/**
 * Created by Mihnea on 12.04.2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numberOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Steam.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Steam.com");
        System.out.println("Try to sink all in the fewest number of guesses.");

        for(DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess) {
        numberOfGuesses++;
        String result = "miss";
        for(DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("hit")) {
                break;
            }
            if(result.equals("kill")) {
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if(numberOfGuesses<=18) {
            System.out.println("It only took you "+numberOfGuesses + " guesses");
            System.out.println("Your got out before your options sank.");
        }
        else {
            System.out.println("Tokk you long enough. "+numberOfGuesses+ " guesses.");
            System.out.println("You suck.");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String>loc) {
        locationCells = loc;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk "+name+"  :(");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLenght = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt+" ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length()==0) return null;
        } catch (IOException e) {
            System.out.println("IOException: "+e);
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();

        String temp = null;
        int [] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if((comCount%2)==1) {
            incr = gridLenght;
        }
        while(!success & attempts++ <200) {
            location = (int) (Math.random()*gridSize);
            System.out.println(" try "+location);
        int x = 0;
        success = true;
        while(success && x <comSize) {
            if(grid[location] == 0) {
                coords[x++] = location;
                location += incr;
                if(location>=gridSize){
                    success=false;
                }
                if(x>0 && (location%gridLenght==0)) {
                    success = false;
                }
            } else {
                System.out.println(" used "+location);
                success = false;
            }
        }
        }
        int x = 0;
        int row = 0;
        int column = 0;
//        System.out.println("\n");
        while(x<comSize) {
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridLenght);
            column = coords[x] % gridLenght;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
//            System.out.println(" coord "+x+" = "+alphaCells.get(x=1));
        }
        return alphaCells;
    }
}
