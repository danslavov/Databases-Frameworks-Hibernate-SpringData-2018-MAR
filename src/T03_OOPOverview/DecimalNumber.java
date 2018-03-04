package T03_OOPOverview;

public class DecimalNumber {
    private String numAsString;

    public DecimalNumber(String s) {
        this.numAsString = s;
    }

    public void printReversed() {
        for (int i = this.numAsString.length() - 1; i >= 0; i--) {
            System.out.print(this.numAsString.charAt(i));
        }
        System.out.println();
    }
}
