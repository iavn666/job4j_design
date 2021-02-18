package ru.job4j.generics;


import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int count = 0;

    private T[] myArray = (T[]) new Object[10];

    public void add(T model) {
        myArray[count++] = model;
    }


    public void set(int index, T model) {
        Objects.checkIndex(index, myArray.length);
        myArray[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, myArray.length);
        T[] result = (T[]) new Object[myArray.length - 1];
        System.arraycopy(myArray, index + 1, result, index, myArray.length - 1);
    }

    public T get(int index) {
        Objects.checkIndex(index, myArray.length);
        T result = null;
        for (int i = 0; i <= myArray.length - 1; i++ ) {
            if (myArray[i] == myArray[index]) {
                result = myArray[i];
            }
        }
        return result;

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