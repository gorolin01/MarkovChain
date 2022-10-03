package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static ArrayList<Link> MarkovChain = new ArrayList<>();

    public static void readFile(){

       /* try {
            List<String> a = Files.readAllLines(Paths.get(""));
        } catch (IOException e){}*/

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
                printLink(link);
                printMarkovChain(MarkovChain);
            }

            //test
            printMarkovChain(MarkovChain);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void printLink(Link link){

        System.out.println("-------------------Link-------------------");
        System.out.print(link.getWord() + " : ");
        for(int i = 0; i < link.getNoda().size(); i++){
            System.out.print(link.getNoda().get(i).getWord() + ", ");
            System.out.print(link.getNoda().get(i).getIterator() + " | ");
        }
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println();

    }

    public static void printMarkovChain(ArrayList<Link> MarkovChain){

        System.out.println("----------------MarkovChain----------------");
        for(int i = 0; i < MarkovChain.size(); i++){
            System.out.print(MarkovChain.get(i).getWord() + " : ");
            for(int j = 0; j < MarkovChain.get(i).getNoda().size(); j++){
                System.out.print(MarkovChain.get(i).getNoda().get(j).getWord() + ", ");
                System.out.print(MarkovChain.get(i).getNoda().get(j).getIterator() + " | ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
        System.out.println();

    }

    public static void main(String[] args) {

        readFile();

    }

}
