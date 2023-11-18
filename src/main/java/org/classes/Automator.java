package src.main.java.org.classes;

import java.util.ArrayList;
import java.util.List;

public class Automator {
    public static void sortProductBacklog(ProductBacklog productBacklog) {
        List<Integer> priorityList = new ArrayList<>();
        for(UserStory userStory : productBacklog.getUserStories()) {
            priorityList.add(getPriority(userStory));
        }
        for(int i = 0; i < priorityList.size(); i++) {
            for(int j = i+1; j < priorityList.size(); j++) {
                if(priorityList.get(i) > priorityList.get(j)) {
                    int temp = priorityList.get(i);
                    priorityList.set(i, priorityList.get(j));
                    priorityList.set(j, temp);
                    UserStory tempUserStory = productBacklog.getUserStories().get(i);
                    productBacklog.getUserStories().set(i, productBacklog.getUserStories().get(j));
                    productBacklog.getUserStories().set(j, tempUserStory);
                }
            }
        }
    }
    public static int getPriority(UserStory userStory) {
        if (userStory == null)
            return Integer.MIN_VALUE;
        if( userStory.getDeveloperValue() == 0)
            return Integer.MAX_VALUE;
        return userStory.getBusinessValue() * 5/userStory.getDeveloperValue();
    }
}
