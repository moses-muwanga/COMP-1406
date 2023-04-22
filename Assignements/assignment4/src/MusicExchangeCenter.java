import javax.print.DocFlavor;
import java.util.*;

public class MusicExchangeCenter {
    // Class which represents the company website that users log in and out of in order to download music.

    public ArrayList<User> usersList;  // An ArrayList of all the registered Users
    public HashMap<String, Float> royalties = new HashMap<String, Float>(); // A HashMap which represents the total amount of royalties for that artist so far
    public ArrayList<Song> downloadedSongs; // An ArrayList containing all of the songs that have been downloaded
    public TreeSet<Song> allDownloadedSongs;

//  A zero-parameter constructor that sets attributes properly.
    public MusicExchangeCenter(){
        usersList = new ArrayList<User>();
        downloadedSongs = new ArrayList<Song>();
    }

//  A method that returns an ArrayList of all Users that are currently online.
    public ArrayList<User> onlineUsers(){
        ArrayList<User> onlineUserList = new ArrayList<>();
        for (User u: usersList){
            if (u.isOnline()){
                onlineUserList.add(u);
            }
        }
        return onlineUserList;
    }

//  A method that returns a new ArrayList of all Songs currently available for download.
    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> availableSongsList = new ArrayList<Song>();
        for (User u: onlineUsers()){
            availableSongsList.addAll(u.getSongList());
        }
        return availableSongsList;
    }

//  A method that returns a string representation of the music center showing the number of users currently online
//  as well as the number of songs currently available.
    public String toString(){
        return "Music Exchange Center ("+ onlineUsers().size() + " users online, " + allAvailableSongs().size() +
                " songs available).";
    }

//  A method that finds and returns the user object with the given name if it is in the list of users.
    public User userWithName(String s){
        for (User u: usersList){
            if (u.getUserName().equalsIgnoreCase(s)){
                return u;
            }
        }
        return null;
    }

//  A method that adds a given User to the music center’s list of users, provided that there are no other users with
//  the same userName.
    public void registerUser(User x){
        if (userWithName(x.getUserName()) == null){
            usersList.add(x);
        }
    }

//  A method that returns a new ArrayList of all Songs currently available for download by the specified artist.
    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> artistsAvailableSongs = new ArrayList<>();
        for (User u: onlineUsers()){
            for (Song s: allAvailableSongs()){
                if (s.getArtist().equalsIgnoreCase(artist)) {
                    artistsAvailableSongs.add(s);
                }
            }
        }
        return artistsAvailableSongs;
    }

//  A method that returns the Song object with the given title owned by the user with the given ownerName, provided
//  that the user is currently online and that the song exists.
    public Song getSong(String title, String ownerName){
        for (User u: usersList){
            if (u.getUserName().equals(ownerName) && u.isOnline()){
                for (Song s: u.getSongList()){
                    if (s == u.songWithTitle(title)){
                        downloadedSongs.add(s);
                        return s;
                    }
                }
            }
        }
        return null;
    }

//  A method which displays the royalties for all artists who have had at least one of their songs downloaded.
    public void displayRoyalties(){
        System.out.println("Amount         Artist");
        System.out.println("---------------------");
        for (Song s: downloadedSongs){
            if (!royalties.containsKey(s.getArtist())){
                royalties.put(s.getArtist(), 0.25f);
            } else {
                royalties.put(s.getArtist(), royalties.get(s.getArtist()) + 0.25f);
            }
        }
        for (String s: royalties.keySet()){
            System.out.println("$" + String.format("%.2f", royalties.get(s)) + "          " + s);
        }
    }

//  A method which returns a TreeSet of all downloaded Song objects such that the set is sorted alphabetically by song title.
    public TreeSet<Song> uniqueDownloads(){
        allDownloadedSongs = new TreeSet<Song>(downloadedSongs);
        return allDownloadedSongs;
    }

//  A method which returns an ArrayList of Pair<Integer,Song> objects where the key of the pair is an Integer
//  representing the number of downloads and the value is the Song object.
    public ArrayList<Pair<Integer, Song>> songsByPopularity(){
        ArrayList<Pair<Integer, Song>> popularityList = new ArrayList<Pair<Integer, Song>>();
        for (Song masterSong: allDownloadedSongs){
            int counter = 0;
            for (Song duplicateSong: downloadedSongs){
                if (duplicateSong.getTitle().equals(masterSong.getTitle())){
                    counter++;
                }
            }
            popularityList.add(new Pair<>(counter, masterSong));
        }
        Collections.sort(popularityList, new Comparator<Pair<Integer, Song>>(){
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                return p2.getKey() - p1.getKey();
        } });
        return popularityList;
    }
    public ArrayList<Song> getDownloadedSongs(){
        return downloadedSongs;
    }
}
