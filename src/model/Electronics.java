package model;

import javax.sound.midi.Soundbank;

public class Electronics {
    private String brand;
    private double price;
    private String color;
    private String operatingSystem;
    private boolean isAvailable;

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void info(){
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
        System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
    }

    public void info(String operationSystem) {
        System.out.println("Operating System: " + operatingSystem);
    }

}
