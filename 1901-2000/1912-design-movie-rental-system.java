import java.util.*;
/**
 * 1912-design-movie-rental-system.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/21
 */
public class MovieRentingSystem {

    private TreeSet<MovieEntry> rented; // [shop, movie, price]
    private Map<Integer, TreeSet<MovieEntry>> exists; // movie -> [shop, price]
    private Map<Integer, Map<Integer, Integer>> entries;

    public MovieRentingSystem(int n, int[][] entries) {
        this.entries = new HashMap<>();
        this.rented = new TreeSet<>();
        this.exists = new HashMap<>();
        for (int[] entry : entries) {
            exists.computeIfAbsent(entry[1], k -> new TreeSet<>())
                    .add(new MovieEntry(entry[1], entry[0], entry[2]));
            this.entries.computeIfAbsent(entry[0], k -> new HashMap<>())
                    .put(entry[1], entry[2]);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> resList = new ArrayList<>();
        TreeSet<MovieEntry> ee = exists.get(movie);
        if (ee == null) {
            return resList;
        }
        int i = 0;
        Iterator<MovieEntry> it = ee.iterator();
        while (it.hasNext() && i < 5) {
            MovieEntry e = it.next();
            resList.add(e.shop);
            i++;
        }
        return resList;
    }

    public void rent(int shop, int movie) {
        Map<Integer, Integer> map = this.entries.get(shop);
        if (map == null) {
            return;
        }
        Integer p = map.get(movie);
        if (p == null) {
            return;
        }
        if (p < 0) {
            return;  // already rented
        }
        map.put(movie, -p);
        MovieEntry e = new MovieEntry(movie, shop, p);
        rented.add(e);
        exists.get(movie).remove(e);
    }

    public void drop(int shop, int movie) {
        Map<Integer, Integer> map = this.entries.get(shop);
        if (map == null) {
            return;
        }
        Integer p = map.get(movie);
        if (p == null) {
            return;
        }
        if (p > 0) {
            return;  // already dropped
        }
        map.put(movie, -p);
        MovieEntry e = new MovieEntry(movie, shop, -p);
        rented.remove(e);
        exists.get(movie).add(e);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> resList = new ArrayList<>();
        int i = 0;
        Iterator<MovieEntry> it = rented.iterator();
        while (it.hasNext() && i < 5) {
            MovieEntry e = it.next();
            resList.add(Arrays.asList(e.shop, e.movie));
            i++;
        }
        return resList;
    }

    public static void main(String[] args) {

        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(
            3, new int[][]{{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}});
        System.out.println(movieRentingSystem.search(1));  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
        movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
        movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
        System.out.println(movieRentingSystem.report());   // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
        movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
        System.out.println(movieRentingSystem.search(2));  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.

    }
}

class MovieEntry implements Comparable<MovieEntry> {
    int movie; // 1 <= movie <= 10_000
    int shop;  // 0 <= shop < 300_000
    int price; // 1 <= price <= 10_000
    long _val;

    public MovieEntry(int movie, int shop, int price) {
        this.movie = movie;
        this.shop = shop;
        this.price = price;
        this._val = shop * 100000001L + movie * 10001L + price;
    }

    public int compareTo(MovieEntry o) {
        int r = this.price - o.price;
        if (r == 0) {
            r = shop - o.shop;
            if (r == 0) {
                r = movie - o.movie;
            }
        }
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MovieEntry) {
            MovieEntry e = (MovieEntry) obj;
            // return e.movie == movie && e.shop == shop && e.price == price;
            return e._val == this._val;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(_val);
    }
}