package sample.Robots;


public class Hybrid extends Robot implements Gezgin,Manipülatör{
    public int gezinmeHizi;
    public float EngelGeçmeSüresi;
    public int PaletSayisi;
    public int BacakSayisi;
    public int tekerlekSayisi;
    public int kolUzunluğu;
    public int taşımaHızı;
    public int kapasite;
    public int motorSayisigezgin;
    public int KonumX;
    public int KonumY;

    @Override
    public int getKonumY() {
        return KonumY;
    }

    @Override
    public int getKonumX() {
        return KonumX;
    }

    @Override
    public void setKonumY(int konumY) {
        KonumY = konumY;
    }

    @Override
    public void setKonumX(int konumX) {
        KonumX = konumX;
    }

    public int getMotorSayisigezgin() {
        return motorSayisigezgin;
    }

    public void setMotorSayisigezgin(int motorSayisigezgin) {
        this.motorSayisigezgin = motorSayisigezgin;
    }

    public int getMotorSayisimanipülatör() {
        return motorSayisimanipülatör;
    }

    public void setMotorSayisimanipülatör(int motorSayisimanipülatör) {
        this.motorSayisimanipülatör = motorSayisimanipülatör;
    }
    public int motorSayisimanipülatör;

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


    public int getGezinmeHizi() {
        return this.gezinmeHizi;
    }


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
            palet = this.motorSayisi / 2;
            this.PaletSayisi = palet;
        }

    }
    //CONSTRUCTORLAR
    public Hybrid(){

    }
    public Hybrid(Tekerlekli t, Seri s){
        this.tekerlekSayisi = t.tekerlekSayisi;
        this.motorSayisigezgin = t.motorSayisi;
        this.motorSayisimanipülatör = s.motorSayisi;
        this.yükMiktari = s.yükMiktari;
        this.kapasite = s.kapasite;
        this.kolUzunluğu = s.kolUzunluğu;
        this.taşımaHızı = s.taşımaHızı;
    }
    public Hybrid(Tekerlekli t, Paralel p){
        this.tekerlekSayisi = t.tekerlekSayisi;
        this.motorSayisigezgin = t.motorSayisi;
        this.motorSayisimanipülatör = p.motorSayisi;
        this.yükMiktari = p.yükMiktari;
        this.kapasite = p.kapasite;
        this.kolUzunluğu = p.kolUzunluğu;
        this.taşımaHızı = p.taşımaHızı;
    }
    public Hybrid(Paletli pt, Seri s){
        this.tekerlekSayisi = pt.PaletSayisi;
        this.motorSayisigezgin = s.motorSayisi;
        this.motorSayisimanipülatör = s.motorSayisi;
        this.yükMiktari = s.yükMiktari;
        this.kapasite = s.kapasite;
        this.kolUzunluğu = s.kolUzunluğu;
        this.taşımaHızı = s.taşımaHızı;
    }
    public Hybrid(Paletli pt, Paralel p){
        this.tekerlekSayisi = pt.PaletSayisi;
        this.motorSayisigezgin = p.motorSayisi;
        this.motorSayisimanipülatör = p.motorSayisi;
        this.yükMiktari = p.yükMiktari;
        this.kapasite = p.kapasite;
        this.kolUzunluğu = p.kolUzunluğu;
        this.taşımaHızı = p.taşımaHızı;
    }
    public Hybrid(Spider sp, Seri s){
        this.tekerlekSayisi = sp.BacakSayisi;
        this.motorSayisigezgin = sp.motorSayisi;
        this.motorSayisimanipülatör = s.motorSayisi;
        this.yükMiktari = s.yükMiktari;
        this.kapasite = s.kapasite;
        this.kolUzunluğu = s.kolUzunluğu;
        this.taşımaHızı = s.taşımaHızı;
    }
    public Hybrid(Spider sp, Paralel p){
        this.tekerlekSayisi = sp.BacakSayisi;
        this.motorSayisigezgin = sp.motorSayisi;
        this.motorSayisimanipülatör = p.motorSayisi;
        this.yükMiktari = p.yükMiktari;
        this.kapasite = p.kapasite;
        this.kolUzunluğu = p.kolUzunluğu;
        this.taşımaHızı = p.taşımaHızı;
    }


}