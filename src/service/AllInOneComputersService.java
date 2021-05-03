package service;

import model.AllInOneComputers;
import model.Smartphones;

import java.util.Scanner;

public class AllInOneComputersService {
    public AllInOneComputers createAllInOneComputer() {

        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        short RAM = 0;
        int totalStorageCapacity = 0;
        short screenSize = 0;
        short numberOfEthernetPorts = 0;
        short numberOfThunderboltPorts = 0;
        int hardDriveSize = 0;

        System.out.println("Add new All in One Computer\n");

        System.out.println("Enter All in One Computer Brand. / HP, Asus....");
        String brand = s.nextLine();

        while (valid == false) {
            System.out.println("Enter All in One Computer Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter All in One Computer Color.");
        String color = s.next();

        System.out.println("Enter All in One Computer Operation System./ Windows...");
        String operatingSystem = s.next();

        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter All in One Computer RAM./ 0 GB-512 GB/");
            str = s.next();
            try {
                RAM = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter All in One Computer processor model. / Intel Core i5");
        String processorModel = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter All in One Computer Total Storage Capacity./ 0 GB - ...");
            str = s.next();
            try {
                totalStorageCapacity = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter All in One Computer Video Card./ NVIDIA GeForce RTX 3080 ....");
        String videoCard = s.next();
        s.nextLine();

        System.out.println("Enter All in One Computer Storage Type./ SSD, HDD");
        String storageType = s.next();
        s.nextLine();

        valid = false;
        while (valid == false) {
            System.out.println("Enter All in One Computer number Of Ethernet Ports. / 0, 1, 2...");
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
            System.out.println("Enter All in One Computer Hard Drive Size./ 1 TB....");
            str = s.next();
            try {
                hardDriveSize = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }


        System.out.println("Is Touch Screen? y/n");
        boolean isTouchScreen = s.next().charAt(0) == 'y';

        System.out.println("Is exist Built In Microphone? / y/n");
        boolean isBuiltInMicrophone = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter All in One Computer Screen Size./ 14 inches....");
            str = s.next();
            try {
                screenSize = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter All in One Computer Number Of Thunderbolt Ports./ 1, 2, 4 ....");
            str = s.next();
            try {
                numberOfThunderboltPorts = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        AllInOneComputers allInOneComputers = new AllInOneComputers();
        allInOneComputers.setBrand(brand);
        allInOneComputers.setPrice(price);
        allInOneComputers.setColor(color);
        allInOneComputers.setOperatingSystem(operatingSystem);
        allInOneComputers.setRAM(RAM);
        allInOneComputers.setProcessorModel(processorModel);
        allInOneComputers.setVideoCard(videoCard);
        allInOneComputers.setTotalStorageCapacity(totalStorageCapacity);
        allInOneComputers.setStorageType(storageType);
        allInOneComputers.setNumberOfEthernetPorts(numberOfEthernetPorts);
        allInOneComputers.setHardDriveSize(hardDriveSize);
        allInOneComputers.setTouchScreen(isTouchScreen);
        allInOneComputers.setBuiltInMicrophone(isBuiltInMicrophone);
        allInOneComputers.setScreenSize(screenSize);
        allInOneComputers.setNumberOfThunderboltPorts(numberOfThunderboltPorts);

        return allInOneComputers;

    }

    public static AllInOneComputers convert(String data) {
        String[] split = data.split(",");
        AllInOneComputers a = new AllInOneComputers();
        a.setBrand(split[0]);
        a.setColor(split[1]);
        a.setOperatingSystem(split[2]);
        a.setPrice(Double.parseDouble(split[3]));
        a.setRAM(Short.parseShort(split[4]));
        a.setProcessorModel(split[5]);
        a.setTotalStorageCapacity(Integer.parseInt(split[6]));
        a.setVideoCard(split[7]);
        a.setStorageType(split[8]);
        a.setNumberOfEthernetPorts(Short.parseShort(split[9]));
        a.setHardDriveSize(Integer.parseInt(split[10]));
        a.setTouchScreen(Boolean.parseBoolean(split[11]));
        a.setBuiltInMicrophone(Boolean.parseBoolean(split[12]));
        a.setScreenSize(Integer.parseInt(split[13]));
        a.setNumberOfThunderboltPorts(Short.parseShort(split[14]));
        a.setAvailable(Boolean.parseBoolean(split[15]));
        return a;
    }

    public static void printSortedByAscPrice(AllInOneComputers[] allInOneComputers) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < allInOneComputers.length-1-count; i++) {
                if (allInOneComputers[i].getPrice() > allInOneComputers[i+1].getPrice()) {
                    AllInOneComputers temp = allInOneComputers[i];
                    allInOneComputers[i] = allInOneComputers[i+1];
                    allInOneComputers[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (AllInOneComputers s : allInOneComputers) {
            s.info();
        }
    }

    public static void printSortedByDescPrice(AllInOneComputers[] allInOneComputers) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < allInOneComputers.length-1-count; i++) {
                if (allInOneComputers[i].getPrice() > allInOneComputers[i+1].getPrice()) {
                    AllInOneComputers temp = allInOneComputers[i];
                    allInOneComputers[i] = allInOneComputers[i+1];
                    allInOneComputers[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (AllInOneComputers s : allInOneComputers) {
            s.info();
        }
    }

    public static void printAllAvailableAllInOneComputers(AllInOneComputers[] allInOneComputers) {
        for (int i = 0; i < allInOneComputers.length; i++) {
            if (allInOneComputers[i].isAvailable()) {
                allInOneComputers[i].info();
            }
        }
    }

    public static void printAllAllInOneComputersModel(AllInOneComputers[] allInOneComputers) {
        for (int i = 0; i < allInOneComputers.length;i++) {
            if (allInOneComputers[i].getProcessorModel() == "Intel") {
                allInOneComputers[i].info();
            }
        }
    }

    public static void printAllComputersWithTouchScreen(AllInOneComputers[] allInOneComputers) {
        for (int i = 0; i < allInOneComputers.length;i++) {
            if (allInOneComputers[i].isTouchScreen()) {
                allInOneComputers[i].info();
            }
        }
    }
}
