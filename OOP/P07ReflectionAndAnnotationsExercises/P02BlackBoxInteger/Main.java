package P07ReflectionAndAnnotationsExercises.P02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Map<String, Method> NAME_METHOD_MAP =
            Arrays.stream(BlackBoxInt.class.getDeclaredMethods()) // взима всички декларирани полета в класа BlackBoxInt
                    .peek(method -> method.setAccessible(true)) // минава (пийква) през всеки метод и го прави достъпно (защото са private)
                    .collect(Collectors.toMap(Method::getName, method -> method)); // пълним мапа с името на метода и самия метод

    private static final String END_COMMAND = "END";

    private static final String RESULT = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchFieldException {

        Constructor<BlackBoxInt> blackBoxIntConstructor =
                BlackBoxInt.class.getDeclaredConstructor(int.class); // взимаме контструктура на BlackBoxInt, който в себе си приема int клас
        blackBoxIntConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = blackBoxIntConstructor.newInstance(0); // взимаме нова инстанция от blackBoxIntConstructor

        String input;

        while (!END_COMMAND.equals(input = SCANNER.nextLine())) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method currentMethod = NAME_METHOD_MAP.get(methodName);
            currentMethod.invoke(blackBoxInt, value); // извикваме и използваме метода (обекта който изпълнява функцията, value-то)

            Field result = blackBoxInt.getClass().getDeclaredField(RESULT);
            result.setAccessible(true);
            System.out.println(result.get(blackBoxInt));
        }

        SCANNER.close();
    }
}
