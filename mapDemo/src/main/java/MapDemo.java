import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Map<String, String> showAndNetwork = new HashMap<>();
        showAndNetwork.put("Arrested Development", "Netflix");
        showAndNetwork.put("The Wire", "HBO");
        showAndNetwork.put ("The Good Place", "Netflix");
        showAndNetwork.put ("GOT", "HBO");


        showAndNetwork.put("Arrested Development", "Hulu");
//
//        System.out.println("After change: ");
//        System.out.println(showAndNetwork);
//
//        String wireNetwork = showAndNetwork.get("The Wire");
//        System.out.println("The Wire is on " + wireNetwork);
//
        displayShowList(showAndNetwork);

        String[] favoriteShows = {"The Wire", "Breaking Bad", "GOT", "The Wire", "GOT", "Abbott Elementary"};

        Map<String, Integer> favoriteCount = countFavoriteShows(favoriteShows);
        System.out.println(favoriteCount);
    }

    public static void displayShowList (Map <String, String> shows) {

        for (Map.Entry <String, String> show : shows.entrySet()){
            System.out.println(show.getKey() + " is on " + show.getValue());
        }

    }

    public static Map<String, Integer> countFavoriteShows (String[] shows) {
        Map<String, Integer> favoriteShows = new HashMap<>();
        for (String show : shows) {
            // show not currently in the Map
            if (!favoriteShows.containsKey(show)){
                favoriteShows.put(show, 1);
            } else // show already on the Map
            {
                int currentCount = favoriteShows.get(show);
                favoriteShows.put(show, currentCount + 1);
            }
        }


        return favoriteShows;
    }





}
