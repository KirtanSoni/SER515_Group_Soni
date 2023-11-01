import org.classes.AddUserStory;
import java.awt.EventQueue;

public class AddUserStoryTests {
    public AddUserStoryTests() {
        testAddUserStory();
    }

    void testAddUserStory() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    AddUserStory nw = new AddUserStory();
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
