package sample.Robots;

public class Paralel extends Robot implements Manipülatör{
    public int minHız = 5;
    public int kolUzunluğu;
    public int taşımaHızı;
    public int kapasite;

    public int getKolUzunluğu() {
        return this.kolUzunluğu;
    }

    public void setKolUzunluğu(int kolUzunluğu) {
        this.kolUzunluğu = kolUzunluğu;
    }

    public int getTaşımaHızı() {
        return this.taşımaHızı;
    }

    public void setTaşımaHızı(int taşımaHızı) {
        this.taşımaHızı = taşımaHızı;
    }

    public int getKapasite() {
        return this.kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public int getMinHız() {
        return minHız;
    }

    public Paralel() {
    }

    public Paralel(int motor, int yük, int kapa, int gezinme, int kol, int taşıma) {
        this.motorSayisi = motor;
        this.yükMiktari = yük;
        this.kapasite = kapa;
        this.kolUzunluğu = kol;
        this.taşımaHızı = taşıma;
    }


}