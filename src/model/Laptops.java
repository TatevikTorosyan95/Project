package model;

public class Laptops extends Notebooks {
    private boolean isTouchScreen;
    private int numberOfPorts;

    public boolean isTouchScreen() {
        return isTouchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        isTouchScreen = touchScreen;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts            ;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getOperatingSystem() + "," + getPrice()
                + "," + getRAM() + "," + getProcessorModel() + "," + getTotalStorageCapacity() + "," + getVideoCard()
                + "," + getStorageType() + "," + getScreenSize() + "," + isBuiltInMicrophone() + "," +
                isTouchScreen() + "," + isAvailable() + ", " + numberOfPorts;
    }

    public void info(){
        super.info();
        System.out.println("Touch Screen: " + (isTouchScreen ? "Yes" : "No"));
        System.out.println("Number Of Ports: " + numberOfPorts);
    }

}
