package model;

public class Ultrabooks extends Notebooks {
    private int numberOfCores;

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getOperatingSystem() + "," + getPrice()
                + "," + getRAM() + "," + getProcessorModel() + "," + getTotalStorageCapacity() + "," + getVideoCard()
                + "," + getStorageType() + "," + getScreenSize() + "," + isBuiltInMicrophone() + ","
                + "," + isAvailable() + ", " + numberOfCores;
    }

    public void info(){
        super.info();
        System.out.println("Number Of Cores: " + numberOfCores);
    }
}
