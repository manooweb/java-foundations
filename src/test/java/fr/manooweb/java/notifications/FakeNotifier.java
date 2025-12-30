package fr.manooweb.java.notifications;

/**
 * Test implementation of Notifier.
 */
class FakeNotifier implements Notifier {

    String lastRecipient;
    String lastMessage;

    @Override
    public void notify(String recipient, String message) {
        this.lastRecipient = recipient;
        this.lastMessage = message;
    }
}
