/**
 * A simulated song which represents song in music library
 */

public class Song {
	private String songTitle;
	private String songLocation;

	/**
	 * Construct song with given title and location
	 * 
	 * @param songTitle
	 *            name of song
	 * @param songLocation
	 *            path of song
	 */
	public Song(String songTitle, String songLocation) {
		super();
		this.songTitle = songTitle;
		this.songLocation = songLocation;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public String getSongLocation() {
		return songLocation;
	}

	@Override
	public String toString() {
		return songTitle + "\t" + songLocation;
	}

}
