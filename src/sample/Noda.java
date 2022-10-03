package sample;

public class Noda {

    private static String word;
    private static int iterator;

    public static void setIterator(int iterator) {
        Noda.iterator = iterator;
    }

    public static void setWord(String word) {
        Noda.word = word;
    }

    public static int getIterator() {
        return iterator;
    }

    public static String getWord() {
        return word;
    }

}
