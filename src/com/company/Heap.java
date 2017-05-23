package com.company;

/**
 * Minimum heap
 */
public class Heap<Key extends Comparable<Key>>{
    private Object [] heapArray;
    private int size;
    Heap (){
        heapArray = new Object[100];
        size=0;
    }

    Heap (Key[] array){
        size=array.length;
        heapArray=array;
        for(int i=size/2;i>=0;i--)
            minHeapify(i);
    }

/**Heap functions */
    private void minHeapify(int index){
        int l = getLeft(index);
        int r = getRight(index);
        int minimum;
        if (l<size && getElement(l).compareTo(getElement(index))<0)
            minimum = l;
        else
            minimum = index;

        if (r<size && getElement(r).compareTo(getElement(minimum))<0)
            minimum=r;
        if (minimum!=index) {
            swap(index, minimum);
            minHeapify(minimum);
        }
    }

    private void swap(int x,int y){
        Key tmp = getElement(x);
        setElement(x,getElement(y));
        setElement(y,tmp);
    }

    private void heapDecreaseKey(int index, Key key){
        if (key.compareTo(getElement(index))>0)
            throw new IllegalArgumentException();
        setElement(index,key);
        while (index>1 && getElement(getParent(index)).compareTo(getElement(index))>=0) {
            swap(index, getParent(index));
            index=getParent(index);
        }
    }

    void insert(Key key){
        setElement(size++,key);
        heapDecreaseKey(size-1,key);
    }


/**Getters*/
    @SuppressWarnings("unchecked")
    private Key getElement(int index){
        return (Key) heapArray[index];
    }

    private int getParent(int index){
        return  (index-1)>>1;
    }

    private int getLeft(int index){
        return  (index<<1)+1;
    }

    private int getRight(int index){
        return (index<<1)+2;
    }

/**Setters*/
    private void setElement(int index, Key key){
        if (index>size)
            throw new IndexOutOfBoundsException();
        if (size>=heapArray.length){
            Object [] newArray = new Object[size+100];
            System.arraycopy(heapArray,0,newArray,0,size);
            heapArray=newArray;
        }
        heapArray[index]=key;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<size;i++){
            stringBuilder.append(getElement(i).toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
