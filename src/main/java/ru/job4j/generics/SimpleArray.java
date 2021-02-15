package ru.job4j.generics;


import java.util.ArrayList;
import java.util.Iterator;

public class SimpleArray<T> implements Iterator<T> {

    public SimpleArray[] myArray = new SimpleArray[10];

    public T add(T model) {
        SimpleArray[] result = new SimpleArray[10];
        for (int index = 0; index <= myArray.length - 1; index++) {
            if (myArray[index] == null) {
                myArray[index] = (SimpleArray) model;
            }
            result = myArray;

        }
        return (T) result;
    }

    public T set(int index, T model) {
        SimpleArray[] result = new SimpleArray[10];
        for (int i = 0; i <= myArray.length - 1; index++) {
            if(myArray[i] == myArray[index]) {
                myArray[i] = (SimpleArray) model;
            }
            result = myArray;
        }

        return (T) result;
    }

    public T remove(int index) {
        SimpleArray[] result = new SimpleArray[myArray.length - 1];
        System.arraycopy(myArray, index + 1, result, index, myArray.length - 1);
        return (T) result;
    }

    public T get(int index) {
        SimpleArray result = null;
        for (int i = 0; i <= myArray.length - 1; i++ ) {
            if (myArray[i] == myArray[index]) {
                result = myArray[i];
            }
        }
        return (T) result;

    }

    private int pos=0;


    @Override
    public boolean hasNext() {
           return myArray.length>pos;
    }

    @Override
    public T next() {
        return (T) myArray[pos++];
    }
}