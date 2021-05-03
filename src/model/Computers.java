package model;

public class Computers extends Electronics{
    private short RAM;
    private String processorModel;
    private int totalStorageCapacity;
    private String videoCard;
    private String storageType;

    public short getRAM() {
        return RAM;
    }

    public void setRAM(short RAM) {
        this.RAM = RAM;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public int getTotalStorageCapacity() {
        return totalStorageCapacity;
    }

    public void setTotalStorageCapacity(int totalStorageCapacity) {
        this.totalStorageCapacity = totalStorageCapacity;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public void info(){
        super.info();
        super.info(getOperatingSystem());
        System.out.println("RAM: " + RAM);
        System.out.println("Processor Model: " + processorModel);
        System.out.println("Total Storage Capacity: " + totalStorageCapacity);
        System.out.println("Total Storage Capacity: " + totalStorageCapacity);
        System.out.println("Video Card: " + videoCard);
        System.out.println("Storage Type: " + storageType);
    }
}
