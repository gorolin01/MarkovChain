package sample;

import java.util.ArrayList;

// звено цепи
public class Link {

    private String word;
    private ArrayList<Noda> noda = new ArrayList<>();

    public Link(String word, ArrayList<Noda> noda){
        this.word = word;
        this.noda = noda;
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Noda> getNoda() {
        return noda;
    }

}
