package com.company;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Klasa tworząca kod Huffmana
 */
public class HuffmanCode {
    private String path;
    private PriorityQueue<HuffmanNode> priorityQueue;
    private TreeMap<String,Integer> tokens;
    private TreeMap<String,String> huffmanCodes;
    HuffmanCode(String path) {
        this.path = path;
        priorityQueue = new PriorityQueue<>();
        tokens= new TreeMap<>();
        huffmanCodes=new TreeMap<>();
    }

    void main(){
        readFromFile();
        createPriorityQueue();
        createHuffmannTree();
        createHuffmannCode();
        printHuffmanCode();
        decodeFile();
        try {
            Desktop.getDesktop().open(new File(path));
            Desktop.getDesktop().open(new File("C:/Users/Mati/Desktop/decoded.txt"));
        }catch (IOException e){e.printStackTrace();}
    }

/**Odczyt danych z pliku*/
    private void readFromFile(){

        try {
            Scanner scan = new Scanner(new File(path));
            while(scan.hasNextLine()){
                splitToSubstring(scan.nextLine());
            }
            scan.close();
            createPriorityQueue();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        }
    }
/**Podziel wczytaną linię tekstu na znaki*/
    private void splitToSubstring(String fileLine){
        String [] splittedLine = fileLine.split("");
        int weightNr=1;
        for (String x: splittedLine){
                Integer value=tokens.get(x);
                if (value!=null)
                tokens.put(x,value+1);
                else
                tokens.put(x,weightNr);
            }
        }
/**Tworzy kolejkę priotytetową na podstawie kluczy i częstości ich występowania*/
    private void createPriorityQueue(){
        while(tokens.size()>0){
            String key=tokens.lastKey();
            Integer value=tokens.get(key);
            tokens.remove(key);
            priorityQueue.insert(new HuffmanNode(value,key));
        }
    }
/**Tworzy drzewo z kodem Huffmanna*/
    private void createHuffmannTree(){
        while (priorityQueue.getSize()>1){
            HuffmanNode left=priorityQueue.extractMinimum();
            HuffmanNode right=priorityQueue.extractMinimum();
            HuffmanNode parent = new HuffmanNode(left.getWeight()+right.getWeight(),
                    "parent");
            parent.setLeft(left);
            parent.setRight(right);
            priorityQueue.insert(parent);
        }
    }

    private void createHuffmannCode(){
        if (priorityQueue.minimum()==null)
            throw new NoSuchElementException();
        String s = new String();
        recurrsiveHuffmannCode(priorityQueue.minimum(),s);
    }

    private void recurrsiveHuffmannCode(HuffmanNode root, String s){
        if(!root.isLeaf()){
            recurrsiveHuffmannCode(root.getLeft(),s+"0");
            recurrsiveHuffmannCode(root.getRight(),s+"1");
        }
        huffmanCodes.put(root.getToken(),s);
    }

    private void printHuffmanCode(){
        Set set = huffmanCodes.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            System.out.print(me.getKey()+" "+me.getValue()+"\n");
        }
    }

    private void decodeFile() {
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br = new BufferedReader(new FileReader(path));
            bw = new BufferedWriter(new FileWriter("C:/Users/Mati/Desktop/decoded.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split("");
                for (String x : splitted)
                    bw.write(huffmanCodes.get(x));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nie można otworzyć pliku");
            e.printStackTrace();
        } finally {
            try {
                if (br!=null)
                br.close();
                if (bw!=null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void printFromRoot(){
        while (priorityQueue.getSize()>0){
            System.out.println(priorityQueue.toString());
            priorityQueue.delete(0);
        }
    }


    @Override
    public String toString() {
        return priorityQueue.toString();
    }
}
