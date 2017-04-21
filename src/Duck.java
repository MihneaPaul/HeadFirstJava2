/**
 * Created by Mihnea on 15.04.2017.
 */
public class Duck {
    int size;

    public Duck(int size) {
        System.out.println("Quack");
        this.size = size;
        System.out.println("Size is "+size);

    }
    public Duck() {
        size = 28;
        System.out.println("No sized Duck");
    }
}
 class SmallDuck extends Duck {
    int size;
    public SmallDuck() {
        System.out.println("Creating a Small Duck");
}
    public SmallDuck(int size) {
        super();
        this.size = size;
    System.out.println("Quaaacky");
}
}

 class UseAdDuck {
     public static void main(String[] args) {
         SmallDuck sd = new SmallDuck();
         SmallDuck sd1 = new SmallDuck(8);
//         Duck d = new Duck(42);
//         System.out.println(d.size);
//         Duck d1 = new Duck();
     }
}
