package src.test.java;

import src.main.java.org.classes.HomePage;
import java.awt.EventQueue;
public class HomePageTests implements ITest{
    public HomePageTests() {
        test();
    }

    @Override
    public void test() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    HomePage nw = new HomePage();
                    nw.setVisible(true);
                    if (nw.isVisible() == true) {
                        System.out.println("HomePageTests passed!");
//                  Thread.sleep(1000);
                    }
//              nw.setVisible(false);

                } catch (Exception e) {
                    System.out.println("Error:" + e);
                }
            }
        });
    }

    // public static void main(String[] args) {

    //     HomePageTests homePageTests = new HomePageTests();




    // }
}
