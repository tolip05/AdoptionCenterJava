package center;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private AnimalCenterManager manager;

    public Engine() {
        this.manager = new AnimalCenterManager();
    }

    public void run() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        while (!input.equals("Paw Paw Pawah")){

            String[]cmdArgs = input.split(" \\| ");
            String commandType = cmdArgs[0];

            switch (commandType){

                case "RegisterCleansingCenter":
                    manager.registerCleansingCenter(cmdArgs[1]);
                    break;
                case "RegisterAdoptionCenter":
                    manager.registerAdoptionCenter(cmdArgs[1]);
                    break;
                case "RegisterDog":
                    manager.registerDog(cmdArgs[1]
                            ,Integer.parseInt(cmdArgs[2])
                            ,Integer.parseInt(cmdArgs[3]),cmdArgs[4]);
                    break;
                case "RegisterCat":
                    manager.registerCat(cmdArgs[1],Integer.parseInt(cmdArgs[2])
                            ,Integer.parseInt(cmdArgs[3]),cmdArgs[4]);
                    break;
                case "SendForCleansing":
                    manager.sendForCleansing(cmdArgs[1],cmdArgs[2]);
                    break;
                case "Cleanse":
                    manager.cleanse(cmdArgs[1]);
                    break;
                case "Adopt":
                    manager.adopt(cmdArgs[1]);
                    break;
                    default:
                        break;
            }

            input = br.readLine();
        }
        manager.printStatistics();
    }
}
