package org.SER.classes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {
    ProductBacklog pb ;
    int SprintVelocity;
    int players;
    int sprintLength;
    List<List<Integer>> chart = new ArrayList<List<Integer>>();

    List<List<Integer>> getChart(){
        return this.chart;
    }
    void setPb(ProductBacklog pb){
        this.pb = pb;
    }
    public Simulator(int sprintVelocity,int players,int sprintLength) {
        this.sprintLength = sprintLength;
        this.players = players;
        this.SprintVelocity = sprintVelocity;
    }
    public SprintBacklog simProductToSprint(){
        SprintBacklog sb = new SprintBacklog();
        sb.setBacklogVelocity(this.SprintVelocity);
        int curr_velocity = 0;
        while(curr_velocity < this.SprintVelocity && !pb.getUserStories().isEmpty()){
            boolean flag = false;
            for(int i = 0 ; i < pb.getUserStories().size();i++) {
                if (pb.getUserStories().get(i).getDeveloperValue() <= (this.SprintVelocity - curr_velocity)) {
                    sb.addUserStory(pb.getUserStories().get(i));
                    curr_velocity += pb.getUserStories().get(i).getDeveloperValue();
                    List<UserStory> us = pb.getUserStories();
                    us.remove(i);
                    pb.setUserStories(us);
                    flag = true;
                    System.out.println(pb.getUserStories().size());
                }

            }
            if(!flag){
                break;
            }


        }
        return sb;
    }

    public void makeProgress(SprintBacklog sb){
        chart.add(new ArrayList<>());
        for(int i =0 ; i< sprintLength;i++){

            for(int j = 0 ; j < players;j++){
                int rand = new Random().nextInt(10);
                if(sb.getUserStoriesbyStatus(Status.TODO).size()!=0){

                    if(rand == 0){
                        sb.getUserStoriesbyStatus(Status.TODO).get(0).setStatus(Status.DONE); System.out.println("US Completed");}
                }
                else{

                    return;
                }
            }
            chart.get(chart.size()-1).add(sb.getProgress());
        }
        //return to pb
    }
    public void run() {
        while (pb.getUserStories().size()>0) {
            System.out.println("Product Backlog Size: "+pb.getUserStories().size());
            SprintBacklog sb = simProductToSprint();
            System.out.printf("Sprint Backlog Created: %d\n",sb.getsprintBacklog().size());
            makeProgress(sb);
            System.out.printf("Sprint Completed: %d\n",sb.getProgress());
           // sb.transferUnusedUserStories(pb);
            System.out.println("Unused User Stories transferring");
            System.out.println(pb.getUserStories().size());
        }
        System.out.println("Simulation Completed: "+ chart.toString());
        for (int i = 0; i < chart.size() ; i++) {
            int [] workDone = new int[chart.get(i).size()];
            for (int j = 0; j < chart.get(i).size(); j++) {
                workDone[j] = chart.get(i).get(j);
            }
            int finalI = i;
            SwingUtilities.invokeLater(() -> {
                BurndownChart burndownChart = new BurndownChart("Burndown Chart "+ Integer.toString(finalI) , workDone);
                burndownChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Change this line
                burndownChart.pack();
                burndownChart.setLocationRelativeTo(null);
                burndownChart.setVisible(true);
            });

        }
    }
}