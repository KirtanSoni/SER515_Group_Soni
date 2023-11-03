package src.test.java;


public class Main {
    public static void main(String[] args) {

        // to run tests, make sure Assertion is enabled in your IDE or run with -ea flag.
        UserStoryTests userStoryTests = new UserStoryTests();
        ProductBacklogTests productBacklogTests = new ProductBacklogTests();
        //HomePageTests homePageTests = new HomePageTests();
        SprintBacklogTests sprintBacklogTests = new SprintBacklogTests();
        HelperTest helpersTest = new HelperTest();
        DBTest.main(args);
        AddUserStoryTests addUserStoryTests = new AddUserStoryTests();


    }

}