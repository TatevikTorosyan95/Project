package service;

import model.EbookReaders;
import model.MobilePhones;

import java.util.Scanner;

public class EbookReadersService {
    public EbookReaders createEbook(){
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        float diagonal = 0;
        int ROM = 0;
        int weight = 0;

        System.out.println("Add new E-book Reader\n");

        System.out.println("Enter E-book Reader Brand.");
        String brand = s.nextLine();

        while (valid == false) {
            System.out.println("Enter E-book Reader Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Enter E-book Reader Color.");
        String color = s.next();

        valid = false;
        while (valid == false) {
            System.out.println("Enter E book Reader diagonal. / 10 inches ...");
            str = s.next();
            try {
                diagonal = Float.parseFloat(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter E book Reader ROM./ 16 GB - ...");
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
            System.out.println("Enter E book Reader ROM./ 16 GB - ...");
            str = s.next();
            try {
                weight = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';

        EbookReaders ebookReaders = new EbookReaders();
        ebookReaders.setBrand(brand);
        ebookReaders.setColor(color);
        ebookReaders.setPrice(price);
        ebookReaders.setWeight(weight);
        ebookReaders.setAvailable(isAvailable);
        ebookReaders.setDiagonal(diagonal);
        ebookReaders.setROM(ROM);

        return ebookReaders;
    }

    public static EbookReaders convert(String data) {
        String[] split = data.split(",");
        EbookReaders e = new EbookReaders();
        e.setBrand(split[0]);
        e.setColor(split[1]);
        e.setPrice(Double.parseDouble(split[2]));
        e.setWeight(Integer.parseInt(split[3]));
        e.setDiagonal(Float.parseFloat(split[4]));
        e.setROM(Integer.parseInt(split[5]));
        e.setAvailable(Boolean.parseBoolean(split[6]));
        return e;
    }

    public static void printSortedByAscPrice(EbookReaders[] ebookReaders) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < ebookReaders.length-1-count; i++) {
                if (ebookReaders[i].getPrice() > ebookReaders[i+1].getPrice()) {
                    EbookReaders temp = ebookReaders[i];
                    ebookReaders[i] = ebookReaders[i+1];
                    ebookReaders[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (EbookReaders e : ebookReaders) {
            e.info();
        }
    }

    public static void printSortedByDescPrice(EbookReaders[] ebookReaders) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < ebookReaders.length-1-count; i++) {
                if (ebookReaders[i].getPrice() < ebookReaders[i+1].getPrice()) {
                    EbookReaders temp = ebookReaders[i];
                    ebookReaders[i] = ebookReaders[i+1];
                    ebookReaders[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (EbookReaders e : ebookReaders) {
            e.info();
        }
    }

    public static void printAllAvailableEbooks(EbookReaders[] ebookReaders) {
        for (int i = 0; i < ebookReaders.length; i++) {
            if (ebookReaders[i].isAvailable()) {
                ebookReaders[i].info();
            }
        }
    }

    public static void printAllEbooksWeightSmallerThan(EbookReaders[] ebookReaders) {
        for (int i = 0; i < ebookReaders.length; i++) {
            if (ebookReaders[i].getWeight() <= 500) {
                ebookReaders[i].info();
            }
        }
    }

}
