package T03_OOPOverview.P07_AverageGrades;

import java.util.List;
import java.util.OptionalDouble;

public class Student {

    private String name;
    private List<Double> grades;

    public Student(String name, List<Double> grades) {
        this.setName(name);
        this.setGrades(grades);
    }

    public final double getAverageGrade() {
        OptionalDouble average = this.grades.stream()
                .mapToDouble(grade -> grade).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        // checks - not needed
        this.name = name;
    }

    private void setGrades(List<Double> grades) {
        //checks - not needed
        this.grades = grades;
    }
}
