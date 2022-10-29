package P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.commands;

import P07ReflectionAndAnnotationsExercises.P03BarracksWars.annotations.Inject;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(this.getData()[1]);
        } catch (Exception e) {
            return e.getMessage();
        }
        return this.getData()[1] + " retired!";
    }
}
