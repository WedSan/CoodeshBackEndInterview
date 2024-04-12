package wedsan.Exception;
/**
 * Exception thrown when the middle element is not found in a list.
 */
public class MiddleElementNotFoundException extends Exception{

    public MiddleElementNotFoundException(String message) {
        super("Middle element not found: " + message);
    }
}
