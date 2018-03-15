package T04_Fundamentals.P11_OnlineRadioDatabase;

import T04_Fundamentals.P11_OnlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Song> radio = new HashSet<>();

            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                try {
                    String[] input = reader.readLine().split(";");
                    String[] duration = input[2].split(":");
                    String artistName = input[0];
                    String songName = input[1];
                    int minutes = Integer.parseInt(duration[0]);
                    int seconds = Integer.parseInt(duration[1]);
                    radio.add(new Song(artistName, songName, minutes, seconds));
                    System.out.println("Song added.");
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException | InvalidSongException e) {
                     System.out.println(e.getMessage());
                }
            }

        System.out.println("Songs added: " + radio.size());
        Song.printPlaylistLength();
    }
}
