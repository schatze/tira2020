/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcapivertailu;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Osku
 */
public class BinääriPuuTreeSet {

    private Set<Integer> tree = new TreeSet();

    public boolean addValue(int value) {
        if (tree.add(value)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchValue(int value) {
        if (tree.contains(value)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removeValue(int value) {
        if (searchValue(value)) {
            tree.remove(value);
            return true;
        } else {
            return false;
        }
    }

    public void printValues() {
        Iterator<Integer> it = tree.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
