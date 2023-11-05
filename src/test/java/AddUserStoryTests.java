package src.test.java;
import src.main.java.org.classes.AddUserStory;
import src.main.java.org.classes.HomePage;
import src.main.java.org.classes.ProductBacklog;

import java.awt.EventQueue;
public class AddUserStoryTests implements ITest{
    public AddUserStoryTests() {
        test();
    }

    @Override
    public void test() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    AddUserStory nw = new AddUserStory(new ProductBacklog());
                    nw.setVisible(true);
                    if (nw.isVisible() == true) {
                        System.out.println("AddUserStoryTests passed!");
//                  Thread.sleep(1000);
                    }
//              nw.setVisible(false);

                } catch (Exception e) {
                    System.out.println("Error:" + e);
                }
            }
        });
    }

     public static void main(String[] args) {

         AddUserStoryTests addUserStoryTests = new AddUserStoryTests();




     }
}