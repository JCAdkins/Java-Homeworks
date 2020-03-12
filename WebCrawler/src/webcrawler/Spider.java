package webcrawler;

import java.util.*;

public class Spider {
    
    private static final int MAX_PAGES_TO_SEARCH = 1000;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    
    private String nextURL()
    {
        String nextURL;
        
        do
        {
            nextURL = this.pagesToVisit.remove(0);
        }
        while(this.pagesVisited.contains(nextURL));
        
        this.pagesVisited.add(nextURL);
        return nextURL;
    }
    
    public void search(String URL, String searchWord)
    {
        while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
        {
            String currentURL;
            SpiderLeg leg = new SpiderLeg();
            if (this.pagesToVisit.isEmpty())
            {
                currentURL = URL;
                this.pagesVisited.add(URL);
            }
            else
            {
                currentURL = this.nextURL();
            }
            leg.crawl(currentURL); //Lots of stuff happening here look at crawl method in SpiderLeg
            boolean success = leg.searchForWord(searchWord);
            if (success)
            {
                System.out.println(String.format("**SUCCESS** Word %s found at %s", searchWord, currentURL));
                break;
            }
            this.pagesToVisit.addAll(leg.getLinks());
        }
        System.out.println(String.format("**DONE** Visited %s web page(s)", this.pagesVisited.size()));
        //System.out.println(pagesVisited.)
    }
}
