package T03_OOPOverview.P03_LastDigitName;

public class Number {

    private int digit;

    public Number(int digit) {
        this.digit = digit;
    }

    public Number() {
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public String getLastDigitName() {
        String[] names = new String[]{
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        return names[this.digit];
    }
}
