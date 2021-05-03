package model;
public class Phones extends Electronics{
    private int cardsQuantity;
    private char bluetooth;


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

    public void info(){
        super.info();
        System.out.println("Cards quantity: " + cardsQuantity);
        System.out.println("Bluetooth: " + (bluetooth == 'y' ? "Yes" : "No"));
    }
}
