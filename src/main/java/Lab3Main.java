import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


/**
 * class experimenting with web scraping and word counting.
 * @author Kimi
 *
 */
public class Lab3Main {

    /**
     * Sends url to the method urlToString.
     * Splits resulting string at each space
     * to get an array with individual words from the url.
     * Counts words at that url
     * @param args unused input arguments
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
//        System.out.println(urlToString("https://cs.illinois.edu/"));

        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
//        System.out.println(hamlet);
        String[] hamletWords = hamlet.split(" ");
        System.out.println("Hamlet: " + hamletWords.length + " words");

        String laborStats = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String[] laborStatsWords = laborStats.split(" ");
        System.out.println("Labor Statistiscs Page: " + laborStatsWords.length + " words");

        String weather =
                urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        String[] weatherWords = weather.split(" ");
        System.out.println("Weather: " + weatherWords.length + " words");
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
