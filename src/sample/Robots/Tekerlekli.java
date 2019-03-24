package sample.Robots;

public class Tekerlekli extends Robot implements Gezgin {
    public int minHız = 7;
    public int tekerlekSayisi;
    public float EngelGeçmeSüresi;
    public int gezinmeHizi;

    public int getMinHız() {
        return minHız;
    }

    public int getGezinmeHizi() {
        return this.gezinmeHizi;
    }

    public void setGezinmeHizi(int gezinmeHizi) {
        this.gezinmeHizi = gezinmeHizi;
    }
    public Tekerlekli() {
        this.setEngelGeçmeSüresi(this.EngelGeçmeSüresi);
        this.setTekerlekSayisi(this.tekerlekSayisi);
    }

    public Tekerlekli(int motor, int yük, int gezinme, int tekerlek, int EGS) {
        this.motorSayisi = motor;
        this.yükMiktari = yük;
        this.gezinmeHizi = gezinme;
        this.EngelGeçmeSüresi = EGS;
        this.tekerlekSayisi = tekerlek;
    }

    public float getEngelGeçmeSüresi() {
        return this.EngelGeçmeSüresi;
    }

    public void setEngelGeçmeSüresi(float engelGeçmeSüresi) {
        if (this.tekerlekSayisi < 0) {
            this.EngelGeçmeSüresi = 0;
        } else {
            this.EngelGeçmeSüresi = engelGeçmeSüresi;
        }

    }

    public void setTekerlekSayisi(int tekerlek) {
        if (this.tekerlekSayisi < 0) {
            this.tekerlekSayisi = 0;
        } else {
            this.tekerlekSayisi = this.motorSayisi / 2;
            this.tekerlekSayisi = tekerlek;
        }

    }

    public int getTekerlekSayisi() {
        return this.tekerlekSayisi;
    }


}