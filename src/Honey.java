import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mihnea on 15.04.2017.
 */
public class Honey {
    public static void main(String[] args) {
        System.out.println(Bear.bearCount);
        Bear bear = new Bear("Honey");
        System.out.println(bear.getName());
        System.out.println(Bear.bearCount);
        Bear lolli = new Bear("Marshmallow");
        System.out.println(lolli.getName());
        System.out.println(Bear.bearCount);
        Honey honeyPot = new Honey();
        Honey [] ha = {honeyPot, honeyPot, honeyPot, honeyPot};
        Bees b1 = new Bees();
        b1.beeHA = ha;
        Bear [] ba = new Bear[5];
        for(int i=0;i<5;i++) {
            ba[i] = new Bear("Lollipop");
            ba[i].hunny = honeyPot;
        }
        Kit k = new Kit();
        k.kh = honeyPot;
        Raccoon r = new Raccoon();
        r.rh = honeyPot;
        r.k = k;
//        k = null;
        System.out.println(Bear.bearCount);
        int x = 42;
        int y = 23;
        String intString = Integer.toString(x);
        System.out.println(intString +" "+ 43);
        int one = 20456654;
        double two = 100567890.248907;
        String s = String.format("The rank is %,d out of %,.1f", one, two);
        System.out.println(s);
        String s1 = String.format("%tc", new Date());
        System.out.println(s1);
        Date today = new Date();
        System.out.println(String.format("%tA, %tB, %td", today,today,today));
        System.out.println(String.format("%tA, %<tB, %<td", today));
        Calendar c = Calendar.getInstance();
        c.set(2016,3,16,15,54);
        long day1 = c.getFirstDayOfWeek();
        System.out.println(day1);

        long day2 = c.getTimeInMillis();
        day2 += 1000*60*60;
        c.setTimeInMillis(day1);
        System.out.println("new hour " +c.get(c.HOUR_OF_DAY));
        c.add(c.DATE, 35);
        System.out.println("add 35 days "+c.getTime());
        c.roll(c.DATE, 30);
        System.out.println("roll 35 days "+c.getTime());
        c.set(c.DATE,1);
        System.out.println("set to 1 "+c.getTime());
    }
}
class Bees {

    Honey [] beeHA;
}
class Raccoon {
    Kit k;
    Honey rh;
}
class Kit {
    Honey kh;
}
class Bear {
    static int bearCount = 0;
    private String name;
    Honey hunny;
    final int x = 12;
    public static void go(final int x) {
        System.out.println(x);
    }
    public Bear(String name) {
        this.name = name;
        bearCount ++;
    }

    public String getName() {
        return name;
    }
}
