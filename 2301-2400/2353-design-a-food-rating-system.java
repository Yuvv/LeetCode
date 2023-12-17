import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 2353-design-a-food-rating-system
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/17
 */
public class FoodRatings {
    private Map<String, TreeMap<Integer, TreeSet<String>>> ratingMap;
    private Map<String, Object[]> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.ratingMap = new HashMap<>();
        this.foodMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            this.ratingMap.computeIfAbsent(cuisines[i], k -> new TreeMap<>())
                    .computeIfAbsent(ratings[i], k -> new TreeSet<>())
                    .add(foods[i]);
            this.foodMap.put(foods[i], new Object[] { cuisines[i], Integer.valueOf(ratings[i]) });
        }
    }

    public void changeRating(String food, int newRating) {
        Object[] infos = foodMap.get(food);
        String cuisine = (String) infos[0];
        Integer oldRating = (Integer) infos[1];
        infos[1] = Integer.valueOf(newRating);
        TreeMap<Integer, TreeSet<String>> ratingInfo = ratingMap.get(cuisine);
        TreeSet<String> oldFoods = ratingInfo.get(oldRating);
        oldFoods.remove(food);
        if (oldFoods.isEmpty()) {
            ratingInfo.remove(oldRating);
        }
        ratingInfo.computeIfAbsent(newRating, k -> new TreeSet<>()).add(food);
    }

    public String highestRated(String cuisine) {
        return ratingMap.get(cuisine).lastEntry().getValue().first();
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[] { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" },
                new String[] { "korean", "japanese", "japanese", "greek", "japanese", "korean" },
                new int[] { 9, 12, 8, 15, 14, 7 });
        foodRatings.highestRated("korean"); // return "kimchi"
                                            // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
                                              // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
                                              // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "ramen"
                                              // Both "sushi" and "ramen" have a rating of 16.
                                              // However, "ramen" is lexicographically smaller than "sushi".

    }
}
