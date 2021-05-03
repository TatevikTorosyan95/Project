package model;

public class Desktops extends Computers{
    private short numberOfEthernetPorts;
    private int hardDriveSize;

    public short getNumberOfEthernetPorts() {
        return numberOfEthernetPorts;
    }

    public void setNumberOfEthernetPorts(short numberOfEthernetPorts) {
        this.numberOfEthernetPorts = numberOfEthernetPorts;
    }

    public int getHardDriveSize() {
        return hardDriveSize;
    }

    public void setHardDriveSize(int hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
    }

    public void info(){
        super.info();
        System.out.println("Number Of Ethernet Ports: " + numberOfEthernetPorts);
        System.out.println("Hard Drive Size: " + hardDriveSize);
    }
}
