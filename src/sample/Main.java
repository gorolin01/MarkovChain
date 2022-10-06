package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public ArrayList<Link> MarkovChain = new ArrayList<>();

    //записывает свой опыт
    public void writeData(){

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("chain.txt"))){

            for(int i = 0; i < MarkovChain.size(); i++){
                fileWriter.write(MarkovChain.get(i).getWord() + " ");
                for(int j = 0; j < MarkovChain.get(i).getNoda().size(); j++){
                    fileWriter.write(MarkovChain.get(i).getNoda().get(j).getWord() + " ");
                    fileWriter.write(MarkovChain.get(i).getNoda().get(j).getIterator() + " ");
                }
                fileWriter.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    //считывает сырые данные
    public void readRawData(){

    }

    //считывает свой прошлый опыт
    public void readData(){

        try (BufferedReader fileReader = new BufferedReader(new FileReader("chain.txt"))){

            String line;

            while ((line = fileReader.readLine()) != null){
                String [] s = line.split(" ");
                ArrayList<Noda> noda_arr = new ArrayList<>();

                //записываем все ноды
                for(int i = 1; i < s.length; i += 2){
                    noda_arr.add(new Noda(s[i], Integer.parseInt(s[i + 1])));
                }

                MarkovChain.add(new Link(s[0], noda_arr));
            }

            //test
            printMarkovChain(MarkovChain);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void process(){

        try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))){

            String line;

            while ((line = fileReader.readLine()) != null){

                //нужно убрать лишние символы из строки!!!

                String [] s = line.split(" ");

                //нужно считывать текст для обучения по предложениям!!!
                //сырой текст нужно разбить на предложения

            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    //разбивает сырой текст на строки из предложений
    public void splitIntoSentences(){

        ArrayList<String> res = new ArrayList<>();

        //чтение
        try (BufferedReader fileReader = new BufferedReader(new FileReader("RawData.txt"))){

            String line;
            String incompleteSentence = "";

            while ((line = fileReader.readLine()) != null){

                int i = 0;

                for(i = 0; line.indexOf('.', i) != -1; i = line.indexOf('.', i) + 1){
                    res.add(incompleteSentence + line.substring(i, line.indexOf('.', i)));
                    incompleteSentence = "";
                }
                if(i < line.length()){
                    incompleteSentence += line.substring(i);
                }else{
                    if(incompleteSentence.length() > 0){
                        res.add(incompleteSentence);
                    }
                    incompleteSentence = "";
                }
                i = 0;

            }

        } catch (IOException e) {
            System.out.println(e);
        }

        //запись
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("data.txt"))){

            for(int i = 0; i < res.size(); i++){
                fileWriter.write(res.get(i));
                fileWriter.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
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

        //readData();
        //writeData();
        splitIntoSentences();

    }

}
