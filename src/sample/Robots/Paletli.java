package sample.Robots;
public class Paletli extends Robot implements Gezgin {

    public int minHız = 5;
    public int gezinmeHizi;
    public int PaletSayisi;
    public float EngelGeçmeSüresi;

    public int getMinHız() {
        return minHız;
    }

    @Override
    public int getGezinmeHizi() {
        return this.gezinmeHizi;
    }

    @Override
    public void setGezinmeHizi(int gezinmeHizi) {
        this.gezinmeHizi = gezinmeHizi;
    }

    public float getEngelGeçmeSüresi() {
        return this.EngelGeçmeSüresi;
    }

    public void setEngelGeçmeSüresi(float engelGeçmeSüresi) {
        this.EngelGeçmeSüresi = engelGeçmeSüresi;
    }

    public int getPaletSayisi() {
        return this.PaletSayisi;
    }

    public void setPaletSayisi(int palet) {
        if (this.PaletSayisi < 0) {
            this.PaletSayisi = 0;
        } else {
            this.PaletSayisi = palet;
        }

    }

    public Paletli() {
        this.setPaletSayisi(this.PaletSayisi);
        this.setEngelGeçmeSüresi(this.EngelGeçmeSüresi);
    }

    public Paletli(int motor, int yük, int kapa, int gezinme, int palet, int EGS) {
        this.motorSayisi = motor;
        this.yükMiktari = yük;
        this.gezinmeHizi = gezinme;
        this.EngelGeçmeSüresi = EGS;
        this.PaletSayisi = palet;
    }
}