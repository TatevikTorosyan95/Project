package main;

import model.*;
import service.*;

import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        FileService.createFolder("Electronics\\phones");
        FileService.createFolder("Electronics\\computers\\notebooks");
        FileService.createFolder("Electronics\\computers\\desktops");
        FileService.createFolder("Electronics\\tablets");
        FileService.createFile("Electronics\\phones", "smartphones.txt");
        FileService.createFile("Electronics\\phones", "mobilePhones.txt");
        FileService.createFile("Electronics\\tablets", "graphicTablets.txt");
        FileService.createFile("Electronics\\tablets", "ebookReaders.txt");
        FileService.createFile("Electronics\\computers\\desktops", "allInOneComputers.txt");
        FileService.createFile("Electronics\\computers\\desktops", "gamingDesktops.txt");
        FileService.createFile("Electronics\\computers\\notebooks", "laptops.txt");
        FileService.createFile("Electronics\\computers\\notebooks", "ultrabooks.txt");

        Scanner s = new Scanner(System.in);

        boolean isActive = true;
        while (isActive) {
            System.out.println("");
            System.out.println("Enter command number");
            System.out.println("1. Add product");
            System.out.println("2. Watch products");

            int a = s.nextInt();
            switch (a) {
                case 1:
                    boolean active = true;
                    while (active) {
                        System.out.println("");
                        System.out.println("1. Smartphones");
                        System.out.println("2. Mobile phones");
                        System.out.println("3. E-book readers");
                        System.out.println("4. Graphic Tablets");
                        System.out.println("5. All in One Computers");
                        System.out.println("6. Gaming desktops");
                        System.out.println("7. Laptops");
                        System.out.println("8. Ultrabooks");
                        System.out.println("9. Back");

                        int b = s.nextInt();
                        switch (b) {
                            case 1:
                                SmartphonesService smartphonesService = new SmartphonesService();
                                Smartphones smart = smartphonesService.create();
                                FileService.write("Electronics\\phones\\smartphones.txt", smart.toString() + "\n");
                                break;
                            case 2:
                                MobilePhonesService mobilePhonesService = new MobilePhonesService();
                                MobilePhones mobile = mobilePhonesService.createMobile();
                                FileService.write("Electronics\\phones\\mobilePhones.txt", mobile.toString() + "\n");
                                break;
                            case 3:
                                EbookReadersService ebookReadersService = new EbookReadersService();
                                EbookReaders ebook = ebookReadersService.createEbook();
                                FileService.write("Electronics\\tablets\\ebookReaders.txt", ebook.toString() + "\n");
                                break;
                            case 4:
                                GraphicTabletsService graphicTabletsService = new GraphicTabletsService();
                                GraphicTablets graphicTablets = graphicTabletsService.createGraphicTablets();
                                FileService.write("Electronics\\tablets\\graphicTablets.txt", graphicTablets.toString() + "\n");
                            case 5:
                                AllInOneComputersService allInOneComputersService = new AllInOneComputersService();
                                AllInOneComputers allInOneComputers = allInOneComputersService.createAllInOneComputer();
                                FileService.write("Electronics\\computers\\desktops\\allInOneComputers.txt", allInOneComputers.toString() + "\n");
                                break;
                            case 6:
                                GamingDesktopsService gamingDesktopsService = new GamingDesktopsService();
                                GamingDesktops gamingDesktops = gamingDesktopsService.createGamingDesktops();
                                FileService.write("Electronics\\computers\\desktops\\gamingDesktops.txt", gamingDesktops.toString() + "\n");
                                break;
                            case 7:
                                LaptopsService laptopsService = new LaptopsService();
                                Laptops laptops = laptopsService.createLaptop();
                                FileService.write("Electronics\\computers\\notebooks\\laptops.txt", laptops.toString() + "\n");
                                break;
                            case 8:
                                UltrabooksService ultrabooksService = new UltrabooksService();
                                Ultrabooks ultrabooks = ultrabooksService.createUltrabook();
                                FileService.write("Electronics\\computers\\notebooks\\ultrabooks.txt", ultrabooks.toString() + "\n");
                                break;
                            case 9:
                                active = false;
                                break;
                            default:
                                System.out.println("Invalid");
                        }
                    }
                    break;
                case 2:
                    boolean act = true;
                    while (act) {
                        System.out.println("");
                        System.out.println("1. Watch Smartphones");
                        System.out.println("2. Watch Mobile phones");
                        System.out.println("3. Watch E-book readers");
                        System.out.println("4. Watch Graphic Tablets");
                        System.out.println("5. Watch All in One Computers");
                        System.out.println("6. Watch Gaming desktops");
                        System.out.println("7. Watch Laptops");
                        System.out.println("8. Watch Ultrabooks");
                        System.out.println("9. Back");

                        int b = s.nextInt();
                        switch (b) {
                            case 1:
                                String[] smartTxt = FileService.readLines("Electronics\\phones\\smartphones.txt");
                                SmartphonesService smartphonesService = new SmartphonesService();
                                Smartphones[] smarts = new Smartphones[smartTxt.length];
                                for (int i = 0; i < smartTxt.length; i++) {
                                    smarts[i] = SmartphonesService.convert(smartTxt[i]);
                                }

                                boolean watchsmart = true;
                                while (watchsmart) {
                                    System.out.println("");
                                    System.out.println("1. Print all smartphones");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available smartphones");
                                    System.out.println("5. Print all smartphones with 2 and more sim cards");
                                    int c = s.nextInt();
                                    switch (c) {
                                        case 1:
                                            for (int i = 0; i < smarts.length; i++) {
                                                smarts[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            SmartphonesService.printSortedByAscPrice(smarts);
                                            break;
                                        case 3:
                                            SmartphonesService.printSortedByDescPrice(smarts);
                                            break;
                                        case 4:
                                            SmartphonesService.printAllAvailableSmartphones(smarts);
                                            break;
                                        case 5:
                                            SmartphonesService.printSmartphonesMoreThanTwoCards(smarts);
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                String[] mobileTxt = FileService.readLines("Electronics\\phones\\mobilePhones.txt");
                                MobilePhonesService mobilePhonesService = new MobilePhonesService();
                                MobilePhones[] mobiles = new MobilePhones[mobileTxt.length];
                                for (int i = 0; i < mobileTxt.length; i++) {
                                    mobiles[i] = MobilePhonesService.convert(mobileTxt[i]);
                                }

                                boolean watchmobile = true;
                                while (watchmobile) {
                                    System.out.println("");
                                    System.out.println("1. Print all smartphones");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available smartphones");
                                    System.out.println("5. Print all mobile phones with colored display");
                                    int d = s.nextInt();
                                    switch (d) {
                                        case 1:
                                            for (int i = 0; i < mobiles.length; i++) {
                                                mobiles[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            mobilePhonesService.printSortedByAscPrice(mobiles);
                                            break;
                                        case 3:
                                            mobilePhonesService.printAllAvailableMobilePhones(mobiles);
                                            break;
                                        case 4:
                                            mobilePhonesService.printSortedByDescPrice(mobiles);
                                            break;
                                        case 5:
                                            mobilePhonesService.printAllMobilePhonesWithColoredDisplay(mobiles);
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                String[] ebookTxt = FileService.readLines("Electronics\\tablets\\ebookReaders.txt");
                                EbookReadersService ebookReadersService = new EbookReadersService();
                                EbookReaders[] ebooks = new EbookReaders[ebookTxt.length];
                                for (int i = 0; i < ebookTxt.length; i++) {
                                    ebooks[i] = EbookReadersService.convert(ebookTxt[i]);
                                }
                                boolean watchebook = true;
                                while (watchebook) {
                                    System.out.println("");
                                    System.out.println("1. Print all Ebook readers");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available Ebook readers");
                                    System.out.println("5. Print all E book Readers with weight smaller than 500");
                                    int e = s.nextInt();
                                    switch (e) {
                                        case 1:
                                            for (int i = 0; i < ebooks.length; i++) {
                                                ebooks[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            EbookReadersService.printSortedByAscPrice(ebooks);
                                            break;
                                        case 3:
                                            EbookReadersService.printSortedByDescPrice(ebooks);
                                            break;
                                        case 4:
                                            EbookReadersService.printAllAvailableEbooks(ebooks);
                                            break;
                                        case 5:
                                            EbookReadersService.printAllEbooksWeightSmallerThan(ebooks);
                                            break;
                                    }
                                }

                                break;
                            case 4:
                                String[] graphicTabletTxt = FileService.readLines("Electronics\\tablets\\graphicTablets.txt");
                                GraphicTabletsService graphicTabletsService = new GraphicTabletsService();
                                GraphicTablets[] graphicTablets = new GraphicTablets[graphicTabletTxt.length];
                                for (int i = 0; i < graphicTabletTxt.length; i++) {
                                    graphicTablets[i] = GraphicTabletsService.convert(graphicTabletTxt[i]);
                                }

                                boolean watchGraphicTablet = true;
                                while (watchGraphicTablet) {
                                    System.out.println("");
                                    System.out.println("1. Print all Graphic Tablets");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available Graphic Tablets");
                                    System.out.println("5. Print all Graphic Tablets with microphone and bluetooth");
                                    int e = s.nextInt();
                                    switch (e) {
                                        case 1:
                                            for (int i = 0; i < graphicTablets.length; i++) {
                                                graphicTablets[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            GraphicTabletsService.printSortedByAscPrice(graphicTablets);
                                            break;
                                        case 3:
                                            GraphicTabletsService.printSortedByDescPrice(graphicTablets);
                                            break;
                                        case 4:
                                            GraphicTabletsService.printAllAvailableGraphicTablets(graphicTablets);
                                            break;
                                        case 5:
                                            GraphicTabletsService.printAllTabletsWithBluetoothAndMicrophone(graphicTablets);
                                            break;
                                    }
                                }
                                break;
                            case 5:
                                String[] allInOneComputersTxt = FileService.readLines("Electronics\\computers\\desktops\\allInOneComputers.txt");
                                AllInOneComputersService allInOneComputersService = new AllInOneComputersService();
                                AllInOneComputers[] allInOneComputers = new AllInOneComputers[allInOneComputersTxt.length];
                                for (int i = 0; i < allInOneComputersTxt.length; i++) {
                                    allInOneComputers[i] = AllInOneComputersService.convert(allInOneComputersTxt[i]);
                                }

                                boolean watchcomputer = true;
                                while (watchcomputer) {
                                    System.out.println("");
                                    System.out.println("1. Print all All in One Computers");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available  All in One Computers");
                                    System.out.println("5. Print all  All in One Computers with intel processor model");
                                    System.out.println("6. Print all  All in One Computers with touch screen");
                                    int f = s.nextInt();
                                    switch (f) {
                                        case 1:
                                            for (int i = 0; i < allInOneComputers.length; i++) {
                                                allInOneComputers[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            AllInOneComputersService.printSortedByAscPrice(allInOneComputers);
                                            break;
                                        case 3:
                                            AllInOneComputersService.printSortedByDescPrice(allInOneComputers);
                                            break;
                                        case 4:
                                            AllInOneComputersService.printAllAvailableAllInOneComputers(allInOneComputers);
                                            break;
                                        case 5:
                                            AllInOneComputersService.printAllAllInOneComputersModel(allInOneComputers);
                                            break;
                                        case 6:
                                            AllInOneComputersService.printAllComputersWithTouchScreen(allInOneComputers);
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                String[] gamingDesktopTxt = FileService.readLines("Electronics\\computers\\desktops\\gamingDesktops.txt");
                                GamingDesktopsService gamingDesktopsService = new GamingDesktopsService();
                                GamingDesktops[] gamingDesktops = new GamingDesktops[gamingDesktopTxt.length];
                                for (int i = 0; i < gamingDesktopTxt.length; i++) {
                                    gamingDesktops[i] = GamingDesktopsService.convert(gamingDesktopTxt[i]);
                                }

                                boolean watchGaming = true;
                                while (watchGaming) {
                                    System.out.println("");
                                    System.out.println("1. Print all All in One Computers");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available  All in One Computers");
                                    System.out.println("5. Print all  All in One Computers with intel processor model");
                                    System.out.println("6. Print all  All in One Computers with touch screen");
                                    int f = s.nextInt();
                                    switch (f) {
                                        case 1:
                                            for (int i = 0; i < gamingDesktops.length; i++) {
                                                gamingDesktops[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            GamingDesktopsService.printSortedByAscPrice(gamingDesktops);
                                            break;
                                        case 3:
                                            GamingDesktopsService.printSortedByDescPrice(gamingDesktops);
                                            break;
                                        case 4:
                                            GamingDesktopsService.printAllAvailableGamingDesktops(gamingDesktops);
                                            break;
                                        case 5:
                                            GamingDesktopsService.printAllGamingDesktopOS(gamingDesktops);
                                            break;
                                        case 6:
                                            GamingDesktopsService.printAllGamingDesktopsMorePorts(gamingDesktops);
                                            break;
                                    }
                                }
                                break;
                            case 7:
                                String[] laptopTxt = FileService.readLines("Electronics\\computers\\notebooks\\laptops.txt");
                                LaptopsService laptopsService = new LaptopsService();
                                Laptops[] laptops = new Laptops[laptopTxt.length];
                                for (int i = 0; i < laptopTxt.length; i++) {
                                    laptops[i] = LaptopsService.convert(laptopTxt[i]);
                                }

                                boolean watchLaptop = true;
                                while (watchLaptop) {
                                    System.out.println("");
                                    System.out.println("1. Print all laptops");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available Laptops");
                                    System.out.println("5. Print all HP Laptops");
                                    int g = s.nextInt();
                                    switch (g) {
                                        case 1:
                                            for (int i = 0; i < laptops.length; i++) {
                                                laptops[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            LaptopsService.printSortedByAscPrice(laptops);
                                            break;
                                        case 3:
                                            LaptopsService.printSortedByDescPrice(laptops);
                                            break;
                                        case 4:
                                            LaptopsService.printAllAvailableLaptops(laptops);
                                            break;
                                        case 5:
                                            LaptopsService.printAllHPLaptops(laptops);
                                            break;
                                    }
                                }

                                break;
                            case 8:
                                String[] ultrabookTxt = FileService.readLines("Electronics\\computers\\notebooks\\ultrabooks.txt");
                                UltrabooksService ultrabooksService = new UltrabooksService();
                                Ultrabooks[] ultrabooks = new Ultrabooks[ultrabookTxt.length];
                                for (int i = 0; i < ultrabookTxt.length; i++) {
                                    ultrabooks[i] = UltrabooksService.convert(ultrabookTxt[i]);
                                }

                                boolean watchUltrabook = true;
                                while (watchUltrabook) {
                                    System.out.println("");
                                    System.out.println("1. Print all Ultrabooks");
                                    System.out.println("2. Sort by price.min to max");
                                    System.out.println("3. Sort by price.max to min");
                                    System.out.println("4. Print all available Ultrabooks");
                                    int h = s.nextInt();
                                    switch (h) {
                                        case 1:
                                            for (int i = 0; i < ultrabooks.length; i++) {
                                                ultrabooks[i].info();
                                                System.out.println("");
                                            }
                                            break;
                                        case 2:
                                            UltrabooksService.printSortedByAscPrice(ultrabooks);
                                            break;
                                        case 3:
                                            UltrabooksService.printSortedByDescPrice(ultrabooks);
                                            break;
                                        case 4:
                                            UltrabooksService.printAllAvailableUltrabooks(ultrabooks);
                                            break;
                                    }
                                }

                                break;
                            case 9:
                                act = false;
                                break;
                            default:
                                System.out.println("Invalid");
                        }
                    }
                    break;
                case 3:
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}