package com.company;

import sun.awt.image.ImageWatched;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Mati on 2017-05-23.
 */
public class HuffmanCode {
    private String path;
    private PriorityQueue<HuffmanNode> priorityQueue;
    TreeMap<String,Integer> tokens;
    HuffmanCode(String path) {
        this.path = path;
        priorityQueue = new PriorityQueue<>();
        tokens= new TreeMap<>();
    }

    void readFromFile(){

        try {
            Scanner scan = new Scanner(new File(path));
            while(scan.hasNextLine()){
                splitToSubstring(scan.nextLine());
            }
            createPriorityQueue();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        }
    }

    private void splitToSubstring(String fileLine){
        Queue<String> lineTokens = new LinkedList<>();
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

    private void createPriorityQueue(){
        while(tokens.size()>0){
            String key=tokens.lastKey();
            Integer value=tokens.get(key);
            tokens.remove(key);
            priorityQueue.insert(new HuffmanNode(value,key));
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
