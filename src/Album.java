/**
 * A simulated album which contains no. of songs added to it.
 */

public class Album {

	private String albumName;
	private int noOfSongs;
	private Song songList[]; // array of song object

	/**
	 * Construct a album with given album name and no. of songs.
	 * 
	 * @param albumName
	 *            name of album
	 * @param noOfSongs
	 *            total song in album
	 */
	public Album(String albumName, int noOfSongs) {
		super();
		this.albumName = albumName;
		this.noOfSongs = noOfSongs;
		songList = new Song[noOfSongs];
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	/**
	 * Adds new song to the album
	 * 
	 * @param songTitle
	 *            song name
	 * @param songLocation
	 *            path of the song
	 */
	public void addSong(String songTitle, String songLocation) {

		// make new song object with title and location
		Song s = new Song(songTitle, songLocation);
		int index = 0;

		// iterate song list and get empty index
		if (songList.length > 0) {
			int i = 0;

			// iterate loop
			while (i < songList.length) {
				// check for null
				if (songList[i] == null) {
					index = i; // match found
					i = songList.length + 1; // terminate the loop
				}
				i = i + 1; // iterate loop
			}
		}

		// add song object
		songList[index] = s;

	}

	/**
	 * Search song by given title
	 * 
	 * @param title
	 *            name of the song
	 * @return object of the Song
	 */
	public Song getSongByTitle(String title) {
		Song s = null;

		// iterate song list and find matching song
		int i = 0;
		while (i < songList.length && s == null) {
			// check for null
			if (songList[i] != null) {
				if (songList[i].getSongTitle().equalsIgnoreCase(title)) {
					s = songList[i]; // if match found
				}
			}
			i = i + 1; // iterate loop
		}
		return s; // return song object
	}

	@Override
	public String toString() {
		return "Album [albumName=" + albumName + ", noOfSongs=" + noOfSongs + "]";
	}

}
