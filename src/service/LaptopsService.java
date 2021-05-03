package service;

import model.GamingDesktops;
import model.Laptops;

import java.util.Scanner;

public class LaptopsService {
    public Laptops createLaptop(){
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        short RAM = 0;
        int totalStorageCapacity = 0;
        float screenSize = 0;
        int numberOfPorts = 0;

        System.out.println("Add new Laptop\n");

        System.out.println("Enter Laptop Brand String. /Asus, Acer, HP, Dell.../");
        String brand = s.nextLine();

        while (valid == false) {
            System.out.println("Enter Laptop Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Laptops Color");
        String color = s.next();

        System.out.println("Enter Laptop Operation System. /Windows, Mac, Linux/");
        String operatingSystem = s.next();

        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter Laptop RAM./ 2 GB-64 GB/");
            str = s.next();
            try {
                RAM = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Laptop processor model./ INTEL Core i5, AMD Ryzen 7....");
        String processorModel = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Laptop Total Storage Capacity./ 120 GB - ...");
            str = s.next();
            try {
                totalStorageCapacity = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Laptop Video Card./ NVIDIA GeForce RTX 3080 ....");
        String videoCard = s.next();
        s.nextLine();

        System.out.println("Enter Laptop Storage Type./ SSD, HDD");
        String storageType = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Laptop Screen Size./ 14 inches....");
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

        System.out.println("Is Touch Screen? y/n");
        boolean isTouchScreen = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter Laptop Number Of Cores/ 1,2,4");
            str = s.next();
            try {
                numberOfPorts = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        Laptops laptops = new Laptops();
        laptops.setBrand(brand);
        laptops.setPrice(price);
        laptops.setColor(color);
        laptops.setOperatingSystem(operatingSystem);
        laptops.setRAM(RAM);
        laptops.setProcessorModel(processorModel);
        laptops.setVideoCard(videoCard);
        laptops.setTotalStorageCapacity(totalStorageCapacity);
        laptops.setStorageType(storageType);
        laptops.setScreenSize(screenSize);
        laptops.setBuiltInMicrophone(isBuiltInMicrophone);
        laptops.setAvailable(isAvailable);
        laptops.setTouchScreen(isTouchScreen);
        laptops.setNumberOfPorts(numberOfPorts);

        return laptops;

    }

    public static Laptops convert(String data) {
        String[] split = data.split(",");
        Laptops l = new Laptops();
        l.setBrand(split[0]);
        l.setColor(split[1]);
        l.setOperatingSystem(split[2]);
        l.setPrice(Double.parseDouble(split[3]));
        l.setRAM(Short.parseShort(split[4]));
        l.setProcessorModel(split[5]);
        l.setTotalStorageCapacity(Integer.parseInt(split[6]));
        l.setVideoCard(split[7]);
        l.setStorageType(split[8]);
        l.setScreenSize(Float.parseFloat(split[9]));
        l.setBuiltInMicrophone(Boolean.parseBoolean(split[10]));
        l.setTouchScreen(Boolean.parseBoolean(split[11]));
        l.setAvailable(Boolean.parseBoolean(split[12]));
        l.setNumberOfPorts(Integer.parseInt(split[13]));
        return l;
    }

    public static void printSortedByAscPrice(Laptops[] laptops) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < laptops.length-1-count; i++) {
                if (laptops[i].getPrice() > laptops[i+1].getPrice()) {
                    Laptops temp = laptops[i];
                    laptops[i] = laptops[i+1];
                    laptops[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (Laptops s : laptops) {
            s.info();
        }
    }

    public static void printSortedByDescPrice(Laptops[] laptops) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < laptops.length-1-count; i++) {
                if (laptops[i].getPrice() > laptops[i+1].getPrice()) {
                    Laptops temp = laptops[i];
                    laptops[i] = laptops[i+1];
                    laptops[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (Laptops s : laptops) {
            s.info();
        }
    }

    public static void printAllAvailableLaptops(Laptops[] laptops) {
        for (int i = 0; i < laptops.length; i++) {
            if (laptops[i].isAvailable()) {
                laptops[i].info();
            }
        }
    }

    public static void printAllHPLaptops(Laptops[] laptops) {
        for (int i = 0; i < laptops.length;i++) {
            if (laptops[i].getBrand() == "HP") {
                laptops[i].info();
            }
        }
    }


}
