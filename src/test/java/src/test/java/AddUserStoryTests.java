package src.test.java;
import src.main.java.org.classes.AddUserStory;

public class AddUserStoryTests {
    public AddUserStoryTests() {
        testAddUserStory();
    }

    void testAddUserStory() {
        try {

            AddUserStory nw = new AddUserStory();
            nw.setVisible(true);
            if(nw.isVisible()== true) {
                System.out.println("AddUserStoryTests passed");
//				Thread.sleep(1000);
            }
//			nw.setVisible(false);

        } catch(Exception e) {
            System.out.println("Error:"+ e);
        }
    }

    public static void main(String[] args) {

        AddUserStoryTests addUserStoryTests = new AddUserStoryTests();


    }

}

