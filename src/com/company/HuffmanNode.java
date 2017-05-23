package com.company;

/**
 * Created by Mati on 2017-05-23.
 */
public class HuffmanNode
            implements Comparable<HuffmanNode>
{
    private int weight;
    private String token;
//Constructor
    HuffmanNode(int weight,String token){
        this.weight=weight;
        this.token=token;
    }

/**Getters*/
    int getWeight() {
        return weight;
    }

    String getToken() {
        return token;
    }





    @Override
    public int compareTo(HuffmanNode o) {
        if (weight>o.getWeight()) return 1;
        return weight<o.getWeight() ? -1: 0;
    }

    @Override
    public String toString() {
        return "Waga: "+weight+" Symbol: "+token;
    }
}
