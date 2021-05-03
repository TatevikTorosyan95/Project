package model;

public class EbookReaders extends Tablets{
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return getBrand() + "," + getColor() + "," + getPrice() + "," + weight + ","
                + getDiagonal() + "," + getROM()  + isAvailable();
    }

    public void info(){
        super.info();
        System.out.println("Weight: " + weight);
    }
}
