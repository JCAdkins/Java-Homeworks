package webcrawler;

public class WebCrawler {

    public static void main(String[] args) {
        
        Spider spider = new Spider();
        
        spider.search("https://www.merriam-webster.com/browse/thesaurus/c", "dander");
        
    }
    
}
