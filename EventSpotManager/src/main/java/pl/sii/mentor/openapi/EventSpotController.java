package pl.sii.mentor.openapi;

import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.sii.mentor.openapi.model.*;

import java.util.*;

@RestController
@AllArgsConstructor
public class EventSpotController implements EventSpotsApi {

    private final EventSpotService eventSpotService;

    @Override
    public ResponseEntity<Void> createEventSpot(final EventSpot eventSpot) {
        eventSpotService.addEventSpot(eventSpot);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteEventSpotById(final String eventSpotId) {
        eventSpotService.deleteEventSpot(eventSpotId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<EventSpot>> getAllEventSpots() {
        return ResponseEntity.ok(eventSpotService.getAllEventSports());
    }

    @Override
    public ResponseEntity<EventSpot> getEventSpotById(final String eventSpotId) {
        return ResponseEntity.ok(eventSpotService.getEventSpot(eventSpotId));
    }
}
