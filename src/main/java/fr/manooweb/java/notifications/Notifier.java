package fr.manooweb.java.notifications;

/**
 * Defines a contract for sending notifications.
 */
public interface Notifier {

    /**
     * Sends a notification message.
     *
     * @param recipient the recipient identifier
     * @param message   the message to send
     */
    void notify(String recipient, String message);
}
