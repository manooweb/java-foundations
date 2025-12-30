package fr.manooweb.java.notifications;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NotificationServiceTest {

    @Test
    void send_shouldDelegateToNotifier_usingLambda() {
                StringBuilder log = new StringBuilder();

        Notifier notifier = (recipient, message) ->
                log.append(recipient).append(":").append(message);

        NotificationService service = new NotificationService(notifier);

        service.send("alice@example.com", "Hello!");

        assertEquals("alice@example.com:Hello!", log.toString());
    }
}
