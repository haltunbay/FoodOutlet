package food;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program implements Serializable {

    public static void main(String[] args) throws IOException {

    	String city="denver";
    	String urlString =  "https://jsonmock.hackerrank.com/api/food_outlets?city=denver&page=1";
    	urlString = urlString.replaceFirst("\\bcity=.*?(&|$)", "city="+city+"$1");
    	urlString = urlString.replaceFirst("\\bpage=.*?(&|$)", "page=1$1");
        // Create a neat value object to hold the URL
        URL url = new URL(urlString);

      
        SearchResult r = runHttpQuery(url);
        
        List<FoodOutlet> foodOutlets = new ArrayList( Arrays.asList(r.getData()));
        
        int page=2;
        while(page<=r.getTotalPages()) {
        	urlString = urlString.replaceFirst("\\bpage=.*?(&|$)", "page="+page+"$1");
        	SearchResult r1 = runHttpQuery(new URL(urlString));
        	foodOutlets.addAll( Arrays.asList(r1.getData()) );
        	page++;
        }
        
        double maxRating = Arrays.stream(r.getData()).mapToDouble(x-> x.getUserRating().getAverageRating()).max().orElse(0);
         List<String> results = foodOutlets.stream().filter(f-> f.getUserRating().getAverageRating() == maxRating).map(f->f.getName()).collect(Collectors.toList());
        for(String f : results){
       		System.out.println(f);
        }

    }
    
    private static SearchResult runHttpQuery (URL url) {
    	try {
	        // Open a connection(?) on the URL(?) and cast the response(??)
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
	        // Now it's "open", we can set the request method, headers etc.
	        connection.setRequestProperty("accept", "application/json");
	
	        // This line makes the request
	        InputStream responseStream = connection.getInputStream();
	
	        // Manually converting the response body InputStream to APOD using Jackson
	        ObjectMapper mapper = new ObjectMapper();
	        SearchResult r = mapper.readValue(responseStream, SearchResult.class);
	        return r;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;

    }
}
