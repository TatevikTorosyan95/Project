package model;

public class AllInOneComputers extends Desktops {
    private boolean isTouchScreen;
    private boolean isBuiltInMicrophone;
    private int screenSize;
    private short numberOfThunderboltPorts;

    public boolean isTouchScreen() {
        return isTouchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        isTouchScreen = touchScreen;
    }

    public boolean isBuiltInMicrophone() {
        return isBuiltInMicrophone;
    }

    public void setBuiltInMicrophone(boolean builtInMicrophone) {
        isBuiltInMicrophone = builtInMicrophone;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public short getNumberOfThunderboltPorts() {
        return numberOfThunderboltPorts;
    }

    public void setNumberOfThunderboltPorts(short numberOfThunderboltPorts) {
        this.numberOfThunderboltPorts = numberOfThunderboltPorts;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getOperatingSystem() + "," + getPrice()
                + "," + getRAM() + "," + getProcessorModel() + "," + getTotalStorageCapacity() + "," + getVideoCard()
                + "," + getStorageType() + "," + getNumberOfEthernetPorts() + "," + getHardDriveSize() + "," +
                isTouchScreen + "," + isBuiltInMicrophone + "," + screenSize + "," + numberOfThunderboltPorts + "," + isAvailable();
    }

    public void info() {
        super.info();
        System.out.println("Screen Size: " + screenSize);
    }
}
