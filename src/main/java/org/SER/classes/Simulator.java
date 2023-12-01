package org.SER.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {
    int SprintVelocity;
    int players;
    int sprintLength;

    public Simulator(int sprintVelocity,int players,int sprintLength) {
        this.sprintLength = sprintLength;
        this.players = players;
        this.SprintVelocity = sprintVelocity;
    }
    public SprintBacklog simProductToSprint(ProductBacklog pb){
        SprintBacklog sb = new SprintBacklog();
        sb.setBacklogVelocity(this.SprintVelocity);
        int curr_velocity = 0;
        while(curr_velocity < this.SprintVelocity && !pb.getUserStories().isEmpty()){
            for(int i = 0 ; i < pb.getUserStories().size();i++) {
                if (pb.getUserStories().get(i).getDeveloperValue() <= (this.SprintVelocity - curr_velocity)) {
                    sb.addUserStory(pb.getUserStories().get(i));
                    curr_velocity += pb.getUserStories().get(i).getDeveloperValue();
                    pb.getUserStories().remove(i);
                }
            }
        }
        return sb;
    }
    public void makeProgress(SprintBacklog sb){
        for(int i =0 ; i< sprintLength;i++){

            for(int j = 0 ; j < players;j++){
                int rand = new Random().nextInt(3);
                if(rand == 0)
                    sb.getUserStoriesbyStatus(Status.TODO).get(0).setStatus(Status.DONE);
            }
        }
    }
}