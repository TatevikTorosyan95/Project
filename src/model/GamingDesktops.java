package model;

public class GamingDesktops extends Desktops{
    private short videoMemory;

    public short getVideoMemory() {
        return videoMemory;
    }

    public void setVideoMemory(short videoMemory) {
        this.videoMemory = videoMemory;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getOperatingSystem() + "," + getPrice()
                + "," + getRAM() + "," + getProcessorModel() + "," + getTotalStorageCapacity() + "," + getVideoCard()
                + "," + getStorageType() + "," + getNumberOfEthernetPorts() + "," + getHardDriveSize() + "," +
                videoMemory + "," + isAvailable();
    }

    public void info(){
        super.info();
        System.out.println("Video Memory: " + videoMemory);
    }
}
