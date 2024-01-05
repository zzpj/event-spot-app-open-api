package pl.sii.mentor.openapi;

public class EventSpotException extends RuntimeException {
    public EventSpotException(String id) {
        super("id=" + id + " is not found");
    }
}
