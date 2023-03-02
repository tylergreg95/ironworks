package gregory.tyler.ironworks.exercise;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    public void addNewExercise(Exercise exercise) {
        Optional<Exercise> exercise1Optional = exerciseRepository.findExerciseByName(exercise.getName());
        if(exercise1Optional.isPresent()) {
            throw new IllegalStateException("Exercise name already exists");
        }
        exerciseRepository.save(exercise);
    }
}
