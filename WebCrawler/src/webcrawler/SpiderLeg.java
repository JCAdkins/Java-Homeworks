package webcrawler;

import java.io.IOException;
import java.util.*;
import org.jsoup.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg {
    
    private List<String> links = new LinkedList<String>(); //Just a list of URL's
    private Document htmlDocument;
    private static final String USER_AGENT = 
             "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    
    
    public boolean crawl(String url) //Give it a URL and it will make a HTTPS request
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            
            if (connection.response().statusCode() == 200)
            {
                System.out.println("\n**VISITING** Received web page at " + url);
            }
            
            if (!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**FAILURE** Received something other than HTML");
                return false;
            }
            
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") size");
            for (Element link: linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Error in out HTTPS request " + e);
            return false;
        }
    }
    
    public boolean searchForWord(String searchWord) //Tries to find word on the page
    {
        if (this.htmlDocument == null)
        {
            System.out.println("ERROR! Call crawl() before performing analysis on page");
            return false;
        }
        System.out.println("Searching for the word " + searchWord + "...");
        String bodyText = this.htmlDocument.body().text();
        return bodyText.toLowerCase().contains(searchWord.toLowerCase());
    }
    
    public List<String> getLinks() //Returns a list of all URL's on page
    {
        return this.links;
    }
    
}
