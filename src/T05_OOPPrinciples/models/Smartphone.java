package T05_OOPPrinciples.models;

import T05_OOPPrinciples.interfaces.Browseable;
import T05_OOPPrinciples.interfaces.Callable;

import java.util.List;

public class Smartphone implements Callable, Browseable {

    private List<String> phones;
    private List<String> sites;

    public Smartphone(List<String> phones, List<String> sites) {
        this.phones = phones;
        this.sites = sites;
    }

    @Override
    public void call() {
        for (String phone : phones) {
            if (phone.matches("\\d+")) {
                System.out.println("Calling... " + phone);
            } else {
                System.out.println("Invalid number!");
            }
        }
    }

    @Override
    public void browse() {
        for (String site : sites) {
            if (site.matches(".*\\d+.*")) {
                System.out.println("Invalid URL!");
            } else {
                System.out.println("Browsing: " + site + "!");
            }
        }
    }
}
