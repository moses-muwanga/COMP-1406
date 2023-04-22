import java.security.PublicKey;
import java.util.ArrayList;

public class User {
  private String     userName;
  private boolean    online;
  private ArrayList<Song> songList;
  
  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList<Song>();
  }
  
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  
  public String toString()  {
    String s = "" + userName + ": "+ songList.size() +" songs (";
    if (!online) s += "not ";
    return s + "online)";
  }

  // Returns the ArrayList of the songs the user has on their hard drive
  public ArrayList<Song> getSongList(){
    return songList;
  }

  // Adds a given song to the user's song list
  public void addSong(Song s){
    songList.add(s);
    if (s.owner == null){
      s.owner = this;
    }
  }

  // Returns an integer indicating the total duration, in seconds, that all the user's songs would require if played
  public int totalSongTime(){
    int total = 0;
    for (Song s: songList){
      total += s.getDuration();
    }
    return total;
  }

//  A method which registers the user into the given MusicExchangeCenter m.
  public void register(MusicExchangeCenter m){
    m.registerUser(this);
  }

  //  A logon() method that simulates a user going online.
  public void logon(){
      online = true;
  }

  //  A logoff() method that simulates a user going offline.
  public void logoff(){
      online = false;
  }

//  A method which gathers the list of all available songs from all users that are online at the given music exchange
//  center and then returns an ArrayList<String>
  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
    ArrayList<String> completeSongList = new ArrayList<String>();
    completeSongList.add(String.format("%10s%36s%18s%10s", "TITLE","ARTIST","TIME","OWNER"));
    int songCounter = 1;
    for (Song s: m.allAvailableSongs()){
      completeSongList.add(String.format("%3d. %-35s%-19s%2d:%02d     %-15s", songCounter, s.getTitle(), s.getArtist(),
              s.getMinutes(), s.getSeconds(), s.owner.getUserName()));
      songCounter++;
    }
    return completeSongList;
  }

// A method which gathers the list of all available songs by the given artist from all users, and then return an
// ArrayList<String>
  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
    ArrayList<String> artistSongList = new ArrayList<String>();
    artistSongList.add(String.format("%10s%36s%18s%10s", "TITLE","ARTIST","TIME","OWNER"));
    int songCounter = 1;
    for (Song s: m.allAvailableSongs()){
      if (s.getArtist().equals(artist)){
        artistSongList.add(String.format("%3d. %-35s%-19s%2d:%02d     %-15s", songCounter,
                s.getTitle(), s.getArtist(), s.getMinutes(), s.getSeconds(), s.owner.getUserName()));
        songCounter++;
      }
    }
    return artistSongList;
  }

//  A method which searches through the center’s users to find User with the matching ownerName and then
//  search through that user’s songs to find the Song with the given title.
  public Song songWithTitle(String title){
    Song requestedSongWithTitle = new Song();
    for (Song s: songList){
      if (title.equals(s.getTitle())){
        requestedSongWithTitle = s;
        return requestedSongWithTitle;
      }
    }
    return null;
  }

//  A method that simulates the downloading of one of the songs in the catalog and adds the downloaded song to
//  the user’s songList (if not null).
  public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
    Song temp = m.getSong(title, ownerName);
    if (temp != null){
      songList.add(temp);
    }
  }
}
