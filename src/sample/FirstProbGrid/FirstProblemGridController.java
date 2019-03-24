//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample.FirstProbGrid;

import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;
import sample.Robots.*;

public class FirstProblemGridController {


    /******************************DEĞİŞKEN TANIMLAMA BÖLGESİ****************************************/
    private int yukarıKomut;
    private int aşağıKomut;
    private int sağaKomut;
    private int solaKomut;
    private int SonKonumX;
    private int SonKonumY;
    private int[] EngelX;
    private int[] EngelY;
    private int size;
    @FXML
    private GridPane myGrid;
    @FXML
    private TextArea sizeText;
    @FXML
    private TextArea KonumX;
    @FXML
    private TextArea KonumY;
    @FXML
    private TextArea yukarı;
    @FXML
    private TextArea aşağı;
    @FXML
    private TextArea sağa;
    @FXML
    private TextArea sola;
    @FXML
    private Label sonKonumX;
    @FXML
    private Label sonKonumY;
    @FXML
    private Label toplamSüre;
    @FXML
    private RadioButton TekerlekliButton;
    @FXML
    private RadioButton PaletliButton;
    @FXML
    private RadioButton SpiderButton;
    @FXML
    private TextArea MotorSayısı;
    @FXML
    private TextArea YükMiktarı;
    @FXML
    private TextArea AyakSayısı;
    @FXML
    private TextArea GezinmeHızı;
    @FXML
    private Label BacakSayısı;
    @FXML
    private Label engelGeçmeSüresiText;
    @FXML
    private Button onay;
    @FXML
    private ToggleButton DoneButton;
    @FXML
    private Button AnaMenüButton;

    /***************************************************************************************************************/


    /************************************ENGELLERİ OLUŞTURAN FONKSİYON********************************************/
    @FXML
    void EngelleriAl(){
        int size = Integer.parseInt(this.sizeText.getText());
        int[] engelX = new int[size];
        int[] engelY = new int[size];

        int i;
        for(i = 0; i < size; ++i) {
            System.out.println(i + 1 + ". engelin koordinatlarını giriniz:");
            Scanner scanner = new Scanner(System.in);
            engelX[i] = scanner.nextInt();
            engelY[i] = scanner.nextInt();
        }

        for(i = 0; i < size; i++) {
            Rectangle engel = new Rectangle();
            engel.setWidth(26);
            engel.setHeight(26);
            GridPane.setColumnIndex(engel, engelX[i]);
            GridPane.setRowIndex(engel,engelY[i]);
            this.myGrid.getChildren().add(engel);
            engel.setFill(Color.rgb(214, 48, 49));
        }
        System.out.println("Engeller oluşturuldu!");
        //
            setEngelX(engelX);
            setEngelY(engelY);
            setSize(size);
    }

    /************************************************************************************************************/


    /****************************************PROGRAMI SİMÜLE EDEN FONKSİYON*************************************/
    @FXML
    void GetValues() {
        Rectangle rectangle;
        if (this.PaletliButton.isSelected()) {
            //Robotun oluşturulduğu ve verilerin alındığı alan
            System.out.println("Paletli tipi robot seçildi");
            Paletli gezgin = new Paletli();
            rectangle = new Rectangle();

            gezgin.setMotorSayisi(Integer.parseInt(this.MotorSayısı.getText()));
            gezgin.setGezinmeHizi(Integer.parseInt(this.GezinmeHızı.getText()));
            gezgin.setYükMiktari(Integer.parseInt(this.YükMiktarı.getText()));
            gezgin.setPaletSayisi(Integer.parseInt(this.AyakSayısı.getText()));
            gezgin.setEngelGeçmeSüresi((float)(gezgin.getMotorSayisi() * 3));
            gezgin.setKonumX(Integer.parseInt(this.KonumX.getText()));
            gezgin.setKonumY(Integer.parseInt(this.KonumY.getText()));
            engelGeçmeSüresiText.setText(Float.toString(gezgin.getEngelGeçmeSüresi()));

            if(gezgin.getMinHız()<= gezgin.getGezinmeHizi()) {
                if (gezgin.getKonumX() >= 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    gezgin.setKonumX(19);
                } else if (gezgin.getKonumX() < 0) {
                    gezgin.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (gezgin.getKonumY() >= 20) {
                    gezgin.setKonumY(19);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (gezgin.getKonumY() < 0) {
                    gezgin.setKonumY(0);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }


                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                GridPane.setRowIndex(rectangle,gezgin.getKonumY());
                GridPane.setColumnIndex(rectangle,gezgin.getKonumX());

                this.myGrid.getChildren().add(rectangle);
                rectangle.setFill(Color.rgb(250, 177, 160));
                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");

                yukarıKomut = Integer.parseInt(this.yukarı.getText());
                aşağıKomut = Integer.parseInt(this.aşağı.getText());
                sağaKomut = Integer.parseInt(this.sağa.getText());
                solaKomut = Integer.parseInt(this.sola.getText());

                //robotun son konumunda dikdörtgen oluşturur
                Rectangle lastRectangle = new Rectangle();
                lastRectangle.setWidth(26);
                lastRectangle.setHeight(26);
                lastRectangle.setFill(Color.rgb(49, 210, 212));

                SonKonumX = gezgin.getKonumX() + sağaKomut - solaKomut;
                SonKonumY = gezgin.getKonumY() - yukarıKomut + aşağıKomut;

                if (SonKonumX > 19) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                   SonKonumX = 19;
                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                } else if (SonKonumX < 0) {
                    SonKonumX = 0;
                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (SonKonumY > 19) {
                    SonKonumY = 19;
                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (SonKonumY < 0) {
                    SonKonumY = 0;
                    GridPane.setRowIndex(lastRectangle,SonKonumY);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                this.sonKonumX.setText(Integer.toString(SonKonumX));
                this.sonKonumY.setText(Integer.toString(SonKonumY));

                GridPane.setColumnIndex(lastRectangle, SonKonumX);
                GridPane.setRowIndex(lastRectangle, SonKonumY);
                myGrid.getChildren().add(lastRectangle);

                int temasEdilenEngel = 0;
                int i;
                if(gezgin.getKonumY()-yukarıKomut < 0){
                    yukarıKomut = gezgin.getKonumY();
                }
                for (i = 0; i <= yukarıKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("yukarı kontrol edilen : " + (gezgin.getKonumX()) + "," + (gezgin.getKonumY() - i) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumY() - i) == getEngelY()[k] && gezgin.getKonumX() == getEngelX()[k]) {
                            temasEdilenEngel++;
                            System.out.println("engel üzerinden geçildi");
                        }
                    }
                }if(gezgin.getKonumX()+sağaKomut >20){
                    sağaKomut = 20-gezgin.getKonumX();
                }
                for (i = 1; i <= sağaKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("sağa kontrol edilen : " + (gezgin.getKonumX() + i) + "," + (gezgin.getKonumY() - yukarıKomut) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumX() + i) == getEngelX()[k] && gezgin.getKonumY() - yukarıKomut == getEngelY()[k]) {
                            temasEdilenEngel++;
                            System.out.println("engel üzerinden geçildi");
                        }
                    }
                }if(gezgin.getKonumY()+aşağıKomut >20){
                    aşağıKomut=20-gezgin.getKonumY();
                }
                for (i = 0; i <= aşağıKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("aşağı kontrol edilen : " + (gezgin.getKonumX() + sağaKomut) + "," + (gezgin.getKonumY() - yukarıKomut + i) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumY() - yukarıKomut + i) == getEngelY()[k] && gezgin.getKonumX() + sağaKomut == getEngelX()[k]) {
                            temasEdilenEngel++;
                            System.out.println("Engel üzerinden geçildi");
                        }
                    }
                }if(gezgin.getKonumX()-solaKomut <=0){
                    solaKomut = gezgin.getKonumX();
                }
                for (i = 0; i <= solaKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("sola kontrol edilen : " + (gezgin.getKonumX() + sağaKomut - i) + "," + (gezgin.getKonumY() - yukarıKomut + aşağıKomut) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumX() + sağaKomut - i) == getEngelX()[k] && (gezgin.getKonumY() - yukarıKomut + aşağıKomut) == getEngelY()[k]) {
                            temasEdilenEngel++;
                            System.out.println("Engel üzerinden geçildi");
                        }
                    }
                }

                //toplam süre hesabı:
                this.toplamSüre.setText(Float.toString((yukarıKomut + aşağıKomut + sağaKomut + solaKomut) * 10 / gezgin.getGezinmeHizi()
                        + temasEdilenEngel * Float.parseFloat(engelGeçmeSüresiText.getText())));
                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + " Son Konum :" + SonKonumX + " " + SonKonumY + " Toplam Süre " + toplamSüre.getText());
            }else System.out.println("Minimum hız sınırı aşıldı.[Paletli robot için minimum hız 5 m/s dir.]");
        }
        else if (this.TekerlekliButton.isSelected()) {
            Tekerlekli gezgin = new Tekerlekli();
            System.out.println("Tekerlekli tipi robot seçildi");

            gezgin.setMotorSayisi(Integer.parseInt(this.MotorSayısı.getText()));
            gezgin.setGezinmeHizi(Integer.parseInt(this.GezinmeHızı.getText()));
            gezgin.setYükMiktari(Integer.parseInt(this.YükMiktarı.getText()));
            gezgin.setTekerlekSayisi(Integer.parseInt(this.AyakSayısı.getText()));
            gezgin.setEngelGeçmeSüresi((float) gezgin.getMotorSayisi() * 0.5F);
            engelGeçmeSüresiText.setText(Float.toString(gezgin.getEngelGeçmeSüresi()));
            gezgin.setKonumX(Integer.parseInt(KonumX.getText()));
            gezgin.setKonumY(Integer.parseInt(KonumY.getText()));

            if (gezgin.getMinHız() <= gezgin.getGezinmeHizi()) {
                if (gezgin.getKonumX() > 19) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    gezgin.setKonumX(19);
                } else if (gezgin.getKonumX() < 0) {
                    gezgin.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                if (gezgin.getKonumY() > 19) {
                    gezgin.setKonumY(19);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (gezgin.getKonumY() < 0) {
                    gezgin.setKonumY(0);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                //robotun dikdörtgenini çizen kısım
                rectangle = new Rectangle();
                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                GridPane.setRowIndex(rectangle,gezgin.getKonumY());
                GridPane.setColumnIndex(rectangle,gezgin.getKonumX());

                this.myGrid.getChildren().add(rectangle);
                rectangle.setFill(Color.rgb(162, 155, 254));
                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");

                yukarıKomut = Integer.parseInt(this.yukarı.getText());
                aşağıKomut = Integer.parseInt(this.aşağı.getText());
                sağaKomut = Integer.parseInt(this.sağa.getText());
                solaKomut = Integer.parseInt(this.sola.getText());

                //robotun son konumunda dikdörtgen oluşturur
                Rectangle lastRectangle = new Rectangle();
                lastRectangle.setWidth(26);
                lastRectangle.setHeight(26);
                lastRectangle.setFill(Color.rgb(49, 210, 212));

                SonKonumX = gezgin.getKonumX() + sağaKomut - solaKomut;
                SonKonumY = gezgin.getKonumY() - yukarıKomut + aşağıKomut;
                if (SonKonumX > 19) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    SonKonumX=19;
                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                } else if (SonKonumX < 0) {
                    SonKonumX=0;
                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (SonKonumY > 19) {
                    SonKonumY= 19;
                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (SonKonumY < 0) {
                    SonKonumY = 0;
                    GridPane.setRowIndex(lastRectangle,SonKonumY);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                this.sonKonumX.setText(Integer.toString(SonKonumX));
                this.sonKonumY.setText(Integer.toString(SonKonumY));

                GridPane.setColumnIndex(lastRectangle, SonKonumX);
                GridPane.setRowIndex(lastRectangle, SonKonumY);
                myGrid.getChildren().add(lastRectangle);

                //kaç engelle temas ettiğini bulan algoritma
                int temasEdilenEngel = 0;
                int i;
                if(gezgin.getKonumY()-yukarıKomut < 0){
                    yukarıKomut = gezgin.getKonumY();
                }
                for (i = 0; i <= yukarıKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("yukarı kontrol edilen : " + (gezgin.getKonumX()) + "," + (gezgin.getKonumY() - i) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumY() - i) == getEngelY()[k] && gezgin.getKonumX() == getEngelX()[k]) {
                            temasEdilenEngel++;
                            System.out.println("engel üzerinden geçildi");
                        }
                    }
                }
                if(gezgin.getKonumX()+sağaKomut >20){
                    sağaKomut = 20-gezgin.getKonumX();
                }
                for (i = 1; i <= sağaKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("sağa kontrol edilen : " + (gezgin.getKonumX() + i) + "," + (gezgin.getKonumY() - yukarıKomut) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumX() + i) == getEngelX()[k] && gezgin.getKonumY() - yukarıKomut == getEngelY()[k]) {
                            temasEdilenEngel++;
                            System.out.println("engel üzerinden geçildi");
                        }
                    }
                }if(gezgin.getKonumY()+aşağıKomut >20){
                    aşağıKomut=20-gezgin.getKonumY();
                }
                for (i = 1; i <= aşağıKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("aşağı kontrol edilen : " + (gezgin.getKonumX() + sağaKomut) + "," + (gezgin.getKonumY() - yukarıKomut + i) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumY() - yukarıKomut + i) == getEngelY()[k] && gezgin.getKonumX() + sağaKomut == getEngelX()[k]) {
                            temasEdilenEngel++;
                            System.out.println("Engel üzerinden geçildi");
                        }
                    }
                }if(gezgin.getKonumX()-solaKomut <=0){
                    solaKomut = gezgin.getKonumX();
                }
                for (i = 1; i <= solaKomut; i++) {
                    for (int k = 0; k < size; k++) {
                        System.out.println("sola kontrol edilen : " + (gezgin.getKonumX() + sağaKomut - i) + "," + (gezgin.getKonumY() - yukarıKomut + aşağıKomut) + " ve " +
                                getEngelX()[k] + "," + getEngelY()[k]);
                        if ((gezgin.getKonumX() + sağaKomut - i) == getEngelX()[k] && (gezgin.getKonumY() - yukarıKomut + aşağıKomut) == getEngelY()[k]) {
                            temasEdilenEngel++;
                            System.out.println("Engel üzerinden geçildi");
                        }
                    }
                }
                //toplam süre hesabı:
                this.toplamSüre.setText(Float.toString((yukarıKomut + aşağıKomut + sağaKomut + solaKomut) * 10 / gezgin.getGezinmeHizi()
                        + temasEdilenEngel * Float.parseFloat(engelGeçmeSüresiText.getText())));

                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + " Son Konum :" + SonKonumX + " " + SonKonumY +
                        " Toplam Süre " + toplamSüre.getText());

            }else System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Tekerlekli robot için minimum hız 7 m/s dir.]");
        }
        else if (this.SpiderButton.isSelected()) {
                System.out.println("Spider tipi robot seçildi");
                Spider gezgin = new Spider();
                rectangle = new Rectangle();
                boolean shouldStop = false;
                gezgin.setGezinmeHizi(Integer.parseInt(GezinmeHızı.getText()));
                gezgin.setMotorSayisi(Integer.parseInt(MotorSayısı.getText()));
                gezgin.setYükMiktari(Integer.parseInt(YükMiktarı.getText()));
                gezgin.setBacakSayisi(Integer.parseInt(AyakSayısı.getText()));
                gezgin.setKonumX(Integer.parseInt(KonumX.getText()));
                gezgin.setKonumY(Integer.parseInt(KonumY.getText()));

                if (gezgin.getMinHız() <= gezgin.getGezinmeHizi()) {

                    if (gezgin.getKonumX() >= 20) {
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        gezgin.setKonumX(19);
                    } else if (gezgin.getKonumX() < 0) {
                        gezgin.setKonumX(0);
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    }
                    if (gezgin.getKonumY() >= 20) {
                        gezgin.setKonumY(19);
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    } else if (gezgin.getKonumY() < 0) {
                        gezgin.setKonumY(0);
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    }
                    GridPane.setRowIndex(rectangle, gezgin.getKonumY());
                    GridPane.setColumnIndex(rectangle, gezgin.getKonumX());
                    rectangle.setWidth(26);
                    rectangle.setHeight(26);
                    this.myGrid.getChildren().add(rectangle);
                    rectangle.setFill(Color.rgb(255, 234, 167));
                    this.DoneButton.setStyle("-fx-background-color : #fdcb6e");

                    setYukarıKomut(Integer.parseInt(this.yukarı.getText()));
                    setAşağıKomut(Integer.parseInt(this.aşağı.getText()));
                    setSağaKomut(Integer.parseInt(this.sağa.getText()));
                    setSolaKomut(Integer.parseInt(this.sola.getText()));

                    //robotun son konumunda dikdörtgen oluşturur
                    Rectangle lastRectangle = new Rectangle();
                    SonKonumX = gezgin.getKonumX() + getSağaKomut() - getSolaKomut();
                    SonKonumY = gezgin.getKonumY() - getYukarıKomut() + getAşağıKomut();

                    if(SonKonumX<0){
                        this.SonKonumX=0;
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    }else if(SonKonumX>=20){
                        this.SonKonumX=19;
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    }
                    else if(SonKonumY<0){
                        this.SonKonumY=0;
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    }else if(SonKonumY>=20){
                        this.SonKonumY=19;
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    }
                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                    GridPane.setRowIndex(lastRectangle, SonKonumY);

                    lastRectangle.setWidth(26);
                    lastRectangle.setHeight(26);
                    lastRectangle.setFill(Color.rgb(49, 210, 212));
                    myGrid.getChildren().add(lastRectangle);
                    if(gezgin.getKonumY() <= yukarıKomut){
                        yukarıKomut = gezgin.getKonumY();
                    }
                    System.out.println(gezgin.getKonumY());
                    System.out.println(yukarıKomut);
                   //Engel Kontrolü
                    int i;int gidilenYol = 0;
                    for (i = 0; i <= yukarıKomut; i++) {
                        for (int k = 0; k < size; k++) {
                            SonKonumX = (gezgin.getKonumX());
                            SonKonumY = (gezgin.getKonumY() - i);
                            if(SonKonumX<0){
                                this.SonKonumX=0;
                                GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }else if(SonKonumX>=20){
                                this.SonKonumX=19;
                                GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            else if(SonKonumY<0){
                                this.SonKonumY=0;
                                GridPane.setRowIndex(lastRectangle, SonKonumY);
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }else if(SonKonumY>=20){
                                this.SonKonumY=19;
                                GridPane.setRowIndex(lastRectangle, SonKonumY);
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            System.out.println("yukarı kontrol edilen : " + SonKonumX + "," + SonKonumY + " ve " +
                                    getEngelX()[k] + "," + getEngelY()[k]);
                            if (SonKonumY == getEngelY()[k] && SonKonumX == getEngelX()[k]) {
                                System.out.println("Engele takıldı");
                                GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                SonKonumY++;
                                GridPane.setRowIndex(lastRectangle, SonKonumY);
                                gidilenYol = Math.abs(SonKonumY-gezgin.getKonumY()) + Math.abs(SonKonumX-gezgin.getKonumX());
                                shouldStop = true;
                                this.sonKonumX.setText(Integer.toString(SonKonumX));
                                this.sonKonumY.setText(Integer.toString(SonKonumY));
                                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                        + SonKonumY + " Gidilen yol " + gidilenYol);
                                this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                                break;
                            }
                            if (shouldStop) break;
                        }
                        if (shouldStop) break;
                    }
                    if (!shouldStop) {
                        if(gezgin.getKonumX()+sağaKomut >20){
                            sağaKomut = 20-gezgin.getKonumX();
                        }
                        for (i = 0; i <= sağaKomut; i++) {
                            for (int k = 0; k < size; k++) {
                                SonKonumX = (gezgin.getKonumX() + i);
                                SonKonumY = (gezgin.getKonumY() - yukarıKomut);
                                if(SonKonumX<0){
                                    this.SonKonumX=0;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }else if(SonKonumX>=20){
                                    this.SonKonumX=19;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }
                                else if(SonKonumY<0){
                                    this.SonKonumY=0;
                                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }else if(SonKonumY>=20){
                                    this.SonKonumY=19;
                                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }
                                System.out.println("sağa kontrol edilen : " + SonKonumX + "," + SonKonumY + " ve " +
                                        getEngelX()[k] + "," + getEngelY()[k]);
                                if ((SonKonumX == getEngelX()[k] && SonKonumY == getEngelY()[k])) {
                                    System.out.println("Engele takıldı");
                                    SonKonumX--;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    GridPane.setRowIndex(lastRectangle,SonKonumY);
                                    gidilenYol = Math.abs(SonKonumY-gezgin.getKonumY()) + Math.abs(SonKonumX-gezgin.getKonumX());
                                    shouldStop = true;
                                    this.sonKonumX.setText(Integer.toString(SonKonumX));
                                    this.sonKonumY.setText(Integer.toString(SonKonumY));
                                    System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                            + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                            + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                            + SonKonumY + " Gidilen yol " + gidilenYol);

                                    this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                                }
                                if (shouldStop) break;
                            }
                            if (shouldStop) break;
                        }
                    }
                    if (!shouldStop) {if(gezgin.getKonumY()+aşağıKomut >20){
                            aşağıKomut=20-gezgin.getKonumY();
                    }
                        for (i = 0; i <= aşağıKomut; i++) {
                            for (int k = 0; k < size; k++) {
                                SonKonumX = (gezgin.getKonumX() + sağaKomut);
                                SonKonumY = (gezgin.getKonumY() - yukarıKomut + i);
                                if(SonKonumX<0){
                                    this.SonKonumX=0;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }else if(SonKonumX>=20){
                                    this.SonKonumX=19;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }
                                else if(SonKonumY<0){
                                    this.SonKonumY=0;
                                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }else if(SonKonumY>=20){
                                    this.SonKonumY=19;
                                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }
                                System.out.println("aşağı kontrol edilen : " + SonKonumX + "," + SonKonumY + " ve " +
                                        getEngelX()[k] + "," + getEngelY()[k]);
                                if (SonKonumY == getEngelY()[k] && SonKonumX == getEngelX()[k]) {
                                    System.out.println("Engele takıldı");
                                    gidilenYol = i + yukarıKomut+sağaKomut;
                                    SonKonumY--;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    GridPane.setRowIndex(lastRectangle,SonKonumY);
                                    shouldStop = true;
                                    this.sonKonumX.setText(Integer.toString(SonKonumX));
                                    this.sonKonumY.setText(Integer.toString(SonKonumY));
                                    System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                            + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                            + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                            + SonKonumY + " Gidilen yol " + gidilenYol);

                                    this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                                }
                                if (shouldStop) break;
                            }
                            if (shouldStop) break;
                        }
                    }
                    if (!shouldStop) {
                        if(gezgin.getKonumX()-solaKomut <=0){
                            solaKomut = gezgin.getKonumX();
                        }
                        for (i = 0; i <= solaKomut; i++) {
                            for (int k = 0; k < size; k++) {
                                SonKonumX = (gezgin.getKonumX() + sağaKomut - i);
                                SonKonumY = ((gezgin.getKonumY() - yukarıKomut + aşağıKomut));
                                if(SonKonumX<0){
                                    this.SonKonumX=0;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }else if(SonKonumX>=20){
                                    this.SonKonumX=19;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }
                                else if(SonKonumY<0){
                                    this.SonKonumY=0;
                                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }else if(SonKonumY>=20){
                                    this.SonKonumY=19;
                                    GridPane.setRowIndex(lastRectangle, SonKonumY);
                                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                }
                                System.out.println("sola kontrol edilen : " + SonKonumX + "," + SonKonumY + " ve " +
                                        getEngelX()[k] + "," + getEngelY()[k]);
                                if (SonKonumX == getEngelX()[k] && (SonKonumY == getEngelY()[k])) {
                                    System.out.println("Engele takıldı");
                                    gidilenYol = i +aşağıKomut + sağaKomut +yukarıKomut;
                                    SonKonumX++;
                                    GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                    GridPane.setRowIndex(lastRectangle,SonKonumY);
                                    this.sonKonumX.setText(Integer.toString(SonKonumX + 1));
                                    this.sonKonumY.setText(Integer.toString(SonKonumY));
                                    System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                            + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                            + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                            + SonKonumY + " Gidilen yol " + gidilenYol);

                                    this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                                    shouldStop = true;
                                    break;
                                }
                                if (shouldStop) break;
                            }
                            if (shouldStop) break;
                        }
                    }
                    if(!shouldStop) {
                        if(gezgin.getKonumY()-yukarıKomut < 0){
                            yukarıKomut = gezgin.getKonumY();
                        }
                        if(gezgin.getKonumX()+sağaKomut >20){
                            sağaKomut = 20-gezgin.getKonumX();
                        }
                        if(gezgin.getKonumY()+aşağıKomut >20){
                            aşağıKomut=20-gezgin.getKonumY();
                        }
                        if(gezgin.getKonumX()-solaKomut <=0){
                            solaKomut = gezgin.getKonumX();
                        }
                        gidilenYol = yukarıKomut + aşağıKomut + sağaKomut + solaKomut;
                        this.sonKonumX.setText(Integer.toString(SonKonumX));
                        this.sonKonumY.setText(Integer.toString(SonKonumY));
                        if(SonKonumX<0){
                            this.SonKonumX=0;
                            GridPane.setColumnIndex(lastRectangle,SonKonumX);
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }else if(SonKonumX>=20){
                            this.SonKonumX=19;
                            GridPane.setColumnIndex(lastRectangle,SonKonumX);
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }
                        else if(SonKonumY<0){
                            this.SonKonumY=0;
                            GridPane.setRowIndex(lastRectangle, SonKonumY);
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }else if(SonKonumY>=20){
                            this.SonKonumY=19;
                            GridPane.setRowIndex(lastRectangle, SonKonumY);
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }
                        GridPane.setColumnIndex(lastRectangle,SonKonumX);
                        GridPane.setRowIndex(lastRectangle, SonKonumY);
                        System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                + SonKonumY + " Gidilen yol " + gidilenYol);
                        this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                    }
                } else if (gezgin.getMinHız() > gezgin.getGezinmeHizi())System.out.println("Minimum hız sınırı aşıldı.[Spider robot için minimum hız 3 m/s dir.]");
            }

    }

    /**********************************************************************************************************/


    /***************************************ANA MENÜYE GEÇİŞ YAPAN FONKSİYON*********************************/
    @FXML
    void anaMenüAç(ActionEvent event) throws IOException {
        Parent FirstProbParent = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        Scene FirstProbScene = new Scene(FirstProbParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FirstProbScene);
        window.show();
    }

    /********************************************************************************************************/


    /*******************************RADİO BUTONLARININ KONTROLÜNÜ YAPAN FONKSİYON***************************/
    @FXML
    void ButonKontrol(ActionEvent event) {
        if (this.TekerlekliButton.isSelected()) {
            this.PaletliButton.setSelected(false);
            this.SpiderButton.setSelected(false);
            this.BacakSayısı.setText("Tekerlek Sayısı:");
        } else if (this.PaletliButton.isSelected()) {
            this.TekerlekliButton.setSelected(false);
            this.SpiderButton.setSelected(false);
            this.BacakSayısı.setText("Palet Sayısı:");
        } else if (this.SpiderButton.isSelected()) {
            this.TekerlekliButton.setSelected(false);
            this.PaletliButton.setSelected(false);
            this.BacakSayısı.setText("Bacak Sayısı:");
        }

    }

    /******************************************************************************************************/
    @FXML
    void initialize() {
        assert AnaMenüButton != null;
        assert myGrid != null : "fx:id=\"myGrid\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert sizeText != null : "fx:id=\"sizeText\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert KonumX != null : "fx:id=\"KonumX\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert KonumY != null : "fx:id=\"KonumY\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert yukarı != null : "fx:id=\"yukarı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert aşağı != null : "fx:id=\"aşağı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert sağa != null : "fx:id=\"sağa\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert sola != null : "fx:id=\"sola\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert sonKonumX != null : "fx:id=\"sonKonumX\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert sonKonumY != null : "fx:id=\"sonKonumY\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert toplamSüre != null : "fx:id=\"toplamSüre\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert TekerlekliButton != null : "fx:id=\"TekerlekliButton\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert PaletliButton != null : "fx:id=\"PaletliButton\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert SpiderButton != null : "fx:id=\"SpiderButton\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert MotorSayısı != null : "fx:id=\"MotorSayısı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert YükMiktarı != null : "fx:id=\"YükMiktarı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert AyakSayısı != null : "fx:id=\"AyakSayısı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert GezinmeHızı != null : "fx:id=\"GezinmeHızı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert BacakSayısı != null : "fx:id=\"BacakSayısı\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert engelGeçmeSüresiText != null : "fx:id=\"engelGeçmeSüresiText\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert onay != null : "fx:id=\"onay\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";
        assert DoneButton != null : "fx:id=\"DoneButton\" was not injected: check your FXML file 'FirstProblemGrid.fxml'.";

    }


    /*******************************************GET-SET METODLARI*****************************************/

    public int getAşağıKomut() {
        return aşağıKomut;
    }

    public int getSağaKomut() {
        return sağaKomut;
    }

    public int getSolaKomut() {
        return solaKomut;
    }

    public int getYukarıKomut() {
        return yukarıKomut;
    }

    public void setAşağıKomut(int aşağıKomut) {
        this.aşağıKomut = aşağıKomut;
    }

    public void setSağaKomut(int sağaKomut) {
        this.sağaKomut = sağaKomut;
    }

    public void setYukarıKomut(int yukarıKomut) {
        this.yukarıKomut = yukarıKomut;
    }

    public void setSolaKomut(int solaKomut) {
        this.solaKomut = solaKomut;
    }

    public int[] getEngelX() {
        return EngelX;
    }

    public void setEngelX(int[] engelX) {
        EngelX = engelX;
    }

    public int[] getEngelY() {
        return EngelY;
    }

    public void setEngelY(int[] engelY) {
        EngelY = engelY;
    }

    public void setSize(int size) {
        this.size = size;
    }
    /******************************************************************************************************************/
}

