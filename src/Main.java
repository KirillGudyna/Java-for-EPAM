import house.House;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            House house = new House();
            house.readData("input.txt");
            house.convert();
            house.workWithAppliances();
        } catch (IOException e) {
            System.out.println("Error!!!");
        }
    }
}
