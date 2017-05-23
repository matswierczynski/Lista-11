package com.company;

public class Main {

    public static void main(String[] args) {
    Integer [] array ={4,1,3,2,16,9,10,14,8,7};
    Heap<Integer> integerHeap = new Heap<>(array);
    System.out.println(integerHeap.toString());
    }
}
