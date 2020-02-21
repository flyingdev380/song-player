
/**
 * A simulated music library contains several albums and having no. of songs.
 * Provides methods for loading albums, loading songs and play songs.
 * 
 */

import java.util.Scanner;

public class MusicLibrary {

	private Album albumList[]; // list of albums

	/**
	 * Construct music library and load albums and songs. Play loaded songs.
	 */
	public MusicLibrary() {
		albumList = new Album[5];
		loadAlbums();
		loadSongs();
		playSongs();
	}

	/**
	 * Adds new album to list
	 * 
	 * @param albumName
	 *            name of album
	 * @param noOfSongs
	 *            total songs in album
	 */
	public void addAlbum(String albumName, int noOfSongs) {
		// make new album object
		Album a = new Album(albumName, noOfSongs);

		// find empty index
		if (albumList.length > 0) {
			int i = 0;
			while (i < albumList.length) {
				// check for null
				if (albumList[i] == null) {
					albumList[i] = a; // add album object to index
					i = albumList.length + 1;
				}
				i = i + 1; // iterate loop
			}
		}
	}

	/**
	 * Search album by title
	 * 
	 * @param title
	 *            name of album
	 * @return object of the Album
	 */
	public Album getAlbumByTitle(String title) {
		Album album = null;
		// iterate and find matching album
		int i = 0;
		while (i < albumList.length && album == null) {
			// check for null
			if (albumList[i].getAlbumName().contains(title)) {
				album = albumList[i];
			}
			i = i + 1; // iterate loop
		}
		return album;
	}

	/**
	 * Load albums to music library
	 */
	public void loadAlbums() {
		addAlbum("A", 5);
		addAlbum("B", 4);
	}

	/**
	 * Load songs to albums
	 */
	public void loadSongs() {
		albumList[0].addSong("song1", "F:\\music\\song1.mp3");
		albumList[0].addSong("song2", "F:\\music\\song2.mp3");
		albumList[1].addSong("song3", "F:\\music\\song3.mp3");

	}

	/**
	 * Play song by given title
	 */
	public void playSongs() {
		String title = "";
		Song song = null;

		System.out.println("----------------------------------------");
		System.out.println("------------- MUSIC LIBRARY ------------");
		System.out.println("----------------------------------------");

		// get song name from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter song title to play : ");
		title = sc.nextLine();

		int i = 0;
		while (i < albumList.length) {
			// check for null
			if (albumList[i] != null && song == null) {
				song = albumList[i].getSongByTitle(title);
			}
			i = i + 1; // iterate loop
		}
		if (song == null) // if not found
		{
			System.out.println("No song found.");
		} else {
			// play current song
			System.out.println("Now playing : @@@ " + song.getSongLocation() + " @@@");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MusicLibrary m1 = new MusicLibrary();

	}
}
