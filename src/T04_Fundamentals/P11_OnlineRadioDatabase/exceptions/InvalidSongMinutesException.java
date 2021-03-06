package T04_Fundamentals.P11_OnlineRadioDatabase.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    public InvalidSongMinutesException() {
        super("Song minutes should be between 0 and 14.");
    }
}
