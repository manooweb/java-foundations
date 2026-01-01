package fr.manooweb.java.notifications;

/**
 * Service responsible for sending notifications.
 */
public class NotificationService {

    private final Notifier notifier;

    /**
     * Creates a notification service using the given notifier.
     */
    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String recipient, String message) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient must not be blank");
        }

        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message must not be blank");
        }

        notifier.notify(recipient, message);
    }
}
