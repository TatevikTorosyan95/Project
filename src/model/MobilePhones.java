package model;

public class MobilePhones extends Phones{
    private double weight;
    private String displayType;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getPrice() + "," + weight
                + "," + displayType + "," + getCardsQuantity() + "," + getBluetooth() + "," + isAvailable();
    }

    public void info(){
        super.info();
        System.out.println("Weight: " + weight);
        System.out.println("Display Type: " + displayType);
    }

}
