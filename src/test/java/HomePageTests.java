package org.classes;

public class HomePageTests {
    public HomePageTests() {
        testHomePage();
    }

    void testHomePage() {
        try {

            HomePage nw = new HomePage();
            nw.setVisible(true);
            if(nw.isVisible()== true) {
                System.out.println("HomePageTests passed!");
                Thread.sleep(1000);
            }
            nw.setVisible(false);

        } catch(Exception e) {
            System.out.println("Error:"+ e);
        }
    }

    public static void main(String[] args) {

        HomePageTests homePageTests = new HomePageTests();




    }
}
