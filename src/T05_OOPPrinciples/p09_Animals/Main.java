package T05_OOPPrinciples.p09_Animals;

import T05_OOPPrinciples.p09_Animals.interfaces.AnimalInterface;
import T05_OOPPrinciples.p09_Animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String PATH = "T05_OOPPrinciples.p09_Animals.models.";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<AnimalInterface> animals = new ArrayList<>();
        String animalType;
        while (!"Beast!".equalsIgnoreCase(animalType = reader.readLine().trim())) {
            try {
                animals.add(createAnimalWithReflection(animalType));
//                createAnimalWithSwitchCase(animals, animalType);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        animals.forEach(a -> System.out.printf(
                "%s\n%s %d %s\n%s\n",
                a.getClass().getSimpleName(),
                a.getName(),
                a.getAge(),
                a.getGender(),
                a.produceSound()));
    }

    private static AnimalInterface createAnimalWithReflection(String animalType) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String animalParams[] = reader.readLine().trim().split("\\s+");
        String name = animalParams[0];
        int age = Integer.parseInt(animalParams[1]);

        // input for Kitten and Tomcat doesn't provide gender
        String gender = animalParams.length < 3 ? "" : animalParams[2];

        String className = PATH + animalType;
        Class<?> animalClass = Class.forName(className);
        Constructor<?> animalConstructor = animalClass.getDeclaredConstructors()[0];
        animalConstructor.setAccessible(true);
        return (AnimalInterface) animalConstructor.newInstance(name, age, gender);
    }

    private static void createAnimalWithSwitchCase(List<AnimalInterface> animals, String type) throws IOException {
        String[] params = reader.readLine().split("\\s+");
        String name = params[0];
        int age = Integer.parseInt(params[1]);
        switch (type) {
            case "Animal":
                animals.add(new Animal(
                        name, age, params[2]
                ));
                break;
            case "Cat":
                animals.add(new Cat(
                        name, age, params[2]
                ));
                break;
            case "Dog":
                animals.add(new Dog(
                        name, age, params[2]
                ));
                break;
            case "Frog":
                animals.add(new Frog(
                        name, age, params[2]
                ));
                break;
            case "Kitten":
                animals.add(new Kitten(
                        name, age, "Female"
                ));
                break;
            case "Tomcat":
                animals.add(new Tomcat(
                        name, age, "Male"
                ));
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
}
