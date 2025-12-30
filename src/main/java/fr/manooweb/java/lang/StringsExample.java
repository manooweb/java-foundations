package fr.manooweb.java.lang;

public class StringsExample {

    public static String concatWithString(String a, String b) {
        return a + b;
    }

    public static String concatWithStringBuilder(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        return sb.toString();
    }

    public static String multilineText() {
        return """
                Hello,
                This is a text block.
                Java 21 makes this easy.
                """;
    }
}
