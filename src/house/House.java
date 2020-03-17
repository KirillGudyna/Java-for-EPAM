package house;

import equipments.Appliance;
import equipments.Equipment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class House {
    private List<Equipment> list;
    private List<Appliance> appliances;
    private static final String STRING_MENU_1 = "Press 1 to print consumed power";
    private static final String STRING_MENU_2 = "Press 2 to turn on appliances";
    private static final String STRING_MENU_3 = "Press 3 to print appliances that are plugged in";
    private static final String STRING_MENU_4 = "Press 4 to add appliances";
    private static final String STRING_MENU_5 = "Press 5 to look all appliances ";
    private static final String STRING_MENU_6 = "Press 6 to delete one appliance";
    private static final String STRING_MENU_0 = "Press 0 to exit";

    public House() {
        list = new ArrayList<>();
    }
    
    public void readData(String str) throws IOException {
        try (Scanner sc = new Scanner(new File(str))) {
            String string;
            while (sc.hasNext()) {
                string = sc.next();
                Appliance appliance = new Appliance(sc.next());
                appliance.setNameAppliances(string);
                appliance.setPower(sc.nextInt());
                list.add(appliance);
            }
        }
    }

    public void convert() {
        appliances = list.stream().filter(obj -> (obj instanceof Appliance)).map(obj -> (Appliance) obj).collect(Collectors.toList());
    }

    private void printOptions() {
        System.out.println(STRING_MENU_1);
        System.out.println(STRING_MENU_2);
        System.out.println(STRING_MENU_3);
        System.out.println(STRING_MENU_4);
        System.out.println(STRING_MENU_5);
        System.out.println(STRING_MENU_6);
        System.out.println(STRING_MENU_0);
    }

    private void deleteAppliances() {
        System.out.println("Write appliances which you want delete");
        System.out.print(toString());
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        /*for(Appliance item: appliances){
            if(item.getNameAppliances().equals(str)){
                appliances.remove(item);
                break;
            }
        }*/
        appliances.removeIf(f -> f.getNameAppliances().equals(str));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Appliance item : appliances) {
            stringBuilder.append(item.getColor().toString()
            );
            stringBuilder.append(" ");
            stringBuilder.append(item.getNameAppliances());
            stringBuilder.append(" ");
            stringBuilder.append(item.getPower());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void add() {
        System.out.println("Enter color(BLACK, GREEN, WHITE, BLUE):");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Appliance appliance = new Appliance(str);
        System.out.println("Enter name of appliances:");
        str = sc.next();
        appliance.setNameAppliances(str);
        System.out.println("Enter power of appliances:");
        short x = sc.nextShort();
        appliance.setPower(x);
        System.out.println("Do you want turn on this appliance?(Yes/No)");
        while (true) {
            str = sc.next();
            switch (str.toLowerCase()) {
                case "yes": {
                    appliance.set(true);
                    appliances.add(appliance);
                    return;
                }
                case "no": {
                    appliance.set(false);
                    appliances.add(appliance);
                    return;
                }
                default: {
                    System.out.println("You enter something wrong!!\nTry again");
                }
            }
        }
    }

    private void printAppliances() {
        short i = 1;
        for (Appliance a : appliances) {
            if (!a.isInOff()) {
                System.out.println(i + ":" + a.getNameAppliances());
                i++;
            }
        }
        System.out.println(i + ":Doing nothing");
    }

    private void consumedPower() {
        List<Appliance> helpList;
        int conPower = 0;
        helpList = appliances.stream().filter(obj -> (obj.isInOff())).collect(Collectors.toList());
        if (!helpList.isEmpty()) {
            for (Appliance obj : helpList) {
                conPower += obj.getPower();
            }
        }
        System.out.println("Power consumed by household appliances = " + conPower);
    }

    private void turnOn() {
        System.out.println("Choose appliances to turn on:");
        printAppliances();
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        assert (x.equals("Doing nothing"));
        List<Appliance> listHelp;
        listHelp = appliances.stream().filter(obj -> (obj.getNameAppliances().equals(x))).collect(Collectors.toList());
        for (Appliance a : listHelp) {
            a.set(true);
        }
    }

    private void printInApplisnces() {
        List<Appliance> listhelp = appliances.stream().filter(obj -> obj.isInOff()).collect(Collectors.toList());
        /*for (Appliance a : listhelp) {
            System.out.println(a.getNameAppliances());
        }*/
        listhelp.forEach(it -> System.out.println(it.getNameAppliances()));
    }

    public void workWithAppliances() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printOptions();
            int x = sc.nextInt();
            switch (x) {
                case 1: {
                    consumedPower();
                    break;
                }
                case 2: {
                    turnOn();
                    break;
                }
                case 3: {
                    printInApplisnces();
                    break;
                }
                case 4: {
                    add();
                    break;
                }
                case 5: {
                    System.out.println(toString());
                    break;
                }
                case 6: {
                    deleteAppliances();
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }
}