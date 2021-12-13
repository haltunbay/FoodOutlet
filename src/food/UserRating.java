package food;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserRating {
    private int id;
    private int votes;
    private double averageRating;

    public UserRating(
            @JsonProperty("id") int id,
            @JsonProperty("votes") int votes,
            @JsonProperty("average_rating") double averageRating) {
        this.setId(id);
        this.setVotes(votes);
        this.setAverageRating(averageRating);

    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
