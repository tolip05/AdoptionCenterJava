package center.centers;

import center.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CleansingCenter extends Center {
    public CleansingCenter(String name) {
        super(name);
    }
    public List<Animal> cliensE(){
        List<Animal> clieansed = new ArrayList<>();
        super.getAnimals().stream()
                .forEach(a -> {
                    a.cleance();
                  clieansed.add(a);
                });
        super.removeAnimals(clieansed);
          return clieansed;
    }
}
