package bookingrequests;

import bookingrequests.models.BookingRequest;
import bookingrequests.models.Suggestion;
import bookingrequests.util.Parser;

import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        // Parse CLI arguments, expecting two arguments: suggestions path and booking request path
        if(args.length < 2){
            System.out.println("Not enough arguments provided.");
            System.out.println("Usage: mvn exec:java " +
                    "-Dexec.mainClass=bookingrequests.Main " +
                    "-Dexec.args=\"<suggestions filepath> <booking request filepath>\"" );
            return;
        }

        // Parse input files
        Parser parser = new Parser();
        List<Suggestion> suggestions = parser.parseSuggestions(args[0]);
        BookingRequest bookingRequest = parser.parseBookingRequest(args[1]);

        System.out.println(bookingRequest);
        System.out.println("---");
        System.out.println("Ranked Suggestions:");

        // Rank Suggestions
        SuggestionRanker ranker = new SuggestionRanker(1.0, 2.0, 3.0);
        TreeSet<Suggestion> rankedSuggestions = ranker.rankSuggestions(suggestions, bookingRequest);
        int suggestionNumber = 1;
        for(Suggestion s : rankedSuggestions) {
            System.out.println(suggestionNumber++ + ": " + s);
        }
    }
}
