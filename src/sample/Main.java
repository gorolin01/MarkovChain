package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public ArrayList<Link> MarkovChain = new ArrayList<>();

    public void readFile(){

       /* try {
            List<String> a = Files.readAllLines(Paths.get(""));
        } catch (IOException e){}*/

        try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))){

            String line;

            while ((line = fileReader.readLine()) != null){
                //System.out.println(line);
                String [] s = line.split(" ");
                ArrayList<Noda> noda_arr = new ArrayList<>();

                //записываем все ноды
                for(int i = 1; i < s.length; i += 2){
                    noda_arr.add(new Noda(s[i], Integer.parseInt(s[i + 1])));
                }
                MarkovChain.add(new Link(s[0], noda_arr));
                //printLink(link);
                printMarkovChain(MarkovChain);
            }

            //test
            printMarkovChain(MarkovChain);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void printLink(Link link){

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

    public void printMarkovChain(ArrayList<Link> MarkovChain){

        System.out.println("----------------MarkovChain----------------");
        //System.out.println(MarkovChain.size());
        for(int i = 0; i < MarkovChain.size(); i++){
            //System.out.println(MarkovChain.get(i).getNoda().size());
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

    public void start() {

        readFile();

    }

}
