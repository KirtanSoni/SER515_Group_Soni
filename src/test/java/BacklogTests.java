package src.test.java;

import src.main.java.org.classes.ProductBacklog;

import java.awt.EventQueue;

public class BacklogTests implements ITest {
    public BacklogTests() {
        test();
    }

    @Override
    public void test() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductBacklog productBacklog = new ProductBacklog();

                    System.out.println("Backlog tests successfully passed!");
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
        });
    }
}
