package P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces;

import P07ReflectionAndAnnotationsExercises.P03BarracksWars.core.commands.Command;

import java.lang.reflect.InvocationTargetException;

public interface CommandFactory {
    Command createCommand(String commandName, String[] data) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException;
}
