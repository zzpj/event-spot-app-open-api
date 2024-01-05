package pl.sii.mentor.openapi.client;

import lombok.extern.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;
import pl.sii.mentor.openapi.*;
import pl.sii.mentor.openapi.model.*;

import java.math.*;
import java.util.*;

@SpringBootApplication
@Slf4j
public class EventSpotAppClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSpotAppClientApplication.class, args);
	}

	@Bean
	public DefaultApi defaultApi() {
		return new DefaultApi();
	}

    @Bean
    public CommandLineRunner run(DefaultApi api) {
        return args -> {
			log.info("event spot app client hello");

			log.info("create new event spot: ");
			String eventSpotId = "ID1";
			EventSpot eventSpot = new EventSpot()
					.id(eventSpotId)
					.capacity(new BigDecimal(1000))
					.eventSpotType(EventSpot.EventSpotTypeEnum.PARK)
					.name("AudioRiver");
			log.info("newly created event spot " + eventSpot);
			api.createEventSpot(eventSpot);

			log.info("event added via webservice client");
			log.info("check event by id: ");
			EventSpot eventSpotById = api.getEventSpotById(eventSpotId);

			log.info("event spot by id " + eventSpotById);

			log.info("all events #1: ");
			List<EventSpot> allEventSpots = api.getAllEventSpots();
			allEventSpots.forEach(e -> log.info("event spot: " + e));

			log.info("delete event by id");
			api.deleteEventSpotById(eventSpotId);

			log.info("all events #2: ");
			allEventSpots = api.getAllEventSpots();
			log.info("event size: " + allEventSpots.size());

			log.info("check error");
			try {
				api.getEventSpotById("XYZ");
			} catch (RestClientException restClientException) {
				log.error(restClientException.getMessage());
			}
		};
    }

}
