package week7.assigment_problems;

import java.util.Arrays;

/**
 * Problem 2 - The Playlist
 *
 * Songs live in a private array and getSongs() hands back a brand new
 * array with the same contents. Modifying the returned array therefore
 * cannot touch what the playlist really holds.
 */
public class Playlist {

    private final String[] songs;
    private int count;

    public Playlist(int maxSongs) {
        this.songs = new String[maxSongs];
    }

    public void addSong(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Rejected: a song needs a title");
            return;
        }
        if (count >= songs.length) {
            System.out.println("Playlist is full: " + title + " not added");
            return;
        }
        songs[count++] = title;
    }

    /** Returns a COPY, never the original array. */
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("getSongs()        -> " + Arrays.toString(p.getSongs()));

        String[] copy = p.getSongs();
        copy[0] = "Hacked";                      // modifying the returned copy...

        System.out.println("copy after edit   -> " + Arrays.toString(copy));
        System.out.println("playlist          -> " + Arrays.toString(p.getSongs()) + "  (unchanged)");
        System.out.println("getSongCount()    -> " + p.getSongCount());
    }
}
