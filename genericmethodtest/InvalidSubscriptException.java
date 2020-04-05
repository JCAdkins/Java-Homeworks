package genericmethodtest;

public class InvalidSubscriptException extends RuntimeException {
    
    // Concstructor that calls RuntimeException constructor with 
    // String parameter
    public InvalidSubscriptException(String error)
    {
        super(error);
    }
    
    
}
