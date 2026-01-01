package fr.manooweb.java.notifications;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Test
    void send_shouldDelegateToNotifier_usingLambda() {
        StringBuilder log = new StringBuilder();

        Notifier notifier = (recipient, message) -> log.append(recipient).append(":").append(message);

        NotificationService service = new NotificationService(notifier);

        service.send("alice@example.com", "Hello!");

        assertEquals("alice@example.com:Hello!", log.toString());
    }

    @Test
    void send_shouldDelegateToNotifier() {
        // Arrange
        Notifier notifier = mock(Notifier.class);
        NotificationService service = new NotificationService(notifier);

        // Act
        service.send("alice@example.com", "Hello!");

        // Assert
        verify(notifier).notify("alice@example.com", "Hello!");
        verifyNoMoreInteractions(notifier);
    }

    @Test
    void send_shouldNotCallNotifier_whenRecipientIsBlank() {
        // Arrange
        Notifier notifier = mock(Notifier.class);
        NotificationService service = new NotificationService(notifier);

        // Act
        assertThrows(IllegalArgumentException.class,
                () -> service.send("   ", "Hello"));

        // Assert
        verifyNoInteractions(notifier);
    }

    @Test
    void send_shouldBuildAndSendExpectedMessage() {
        // Arrange
        Notifier notifier = mock(Notifier.class);
        NotificationService service = new NotificationService(notifier);

        // Act
        service.send("alice@example.com", "Hello");

        // Assert
        ArgumentCaptor<String> recipientCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

        verify(notifier).notify(recipientCaptor.capture(), messageCaptor.capture());

        assertEquals("alice@example.com", recipientCaptor.getValue());
        assertTrue(messageCaptor.getValue().contains("Hello"));
    }
}
