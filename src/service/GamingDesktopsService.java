package service;

import model.AllInOneComputers;
import model.GamingDesktops;

import java.util.Scanner;

public class GamingDesktopsService {
    public GamingDesktops createGamingDesktops(){
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        short RAM = 0;
        int totalStorageCapacity = 0;
        short numberOfEthernetPorts = 0;
        int hardDriveSize = 0;
        short videoMemory = 0;

        System.out.println("Add new Gaming Desktop\n");

        System.out.println("Enter Gaming Desktop Brand. / HP, Asus, Dell....");
        String brand = s.nextLine();

        while (valid == false) {
            System.out.println("Enter Gaming Desktop Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Gaming Desktop Color.");
        String color = s.next();

        System.out.println("Enter Gaming Desktop Operation System./ Windows...");
        String operatingSystem = s.next();

        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter Gaming Desktop RAM./ 0 GB-512 GB/");
            str = s.next();
            try {
                RAM = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Gaming Desktop processor model. / Intel Core i5");
        String processorModel = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Gaming Desktop Total Storage Capacity./ 0 GB - ...");
            str = s.next();
            try {
                totalStorageCapacity = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter Gaming Desktop Video Card./ NVIDIA GeForce RTX 3080 ....");
        String videoCard = s.next();
        s.nextLine();

        System.out.println("Enter Gaming Desktop Storage Type./ SSD, HDD");
        String storageType = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Gaming Desktop number Of Ethernet Ports. / 0, 1, 2...");
            str = s.next();
            try {
                numberOfEthernetPorts = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter Gaming Desktop Hard Drive Size./ 1 TB....");
            str = s.next();
            try {
                hardDriveSize = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter Gaming Desktop Video Memory./ 4 MB -...");
            str = s.next();
            try {
                videoMemory = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        GamingDesktops gamingDesktops = new GamingDesktops();
        gamingDesktops.setBrand(brand);
        gamingDesktops.setPrice(price);
        gamingDesktops.setColor(color);
        gamingDesktops.setOperatingSystem(operatingSystem);
        gamingDesktops.setRAM(RAM);
        gamingDesktops.setProcessorModel(processorModel);
        gamingDesktops.setVideoCard(videoCard);
        gamingDesktops.setTotalStorageCapacity(totalStorageCapacity);
        gamingDesktops.setStorageType(storageType);
        gamingDesktops.setNumberOfEthernetPorts(numberOfEthernetPorts);
        gamingDesktops.setHardDriveSize(hardDriveSize);
        gamingDesktops.setAvailable(isAvailable);
        gamingDesktops.setVideoMemory(videoMemory);

        return gamingDesktops;
    }
    public static GamingDesktops convert(String data) {
        String[] split = data.split(",");
        GamingDesktops g = new GamingDesktops();
        g.setBrand(split[0]);
        g.setColor(split[1]);
        g.setOperatingSystem(split[2]);
        g.setPrice(Double.parseDouble(split[3]));
        g.setRAM(Short.parseShort(split[4]));
        g.setProcessorModel(split[5]);
        g.setTotalStorageCapacity(Integer.parseInt(split[6]));
        g.setVideoCard(split[7]);
        g.setStorageType(split[8]);
        g.setNumberOfEthernetPorts(Short.parseShort(split[9]));
        g.setHardDriveSize(Integer.parseInt(split[10]));
        g.setVideoMemory(Short.parseShort(split[11]));
        g.setAvailable(Boolean.parseBoolean(split[12]));
        return g;
    }

    public static void printSortedByAscPrice(GamingDesktops[] gamingDesktops) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < gamingDesktops.length-1-count; i++) {
                if (gamingDesktops[i].getPrice() > gamingDesktops[i+1].getPrice()) {
                    GamingDesktops temp = gamingDesktops[i];
                    gamingDesktops[i] = gamingDesktops[i+1];
                    gamingDesktops[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (GamingDesktops s : gamingDesktops) {
            s.info();
        }
    }

    public static void printSortedByDescPrice(GamingDesktops[] gamingDesktops) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < gamingDesktops.length-1-count; i++) {
                if (gamingDesktops[i].getPrice() > gamingDesktops[i+1].getPrice()) {
                    GamingDesktops temp = gamingDesktops[i];
                    gamingDesktops[i] = gamingDesktops[i+1];
                    gamingDesktops[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (GamingDesktops s : gamingDesktops) {
            s.info();
        }
    }

    public static void printAllAvailableGamingDesktops(GamingDesktops[] gamingDesktops) {
        for (int i = 0; i < gamingDesktops.length; i++) {
            if (gamingDesktops[i].isAvailable()) {
                gamingDesktops[i].info();
            }
        }
    }

    public static void printAllGamingDesktopOS(GamingDesktops[] gamingDesktops) {
        for (int i = 0; i < gamingDesktops.length;i++) {
            if (gamingDesktops[i].getOperatingSystem() == "Windows") {
                gamingDesktops[i].info();
            }
        }
    }

    public static void printAllGamingDesktopsMorePorts(GamingDesktops[] gamingDesktops) {
        for (int i = 0; i < gamingDesktops.length;i++) {
            if (gamingDesktops[i].getNumberOfEthernetPorts() > 3) {
                gamingDesktops[i].info();
            }
        }
    }

}
