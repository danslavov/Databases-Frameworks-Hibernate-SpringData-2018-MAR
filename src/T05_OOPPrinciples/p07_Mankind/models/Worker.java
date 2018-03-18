package T05_OOPPrinciples.p07_Mankind.models;

public class Worker extends Human {

    private double weekSalary;
    private double hoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    public double calculateSalaryPerHour() {
        return this.weekSalary / (7 * this.hoursPerDay);
    }

    public double getWeekSalary() {
        return this.weekSalary;
    }

    public double getHoursPerDay() {
        return this.hoursPerDay;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException(
                    "Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setHoursPerDay(double hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12) {
            throw new IllegalArgumentException(
                    "Expected value mismatch!Argument: workHoursPerDay");
        }
        this.hoursPerDay = hoursPerDay;
    }
}
