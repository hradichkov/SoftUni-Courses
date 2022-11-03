package OldExams.P03Workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream()
                .max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElseThrow(null);
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public String getStatistics() {
        return String.format("Workout type: %s%n", this.type) +
                exercises.stream()
                        .map(e -> String.format("%s", e.toString()))
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim();
    }
}
