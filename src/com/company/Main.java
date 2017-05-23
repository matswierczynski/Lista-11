package com.company;

public class Main {

    public static void main(String[] args) {
        HuffmanCode huffmanCode= new HuffmanCode("C:/Users/Mati/Desktop/lista11.txt");
        huffmanCode.readFromFile();
        huffmanCode.printFromRoot();
        //System.out.println(huffmanCode.toString());
    }
}
