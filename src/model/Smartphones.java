package model;

public class Smartphones extends Phones {
    private char wirelessCharger;
    private float diagonal;
    private int ROM;
    private int RAM;
    private String CPUType;

    public char getWirelessCharger() {
        return wirelessCharger;
    }

    public void setWirelessCharger(char wirelessCharger) {
        this.wirelessCharger = wirelessCharger;
    }

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getCPUType() {
        return CPUType;
    }

    public void setCPUType(String CPUType) {
        this.CPUType = CPUType;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getOperatingSystem() + "," + getPrice()
                + "," + CPUType + "," + RAM + "," + ROM + "," + getCardsQuantity() + "," + diagonal
                + "," + getBluetooth() + "," + wirelessCharger + "," + isAvailable();
    }

    public void info(){
        super.info();
        super.info(getOperatingSystem());
        System.out.println("Wireless Charger: " + wirelessCharger);
        System.out.println("Diagonal: " + diagonal);
        System.out.println("ROM: " + ROM);
        System.out.println("RAM: " + RAM);
        System.out.println("CPU Type: " + CPUType);
    }
}
