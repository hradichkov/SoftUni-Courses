package P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.commands;

import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.Executable;

public abstract class Command implements Executable {

    private final String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }

}

