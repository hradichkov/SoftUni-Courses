package P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.commands;

import P07ReflectionAndAnnotationsExercises.P03BarracksWars.annotations.Inject;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.Repository;

public class Report extends Command {

    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
