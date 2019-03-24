package sample.Robots;

public class Robot {
    public int motorSayisi;
    public int yükMiktari;
    public int KonumX;
    public int KonumY;

    public Robot() {
    }

    public int getMotorSayisi() {
        return this.motorSayisi;
    }

    public int getYükMiktari() {
        return this.yükMiktari;
    }

    public void setMotorSayisi(int motorSayisi) {
        this.motorSayisi = motorSayisi;
    }

    public void setYükMiktari(int yükMiktari) {
        this.yükMiktari = yükMiktari;
    }

    public int getKonumX() {
        return this.KonumX;
    }

    public int getKonumY() {
        return this.KonumY;
    }

    public void setKonumX(int konumX) {
        this.KonumX = konumX;
    }

    public void setKonumY(int konumY) {
        this.KonumY = konumY;
    }}