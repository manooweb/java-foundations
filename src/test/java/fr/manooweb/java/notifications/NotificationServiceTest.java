package fr.manooweb.java.notifications;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void send_shouldDelegateToNotifier() {
        FakeNotifier notifier = new FakeNotifier();
        NotificationService service = new NotificationService(notifier);

        service.send("alice@example.com", "Hello!");

        assertEquals("alice@example.com", notifier.lastRecipient);
        assertEquals("Hello!", notifier.lastMessage);
    }
}
