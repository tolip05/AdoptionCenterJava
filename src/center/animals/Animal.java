package center.animals;

public abstract class Animal {
    private String name;

    private int age;

    private boolean isCleaning;

    private String adoptionCenter;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.isCleaning = false;
    }

    public Animal(String name, int age, String adoptionCenter) {
        this(name,age);
        this.isCleaning = false;
        this.adoptionCenter = adoptionCenter;
    }

    public boolean isCleansed(){
        return this.isCleaning;
    }

    public void cleance() {
        this.isCleaning = true;
    }

    public String getName() {
        return this.name;
    }

    public String getCenterName() {
        return this.adoptionCenter;
    }
}
