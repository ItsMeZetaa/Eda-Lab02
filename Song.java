interface SongInterface {
    // Getters
    public String getTitle();
    public String getArtist();
    public String getYear();
    public String toString();

    // Setters
    public void setTitle(String title);
    public void setArtist(String artist);
    public void setYear(String year);
}

/* Esta es la clase Song. Todas las canciones tendrán este formato, y deberán tener estas funciones */
public class Song implements SongInterface{
    private String title;   
    private String artist;
    private String year;


    public Song(String title, String artist, String year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }
    
    // Getters
    public String getTitle() {
        return this.title;
    };
    public String getArtist() {
        return this.artist;
    };
    public String getYear() {
        return this.year;
    };

    public String toString() {
        return this.year +" / " + this.title + " de: " + this.artist;
    };

    // Setters
    public void setTitle(String title) {
        this.title = title;
    };
    public void setArtist(String artist) {
        this.artist = artist;
    };
    public void setYear(String year) {
        this.year = year;
    };
}