package T03_OOPOverview.P10_BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            try {
                int[] beers = Arrays.stream(input.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int beersBought = beers[0];
                int beersDrank = beers[1];
                BeerCounter.buyBeer(beersBought);
                BeerCounter.drinkBeer(beersDrank);
            } catch (NullPointerException npe) {
                break;
            }
        }
        System.out.println(BeerCounter.getBeerInStock() + " " + BeerCounter.getBeersDrankCount());
    }
}
