package T04_Fundamentals.P11_OnlineRadioDatabase;

import T04_Fundamentals.P11_OnlineRadioDatabase.exceptions.*;

public class Song {

    private static int totalSeconds;

    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, int minutes, int seconds) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        addDuration(minutes, seconds);
    }

    public String getArtistName() {
        return this.artistName;
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {

        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {

        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    public int getMinutes() {
        return this.minutes;
    }

    private void setMinutes(int minutes) throws InvalidSongMinutesException {

        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException();
        }

        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(int seconds) throws InvalidSongSecondsException {

        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException();
        }

        this.seconds = seconds;
    }

    private void addDuration(int minutes, int seconds) {
        totalSeconds += (minutes * 60 + seconds);
    }

    public static void printPlaylistLength() {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = (totalSeconds % 3600) % 60;
        System.out.printf("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}
