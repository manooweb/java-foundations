package fr.manooweb.java.notifications;

/**
 * Simple notifier that writes messages to the console.
 */
public class ConsoleNotifier implements Notifier {

    @Override
    public void notify(String recipient, String message) {
        System.out.println("Sending message to " + recipient + ": " + message);
    }
}
