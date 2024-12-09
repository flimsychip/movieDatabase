/*************************************************
 File: P4MovieDB
 By: Allie Young
 Date: 12/8/24
 Description: scans a file and sorts it into a database of movies and directors.
 allows user to access the stored list of movies using directors' names as keys
 *************************************************/

package P4MovieDB;
import java.util.*;
import java.io.*;

public class P4MovieDB {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();
        System.out.print("Enter input file name: ");
        java.io.File file = new java.io.File(in.nextLine());
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNext()) {
            String[] words = fileScanner.nextLine().split(",");
            String movie = words[0].trim();
            String director = words[1].trim();
            if(!map.containsKey(director)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(movie);
                map.put(director, list);
            } else {
                map.get(director).add(movie);
                map.put(director, map.get(director));
            }
        }

        System.out.println(map);

        while(true) {
            System.out.print("Enter director: ");
            String inpDirector = in.nextLine();
            if(!map.containsKey(inpDirector)) {
                System.out.print("Director not found.");
                break;
            }
            System.out.println(inpDirector + "'s movies in database:\n" + map.get(inpDirector));
        }
    }
}