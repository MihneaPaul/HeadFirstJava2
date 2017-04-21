///**
// * Created by Mihnea on 12.04.2017.
// */
//import java.io.*;
//import java.util.ArrayList;
//public class SimpleDotComTestDrive {
//    public static void main(String[] args) {
//
//        int numOfGuesses = 0;
//        GameHelper helper = new GameHelper();
//        SimpleDotCom dot = new SimpleDotCom();
//        int randomNum = (int) (Math.random() * 5);
//        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
////        dot.setLocationCells(locations); // make an int array for the location of the dor com(3 consec hits out of 7)
//        boolean isAlive = true;
//
//        while (isAlive) {
//            String guess = helper.getUserInput("Enter a number: "); // make a fake user guess
//            String result = dot.checkYourself(guess);
//            numOfGuesses++;
//
//            if (result.equals("kill")) {
//                isAlive = false;
//            }
//        }
//        System.out.println("You took " + numOfGuesses + " guesses.");
//    }
//}
//
//    class SimpleDotCom {
//        private ArrayList<String> locationCells;
//        int numOfHits = 0;
//
//        public void setLocationCells(ArrayList<String> locs) {
//            locationCells=locs;
//        }
//
//        public String checkYourself(String userInput) {
////        int guess = Integer.parseInt(stringGuess); // convert String into array
//        String result = "miss"; // make a variable to hold the result we'll return. "miss" is default
//        int index = locationCells.indexOf(userInput);
//        if(index >= 0) {
//            locationCells.remove(index);
//
//            if (locationCells.isEmpty()) {
//                result = "kill";
//            } else {
//                result = "hit";
//
//            }
//        }
////        System.out.println(result);
//        return result;
//    }
//}
//
//class GameHelper {
//    public String getUserInput(String prompt) {
//        String inputLine = null;
//        System.out.println(prompt + " ");
//        try {
//            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
//            inputLine = is.readLine();
//            if(inputLine.length() == 0) return null;
//        } catch (IOException e) {
//            System.out.println("IOEsception: "+e);
//        }
//        return inputLine;
//    }
//}