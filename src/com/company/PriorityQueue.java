package com.company;

/**
 * Priority Queue based on minimum heap
 */
public class PriorityQueue<Key extends Comparable<Key>>
        extends Heap<Key> {

    //Constructors
    PriorityQueue(){
        super();
    }

    PriorityQueue(Key [] array){
        super(array);
    }
    /**public methods*/

    Key minimum(){
        return getElement(0);
    }

    Key extractMinimum(){
        return delete(0);
    }
}
