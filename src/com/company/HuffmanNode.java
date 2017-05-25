package com.company;

/**
 * Węzeł znaku
 */
public class HuffmanNode
            implements Comparable<HuffmanNode>
{
    private int weight;
    private String token;
    private HuffmanNode left;
    private HuffmanNode right;
//Constructor
    HuffmanNode(int weight,String token){
        this.weight=weight;
        this.token=token;
        left=null;
        right=null;
    }

/**Getters*/
    int getWeight() {
        return weight;
    }

    String getToken() {
        return token;
    }

    HuffmanNode getLeft(){
        return left;
    }

    HuffmanNode getRight(){
        return right;
    }

/**Setters*/
    void setLeft(HuffmanNode left){
        this.left=left;
    }

    void setRight(HuffmanNode right){
        this.right=right;
    }




    @Override
    public int compareTo(HuffmanNode o) {
        if (weight>o.getWeight()) return 1;
        if (weight<o.getWeight()) return -1;
        return token.compareTo(o.getToken());
    }

    @Override
    public String toString() {
        return "Waga: "+weight+" Symbol: "+token;
    }

    boolean isLeaf(){
        return (left==null && right==null);
    }
}
