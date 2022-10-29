package P07ReflectionAndAnnotationsExercises.P03BarracksWars;

import P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.CommandInterpreterImpl;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.Engine;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.factories.UnitFactoryImpl;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.data.UnitRepository;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.Repository;
import P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {

        final Repository repository = new UnitRepository();

        final UnitFactory unitFactory = new UnitFactoryImpl();

        final CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        final Engine engine = new Engine(commandInterpreter);

        engine.run();
    }
}
