package P07ReflectionAndAnnotationsExercises.P03BarracksWars.interfaces;

public interface CommandInterpreter {

	@SuppressWarnings("unchecked")
	Executable interpretCommand(String[] data);

	Executable interpretCommand(String[] data, String commandName);
}
