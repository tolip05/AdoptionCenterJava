package center;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
     Engine engine = new Engine();
     engine.run();
    }
    // input

//    RegisterAdoptionCenter | Rebellion
//    RegisterAdoptionCenter | Sentinel
//    RegisterCleansingCenter | Sanctuary
//    RegisterCleansingCenter | Liberty
//    RegisterCat | Mr.Whiskas | 1 | 1 | Sentinel
//    RegisterCat | Gosho | 20 | 100 | Rebellion
//    RegisterCat | Chukky | 10 | 10 | Rebellion
//    Adopt | Sentinel
//    RegisterDog | Sirius | 5 | 1000 | Rebellion
//    SendForCleansing | Sentinel | Sanctuary
//    SendForCleansing | Rebellion | Sanctuary
//    Cleanse | Sanctuary
//    Adopt | Rebellion
//    RegisterDog | Husku | 1 | 20 | Sentinel
//    SendForCleansing | Sentinel | Liberty
//    RegisterCat | Nero | 1 | 120 | Sentinel
//    Paw Paw Pawah

    // output

//    Paw Incorporative Regular Statistics
//    Adoption Centers: 2
//    Cleansing Centers: 2
//    Adopted Animals: Chukky, Gosho,
//    Sirius
//    Cleansed Animals: Chukky, Gosho,
//    Mr.Whiskas, Sirius
//    Animals Awaiting Adoption: 1
//    Animals Awaiting Cleansing: 1

}
