package org.SER.classes;

import java.awt.*;
import java.util.List;

public class ScrumGame {
    ProductBacklog productbacklog;
    List<SprintBacklog> Sprints;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
