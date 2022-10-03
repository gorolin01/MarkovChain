package sample;

import java.util.ArrayList;

// звено цепи
public class Link {

    private static String word;
    private static ArrayList<Noda> noda = new ArrayList<>();

    public static void setWord(String word) {
        Link.word = word;
    }

    public static void setNoda(ArrayList<Noda> noda) {
        Link.noda = noda;
    }

    public static String getWord() {
        return word;
    }

    public static ArrayList<Noda> getNoda() {
        return noda;
    }

}
