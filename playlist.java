public class InvalidLengthException extends Exceptior
{
    private String lenghtSent;

    //Creates a blank InvalidLengthException with no arguments.
    private InvalidLengthException()
    {

    }
    //Creates an InvalidLengthException that takes in the invalid String.
	public InvalidLengthException(String inString)
	{
		this.lengthSent = inString;
    }
    //Returns the inString of an InvalidLengthException.
    public String getLengthSet()
    {
        return this.lenghtSent;
    }

    //Returns the InvalidLengthException as a String.
    public String toString()
    {
        String returnString;

        returnString = this.lenghtSent + " is an invalid length!\n";

        return returnString;
    }
}

public class InvalidRatingException extends Exception {

    private int numberSent;

    // Creates a blank InvalidRatingException with no arguments.
    private InvalidRatingException() {

    }

    // Creates an InvalidRatingException with the invalid number.
    public InvalidRatingException(int inNumberSent) {
        this.numberSent = inNumberSent;
    }

    // Returns the numberSent of an InvalidRatingException.
    public int getNumberSent() {
        return this.numberSent;
    }

    // Returns InvalidRatingException as a String.
    public String toString() {
        String returnString;

        returnString = this.numberSent + " is an invalid rating! Please choose a rating between 1 and 5.\n";

        return returnString;
    }
}

public class Main {
    public static void main(String[] arg) {
        Menu menu = new Menu();

        menu.loadPlaylist();
        menu.runMenu();

    }

} // End class

import java.io.*;
import java.util.Scanner;

public class Menu {
    private Scanner scan = new this.Scanner(System.in);
    private Playlist playlist = new Playlist();

    // Display a menu, prompts for user input (int selection), and returns the
    // input.
    {
        int selection;
    
        System.out.print("\nWhat would you like to do?"
						+ "\n1- Add song"+ "\n2- View playlist"
						+ "\n3- Update song" + "\n4- Remove song" + "\n5- Delete playlist"
            + " \n6- Exit" + "\nSelection: ");
    selection = scan.nextInt();
    System.out.print("\n")

    return selection;
}

    // Displays menu from showMenu(): Contains a switch,
    // executes case based on returned int from showMenu().
public void runMenu()
{

    int selection = showMenu();

    switch (selection) {
        case 1:
            addSong();
            savePlaylist();
            runMenu();
            break;
        case 2:
            viewPlaylist();
            runmenu();
            break;
        case 3:
            updateSong();
            savePlayist();
            runMenu();
            break;
        case 4:
            removeSong();
            savePlaylist();
            runMenu;
            break;
        case 5:
            playlist.deletePlaylist();
            runMenu();
            break;
        case 6:
            savePlaylist();
            System.exit(0);
            break;
        default:
            System.out.println("\nThat is not a valid selection!\n");
			runMenu();
    }

}

    // Creates a new Song with user to input for artist, title,
    // length, genre, rating; adds Song to a Playlist.
    /*
     * I had a lot of trouble getting the scanner get the input and assign it
     * correctly.
     * Someone suggested I utilize scanner.reset(), but I'd get a scanner exception.
     * This way worked.
     */
public void addSong()
{
    Song newSong = new Song(null, null, null, null, 0);

    newSong.setArtist(scan.nextLine());
    System.out.print("Enter artist: ");
    newSong.setArtist(scan.nextLine());
    System.out.print("Enter title: ");
    newSong.setTitle(scan.nextLine());
    do
    {
        try
        {
            System.out.print("Enter length: ");
            newSong.setLength(scan.next());
        }
        catch (InvalidLengthException invalidLength)
        {
            System.out.print(invalidLength.toString());
            System.out.print("Enter length as" \"minutes:seconds\".\n");    
        }
    } while (newSong.getLength() == null);

    newSong.setGenre(scan.nextLine();
    System.out.print("Enter genre: ");
    newSong.setGenre(scan.nextLine());
    boolean flag = false;
    do
    {
        try {
            System.out.print("Enter rating: ");
            newSong.setRating(scan.nextInt());
            flag = true;
        }
        catch (InvalidRatingException invalidRating)
			{
				System.out.print(invalidRating.toString());
			}
		} while(flag == false);
		
		playlist.addSong(newSong);
}

    // Formats and displays all Songs in Playlist.
public void viewPlaylist()
{
    if (playlist.getPlaylistSize() == 0) {
        System.out.print("\nPlaylist empty!");
    }
    else {
        for (int i = 0, i < playlist.getPlaylistSize(); i++) {
            System.out.print("\n#" + (i + 1) + " ");
            System.out.print("" + playlist.getArtist(i) + " - ");
            System.out.print("\"" + playlist.getTitle(i) + "\"" + ", ");
            System.out.print(playlist.getLength(i) + ", ");
            System.out.print(playlist.getGenre(i) + ", ");
            System.out.print(playlist.getRating(i) + " out of 5");
            
        }
        System.ou.print("\n");
    }
}

    // Displays Playlist; prompts user to select song,
    // asks which variable of song they would like to update,
    // asks for input for that variables to update.
    public void updateSong() {
        if (playlist.getPlaylistSize() == 0) {
            System.out.println("\nPlaylist empty!");
        } else {
            viewPlaylist();
            System.out.print("\nPlease select a song to update: ");
            int songSelection = scan.nextInt();

            System.out.print("\nWhat would you like to update?\n" + "1- Artist\n" + "2- Title\n"
                    + "3- Length\n" + "4- Genre\n" + "5- Rating\n" + "Selection: ");

            int updateSelection = scan.nextInt();

            switch (updateSelection) {
                case 1:
                    System.out.print("Enter artist: ");
                    String artist = scan.next();
                    playlist.updateArtist(songSelection, artist);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = scan.next();
                    playlist.updateTitle(songSelection, title);
                    break;
                case 3:
                    boolean lengthFlag = false;
                    do {
                        try {
                            System.out.print("Enter Length: ");
                            String length = scan.next();
                            playlist.updateLength(songSelection, length);
                            lengthFlag = true;
                        } catch (InvalidLengthException invalidLength) {
                            System.out.print(invalidLength.toString());
                            System.out.print("Enter length as \"minutes:seconds\".\n");
                        }
                    } while (lengthFlag == false);
                    break;
                case 4:
                    System.out.print("Enter genre: ");
                    String genre = scan.next();
                    playlist.updateGenre(songSelection, genre);
                    break;
                case 5:
                    boolean ratingFlag = false;
                    do {
                        try {
                            System.out.print("Enter rating: ");
                            int rating = scan.nextInt();
                            playlist.updateRating(songSelection, rating);
                            ratingFlag = true;
                        } catch (InvalidRatingException invalidLength) {
                            System.out.print(invalidLength.toString());
                        }
                    } while (ratingFlag == false);
                    break;
                default:
                    System.out.println("\nThat is not a valid selection!\n");
                    runMenu();
            }
        }
    }

    // Displays Playlist; prompts user to select song,
    public void removeSong() {
        if (playlist.getPlaylistSize() == 0) {
            System.out.println("\nPlaylist empty!");
        } else {
            viewPlaylist();
            boolean flag = false;
            do {
                System.out.print("\nSelect a song to remove: ");
                int removeSelection = scan.nextInt();

                if (removeSelection < playlist.getPlaylistSize() || removeSelection > playlist.getPlaylistSize()) {
                    System.out.print("That is not a valid selection!\n");
                } else {
                    playlist.removeSong(--removeSelection);
                    flag = true;
                }
            } while (flag == false);
        }
    }

    // Write the contents of Playlist to a file called playlist.
    public void savePlaylist() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("playlist");

            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

            outObjectStream.writeObject(playlist);

            outObjectStream.flush();
            outObjectStream.close();
        } catch (FileNotFoundException fnfException) {
            System.out.println("No file");
        } catch (IOException ioException) {
            system.out.println("bad IO");
        }
    }

    // Reads the file contents containing to a Playlist.
    {
        try {
            FileInputStream fileInputStream = new FileInputStream("playlist");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            playlist = (Playlist) objectInputStream.readObject();

            objectInputStream.close();
        } catch (FileNotFoundException fnfException) {
            System.out.println("No File");
        } catch (IOException ioException) {
            System.out.println("IO no good");
        } catch (ClassNotFoundException classNotFoundException) {
            System.ou.println("This is not a Playlist.");
        }
    }

}// End class
import java.util.*;
import java.io.*;

public class Playlist implements Serializable 
{
    private ArrayList<Song> playlist;

    //Creates a Playlist object that contains an Arraylist for Songs.
    public Playlist()
    {
        playlist = new ArrayList<Song>();
    }

    //Adds a Song to the Playlist.
    public void addSong(Song song)
    {
        playlist.add(song);
    }

    //Returns the size of a Playlist.
    public int getPlaylistSize()
    {
        return playlist.size();
    }

    //Returns the artist of the Song at position (index) of a Playlist.
    public String getArtist(int index)
    {
        return playlist.get(index).getArtist();
    }

    //Returns the length of the Song at position (index) of a Playlist.
    public String getLength(int index)
    {
        return playlist.get(index).getLength();
    }

    //Returns the genre of the Song at position (index) of a Playlisy.
    public String getGenre(int index)
    {
        return playlist.get(index).getGenre();
    }

    //Return the rating of the Song at position (index) of a Playlist.
    public int getRating(int index)
    {
        return playlist.get(index).getRating();
    }
//Sets the artist of the Song at position (index) to artist.
	public void updateArtist(int index, String artist)
	{
		playlist.get(--index).setArtist(artist);
	}
	
	//Sets the title of the Song at position (index) to the title.
	public void updateTitle(int index, String title)
	{
		playlist.get(--index).setTitle(title);
	}
	
	//Sets the length of the Song at position (index) to length; throws InvalidLengthException.
	public void updateLength(int index, String length) throws InvalidLengthException
	{
		if(length.matches("(\\d.*):(\\d.*)"))
		{
			playlist.get(--index).setLength(length);
		}
		else
		{
			throw new InvalidLengthException(length);
		}
	}
	
	//Sets the genre of the Song at position (index) to genre.
	public void updateGenre(int index, String genre)
	{
		playlist.get(--index).setGenre(genre);
	}
	
	//Sets the rating of the Song at position (index) to rating.
	public void updateRating(int index, int rating) throws InvalidRatingException
	{
		if(rating > 0 && rating < 6)
		{
			playlist.get(--index).setRating(rating);
		}
		else
		{
			throw new InvalidRatingException(rating);
		}
	}
	
	//Removes the song located at the specified index from the Playlist.
	public void removeSong(int index)
	{
			playlist.remove(index);
	}
	
	//Clears the Playlist of all Songs by invoking clear() on a Playlist.
	public void deletePlaylist()
	{
		if(playlist.size() == 0)
		{
			System.out.print("Playlist is empty!\n");
		}
		else
		{
			playlist.clear();
			System.out.print("Playlist has been deleted.\n");
		}
	}
	
} // End class
import java.io.*;

public class Song implements Serializable {
    private String artist;
    private String title;
    private String length;
    private String genre;
    private int rating;

    // Creates a playlist object with an artist, title, length, genre, and rating.
    public Song(String artist, String title, String length, String genre, int rating) {
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
    }

    // Sets Song's artits to argument artist.
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Return the value of artist in a Song.
    public String getArtist() {
        return artist;
    }

    // Sets Song's title to argument title.
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns the value of title in a Song.
    public String getTitle() {
        return title;
    }

    // Sets song's length to length argument; creates InvalidLengthException.
    /*
     * This is not exactly how I wanted to do this, instead
     * this checks for validity by seeing if the argument String
     * contains both a colon and only numbers.
     */
    public void setLength(String length) throws InvalidLengthException {
        if (length.matches("(\\d.*):(\\d.*)")) {
            this.length = length;
        } else {
            throw new InvalidLengthException(length);
        }
    }

    // Returns the value of length in a Song.
    public String getLength() {
        return length;
    }

    // Sets Song's genre to argument genre.
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Returns value of genre in a Song.
    public String getGenre() {
        return this.genre;
    }

    // Sets Song's rating to argument rating; creates InvalidRatingException.
    public void setRating(int rating) throws InvalidRatingException {
        if (rating > 0 || rating < 6) {
            this.rating = rating;
        } else {
            throw new InvalidRatingException(rating);
        }

    }

    // Returns rating value in a Song.
    public int getRating() {
        return this.rating;
    }

} // End class
