package beans;


import exceptions.dataException.DataFieldException;
import exceptions.dataException.TyperEnumerations.FieldsEnum;
import exceptions.dataException.TyperEnumerations.ProblemEnum;
import model.ExerciseStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExerciseForWorkoutRoutineBean extends ExerciseBean{
    private final String day;
    private int repetitions;
    private int sets;
    private String rest;

    public ExerciseForWorkoutRoutineBean(String name, ExerciseStatus statusExercise, String day, int repetitions, int sets, String rest) {
        super(name, statusExercise);
        this.day = day;
        this.rest = rest;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public ExerciseForWorkoutRoutineBean(String name, ExerciseStatus statusExercise, String day) {
        super(name, statusExercise);
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public int getRepetitions() {return repetitions;}

    public int getSets() {return sets;}

    public String getRest() {return rest;}

    public void setRest(String timeString) throws DataFieldException{
        if(isValidTime(timeString)) {
            this.rest = timeString;
        } else if (!timeString.equals("00:00")){
            throw new DataFieldException(FieldsEnum.ExerciseRest, ProblemEnum.IsNull);
        }else {
            throw new DataFieldException(FieldsEnum.ExerciseRest, ProblemEnum.NotValid);
        }
    }

    public void setRepetitions(int reps) throws DataFieldException {
        if(reps>0){
            this.repetitions = reps;
        } else if (reps == 0){
            throw new DataFieldException(FieldsEnum.ExerciseReps, ProblemEnum.IsNull);
        } else {
            throw new DataFieldException(FieldsEnum.ExerciseReps, ProblemEnum.NotValid);
        }
    }
    public void setSets(int sets) throws DataFieldException{
        if(sets>0){
            this.sets = sets;
        } else if (sets == 0){
            throw new DataFieldException(FieldsEnum.ExerciseSets, ProblemEnum.IsNull);
        } else {
            throw new DataFieldException(FieldsEnum.ExerciseSets, ProblemEnum.NotValid);
        }
    }

    public static boolean isValidTime(String timeString) {
        if (timeString == null) {
            return false;  // or handle the null case differently
        }

        String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(timeString);
        return matcher.matches();
    }
}
