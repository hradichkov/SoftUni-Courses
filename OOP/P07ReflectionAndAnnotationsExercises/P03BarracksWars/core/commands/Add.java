package P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.commands;

import P07ReflectionAndAnnotationsExercises.P03BarracksWars.annotations.Inject;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.Repository;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.Unit;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException,
            ExecutionControl.NotImplementedException {

        final String unitType = getData()[1];

        final Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
