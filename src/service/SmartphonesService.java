package service;

import model.MobilePhones;
import model.Smartphones;

import java.util.Scanner;

public class SmartphonesService {
    public Smartphones create(){
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        int cardsQuantity = 0;
        float diagonal = 0;
        int ROM = 0;
        int RAM = 0;

        System.out.println("Add new Smartphone\n");

        System.out.println("Enter Smartphone Brand. /Apple, Samsung.../");
        String brand = s.nextLine();

        System.out.println("Enter Smartphone Operation System. /Android, iOS.../");
        String operatingSystem = s.next();

        System.out.println("Enter Smartphone Color.");
        String color = s.next();

        while (valid == false) {
            System.out.println("Enter Smartphone Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter Sim Cards Quantity.");
            str = s.next();
            try {
                cardsQuantity = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Bluetooth exist or not./ y/n");
        char bluetooth = s.next().charAt(0);

        valid = false;
        while (valid == false) {
            System.out.println("Enter Smartphone diagonal. / 10 inches ...");
            str = s.next();
            try {
                diagonal = Float.parseFloat(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter smartphone CPU Type./ A10....");
        String CPUType = s.next();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Smartphone ROM./ 16 GB - ...");
            str = s.next();
            try {
                ROM = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter Smartphone RAM./ 1 GB - ...");
            str = s.next();
            try {
                RAM = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Wireless charger available or not. / y/n");
        char wirelessCharger = s.next().charAt(0);

        Smartphones smartphone = new Smartphones();
        smartphone.setBluetooth(bluetooth);
        smartphone.setWirelessCharger(wirelessCharger);
        smartphone.setAvailable(isAvailable);
        smartphone.setCardsQuantity(cardsQuantity);
        smartphone.setDiagonal(diagonal);
        smartphone.setCPUType(CPUType);
        smartphone.setBrand(brand);
        smartphone.setColor(color);
        smartphone.setOperatingSystem(operatingSystem);
        smartphone.setPrice(price);
        smartphone.setRAM(RAM);
        smartphone.setRAM(ROM);

        return smartphone;
    }

    public static Smartphones convert(String data) {
        String[] split = data.split(",");
        Smartphones s = new Smartphones();
        s.setBrand(split[0]);
        s.setColor(split[1]);
        s.setOperatingSystem(split[2]);
        s.setPrice(Double.parseDouble(split[3]));
        s.setCPUType(split[4]);
        s.setRAM(Integer.parseInt(split[5]));
        s.setROM(Integer.parseInt(split[6]));
        s.setCardsQuantity(Integer.parseInt(split[7]));
        s.setDiagonal(Float.parseFloat(split[8]));
        s.setBluetooth(split[9].charAt(0));
        s.setWirelessCharger(split[10].charAt(0));
        s.setAvailable(Boolean.parseBoolean(split[11]));
        return s;
    }

    public static void printSortedByAscPrice(Smartphones[] smartphones) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < smartphones.length-1-count; i++) {
                if (smartphones[i].getPrice() > smartphones[i+1].getPrice()) {
                    Smartphones temp = smartphones[i];
                    smartphones[i] = smartphones[i+1];
                    smartphones[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (Smartphones s : smartphones) {
            s.info();
        }
    }

    public static void printSortedByDescPrice(Smartphones[] smartphones) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < smartphones.length-1-count; i++) {
                if (smartphones[i].getPrice() > smartphones[i+1].getPrice()) {
                    Smartphones temp = smartphones[i];
                    smartphones[i] = smartphones[i+1];
                    smartphones[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (Smartphones s : smartphones) {
            s.info();
        }
    }

    public static void printAllAvailableSmartphones(Smartphones[] smartphones) {
        for (int i = 0; i < smartphones.length; i++) {
            if (smartphones[i].isAvailable()) {
                smartphones[i].info();
            }
        }
    }

    public static void printSmartphonesMoreThanTwoCards(Smartphones[] smartphones) {
        for (int i = 0; i < smartphones.length;i++) {
            if (smartphones[i].getCardsQuantity() >= 2) {
                smartphones[i].info();
            }
        }
    }
}
