package bookingrequests.util;

import bookingrequests.models.BookingRequest;
import bookingrequests.models.Suggestion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {

    private JSONParser parser;
    public Parser() {
        this.parser = new JSONParser();
    }

    // TODO: Throw error if field is not found
    public BookingRequest parseBookingRequest(String filepath) {
        JSONObject requestObj = parseFile(filepath);
        String carColor = (String) requestObj.get("carColor");
        String locationString = (String) requestObj.get("location");
        String[] locations = locationString.split(",");

        return new BookingRequest(carColor, Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
    }

    public List<Suggestion> parseSuggestions(String filepath){
        JSONObject parsed = parseFile(filepath);
        JSONArray suggestionInput = (JSONArray) parsed.get("suggestions");

        ArrayList<Suggestion> suggestionList = new ArrayList<>();
        Iterator<JSONObject> iterator = suggestionInput.iterator();
        while (iterator.hasNext()) {
            suggestionList.add(parseSuggestion(iterator.next()));
        }
        return suggestionList;
    }

    // TODO: Throw error if field is not found
    private Suggestion parseSuggestion(JSONObject suggestionObj) {

            String carColor = (String) suggestionObj.get("carColor");
            Long timeOffset = (Long) suggestionObj.get("timeOffset");
            String locationString = (String) suggestionObj.get("location");
            String[] locations = locationString.split(",");

            return new Suggestion(carColor, timeOffset.intValue(), Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
    }

    // Parse file located at given filepath (relative to /src/main)
    public JSONObject parseFile(String filepath) {
        try{
            URL url = getClass().getResource(filepath);
            File file = new File(url.getPath());

            Object obj = parser.parse(new FileReader(file));
            return (JSONObject) obj;
        } catch(IOException | ParseException e){
            e.printStackTrace();
            return null;
        }
    }

}
