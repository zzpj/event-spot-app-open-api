package pl.sii.mentor.openapi;

import org.springframework.stereotype.*;
import pl.sii.mentor.openapi.model.*;

import java.util.*;

@Service
public class EventSpotService {

    private static List<EventSpot> spots = new ArrayList<>();

    public void addEventSpot(EventSpot eventSpot) {
        spots.add(eventSpot);
    }

    public List<EventSpot> getAllEventSports() {
        return spots;
    }

    public void deleteEventSpot(String id) {
        EventSpot eventSpot = getEventSpot(id);
        spots.remove(eventSpot);
    }

    public EventSpot getEventSpot(String id) {
        return spots.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst().orElseThrow(() -> new EventSpotException(id));
    }
}
