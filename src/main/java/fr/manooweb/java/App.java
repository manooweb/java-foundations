package fr.manooweb.java;

/**
 * Hello world!
 *
 */
public class App {
    static String greeting() {
        return "Hello Java 21 👋";
    }

    static String greeting(String name) {
        return "Hello " + name + " 👋";
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(greeting());
            return;
        }

        System.out.println(greeting(args[0]));

    }
}
