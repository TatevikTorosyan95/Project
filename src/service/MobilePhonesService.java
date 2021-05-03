package service;

import model.MobilePhones;

import java.util.Scanner;

public class MobilePhonesService {
    public MobilePhones createMobile(){
        Scanner s = new Scanner(System.in);
        boolean valid = false;
        String str;
        double price = 0;
        double weight = 0;
        int cardsQuantity = 0;

        System.out.println("Add new Mobile Phone\n");

        System.out.println("Enter Mobile Phone Brand. / Nokia, Samsung....");
        String brand = s.nextLine();

        System.out.println("Enter Mobile Phone Color.");
        String color = s.nextLine();

        while (valid == false) {
            System.out.println("Enter Mobile Phone Price. $");
            str = s.next();
            try {
                price = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        valid = false;
        while (valid == false) {
            System.out.println("Enter Mobile Phone Weight.");
            str = s.next();
            try {
                weight = Double.parseDouble(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }


        System.out.println("Is available in stock?/ y/n");
        boolean isAvailable = s.next().charAt(0) == 'y';

        valid = false;
        while (valid == false) {
            System.out.println("Enter Mobile Phone Cards quantity.");
            str = s.next();
            try {
                cardsQuantity = Integer.parseInt(str);
                valid = true;
            } catch (Exception e) {
                System.out.println("--------Error--------- Enter right value\n");
            }
        }

        System.out.println("Bluetooth exist or not. / y/n");
        char bluetooth = s.next().charAt(0);

        System.out.println("Enter display type./ colored,....");
        String display = s.next();

        MobilePhones mobilePhone = new MobilePhones();
        mobilePhone.setWeight(weight);
        mobilePhone.setDisplayType(display);
        mobilePhone.setAvailable(isAvailable);
        mobilePhone.setBluetooth(bluetooth);
        mobilePhone.setCardsQuantity(cardsQuantity);
        mobilePhone.setBrand(brand);
        mobilePhone.setPrice(price);
        mobilePhone.setColor(color);

        return mobilePhone;
    }

    public static MobilePhones convert(String data) {
        String[] split = data.split(",");
        MobilePhones m = new MobilePhones();
        m.setBrand(split[0]);
        m.setColor(split[1]);
        m.setPrice(Double.parseDouble(split[2]));
        m.setWeight(Double.parseDouble(split[3]));
        m.setDisplayType(split[4]);
        m.setCardsQuantity(Integer.parseInt(split[5]));
        m.setBluetooth(split[6].charAt(0));
        m.setAvailable(Boolean.parseBoolean(split[7]));
        return m;
    }

    public void printSortedByAscPrice(MobilePhones[] mobilePhones) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < mobilePhones.length-1-count; i++) {
                if (mobilePhones[i].getPrice() > mobilePhones[i+1].getPrice()) {
                    MobilePhones temp = mobilePhones[i];
                    mobilePhones[i] = mobilePhones[i+1];
                    mobilePhones[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (MobilePhones m : mobilePhones) {
            m.info();
        }
    }

    public void printSortedByDescPrice(MobilePhones[] mobilePhones) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < mobilePhones.length-1-count; i++) {
                if (mobilePhones[i].getPrice() < mobilePhones[i+1].getPrice()) {
                    MobilePhones temp = mobilePhones[i];
                    mobilePhones[i] = mobilePhones[i+1];
                    mobilePhones[i+1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        for (MobilePhones m : mobilePhones) {
            m.info();
        }
    }

    public void printAllAvailableMobilePhones(MobilePhones[] mobilePhones) {
        for (int i = 0; i < mobilePhones.length; i++) {
            if (mobilePhones[i].isAvailable()) {
                mobilePhones[i].info();
            }
        }
    }

    public void printAllMobilePhonesWithColoredDisplay(MobilePhones[] mobilePhones) {
        for (int i = 0; i < mobilePhones.length; i++) {
            if (mobilePhones[i].getDisplayType() == "colored") {
                mobilePhones[i].info();
            }
        }
    }
}
