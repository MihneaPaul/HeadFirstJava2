/**
 * Created by Mihnea on 15.04.2017.
 */
public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public Animal(String name) {
        this.name = name;
    }
}

class Hippo extends Animal {
    public Hippo (String name) {
        super(name);
    }
}

class MakeHippo {
    public static void main(String[] args) {
        Hippo hippo = new Hippo("Buffy");
        System.out.println(hippo.getName());
    }
}
