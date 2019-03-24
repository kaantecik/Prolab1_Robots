package sample.SecondProbGrid;
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
import javafx.stage.Stage;
import sample.Main;
import sample.Robots.Paralel;
import sample.Robots.Seri;


public class SecondProbController {
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
    private Button simulateButton;
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
    private RadioButton ParalelButton;
    @FXML
    private RadioButton SeriButton;
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
    private TextArea KapasiteText;
    @FXML
    private Button onay;
    @FXML
    private ToggleButton DoneButton;
    @FXML
    private Button AnaMenüButton;


    //Engelleri oluşturan fonksiyon
    @FXML
    void EngelleriAl(ActionEvent event) {
        int size = Integer.parseInt(this.sizeText.getText());
        int[] a = new int[size];
        int[] b = new int[size];
        int i;
        for(i = 0; i < size; ++i) {
            System.out.println(i + 1 + ". engelin koordinatlarını giriniz:");
            Scanner scanner = new Scanner(System.in);
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        for(i = 0; i < size; ++i) {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(26.0D);
            rectangle.setHeight(26.0D);
            GridPane.setColumnIndex(rectangle, a[i]);
            GridPane.setRowIndex(rectangle, b[i]);
            this.myGrid.getChildren().add(rectangle);
            rectangle.setFill(Color.rgb(214, 48, 49));
        }
        System.out.println("Engeller oluşturuldu!");

    }

    //Tüm değerleri alıp problemi çözen fonksiyon
    @FXML
    void GetValues(ActionEvent event) {
        int yukarıKomut;
        int aşağıKomut;
        int sağaKomut;
        int solaKomut;

        if (this.ParalelButton.isSelected()) {
            System.out.println("Paralel tipi robot seçildi");
            Paralel paralel = new Paralel();
            Rectangle rectangle = new Rectangle();

            paralel.setMotorSayisi(Integer.parseInt(this.MotorSayısı.getText()));
            paralel.setTaşımaHızı(Integer.parseInt(this.GezinmeHızı.getText()));
            paralel.setYükMiktari(Integer.parseInt(this.YükMiktarı.getText()));
            paralel.setKolUzunluğu(Integer.parseInt(this.AyakSayısı.getText()));
            paralel.setKapasite(Integer.parseInt(this.KapasiteText.getText()));
            paralel.setKonumX(Integer.parseInt(this.KonumX.getText()));
            paralel.setKonumY(Integer.parseInt(this.KonumY.getText()));

            if (paralel.getKapasite() >= paralel.getYükMiktari() &&  paralel.getTaşımaHızı() >= paralel.getMinHız()) {

                if (paralel.getKonumX() >= 20) {
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                    paralel.setKonumX(19);
                }
                else if (paralel.getKonumX() < 0) {
                    paralel.setKonumX(0);
                    System.out.println("X ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                if (paralel.getKonumY() >= 20) {
                    paralel.setKonumY(19);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                else if (paralel.getKonumY() < 0) {
                    paralel.setKonumY(0);
                    System.out.println("Y ekseninde Izgara sınırları aşılığı için köşeye sabitlendi");
                }
                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                //dikdörtgeni ızgaranın içine robotun konumuna yerleştirir
                GridPane.setColumnIndex(rectangle, paralel.getKonumX());
                GridPane.setRowIndex(rectangle, paralel.getKonumY());
                rectangle.setFill(Color.rgb(255, 234, 167));
                this.myGrid.getChildren().add(rectangle);

                yukarıKomut = Integer.parseInt(this.yukarı.getText());
                aşağıKomut = Integer.parseInt(this.aşağı.getText());
                sağaKomut = Integer.parseInt(this.sağa.getText());
                solaKomut = Integer.parseInt(this.sola.getText());

                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");
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
                lastRectangle.setFill(Color.rgb(49,210,212));
                myGrid.getChildren().add(lastRectangle);
                // burada kol uzunluğunun kontrolü yapılacak kol uzunluğu ne kadarsa o kadar uzunlukta gidicek

                int kalanKolUzunluğu = paralel.getKolUzunluğu()/10;
                int i;int gidilenYol = 0;
                if(paralel.getKonumY()-yukarıKomut < 0){
                    yukarıKomut = paralel.getKonumY();
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
                        this.sonKonumX.setText(Integer.toString((SonKonumX)));
                        this.sonKonumY.setText(Integer.toString((SonKonumY)));
                        this.toplamSüre.setText(Float.toString(gidilenYol*10/paralel.getTaşımaHızı()));
                        break;
                    }
                }
                if(kalanKolUzunluğu >0) {
                    if(paralel.getKonumX()+sağaKomut >20){
                        sağaKomut = 20-paralel.getKonumX();
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
                            this.sonKonumX.setText(Integer.toString((SonKonumX)));
                            this.sonKonumY.setText(Integer.toString((SonKonumY)));
                            this.toplamSüre.setText(Float.toString(gidilenYol*10/paralel.getTaşımaHızı()));
                            break;
                        }
                    }
                }
                if(kalanKolUzunluğu > 0) {
                    if(paralel.getKonumY()+aşağıKomut >20){
                        aşağıKomut=20-paralel.getKonumY();
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

                            this.sonKonumX.setText(Integer.toString((SonKonumX)));
                            this.sonKonumY.setText(Integer.toString(SonKonumY));
                            this.toplamSüre.setText(Float.toString(gidilenYol*10/paralel.getTaşımaHızı()));
                            break;
                        }
                    }
                }
                if(kalanKolUzunluğu > 0) {
                    if(paralel.getKonumX()-solaKomut <=0){
                        solaKomut = paralel.getKonumX();
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

                            this.sonKonumX.setText(Integer.toString((SonKonumX)));
                            this.sonKonumY.setText(Integer.toString((SonKonumY)));
                            this.toplamSüre.setText(Float.toString(gidilenYol*10/paralel.getTaşımaHızı()));
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
                this.sonKonumX.setText(Integer.toString((SonKonumX)));
                this.sonKonumY.setText(Integer.toString((SonKonumY)));
                this.toplamSüre.setText(Float.toString((gidilenYol*10)/paralel.getTaşımaHızı()));

            }
            else if (paralel.getKapasite() < paralel.getYükMiktari()) System.out.println("Yük miktarı kapasiteden daha fazla yük miktarını tekrar giriniz!");

            else System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Paralel robot için minimum hız 5 m/s dir.");
        }

        if(this.SeriButton.isSelected()) {
            System.out.println("Seri tipi robot seçildi");
            Seri seri = new Seri();

            seri.setMotorSayisi(Integer.parseInt(this.MotorSayısı.getText()));
            seri.setTaşımaHızı(Integer.parseInt(this.GezinmeHızı.getText()));
            seri.setYükMiktari(Integer.parseInt(this.YükMiktarı.getText()));
            seri.setKolUzunluğu(Integer.parseInt(this.AyakSayısı.getText()));
            seri.setKapasite(Integer.parseInt(this.KapasiteText.getText()));
            seri.setKonumX(Integer.parseInt(this.KonumX.getText()));
            seri.setKonumY(Integer.parseInt(this.KonumY.getText()));

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
                //robotu temsil eden dikdörtgeni oluşturur
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(26.0D);
                rectangle.setHeight(26.0D);

                //dikdörtgeni ızgaranın içine robotun konumuna yerleştirir
                GridPane.setColumnIndex(rectangle, seri.getKonumX());
                GridPane.setRowIndex(rectangle, seri.getKonumY());
                rectangle.setFill(Color.rgb(255, 234, 167));
                this.myGrid.getChildren().add(rectangle);
                this.DoneButton.setStyle("-fx-background-color : #fdcb6e");

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
                lastRectangle.setFill(Color.rgb(49,210,212));
                myGrid.getChildren().add(lastRectangle);
                // burada kol uzunluğunun kontrolü yapılacak kol uzunluğu ne kadarsa o kadar uzunlukta gidicek

                int kalanKolUzunluğu = seri.getKolUzunluğu()/10;
                int i;int gidilenYol = 0;


                /************************************YUKARI****************************************/
                if(seri.getKonumY()-yukarıKomut < 0){
                    yukarıKomut = seri.getKonumY();
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
                                this.sonKonumX.setText(Integer.toString(SonKonumX));
                                this.sonKonumY.setText(Integer.toString(SonKonumY));
                                this.toplamSüre.setText(Integer.toString((gidilenYol*10/seri.getTaşımaHızı())));
                                System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                        + " Yük Miktarı : " + seri.getYükMiktari() +
                                        " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ " Son Konum "
                                        + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                                break;
                            }
                }

                /*********************SAĞA************************/
                if(seri.getKonumX()+sağaKomut >20){
                    sağaKomut = 20-seri.getKonumX();
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
                                 this.sonKonumX.setText(Integer.toString(SonKonumX));
                                 this.sonKonumY.setText(Integer.toString(SonKonumY));
                                 this.toplamSüre.setText(Integer.toString((gidilenYol*10/seri.getTaşımaHızı())));
                                 System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                         + " Yük Miktarı : " + seri.getYükMiktari() +
                                         " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ "Son Konum "
                                         + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);

                                 break;
                             }
                    }
                }
                /*****************AŞAĞI*********************/
                if(kalanKolUzunluğu > 0) {
                    if(seri.getKonumY()+aşağıKomut >20){
                        aşağıKomut=20-seri.getKonumY();
                    }
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
                                 this.sonKonumX.setText(Integer.toString(SonKonumX));
                                 this.sonKonumY.setText(Integer.toString(SonKonumY));
                                 this.toplamSüre.setText(Integer.toString((gidilenYol*10/seri.getTaşımaHızı())));
                                 System.out.println("Motor Sayısı :" + seri.getMotorSayisi() + "Taşıma Hızı : " + seri.getTaşımaHızı()
                                         + " Yük Miktarı : " + seri.getYükMiktari() +
                                         " Konum :" + seri.getKonumX() + " " + seri.getKonumY()+ "Son Konum "
                                         + SonKonumX + " " + SonKonumY + " Gidilen Yol : " + gidilenYol);
                                 break;
                             }
                    }
                }
                /**********************SOLA************************/
                if(kalanKolUzunluğu > 0) {
                    if(seri.getKonumX()-solaKomut <=0){
                        solaKomut = seri.getKonumX();
                    }
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
                             this.sonKonumX.setText(Integer.toString(SonKonumX));
                             this.sonKonumY.setText(Integer.toString(SonKonumY));
                             this.toplamSüre.setText(Integer.toString((gidilenYol*10/seri.getTaşımaHızı())));
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
                this.sonKonumX.setText(Integer.toString((SonKonumX)));
                this.sonKonumY.setText(Integer.toString((SonKonumY)));
                this.toplamSüre.setText(Float.toString(gidilenYol*10/seri.getTaşımaHızı()));
            } else if (seri.getKapasite() < seri.getYükMiktari()) System.out.println("Yük miktarı kapasiteden daha fazla yük miktarını tekrar giriniz!");

            else System.out.println("Minimum hız sınırından daha küçük değer girilemez.[Seri robot için minimum hız 3 m/s dir.");
        }
    }

    @FXML
    void anaMenüAç(ActionEvent event) throws IOException {
        Parent FirstProbParent = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        Scene FirstProbScene = new Scene(FirstProbParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FirstProbScene);
        window.show();
    }

    //Radio butonlarının kontrolünü yapan fonksiyon
    @FXML
    void Initialize (ActionEvent event)
    {
            if (this.ParalelButton.isSelected()) {
                this.SeriButton.setSelected(false);
            } else if (this.SeriButton.isSelected()) {
                this.ParalelButton.setSelected(false);
            }
        }

        @FXML
        void initialize () {
            assert AnaMenüButton != null : "fx:id=\"AnaMenüButton\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert myGrid != null : "fx:id=\"myGrid\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert simulateButton != null : "fx:id=\"simulateButton\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert sizeText != null : "fx:id=\"sizeText\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert KonumX != null : "fx:id=\"KonumX\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert KonumY != null : "fx:id=\"KonumY\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert yukarı != null : "fx:id=\"yukarı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert aşağı != null : "fx:id=\"aşağı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert sağa != null : "fx:id=\"sağa\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert sola != null : "fx:id=\"sola\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert sonKonumX != null : "fx:id=\"sonKonumX\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert sonKonumY != null : "fx:id=\"sonKonumY\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert toplamSüre != null : "fx:id=\"toplamSüre\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert ParalelButton != null : "fx:id=\"ParalelButton\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert SeriButton != null : "fx:id=\"SeriButton\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert MotorSayısı != null : "fx:id=\"MotorSayısı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert YükMiktarı != null : "fx:id=\"YükMiktarı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert AyakSayısı != null : "fx:id=\"AyakSayısı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert GezinmeHızı != null : "fx:id=\"GezinmeHızı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert BacakSayısı != null : "fx:id=\"BacakSayısı\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert onay != null : "fx:id=\"onay\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert KapasiteText != null : "fx:id=\"KapasiteText\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";
            assert DoneButton != null : "fx:id=\"DoneButton\" was not injected: check your FXML file 'SecondProbInterface.fxml'.";

        }
}


