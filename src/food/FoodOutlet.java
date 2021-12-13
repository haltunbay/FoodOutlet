package food;
import com.fasterxml.jackson.annotation.JsonProperty;
public class FoodOutlet {
    private int id;
    private String city;
    private String name;
    private int estimatedCost;
    private UserRating userRating;

    public FoodOutlet(
            @JsonProperty("id") int id,
            @JsonProperty("city") String city,
            @JsonProperty("name") String name,
            @JsonProperty("estimated_cost") int estimatedCost,
            @JsonProperty("user_rating") UserRating userRating) {
        this.setId(id);
        this.setCity(city);
        this.setName(name);
        this.setEstimatedCost(estimatedCost);
        this.setUserRating(userRating);

    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(int estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
