package model;

public class Tablets extends Electronics{
    private float diagonal;
    private int ROM;

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    public void info(){
        super.info();
        System.out.println("Diagonal: " + diagonal);
        System.out.println("ROM: " + ROM);
    }
}
