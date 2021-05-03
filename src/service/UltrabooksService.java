package service;

import model.Ultrabooks;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UltrabooksService {
    public Ultrabooks createUltrabook() {
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        short RAM = 0;
        int totalStorageCapacity = 0;
        float screenSize = 0;
        int numberOfCores = 0;

        System.out.println("Add new Ultrabook\n");

        System.out.println("Enter Ultrabook Brand String. /Asus, Acer, HP, Dell.../");
        String brand = s.nextLine();

        while (valid == false) {
            System.out.println("Enter Ultrabook Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Ultrabook Color.");
        String color = s.next();


        System.out.println("Enter Ultrabook processor model./ INTEL Core i5, AMD Ryzen 7....");
        String processorModel = s.next();
        s.nextLine();

        System.out.println("Enter Ultrabook Operation System. /Windows, Mac, Linux/");
        String operatingSystem = s.next();


        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';


        valid = false;
        while (valid == false) {
            System.out.println("Enter Ultrabook RAM./ 4 GB-16 GB/");
            str = s.next();
            try {
                RAM = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter Ultrabook Total Storage Capacity./ 120 GB - ...");
            str = s.next();
            try {
                totalStorageCapacity = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Ultrabook Video Card./ NVIDIA GeForce RTX 3080 ....");
        String videoCard = s.next();
        s.nextLine();

        System.out.println("Enter Ultrabook Storage Type./ SSD, HDD");
        String storageType = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Ultrabook Screen Size./ 14 inches....");
            str = s.next();
            try {
                screenSize = Float.parseFloat(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Is Exist  Built In Microphone? / y/n");
        boolean isBuiltInMicrophone = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter Ultrabook Number Of Cores/ 6,8,10");
            str = s.next();
            try {
                numberOfCores = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        Ultrabooks ultrabooks = new Ultrabooks();
        ultrabooks.setBrand(brand);
        ultrabooks.setPrice(price);
        ultrabooks.setColor(color);
        ultrabooks.setOperatingSystem(operatingSystem);
        ultrabooks.setRAM(RAM);
        ultrabooks.setProcessorModel(processorModel);
        ultrabooks.setVideoCard(videoCard);
        ultrabooks.setTotalStorageCapacity(totalStorageCapacity);
        ultrabooks.setStorageType(storageType);
        ultrabooks.setScreenSize(screenSize);
        ultrabooks.setBuiltInMicrophone(isBuiltInMicrophone);
        ultrabooks.setAvailable(isAvailable);
        ultrabooks.setNumberOfCores(numberOfCores);

        return ultrabooks;

    }

    public static Ultrabooks convert(String data) {
        String[] split = data.split(",");
        Ultrabooks a = new Ultrabooks();
        a.setBrand(split[0]);
        a.setColor(split[1]);
        a.setOperatingSystem(split[2]);
        a.setPrice(Double.parseDouble(split[3]));
        a.setRAM(Short.parseShort(split[4]));
        a.setProcessorModel(split[5]);
        a.setTotalStorageCapacity(Integer.parseInt(split[6]));
        a.setVideoCard(split[7]);
        a.setStorageType(split[8]);
        a.setScreenSize(Float.parseFloat(split[9]));
        a.setBuiltInMicrophone(Boolean.parseBoolean(split[10]));
        a.setAvailable(Boolean.parseBoolean(split[11]));
        a.setNumberOfCores(Integer.parseInt(split[12]));
        return a;
    }

    public static void printSortedByAscPrice(Ultrabooks[] ultrabooks) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < ultrabooks.length - 1 - count; i++) {
                if (ultrabooks[i].getPrice() > ultrabooks[i + 1].getPrice()) {
                    Ultrabooks temp = ultrabooks[i];
                    ultrabooks[i] = ultrabooks[i + 1];
                    ultrabooks[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (Ultrabooks s : ultrabooks) {
            s.info();
        }
    }

    public static void printSortedByDescPrice(Ultrabooks[] ultrabooks) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < ultrabooks.length - 1 - count; i++) {
                if (ultrabooks[i].getPrice() > ultrabooks[i + 1].getPrice()) {
                    Ultrabooks temp = ultrabooks[i];
                    ultrabooks[i] = ultrabooks[i + 1];
                    ultrabooks[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (Ultrabooks s : ultrabooks) {
            s.info();
        }
    }

    public static void printAllAvailableUltrabooks(Ultrabooks[] ultrabooks) {
        for (int i = 0; i < ultrabooks.length; i++) {
            if (ultrabooks[i].isAvailable()) {
                ultrabooks[i].info();
            }
        }
    }
}
