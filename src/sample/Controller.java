package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    private static String mas;

    public TextArea Masiv1Lab1;
    public TextArea Masiv2Lab1;
    public TextArea VuvidLab1;
    public MenuItem Action;
    public TextField lableId1;
    public TextArea lableid2;
    public TextArea lableid3;
    public TextArea matrix3;
    public TextField finish3;
    public TextField start3;
    public TextField vidpovid3;
    public TextField vidpovidvid2do3;

    @FXML
    private Button CountButton;
    @FXML
    private Button Teoria1;
    @FXML
    private TextField text41;
    @FXML
    private Button Teoria2;

    Lab1 l = new Lab1();
    Lab2 l2 = new Lab2();
    lab3 l3 = new lab3();


    public void CountButton(ActionEvent actionEvent) {
        String a = l.lab1(Masiv1Lab1.getText(), Masiv2Lab1.getText());
        VuvidLab1.setText(a);

    }

    public void Teoria1(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TeoriaLab1.fxml"));
        stage.setTitle("Теорія");
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }


    public void Teoria2(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("TeoriaLab2.fxml"));
            stage.setTitle("Теорія");
            stage.setMinWidth(500);
            stage.setMinHeight(500);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
            System.out.println(Action.getText());
        } catch (RuntimeException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void butoonLab2(ActionEvent actionEvent) {
        try {
            lableid3.setText(l2.lab2(Integer.parseInt(lableId1.getText()), lableid2.getText()));

        }catch (RuntimeException e){

        }
    }

    public void teoria3(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("TeoriaLab3.fxml"));
            stage.setTitle("Теорія");
            stage.setMinWidth(500);
            stage.setMinHeight(500);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
            System.out.println(Action.getText());
        } catch (RuntimeException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void search(ActionEvent actionEvent) {
        try {


            if (start3.getLength() >= 0 || finish3.getLength() >= 0 || matrix3.getLength() >= 0) {
                int start = Integer.parseInt(start3.getText());
                int finish = Integer.parseInt(finish3.getText());

                try {
                    vidpovidvid2do3.setText(l2.lab2Forlab3(9,matrix3.getText()));
                    vidpovid3.setText(l3.Labolatorna3(10, matrix3.getText(), start, finish));
                } catch (Exception e) {
                    if (start <= 0 || start > 11 || finish <= 0 || finish > 11 || matrix3.getLength() <= 0) {
                        vidpovid3.setText("Некорекний ввід даний");
                    }
                }
            }
        } catch (Exception e) {
            vidpovid3.setText("Некорекний ввід даний");
        }
    }
}