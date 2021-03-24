package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        if(model != null) {
            mem.add(model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        T find = findById(id);
        mem.remove(find);
        mem.add(model);
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).equals(model)) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = true;
        T find = findById(id);
        mem.remove(find);
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).equals(find)) {
                res = false;
            }
        }

        return res;
    }

    @Override
    public T findById(String id) {
        T res = null;
        for (int index = 0; index < mem.size(); index++) {
        if (mem.get(index).equals(id)) {
            res = mem.get(index);
            break;
        }
    }
        return res;
    }


}