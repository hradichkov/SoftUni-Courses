package P07ReflectionAndAnnotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Field[] declaredFields = clazz.getDeclaredFields();

        TreeSet<Field> fields = collectByName(Arrays.stream(declaredFields));

        TreeSet<Method> getters = filterMembersBy(methods, "get");

        TreeSet<Method> setters = filterMembersBy(methods, "set");
    }

    public static <T extends Member> TreeSet<T> filterMembersBy(T[] members, String filter) {
        return Arrays.stream(members)
                .filter(m -> m.getName().contains(filter))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Member::getName))));
    }

    public static <T extends Member> TreeSet<T> collectByName(Stream<T> stream) {
        return stream.collect(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(Member::getName))));
    }
}
