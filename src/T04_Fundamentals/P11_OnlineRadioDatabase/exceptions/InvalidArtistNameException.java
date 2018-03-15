package T04_Fundamentals.P11_OnlineRadioDatabase.exceptions;

public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException() {
        super("Artist name should be between 3 and 20 symbols.");
    }

    protected InvalidArtistNameException(String message) {
        super(message);
    }
}
