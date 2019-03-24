package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private Button ProbOne;

    @FXML
    private Button ProbTwo;

    @FXML
    private Button ProbThree;

    @FXML
    void OPOne(ActionEvent event) throws  IOException {
        if(event.getSource().equals(ProbOne))
        {
            Parent FirstProbParent = FXMLLoader.load(Main.class.getResource("FirstProbGrid/FirstProblemGrid.fxml"));
            Scene FirstProbScene = new Scene(FirstProbParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FirstProbScene);
            window.show();
        }
    }
    @FXML
    void OPTwo(ActionEvent event) throws IOException {
        if(event.getSource().equals(ProbTwo))
        {
            Parent FirstProbParent = FXMLLoader.load(Main.class.getResource("SecondProbGrid/SecondProbInterface.fxml"));
            Scene FirstProbScene = new Scene(FirstProbParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FirstProbScene);
            window.show();
        }
    }
    @FXML
    void OPThree(ActionEvent event) throws IOException {
        if(event.getSource().equals(ProbThree))
        {
            Parent FirstProbParent = FXMLLoader.load(Main.class.getResource("ThirdProbGrid/ThirdProbGrid.fxml"));
            Scene FirstProbScene = new Scene(FirstProbParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FirstProbScene);
            window.show();
        }
    }
    @FXML
    void initialize() {
        assert MainPane != null : "fx:id=\"MainPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert ProbTwo != null : "fx:id=\"ProbTwo\" was not injected: check your FXML file 'sample.fxml'.";
        assert ProbThree != null : "fx:id=\"ProbThree\" was not injected: check your FXML file 'sample.fxml'.";
        assert ProbOne != null : "fx:id=\"ProbOne\" was not injected: check your FXML file 'sample.fxml'.";
    }
}





