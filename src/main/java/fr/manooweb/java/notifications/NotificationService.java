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
        notifier.notify(recipient, message);
    }
}
