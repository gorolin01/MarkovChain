package sample;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Link> MarkovChain = new ArrayList<>();

    public static void readFile(){

        try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))){

            String line;
            while ((line = fileReader.readLine()) != null){
                //System.out.println(line);
                String [] s = line.split(" ");
                MarkovChain.add(Link.setWord(s[0]));
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        readFile();

    }

}
