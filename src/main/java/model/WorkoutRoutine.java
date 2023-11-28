package model;

import beans.WorkoutDayBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkoutRoutine {

    private int numberDays;
    private String name;
    private LocalDateTime activateDate;

        private int id;
    private List<WorkoutDay> workoutDayList;

    public WorkoutRoutine(String name, int numberDays){
        this();
        this.name = name;
        this.numberDays = numberDays;
    }
    public WorkoutRoutine(){
        this.name = "No Name";
        this.workoutDayList = new ArrayList<>();
        this.numberDays = 0;
        this.activateDate = LocalDateTime.now();
    }

    public List<WorkoutDay> getWorkoutDayList() {
        return workoutDayList;
    }

    public LocalDateTime getActivateDate() {
        return activateDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void addAllWorkoutDays(List<WorkoutDay> workoutDayList) {
        this.workoutDayList = new ArrayList<>();
        for (WorkoutDay workoutDay : workoutDayList) {
            WorkoutDay newWorkoutDay = new WorkoutDay(workoutDay.getDay());
            newWorkoutDay.addAllExercise(workoutDay.getExerciseList());
            addWorkoutDay(newWorkoutDay);
        }
    }

    public void addWorkoutDay(WorkoutDay workoutDay) {
        workoutDayList.add(workoutDay);
    }

    public void removeWorkoutDay(WorkoutDay workoutDay) {
        workoutDayList.remove(workoutDay);
    }

}
