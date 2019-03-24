package sample.Robots;

public class Spider extends Robot implements Gezgin {
    public int gezinmeHizi;
    public int BacakSayisi;
    public int minHız = 3;

    public int getMinHız() {
        return minHız;
    }

    public int getGezinmeHizi() {
        return this.gezinmeHizi;
    }

    public void setGezinmeHizi(int gezinmeHizi) {
        this.gezinmeHizi = gezinmeHizi;
    }
    public int getBacakSayisi() {
        return this.BacakSayisi;
    }

    public void setBacakSayisi(int bacakSayisi) {
        if (this.BacakSayisi < 0) {
            this.BacakSayisi = 0;
        } else {
            this.BacakSayisi = bacakSayisi;
        }

    }

    public Spider() {
        this.setBacakSayisi(this.BacakSayisi);
    }

    public Spider(int motor, int yük, int gezinme, int bacakSayisi) {
        this.motorSayisi = motor;
        this.yükMiktari = yük;
        this.gezinmeHizi = gezinme;
        this.BacakSayisi = bacakSayisi;
    }
}