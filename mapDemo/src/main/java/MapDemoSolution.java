import java.util.*;

public class MapDemoSolution {

    public static void main(String[] args) {
        Map<String, String> showAndNetwork = new HashMap<>();

        showAndNetwork.put("Arrested Development", "Netflix");
        showAndNetwork.put("The Wire", "HBO");
        showAndNetwork.put ("The Good Place", "Netflix");
        showAndNetwork.put ("GOT", "HBO");

        System.out.println(showAndNetwork);

        showAndNetwork.put("Arrested Development", "Hulu");

        System.out.println("After change");
        System.out.println(showAndNetwork);

        String wireNetwork = showAndNetwork.get("The Wire");
        System.out.println(wireNetwork);

        System.out.println("Displaying formatted show list");
        displayShowList(showAndNetwork);


        String[] favoriteShows = {"The Wire", "Breaking Bad", "GOT", "The Wire", "GOT", "Abbott Elementary"};

        Map<String, Integer> favoriteCount = countFavoriteShows(favoriteShows);
        System.out.println(favoriteCount);

        Set<Map.Entry<String, String>> showNetworkPairs = showAndNetwork.entrySet();

//        Set <String> shows = showAndNetwork.keySet();
//        System.out.println("The keys:");
//        for (String show : shows){
//            System.out.println(show);
//        }
//
//        Collection<String> networks = showAndNetwork.values();
//        System.out.println("The values:");
//        for (String network: networks){
//            System.out.println(network);
//        }

    }

    public static void displayShowList (Map <String, String> shows) {
        for (Map.Entry<String, String> show : shows.entrySet()){
            System.out.println(show.getKey() + " appears on " + show.getValue());
        }
    }

    public static Map<String, Integer> countFavoriteShows (String[] shows){
        Map<String, Integer> favoriteShows = new HashMap<>();
        for (String show : shows) {
            if (!favoriteShows.containsKey(show)) {
                favoriteShows.put(show, 1);
            } else {
                int currentCount = favoriteShows.get(show);
                favoriteShows.put (show, currentCount + 1);
            }
        }
        return favoriteShows;
    }



}
