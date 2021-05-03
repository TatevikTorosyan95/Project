package service;

import model.EbookReaders;
import model.GraphicTablets;

import java.util.Scanner;

public class GraphicTabletsService {
    public GraphicTablets createGraphicTablets() {

        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        int cardsQuantity = 0;
        short numberOfCores = 0;
        float diagonal = 0;
        int ROM = 0;
        int RAM = 0;

        System.out.println("Add new Graphic Tablet\n");

        System.out.println("Enter Graphic Tablet Brand. /Asus, Acer, HP, Dell.../");
        String brand = s.nextLine();

        System.out.println("Enter Graphic Tablet Operation System. /Windows, Mac, Linux/");
        String operatingSystem = s.next();

        System.out.println("Enter Graphic Tablet Color");
        String color = s.next();

        while (valid == false) {
            System.out.println("Enter Graphic Tablet Price. $");
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


        valid = false;
        while (valid == false) {
            System.out.println("Enter Number of Cores./ 1,2 ..");
            str = s.next();
            try {
                numberOfCores = Short.parseShort(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter Graphic tablet diagonal. / 10 inches ...");
            str = s.next();
            try {
                diagonal = Float.parseFloat(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }


        System.out.println("Bluetooth exist or not./ y/n");
        char bluetooth = s.next().charAt(0);

        System.out.println("Enter graphic tablet CPU Type./ A10....");
        String CPUType = s.next();

        valid = false;
        while (valid == false) {
            System.out.println("Enter Graphic Tablet ROM./ 16 GB - ...");
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
            System.out.println("Enter Graphic Tablet RAM./ 1 GB - ...");
            str = s.next();
            try {
                RAM = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Built in microphone available or not. / y/n");
        char builtInMicrophone = s.next().charAt(0);

        GraphicTablets graphicTablets = new GraphicTablets();
        graphicTablets.setBrand(brand);
        graphicTablets.setColor(color);
        graphicTablets.setOperatingSystem(operatingSystem);
        graphicTablets.setPrice(price);
        graphicTablets.setRAM(RAM);
        graphicTablets.setRAM(ROM);
        graphicTablets.setBluetooth(bluetooth);
        graphicTablets.setAvailable(isAvailable);
        graphicTablets.setCardsQuantity(cardsQuantity);
        graphicTablets.setDiagonal(diagonal);
        graphicTablets.setCPUType(CPUType);
        graphicTablets.setBuiltInMicrophone(builtInMicrophone);
        graphicTablets.setNumberOfCores(numberOfCores);

        return graphicTablets;
    }

    public static GraphicTablets convert(String data) {
        String[] split = data.split(",");
        GraphicTablets g = new GraphicTablets();
        g.setBrand(split[0]);
        g.setColor(split[1]);
        g.setOperatingSystem(split[2]);
        g.setPrice(Double.parseDouble(split[3]));
        g.setCPUType(split[4]);
        g.setRAM(Integer.parseInt(split[5]));
        g.setROM(Integer.parseInt(split[6]));
        g.setCardsQuantity(Integer.parseInt(split[7]));
        g.setBuiltInMicrophone(split[8].charAt(0));
        g.setBluetooth(split[9].charAt(0));
        g.setDiagonal(Float.parseFloat(split[10]));
        g.setAvailable(Boolean.parseBoolean(split[11]));
        g.setNumberOfCores(Short.parseShort(split[12]));
        return g;
    }

    public static void printSortedByAscPrice(GraphicTablets[] graphicTablets) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < graphicTablets.length-1-count; i++) {
                if (graphicTablets[i].getPrice() > graphicTablets[i+1].getPrice()) {
                    GraphicTablets temp = graphicTablets[i];
                    graphicTablets[i] = graphicTablets[i+1];
                    graphicTablets[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (GraphicTablets g : graphicTablets) {
            g.info();
        }
    }

    public static void printSortedByDescPrice(GraphicTablets[] graphicTablets) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < graphicTablets.length-1-count; i++) {
                if (graphicTablets[i].getPrice() < graphicTablets[i+1].getPrice()) {
                    GraphicTablets temp = graphicTablets[i];
                    graphicTablets[i] = graphicTablets[i+1];
                    graphicTablets[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (GraphicTablets g : graphicTablets) {
            g.info();
        }
    }

    public static void printAllAvailableGraphicTablets(GraphicTablets[] graphicTablets) {
        for (int i = 0; i < graphicTablets.length; i++) {
            if (graphicTablets[i].isAvailable()) {
                graphicTablets[i].info();
            }
        }
    }

    public static void printAllTabletsWithBluetoothAndMicrophone(GraphicTablets[] graphicTablets) {
        for (int i = 0; i < graphicTablets.length; i++) {
            if (graphicTablets[i].getBluetooth() == 'y' && graphicTablets[i].getBuiltInMicrophone() == 'y') {
                graphicTablets[i].info();
            }
        }
    }
}
