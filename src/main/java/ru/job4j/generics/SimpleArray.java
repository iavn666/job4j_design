package ru.job4j.generics;


import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int count = 0;

    public SimpleArray[] myArray = new SimpleArray[10];

    public void add(T model) {
        myArray[count++] = (SimpleArray) model;
    }


    public void set(int index, T model) {
        myArray[index] = (SimpleArray) model;
    }

    public void remove(int index) {
        SimpleArray[] result = new SimpleArray[myArray.length - 1];
        System.arraycopy(myArray, index + 1, result, index, myArray.length - 1);
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

    @Override
    public Iterator<T> iterator() {
        Iterator<T> num = new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return count< myArray.length;
            }

            @Override
            public T next() {
                return (T) myArray[count++];
            }

        };
        return num;
    }


}