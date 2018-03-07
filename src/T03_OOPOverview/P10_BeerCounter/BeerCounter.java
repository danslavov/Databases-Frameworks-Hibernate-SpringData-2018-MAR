package T03_OOPOverview.P10_BeerCounter;

public class BeerCounter {

    private static int beerInStock = 0;
    private static int beersDrankCount = 0;

    public static void buyBeer(int bottlesCount) {
        BeerCounter.beerInStock += bottlesCount;
    }

    public static void drinkBeer(int bottlesCount) {
        BeerCounter.beersDrankCount += bottlesCount;
        BeerCounter.beerInStock -= bottlesCount;
    }

    public static int getBeerInStock() {
        return BeerCounter.beerInStock;
    }

    public static int getBeersDrankCount() {
        return BeerCounter.beersDrankCount;
    }
}
