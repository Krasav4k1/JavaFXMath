package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lab1 {



    static String AAA;
    public String lab1(String aa, String bb) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        Set<String> n = new HashSet<>();


        String f = aa;
        String r = bb;
        String[] h = f.split(" ");
        String[] j = r.split(" ");
        for (int d = 0; d < h.length; d++) {
            a.add(h[d]);
        }

        for (int d = 0; d < j.length; d++) {
            b.add(j[d]);
        }

        for (int d = 0; d < a.size(); d++) {
            for (int g = 0; g < b.size(); g++) {
                if (a.get(d).equals(b.get(g))) {
                    n.add(a.get(d));
                }
            }
        }

        AAA = String.join(" ",n);

                return AAA;
    }


}
