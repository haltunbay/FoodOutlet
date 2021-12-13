package food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {

    private int page;
    @JsonIgnore
    private int per_page;
    @JsonIgnore
    private int total;
    private int totalPages;
    private FoodOutlet[] data;

    public SearchResult(
            @JsonProperty("page") int page,
            @JsonProperty("per_page") int per_page,
            @JsonProperty("total") int total,
            @JsonProperty("total_pages") int totalPages,
            @JsonProperty("data") FoodOutlet[] data) {
        this.per_page = per_page;
		this.total = total;
		this.setPage(page);
        this.setTotalPages(totalPages);
        this.setData(data);

    }

    public FoodOutlet[] getData() {
        return data;
    }

    public void setData(FoodOutlet[] data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
