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
                Link link = new Link();

                ArrayList<Noda> noda_arr = new ArrayList<>();
                link.setWord(s[0]);
                //записываем все ноды
                for(int i = 1; i < s.length; i += 2){
                    Noda noda = new Noda();
                    noda.setWord(s[i]);
                    noda.setIterator(Integer.parseInt(s[i + 1]));
                    noda_arr.add(noda);
                }
                link.setNoda(noda_arr);
                MarkovChain.add(link);
            }

            //test
            for(int i = 0; i < MarkovChain.size(); i++){
                System.out.print(MarkovChain.get(i).getWord() + " : ");
                for(int j = 0; j < MarkovChain.get(i).getNoda().size(); j++){
                    System.out.print(MarkovChain.get(i).getNoda().get(j).getWord() + ", ");
                    System.out.print(MarkovChain.get(i).getNoda().get(j).getIterator() + " | ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        readFile();

    }

}
