/**
 * Created by Mihnea on 16.04.2017.
 */
import java.util.*;

public class FullMoons {
    static int DAY_IM = 100*60*60*24;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2017,0,7,15,40);
        long day1 = c.getTimeInMillis();
        for(int i = 0;i<3;i++) {
            day1 += (DAY_IM*29.52);
            c.setTimeInMillis(day1);
            System.out.println(String.format("full moon on %tc",c));
        }
    }
}
