package center;

import center.animals.Animal;
import center.animals.Cat;
import center.animals.Dog;
import center.centers.AdoptionCenter;
import center.centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private HashMap<String, AdoptionCenter> adoptionCenters;
    private HashMap<String, CleansingCenter> cleansingCenters;
    private List<Animal> cleansedAnimals;
    private List<Animal> adoptedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter =
                new CleansingCenter(name);
        this.cleansingCenters
                .putIfAbsent(cleansingCenter.getName(), cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter =
                new AdoptionCenter(name);
        this.adoptionCenters
                .putIfAbsent(adoptionCenter.getName(), adoptionCenter);

    }

    public void registerDog(String name, int age, int learnedCommands, String
            adoptionCenterName) {
        Dog dog =
                new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters
                .get(adoptionCenterName)
                .register(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String
            adoptionCenterName) {
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleaning(cleansingCenter);
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> cliensed = this.cleansingCenters.get(cleansingCenterName)
                .cliensE();
        for (Animal animal : cliensed) {
            this.adoptionCenters
                    .get(animal.getCenterName()).register(animal);
        }
        this.cleansedAnimals.addAll(cliensed);
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> adoptedAnimals =
                this.adoptionCenters.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(adoptedAnimals);
    }

    public void printStatistics() {
        String nam = "Paw Incorporative Regular Statistics\n" +
                "Adoption Centers: {amountOfAdoptionCenters}\n" +
                "Cleansing Centers: {amountOfCleansingCenters}\n" +
                "Adopted Animals: {adoptedAnimal1Name}, {adoptedAnimal2Name}…\n" +
                "Cleansed Animals: {cleansedAnimal1Name}, {cleansedAnimal2Name}…\n" +
                "Animals Awaiting Adoption: {amountOfAnimalsWaitingForAdoption}\n" +
                "Animals Awaiting Cleansing: {amountOfAnimalsWaitingForCleansing}";
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics\n");
        sb.append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()));
        sb.append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.adoptedAnimals)));
        sb.append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)));
        sb.append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingAdoptionCount()));
        sb.append(String.format("Animals Awaiting Cleansing: %d\n", getAwaitingCleansedCount()));

        System.out.println(sb.toString());
    }

    private int getAwaitingCleansedCount() {
        int result = this.cleansingCenters.values()
                .stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(a -> !a.isCleansed())
                .collect(Collectors.toList())
                .size();
        return result;
    }

    private int getAwaitingAdoptionCount() {
        int count = this.adoptionCenters
                .values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(a -> a.isCleansed())
                .collect(Collectors.toList())
                .size();
        return count;
    }

    private String getSortedAnimals(List<Animal> adoptedAnimals) {
        if (adoptedAnimals.isEmpty()) {
            return "None";
        }
        List<String> sorted = adoptedAnimals.stream()
                .map(a -> a.getName())
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());
        return String.join(", ", sorted);
    }

//    private String getAdoptedAnimals() {
//        if (this.adoptedAnimals.isEmpty()){
//            return "None";
//        }
//        List<String>sorted = this.adoptedAnimals.stream()
//                .map(Animal::getName)
//                .sorted(Collator.getInstance())
//                .collect(Collectors.toList());
//        return String.join(", ",sorted);
//
//    }

}
