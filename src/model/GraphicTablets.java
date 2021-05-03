package model;

public class GraphicTablets extends Tablets{
    private int cardsQuantity;
    private char bluetooth;
    private int RAM;
    private String CPUType;
    private char builtInMicrophone;
    private short numberOfCores;

    public int getCardsQuantity() {
        return cardsQuantity;
    }

    public void setCardsQuantity(int cardsQuantity) {
        this.cardsQuantity = cardsQuantity;
    }

    public char getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(char bluetooth) {
        this.bluetooth = bluetooth;
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

    public char getBuiltInMicrophone() {
        return builtInMicrophone;
    }

    public void setBuiltInMicrophone(char builtInMicrophone) {
        this.builtInMicrophone = builtInMicrophone;
    }

    public short getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(short numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getOperatingSystem() + "," + getPrice()
                + "," + CPUType + "," + RAM + "," + getROM() + "," + getCardsQuantity() + "," + getBuiltInMicrophone()
                + "," + getBluetooth() + "," + getDiagonal() + "," + isAvailable() + "," + getNumberOfCores();
    }

    public void info(){
        super.info();
        super.info(getOperatingSystem());
        System.out.println("Cards Quantity: " + cardsQuantity);
        System.out.println("Bluetooth: " + (bluetooth == 'y' ? "Yes" : "No"));
        System.out.println("RAM: " + RAM);
        System.out.println("CPU Type: " + CPUType);
        System.out.println("Built In Microphone: " + (builtInMicrophone == 'y' ? "Yes" : "No"));
        System.out.println("Number Of Cores: " + numberOfCores);
    }
}
