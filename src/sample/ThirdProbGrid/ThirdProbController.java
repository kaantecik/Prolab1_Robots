package sample.ThirdProbGrid;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;
import sample.Robots.*;

import javax.swing.text.html.ImageView;

public class ThirdProbController {

    ObservableList<String> gezginList = FXCollections.observableArrayList("Tekerlekli", "Paletli", "Spider");
    ObservableList<String> manipülatörList = FXCollections.observableArrayList("Paralel", "Seri");
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
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea ayakSayısı;

    @FXML
    private TextArea kolUzunluğu;

    @FXML
    private TextArea sizeText;

    @FXML
    private TextArea kapasite;

    @FXML
    private TextArea yükMiktarı;

    @FXML
    private TextArea sabitlemeSüresi;

    @FXML
    private TextArea geçişSüresi;

    @FXML
    private TextArea motorSayısı;

    @FXML
    private TextArea konumX;

    @FXML
    private TextArea konumY;

    @FXML
    private TextArea gezinmeHızı;

    @FXML
    private TextArea yukarı;

    @FXML
    private TextArea aşağı;

    @FXML
    private TextArea sağa;

    @FXML
    private TextArea sola;

    @FXML
    private Label GezginAyakSayısıText;

    @FXML
    private TextArea taşımaHızı;

    @FXML
    private TextArea solaK;

    @FXML
    private TextArea aşağıK;

    @FXML
    private TextArea sağaK;

    @FXML
    private TextArea yukarıK;

    @FXML
    private TextArea manipMotorSayısı;

    @FXML
    private Label sonKonumX;

    @FXML
    private Label sonKonumY;

    @FXML
    private Label ManipSonKonumX;

    @FXML
    private Label ManipSonKonumY;

    @FXML
    private Label toplamSüre;

    @FXML
    private RadioButton ParalelButton;

    @FXML
    private RadioButton SeriButton;

    @FXML
    private RadioButton TekerlekliButton;

    @FXML
    private RadioButton PaletliButton;

    @FXML
    private RadioButton SpiderButton;

    @FXML
    private GridPane myGrid;

    @FXML
    private Button onay;

    @FXML
    private ToggleButton DoneButton;

    @FXML
    private Button SimulateButton;

    @FXML
    private Button AnaMenüButton;

    Paletli paletli = new Paletli();
    Tekerlekli tekerlekli = new Tekerlekli();
    Spider spider =new Spider();
    Paralel paralel = new Paralel();
    Seri seri = new Seri();
    public Hybrid spiderParalel = new Hybrid(spider,paralel);
    public Hybrid spiderSeri = new Hybrid(spider,seri);
    public Hybrid paletliParalel = new Hybrid(paletli,paralel);
    public Hybrid paletliSeri = new Hybrid(paletli,seri);
    public Hybrid tekerlekliParalel = new Hybrid(tekerlekli,paralel);
    public Hybrid tekerlekliSeri = new Hybrid(tekerlekli,seri);
    private  float gezginSüre;
    public float getGezginSüre() {
        return gezginSüre;
    }
    public void setGezginSüre(float gezginSüre) {
        this.gezginSüre = gezginSüre;
    }

    @FXML
    void anaMenüAç(ActionEvent event) throws IOException {
        Parent FirstProbParent = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        Scene FirstProbScene = new Scene(FirstProbParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(FirstProbScene);
        window.show();
    }

    @FXML
    void initialize() {
        assert AnaMenüButton != null : "fx:id=\"AnaMenüButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert ayakSayısı != null : "fx:id=\"ayakSayısı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert kolUzunluğu != null : "fx:id=\"kolUzunluğu\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sizeText != null : "fx:id=\"sizeText\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert kapasite != null : "fx:id=\"kapasite\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert yükMiktarı != null : "fx:id=\"yükMiktarı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sabitlemeSüresi != null : "fx:id=\"sabitlemeSüresi\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert geçişSüresi != null : "fx:id=\"geçişSüresi\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert motorSayısı != null : "fx:id=\"motorSayısı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert konumX != null : "fx:id=\"konumX\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert konumY != null : "fx:id=\"konumY\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert gezinmeHızı != null : "fx:id=\"gezinmeHızı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert yukarı != null : "fx:id=\"yukarı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert aşağı != null : "fx:id=\"aşağı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sağa != null : "fx:id=\"sağa\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sola != null : "fx:id=\"sola\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert GezginAyakSayısıText != null : "fx:id=\"GezginAyakSayısıText\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert taşımaHızı != null : "fx:id=\"taşımaHızı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert solaK != null : "fx:id=\"solaK\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert aşağıK != null : "fx:id=\"aşağıK\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sağaK != null : "fx:id=\"sağaK\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert yukarıK != null : "fx:id=\"yukarıK\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert manipMotorSayısı != null : "fx:id=\"manipMotorSayısı\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sonKonumX != null : "fx:id=\"sonKonumX\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert sonKonumY != null : "fx:id=\"sonKonumY\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert ManipSonKonumX != null : "fx:id=\"ManipSonKonumX\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert ManipSonKonumY != null : "fx:id=\"ManipSonKonumY\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert toplamSüre != null : "fx:id=\"toplamSüre\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert ParalelButton != null : "fx:id=\"ParalelButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert SeriButton != null : "fx:id=\"SeriButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert TekerlekliButton != null : "fx:id=\"TekerlekliButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert PaletliButton != null : "fx:id=\"PaletliButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert SpiderButton != null : "fx:id=\"SpiderButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert myGrid != null : "fx:id=\"myGrid\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert onay != null : "fx:id=\"onay\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert DoneButton != null : "fx:id=\"DoneButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";
        assert SimulateButton != null : "fx:id=\"SimulateButton\" was not injected: check your FXML file 'ThirdProbGrid.fxml'.";

    }

    //engelleri oluşturan fonksiyon
    @FXML
    void EngelleriAl() {
        int size = Integer.parseInt(this.sizeText.getText());
        int[] engelX = new int[size];
        int[] engelY = new int[size];

        int i;
        for (i = 0; i < size; ++i) {
            System.out.println(i + 1 + ". engelin koordinatlarını giriniz:");
            Scanner scanner = new Scanner(System.in);
            engelX[i] = scanner.nextInt();
            engelY[i] = scanner.nextInt();
        }

        for (i = 0; i < size; i++) {
            Rectangle engel = new Rectangle();
            engel.setWidth(26);
            engel.setHeight(26);
            GridPane.setColumnIndex(engel, engelX[i]);
            GridPane.setRowIndex(engel, engelY[i]);
            this.myGrid.getChildren().add(engel);
            engel.setFill(Color.rgb(214, 48, 49));
        }
        System.out.println("Engeller oluşturuldu!");
        //

        setEngelX(engelX);
        setEngelY(engelY);
        setSize(size);
    }

    //Gezgin için simüle eden fonksiyon
    @FXML
    void GetValues() {
        Rectangle rectangle;
        if (PaletliButton.isSelected()) {
            //Robotun oluşturulduğu ve verilerin alındığı alan
            System.out.println("Paletli tipi robot seçildi");
            Paletli gezgin = new Paletli();

            gezgin.setMotorSayisi(Integer.parseInt(motorSayısı.getText()));
            gezgin.setGezinmeHizi(Integer.parseInt(gezinmeHızı.getText()));
            gezgin.setYükMiktari(Integer.parseInt(yükMiktarı.getText()));
            gezgin.setPaletSayisi(Integer.parseInt(ayakSayısı.getText()));
            gezgin.setEngelGeçmeSüresi((float) (gezgin.getMotorSayisi() * 3));
            gezgin.setKonumX(Integer.parseInt(konumX.getText()));
            gezgin.setKonumY(Integer.parseInt(konumY.getText()));

            if(gezgin.getMinHız()<= gezgin.getGezinmeHizi()) {
                if (gezgin.getKonumX() > 20) {
                    System.out.println("X ekseninde Izgara sınırları aşıldığı için köşeye sabitlendi");
                    gezgin.setKonumX(20);
                } else if (gezgin.getKonumX() < 0) {
                    gezgin.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşıldığı için köşeye sabitlendi");
                }

                if (gezgin.getKonumY() > 20) {
                    gezgin.setKonumY(20);
                    System.out.println("Y ekseninde Izgara sınırları aşıldığı için köşeye sabitlendi");
                } else if (gezgin.getKonumY() < 0) {
                    gezgin.setKonumX(0);
                    System.out.println("Y ekseninde Izgara sınırları aşıldığı için köşeye sabitlendi");
                }

                //robotun dikdörtgenini çizen kısım
                rectangle = new Rectangle();
                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                GridPane.setRowIndex(rectangle, gezgin.getKonumY());
                GridPane.setColumnIndex(rectangle, gezgin.getKonumX());

                this.myGrid.getChildren().add(rectangle);
                rectangle.setFill(Color.rgb(250, 177, 160));
                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");

                yukarıKomut= Integer.parseInt(this.yukarıK.getText());
                aşağıKomut = Integer.parseInt(this.aşağıK.getText());
                sağaKomut = Integer.parseInt(this.sağaK.getText());
                solaKomut = Integer.parseInt(this.solaK.getText());

                //robotun son konumunda dikdörtgen oluşturur
                Rectangle lastRectangle = new Rectangle();
                lastRectangle.setWidth(26);
                lastRectangle.setHeight(26);
                lastRectangle.setFill(Color.rgb(34, 197, 197));

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
                this.sonKonumX.setText(Integer.toString(gezgin.getKonumX() + sağaKomut - solaKomut));
                this.sonKonumY.setText(Integer.toString(gezgin.getKonumY() - yukarıKomut+ aşağıKomut));

                GridPane.setColumnIndex(lastRectangle,SonKonumX);
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
                }
                if(gezgin.getKonumY()+aşağıKomut >20){
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
                        if ((gezgin.getKonumX() + sağaKomut - i) == getEngelX()[k] && (gezgin.getKonumY() - yukarıKomut+ aşağıKomut) == getEngelY()[k]) {
                            temasEdilenEngel++;
                            System.out.println("Engel üzerinden geçildi");
                        }
                    }
                }


                //toplam süre hesabı:
                this.toplamSüre.setText(Float.toString((yukarıKomut + aşağıKomut + sağaKomut + solaKomut) * 10 / gezgin.getGezinmeHizi()
                        + temasEdilenEngel * gezgin.getEngelGeçmeSüresi()));
                setGezginSüre(((yukarıKomut + aşağıKomut + sağaKomut + solaKomut)) * 10 / gezgin.getGezinmeHizi()
                        + temasEdilenEngel * gezgin.getEngelGeçmeSüresi());
                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + " Son Konum :" + SonKonumX + " " + SonKonumY + " Toplam Süre " + toplamSüre.getText());

            }else System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Paletli robot için minimum hız 5 m/s dir.]");

        }
        else if (TekerlekliButton.isSelected()) {
            Tekerlekli gezgin = new Tekerlekli();
            System.out.println("Tekerlekli tipi robot seçildi");

            gezgin.setMotorSayisi(Integer.parseInt(this.motorSayısı.getText()));
            gezgin.setGezinmeHizi(Integer.parseInt(this.gezinmeHızı.getText()));
            gezgin.setYükMiktari(Integer.parseInt(this.yükMiktarı.getText()));
            gezgin.setTekerlekSayisi(Integer.parseInt(this.ayakSayısı.getText()));
            gezgin.setEngelGeçmeSüresi((float)gezgin.getMotorSayisi() / 2);
            gezgin.setKonumX(Integer.parseInt(konumX.getText()));
            gezgin.setKonumY(Integer.parseInt(konumY.getText()));

            if (gezgin.getMinHız() <= gezgin.getGezinmeHizi()) {
                if (gezgin.getKonumX() > 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    gezgin.setKonumX(20);
                } else if (gezgin.getKonumX() < 0) {
                    gezgin.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                if (gezgin.getKonumY() > 20) {
                    gezgin.setKonumY(20);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (gezgin.getKonumY() < 0) {
                    gezgin.setKonumY(0);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                //robotun dikdörtgenini çizen kısım
                rectangle = new Rectangle();
                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                GridPane.setRowIndex(rectangle, gezgin.getKonumY());
                GridPane.setColumnIndex(rectangle, gezgin.getKonumX());

                this.myGrid.getChildren().add(rectangle);
                rectangle.setFill(Color.rgb(248, 156, 252));
                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");

                yukarıKomut = Integer.parseInt(this.yukarıK.getText());
                aşağıKomut = Integer.parseInt(this.aşağıK.getText());
                sağaKomut = Integer.parseInt(this.sağaK.getText());
                solaKomut = Integer.parseInt(this.solaK.getText());

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
                GridPane.setRowIndex(lastRectangle,SonKonumY);
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

                for (i = 0; i <= solaKomut ;i++) {
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
                this.toplamSüre.setText(Float.toString((yukarıKomut+ aşağıKomut + sağaKomut+ solaKomut) * 10 / gezgin.getGezinmeHizi()
                        + temasEdilenEngel * gezgin.getEngelGeçmeSüresi()));
                setGezginSüre(((yukarıKomut + aşağıKomut + sağaKomut + solaKomut)) * 10 / gezgin.getGezinmeHizi()
                        + temasEdilenEngel * gezgin.getEngelGeçmeSüresi());
                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :"
                        + SonKonumX + " " + SonKonumY + " Toplam süre: " + toplamSüre.getText());

            }else System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Tekerlekli robot için minimum hız 7 m/s dir.]");
        }
        else if (SpiderButton.isSelected()) {
            System.out.println("Spider tipi robot seçildi");
            Spider gezgin = new Spider();
            int gidilenYol=0;
            boolean shouldStop = false;
            gezgin.setGezinmeHizi(Integer.parseInt(gezinmeHızı.getText()));
            gezgin.setMotorSayisi(Integer.parseInt(motorSayısı.getText()));
            gezgin.setYükMiktari(Integer.parseInt(yükMiktarı.getText()));
            gezgin.setBacakSayisi(Integer.parseInt(ayakSayısı.getText()));
            gezgin.setKonumX(Integer.parseInt(konumX.getText()));
            gezgin.setKonumY(Integer.parseInt(konumY.getText()));

            if (gezgin.getMinHız() <= gezgin.getGezinmeHizi()) {
                if (gezgin.getKonumX() > 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    gezgin.setKonumX(20);
                } else if (gezgin.getKonumX() < 0) {
                    gezgin.setKonumX(1);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                if (gezgin.getKonumY() > 20) {
                    gezgin.setKonumY(20);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (gezgin.getKonumY() < 0) {
                    gezgin.setKonumY(1);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                //robotun dikdörtgenini çizen kısım
                rectangle = new Rectangle();
                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                GridPane.setRowIndex(rectangle, gezgin.getKonumY());
                GridPane.setColumnIndex(rectangle, gezgin.getKonumX());

                this.myGrid.getChildren().add(rectangle);
                rectangle.setFill(Color.rgb(168, 250, 255));
                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");


                yukarıKomut = Integer.parseInt(this.yukarıK.getText());
                aşağıKomut = Integer.parseInt(this.aşağıK.getText());
                sağaKomut = Integer.parseInt(this.sağaK.getText());
                solaKomut = Integer.parseInt(this.solaK.getText());

                //robotun son konumunda dikdörtgen oluşturur
                Rectangle lastRectangle = new Rectangle();
                SonKonumX = gezgin.getKonumX() + sağaKomut - solaKomut;
                SonKonumY = gezgin.getKonumY() - yukarıKomut + aşağıKomut;

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

                //Engel Kontrolü
                int i;
                if(gezgin.getKonumY()-yukarıKomut <= 0){
                    yukarıKomut = gezgin.getKonumY();
                }
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
                            SonKonumY++;
                            GridPane.setColumnIndex(lastRectangle,SonKonumX);
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
                            setGezginSüre(gidilenYol * 10 / gezgin.getGezinmeHizi());
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
                                setGezginSüre(gidilenYol * 10 / gezgin.getGezinmeHizi());
                            }
                            if (shouldStop) break;
                        }
                        if (shouldStop) break;
                    }
                }
                if (!shouldStop) {
                    if(gezgin.getKonumY()+aşağıKomut >20) {
                        aşağıKomut = 20 - gezgin.getKonumY();
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
                                GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                GridPane.setRowIndex(lastRectangle,SonKonumY );
                                shouldStop = true;
                                this.sonKonumX.setText(Integer.toString(SonKonumX));
                                this.sonKonumY.setText(Integer.toString(SonKonumY));
                                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                        + SonKonumY + " Gidilen yol " + gidilenYol);

                                this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                                setGezginSüre(gidilenYol * 10 / gezgin.getGezinmeHizi());
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
                                GridPane.setColumnIndex(lastRectangle,SonKonumX + 1);
                                GridPane.setRowIndex(lastRectangle,SonKonumY);
                                this.sonKonumX.setText(Integer.toString(SonKonumX + 1));
                                this.sonKonumY.setText(Integer.toString(SonKonumY));
                                System.out.println("Motor Sayısı :" + gezgin.getMotorSayisi() + " Gezinme Hızı : "
                                        + gezgin.getGezinmeHizi() + " Yük Miktarı : " + gezgin.getYükMiktari()
                                        + " Konum :" + gezgin.getKonumX() + " " + gezgin.getKonumY() + "Son Konum :" + SonKonumX + "  "
                                        + SonKonumY + " Gidilen yol " + gidilenYol);

                                this.toplamSüre.setText(Float.toString(gidilenYol * 10 / gezgin.getGezinmeHizi()));
                                setGezginSüre(gidilenYol * 10 / gezgin.getGezinmeHizi());
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
                    setGezginSüre(gidilenYol * 10 / gezgin.getGezinmeHizi());
                }
            } else System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Spider robot için minimum hız 3 m/s dir.]");
        }
    }

    //Manipülatör için simüle eden fonksiyon
    @FXML
    void Simulate (ActionEvent event){

        int yukarıKomut;
        int aşağıKomut;
        int sağaKomut;
        int solaKomut;

        if (ParalelButton.isSelected()) {
            System.out.println("Paralel tipi robot seçildi");
            Paralel paralel = new Paralel();

            paralel.setMotorSayisi(Integer.parseInt(this.manipMotorSayısı.getText()));
            paralel.setTaşımaHızı(Integer.parseInt(this.taşımaHızı.getText()));
            paralel.setYükMiktari(Integer.parseInt(this.yükMiktarı.getText()));
            paralel.setKolUzunluğu(Integer.parseInt(this.kolUzunluğu.getText()));
            paralel.setKapasite(Integer.parseInt(this.kapasite.getText()));
            paralel.setKonumX(Integer.parseInt(this.sonKonumX.getText()));
            paralel.setKonumY(Integer.parseInt(this.sonKonumY.getText()));

            if (paralel.getKapasite() >= paralel.getYükMiktari() && paralel.getTaşımaHızı() >= paralel.getMinHız()) {

                if (paralel.getKonumX() > 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    paralel.setKonumX(20);
                } else if (paralel.getKonumX() < 0) {
                    paralel.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (paralel.getKonumY() > 20) {
                    paralel.setKonumY(20);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (paralel.getKonumY() < 0) {
                    paralel.setKonumX(0);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                yukarıKomut = Integer.parseInt(this.yukarı.getText());
                aşağıKomut = Integer.parseInt(this.aşağı.getText());
                sağaKomut = Integer.parseInt(this.sağa.getText());
                solaKomut = Integer.parseInt(this.sola.getText());

                this.SimulateButton.setStyle("-fx-background-color : #fdcb6e");
                //yükün son konumunda dikdörtgen çizer
                Rectangle lastRectangle = new Rectangle();
                SonKonumX = paralel.getKonumX() + sağaKomut - solaKomut;
                SonKonumY = paralel.getKonumY() - yukarıKomut + aşağıKomut;

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
                GridPane.setColumnIndex(lastRectangle, SonKonumX);
                GridPane.setRowIndex(lastRectangle, SonKonumY);
                lastRectangle.setWidth(26);
                lastRectangle.setHeight(26);
                lastRectangle.setFill(Color.rgb(35, 196, 89));
                myGrid.getChildren().add(lastRectangle);
                // burada kol uzunluğunun kontrolü yapılacak kol uzunluğu ne kadarsa o kadar uzunlukta gidicek
                int kalanKolUzunluğu = paralel.getKolUzunluğu()/10;
                int i;
                int gidilenYol = 0;
                if(SonKonumY-yukarıKomut < 0){
                    yukarıKomut = SonKonumY;
                }
                for(i=1;i<=yukarıKomut;i++){
                    kalanKolUzunluğu--;
                    gidilenYol = i;
                    SonKonumX = paralel.getKonumX();
                    SonKonumY = paralel.getKonumY()-i;
                    if (SonKonumX >= 20) {
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        SonKonumX = 19;
                    } else if (SonKonumX < 0) {
                        SonKonumX = 0;
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        break;
                    }
                    if (SonKonumY >= 20) {
                        SonKonumY = 19;
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    } else if (SonKonumY < 0) {
                        SonKonumY = 0;
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        break;
                    }
                    System.out.println("yukarı ilerleniyor, kalan kol uzunluğu "+ kalanKolUzunluğu + " konum "+
                            " " +paralel.getKonumX() + ", " + (paralel.getKonumY()-i));
                    if(kalanKolUzunluğu == 0){
                        System.out.println("Limit uzaklığa ulaşıldı");
                        SonKonumX = (paralel.getKonumX());
                        SonKonumY = (paralel.getKonumY() - i);
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }
                        GridPane.setColumnIndex(lastRectangle, SonKonumX);
                        GridPane.setRowIndex(lastRectangle,SonKonumY);
                        System.out.println("Motor Sayısı :" + paralel.getMotorSayisi() + "Taşıma Hızı : " + paralel.getTaşımaHızı()
                                + " Yük Miktarı : " + paralel.getYükMiktari() +
                                " İlk Konum :" + paralel.getKonumX() + " " + paralel.getKonumY() +
                                " Son Konum : " + SonKonumX + ", " + SonKonumY + " Gidilen Yol : " + gidilenYol);
                        this.ManipSonKonumX.setText(Integer.toString((SonKonumX)));
                        this.ManipSonKonumY.setText(Integer.toString((SonKonumY)));
                        int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                        this.toplamSüre.setText(Float.toString( sabitlemeS+getGezginSüre()+gidilenYol*10/paralel.getTaşımaHızı()));
                        break;
                    }
                }
                if(kalanKolUzunluğu >0) {
                    if(SonKonumX+sağaKomut >20){
                        sağaKomut = 20-SonKonumX;
                    }
                    for (i = 1; i <= sağaKomut; i++) {
                        kalanKolUzunluğu--;
                        gidilenYol = i + yukarıKomut;
                        SonKonumX = paralel.getKonumX()+i;
                        SonKonumY = paralel.getKonumY()-yukarıKomut;
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        System.out.println("sağa ilerleniyor ,kalan kol uzunluğu " + kalanKolUzunluğu + " konum "+
                                " " + (paralel.getKonumX()+i) + ", " + (paralel.getKonumY()-yukarıKomut));
                        if (kalanKolUzunluğu == 0) {
                            System.out.println("Limit uzaklığa ulaşıldı");
                            SonKonumX = (paralel.getKonumX() + i);
                            SonKonumY = (paralel.getKonumY() - yukarıKomut);
                            if (SonKonumX >= 20) {
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                SonKonumX = 19;
                            } else if (SonKonumX < 0) {
                                SonKonumX = 0;
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            if (SonKonumY >= 20) {
                                SonKonumY = 19;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            } else if (SonKonumY < 0) {
                                SonKonumY = 0;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            System.out.println("Motor Sayısı :" + paralel.getMotorSayisi() + "Taşıma Hızı : " + paralel.getTaşımaHızı()
                                    + " Yük Miktarı : " + paralel.getYükMiktari() +
                                    " İlk Konum :" + paralel.getKonumX() + " " + paralel.getKonumY() +
                                    " Son Konum : " + SonKonumX + ", " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                            GridPane.setColumnIndex(lastRectangle,SonKonumX);
                            GridPane.setRowIndex(lastRectangle, SonKonumY);
                            this.ManipSonKonumX.setText(Integer.toString((SonKonumX)));
                            this.ManipSonKonumY.setText(Integer.toString((SonKonumY)));
                            int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                            this.toplamSüre.setText(Float.toString( sabitlemeS+getGezginSüre()+gidilenYol*10/paralel.getTaşımaHızı()));
                            break;
                        }
                    }
                }
                if(kalanKolUzunluğu > 0) {
                    if(SonKonumY+aşağıKomut >20){
                        aşağıKomut=20-SonKonumY;
                    }
                    for (i = 1 ; i <= aşağıKomut; i++) {
                        kalanKolUzunluğu--;
                        gidilenYol = i+yukarıKomut+sağaKomut;
                        SonKonumX = paralel.getKonumX()+sağaKomut;
                        SonKonumY = paralel.getKonumY()-yukarıKomut+i;
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        System.out.println("aşağı ilerleniyor,kalan kol uzunluğu "+ kalanKolUzunluğu + " konum "+
                                " " + (paralel.getKonumX() + sağaKomut) + ", " + (paralel.getKonumY() - yukarıKomut + i));
                        if (kalanKolUzunluğu == 0) {
                            System.out.println("Limit uzaklığa ulaşıldı");
                            SonKonumX = (paralel.getKonumX() + sağaKomut);
                            SonKonumY= (paralel.getKonumY() - yukarıKomut + i);
                            if (SonKonumX >= 20) {
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                SonKonumX = 19;
                            } else if (SonKonumX < 0) {
                                SonKonumX = 0;
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            if (SonKonumY >= 20) {
                                SonKonumY = 19;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            } else if (SonKonumY < 0) {
                                SonKonumY = 0;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            GridPane.setColumnIndex(lastRectangle, SonKonumX);
                            GridPane.setRowIndex(lastRectangle,SonKonumY);
                            System.out.println("Motor Sayısı :" + paralel.getMotorSayisi() + "Taşıma Hızı : " + paralel.getTaşımaHızı()
                                    + " Yük Miktarı : " + paralel.getYükMiktari() +
                                    " İlk Konum :" + paralel.getKonumX() + " " + paralel.getKonumY() +
                                    " Son Konum : " + SonKonumX + ", " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                            this.ManipSonKonumX.setText(Integer.toString((SonKonumX)));
                            this.ManipSonKonumY.setText(Integer.toString(SonKonumY));
                            int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                            this.toplamSüre.setText(Float.toString( sabitlemeS+getGezginSüre()+gidilenYol*10/paralel.getTaşımaHızı()));
                            break;
                        }
                    }
                }
                if(kalanKolUzunluğu > 0) {
                    if(SonKonumX-solaKomut <=0){
                        solaKomut = SonKonumX;
                    }
                    for (i = 1; i <= solaKomut; i++) {
                        kalanKolUzunluğu--;
                        System.out.println("sola ilerleniyor ,kalan kol uzunluğu "+ kalanKolUzunluğu + " konum "+
                                " " + (paralel.getKonumX() + sağaKomut - i) + ", " + (paralel.getKonumY() - yukarıKomut + aşağıKomut));
                        gidilenYol = i+ yukarıKomut +sağaKomut + aşağıKomut;
                        SonKonumX = paralel.getKonumX()+sağaKomut-i;
                        SonKonumY = paralel.getKonumY()-yukarıKomut+aşağıKomut;
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (kalanKolUzunluğu == 0) {
                            System.out.println("Limit uzaklığa ulaşıldı");
                            SonKonumX=(paralel.getKonumX() + sağaKomut - i);
                            SonKonumY= (paralel.getKonumY() - yukarıKomut + aşağıKomut);
                            if (SonKonumX >= 20) {
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                SonKonumX = 19;
                                GridPane.setColumnIndex(lastRectangle,SonKonumX);
                            } else if (SonKonumX < 0) {
                                SonKonumX = 0;
                                GridPane.setColumnIndex(lastRectangle,SonKonumX);
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            if (SonKonumY >= 20) {
                                SonKonumY = 19;
                                GridPane.setRowIndex(lastRectangle, SonKonumY);
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            } else if (SonKonumY < 0) {
                                SonKonumY = 0;
                                GridPane.setRowIndex(lastRectangle,SonKonumY);
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            GridPane.setColumnIndex(lastRectangle, SonKonumX);
                            GridPane.setRowIndex(lastRectangle, SonKonumY);
                            System.out.println("Motor Sayısı :" + paralel.getMotorSayisi() + "Taşıma Hızı : " + paralel.getTaşımaHızı()
                                    + " Yük Miktarı : " + paralel.getYükMiktari() +
                                    " İlk Konum :" + paralel.getKonumX() + " " + paralel.getKonumY()+ " Son Konum : " + SonKonumX
                                    + ", " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                            this.ManipSonKonumX.setText(Integer.toString((SonKonumX)));
                            this.ManipSonKonumY.setText(Integer.toString((SonKonumY)));
                            int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                            this.toplamSüre.setText(Float.toString( sabitlemeS+getGezginSüre()+gidilenYol*10/paralel.getTaşımaHızı()));
                            break;
                        }
                    }
                }
                SonKonumX = paralel.getKonumX() +sağaKomut-solaKomut;
                SonKonumY= paralel.getKonumY() -yukarıKomut+aşağıKomut;
                if (SonKonumX >= 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    SonKonumX = 20;
                } else if (SonKonumX < 0) {
                    SonKonumX = 0;
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (SonKonumY >= 20) {
                    SonKonumY = 20;
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (SonKonumY < 0) {
                    SonKonumY = 0;
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                this.ManipSonKonumX.setText(Integer.toString((SonKonumX)));
                this.ManipSonKonumY.setText(Integer.toString((SonKonumY)));
                int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                this.toplamSüre.setText(Float.toString( sabitlemeS+getGezginSüre()+gidilenYol*10/paralel.getTaşımaHızı()));

            } else if (paralel.getKapasite() < paralel.getYükMiktari())
                System.out.println("Yük miktarı kapasiteden daha fazla yük miktarını tekrar giriniz!");

            else
                System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Paralel robot için minimum hız 5 m/s dir.");
        }

        if (SeriButton.isSelected()) {
            System.out.println("Seri tipi robot seçildi");
            Seri seri = new Seri();

            seri.setMotorSayisi(Integer.parseInt(this.motorSayısı.getText()));
            seri.setTaşımaHızı(Integer.parseInt(this.taşımaHızı.getText()));
            seri.setYükMiktari(Integer.parseInt(this.yükMiktarı.getText()));
            seri.setKolUzunluğu(Integer.parseInt(this.kolUzunluğu.getText()));
            seri.setKapasite(Integer.parseInt(this.kapasite.getText()));
            seri.setKonumX(Integer.parseInt(this.sonKonumX.getText()));
            seri.setKonumY(Integer.parseInt(this.sonKonumY.getText()));

            if (seri.getKapasite() >= seri.getYükMiktari() && seri.getTaşımaHızı() >= seri.getMinHız()) {

                if (seri.getKonumX() >= 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    seri.setKonumX(19);
                }
                else if (seri.getKonumX() < 0) {
                    seri.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (seri.getKonumY() >= 20) {
                    seri.setKonumY(19);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                else if (seri.getKonumY() < 0) {
                    seri.setKonumY(0);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

                this.SimulateButton.setStyle("-fx-background-color : #fdcb6e");

                yukarıKomut = Integer.parseInt(this.yukarı.getText());
                aşağıKomut = Integer.parseInt(this.aşağı.getText());
                sağaKomut = Integer.parseInt(this.sağa.getText());
                solaKomut = Integer.parseInt(this.sola.getText());

                //yükün son konumunda dikdörtgen çizer
                Rectangle lastRectangle = new Rectangle();
                SonKonumX = seri.getKonumX() + sağaKomut - solaKomut;
                SonKonumY = seri.getKonumY() - yukarıKomut + aşağıKomut;

                if (SonKonumX > 19) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    SonKonumX = 19;
                } else if (SonKonumX < 0) {
                    SonKonumX = 0;
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (SonKonumY > 19) {
                    SonKonumY = 19;
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (SonKonumY < 0) {
                    SonKonumY = 0;
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                GridPane.setColumnIndex(lastRectangle, SonKonumX);
                GridPane.setRowIndex(lastRectangle, SonKonumY);
                lastRectangle.setWidth(26);
                lastRectangle.setHeight(26);
                lastRectangle.setFill(Color.rgb(35, 196, 89));
                myGrid.getChildren().add(lastRectangle);
                // burada kol uzunluğunun kontrolü yapılacak kol uzunluğu ne kadarsa o kadar uzunlukta gidicek

                int kalanKolUzunluğu = seri.getKolUzunluğu()/10;
                int i;
                int gidilenYol = 0;

                /************************************YUKARI****************************************/
                if(SonKonumY-yukarıKomut < 0){
                    yukarıKomut = SonKonumY;
                }
                for(i=1;i<=yukarıKomut;i++){
                    kalanKolUzunluğu--;
                    SonKonumX = seri.getKonumX();
                    SonKonumY = seri.getKonumY()-i;
                    if (SonKonumX >= 20) {
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        SonKonumX = 19;
                    } else if (SonKonumX < 0) {
                        SonKonumX = 0;
                        System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        break;
                    }
                    if (SonKonumY >= 20) {
                        SonKonumY = 19;
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    } else if (SonKonumY < 0) {
                        SonKonumY = 0;
                        System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        break;
                    }
                    System.out.println("yukarı ilerleniyor, kalan kol uzunluğu "+ kalanKolUzunluğu + " konum "+
                            " " + seri.getKonumX() + ", " + (seri.getKonumY()-i));
                    if(kalanKolUzunluğu == 0){
                        System.out.println("Limit uzaklığa ulaşıldı");
                        SonKonumX = (seri.getKonumX());
                        SonKonumY = (seri.getKonumY() - i);

                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        }
                        gidilenYol = i;
                        GridPane.setColumnIndex(lastRectangle, SonKonumX);
                        GridPane.setRowIndex(lastRectangle,SonKonumY);
                        this.ManipSonKonumX.setText(Integer.toString(SonKonumX));
                        this.ManipSonKonumY.setText(Integer.toString(SonKonumY));
                        int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                        int geçişS = Integer.parseInt(geçişSüresi.getText());
                        this.toplamSüre.setText(Float.toString( geçişS+sabitlemeS+getGezginSüre()+gidilenYol*10/seri.getTaşımaHızı()-2));
                        System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                + " Yük Miktarı : " + seri.getYükMiktari() +
                                " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ " Son Konum "
                                + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                        break;
                    }
                }

                /*********************SAĞA************************/
                if(SonKonumX+sağaKomut >20){
                    sağaKomut = 20-SonKonumX;
                }
                if(kalanKolUzunluğu >0) {
                    for (i = 1; i <= sağaKomut; i++) {
                        kalanKolUzunluğu--;
                        SonKonumX = seri.getKonumX()+i;
                        SonKonumY = seri.getKonumY()-yukarıKomut;
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        System.out.println("sağa ilerleniyor ,kalan kol uzunluğu " + kalanKolUzunluğu + " konum "+
                                " " + (seri.getKonumX()+i) + ", " + (seri.getKonumY()-yukarıKomut));
                        if (kalanKolUzunluğu == 0) {
                            System.out.println("Limit uzaklığa ulaşıldı");
                            SonKonumX = (seri.getKonumX() + i);
                            SonKonumY = (seri.getKonumY() - yukarıKomut);
                            if (SonKonumX >= 20) {
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                SonKonumX = 19;
                            } else if (SonKonumX < 0) {
                                SonKonumX = 0;
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            if (SonKonumY >= 20) {
                                SonKonumY = 19;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            } else if (SonKonumY < 0) {
                                SonKonumY = 0;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            gidilenYol = i + yukarıKomut;
                            GridPane.setColumnIndex(lastRectangle,SonKonumX);
                            GridPane.setRowIndex(lastRectangle, SonKonumY);
                            this.ManipSonKonumX.setText(Integer.toString(SonKonumX));
                            this.ManipSonKonumY.setText(Integer.toString(SonKonumY));
                            int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                            int geçişS = Integer.parseInt(geçişSüresi.getText());
                            this.toplamSüre.setText(Float.toString( geçişS+sabitlemeS+getGezginSüre()+gidilenYol*10/seri.getTaşımaHızı()-2));
                            System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                    + " Yük Miktarı : " + seri.getYükMiktari() +
                                    " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ "Son Konum "
                                    + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                            break;
                        }
                    }
                }
                /*****************AŞAĞI*********************/
                if(SonKonumY+aşağıKomut >20){
                    aşağıKomut=20-SonKonumY;
                }
                if(kalanKolUzunluğu > 0) {
                    for (i = 1 ; i <= aşağıKomut; i++) {
                        kalanKolUzunluğu--;
                        SonKonumX = seri.getKonumX()+ sağaKomut;
                        SonKonumY = seri.getKonumY()-yukarıKomut +i;
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        System.out.println("aşağı ilerleniyor,kalan kol uzunluğu "+ kalanKolUzunluğu + " konum "+
                                " " + (seri.getKonumX() + sağaKomut) + ", " + (seri.getKonumY() - yukarıKomut + i));
                        if (kalanKolUzunluğu == 0) {
                            System.out.println("Limit uzaklığa ulaşıldı");
                            SonKonumX = (seri.getKonumX() + sağaKomut);
                            SonKonumY= (seri.getKonumY() - yukarıKomut + i);

                            if (SonKonumX >= 20) {
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                SonKonumX = 19;
                            } else if (SonKonumX < 0) {
                                SonKonumX = 0;
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            if (SonKonumY >= 20) {
                                SonKonumY = 19;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            } else if (SonKonumY < 0) {
                                SonKonumY = 0;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            gidilenYol = i+yukarıKomut+sağaKomut;
                            GridPane.setColumnIndex(lastRectangle, SonKonumX);
                            GridPane.setRowIndex(lastRectangle,SonKonumY);
                            this.ManipSonKonumX.setText(Integer.toString(SonKonumX));
                            this.ManipSonKonumY.setText(Integer.toString(SonKonumY));
                            int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                            int geçişS = Integer.parseInt(geçişSüresi.getText());
                            this.toplamSüre.setText(Float.toString( geçişS+sabitlemeS+getGezginSüre()+gidilenYol*10/seri.getTaşımaHızı()-2));
                            System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                    + " Yük Miktarı : " + seri.getYükMiktari() +
                                    " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ "Son Konum "
                                    + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);
                            break;
                        }
                    }
                }
                /**********************SOLA************************/
                if(SonKonumX-solaKomut <=0){
                    solaKomut = SonKonumX;
                }
                if(kalanKolUzunluğu > 0) {
                    for (i = 1; i <= solaKomut; i++) {
                        kalanKolUzunluğu--;
                        SonKonumX = seri.getKonumX()+sağaKomut-i;
                        SonKonumY = seri.getKonumY()-yukarıKomut+aşağıKomut;
                        if (SonKonumX >= 20) {
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            SonKonumX = 19;
                        } else if (SonKonumX < 0) {
                            SonKonumX = 0;
                            System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        if (SonKonumY >= 20) {
                            SonKonumY = 19;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                        } else if (SonKonumY < 0) {
                            SonKonumY = 0;
                            System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            break;
                        }
                        System.out.println("sola ilerleniyor ,kalan kol uzunluğu "+ kalanKolUzunluğu + " konum "+
                                " " + (seri.getKonumX() + sağaKomut - i) + ", " + (seri.getKonumY() - yukarıKomut + aşağıKomut));
                        if (kalanKolUzunluğu == 0) {
                            System.out.println("Limit uzaklığa ulaşıldı");
                            SonKonumX=(seri.getKonumX() + sağaKomut - i);
                            SonKonumY= (seri.getKonumY() - yukarıKomut + aşağıKomut);
                            if (SonKonumX >= 20) {
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                                SonKonumX = 19;
                            } else if (SonKonumX < 0) {
                                SonKonumX = 0;
                                System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            if (SonKonumY >= 20) {
                                SonKonumY = 19;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            } else if (SonKonumY < 0) {
                                SonKonumY = 0;
                                System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                            }
                            gidilenYol = i+yukarıKomut+aşağıKomut+sağaKomut;
                            GridPane.setColumnIndex(lastRectangle, SonKonumX);
                            GridPane.setRowIndex(lastRectangle, SonKonumY);
                            this.ManipSonKonumX.setText(Integer.toString(SonKonumX));
                            this.ManipSonKonumY.setText(Integer.toString(SonKonumY));
                            int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                            int geçişS = Integer.parseInt(geçişSüresi.getText());
                            this.toplamSüre.setText(Float.toString( geçişS+sabitlemeS+getGezginSüre()+(gidilenYol*10/seri.getTaşımaHızı())-2));
                            System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                    + " Yük Miktarı : " + seri.getYükMiktari() +
                                    " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ "Son Konum "
                                    + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);
                            break;
                        }
                    }
                }

                SonKonumX = seri.KonumX +sağaKomut-solaKomut;
                SonKonumY= seri.KonumY -yukarıKomut+aşağıKomut;
                gidilenYol = sağaKomut+solaKomut+aşağıKomut+yukarıKomut;
                if (SonKonumX >= 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    SonKonumX = 20;
                } else if (SonKonumX < 0) {
                    SonKonumX = 0;
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (SonKonumY >= 20) {
                    SonKonumY = 20;
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                } else if (SonKonumY < 0) {
                    SonKonumY = 0;
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }

            this.ManipSonKonumX.setText(Integer.toString(SonKonumX));
            this.ManipSonKonumY.setText(Integer.toString(SonKonumY));
                int sabitlemeS = Integer.parseInt(sabitlemeSüresi.getText());
                int geçişS = Integer.parseInt(geçişSüresi.getText());
                this.toplamSüre.setText(Float.toString( geçişS+sabitlemeS+getGezginSüre()+gidilenYol*10/seri.getTaşımaHızı()));
            } else if (seri.getKapasite() < seri.getYükMiktari())
                System.out.println("Yük miktarı kapasiteden daha fazla yük miktarını tekrar giriniz!");

            else
                System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Seri robot için minimum hız 3 m/s dir.");
        }
    }

    public void setSize(int size) {
        this.size = size;
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
    //Radio butonlarının kontrolünü yapan fonksiyonlar
    @FXML
    void ButonKontrol (ActionEvent event)
    {
        if (this.ParalelButton.isSelected()) {
            this.SeriButton.setSelected(false);
        } else if (this.SeriButton.isSelected()) {
            this.ParalelButton.setSelected(false);
        }
    }

    @FXML
    void GezginButonKontrol(){
        if (this.TekerlekliButton.isSelected()) {
            this.PaletliButton.setSelected(false);
            this.SpiderButton.setSelected(false);
            this.GezginAyakSayısıText.setText("Tekerlek Sayısı:");
        } else if (this.PaletliButton.isSelected()) {
            this.TekerlekliButton.setSelected(false);
            this.SpiderButton.setSelected(false);
            this.GezginAyakSayısıText.setText("Palet Sayısı:");

        } else if (this.SpiderButton.isSelected()) {
            this.TekerlekliButton.setSelected(false);
            this.PaletliButton.setSelected(false);
            this.GezginAyakSayısıText.setText("Bacak Sayısı:");
        }
    }
    //
}

