package T03_OOPOverview.P06_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    public Person() {
    }

    public void buy(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(
                    String.format("%s can't afford %s",
                            this.name, product.getName()));
        }
        this.bag.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s%n", this.name, product.getName());
    }

    public void printResult() {

        String boughtProducts = this.bag.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        System.out.printf("%s - %s",
                this.name,
                boughtProducts.length() != 0 ?
                boughtProducts : "Nothing bought");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return this.bag;
    }
}
