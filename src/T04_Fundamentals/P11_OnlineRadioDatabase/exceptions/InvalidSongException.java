package T04_Fundamentals.P11_OnlineRadioDatabase.exceptions;

public class InvalidSongException extends Exception {

    public InvalidSongException() {
        super("Invalid song.");
    }
    protected InvalidSongException(String message) {
        super(message);
    }
}