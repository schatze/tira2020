/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jono;

/**
 *
 * @author Osku
 */
public class ListItem {
    private String data;
    private ListItem next;
    private ListItem last;

    public ListItem getLast() {
        return last;
    }

    public void setLast(ListItem last) {
        this.last = last;
    }

    public ListItem() {
        next = null;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
    
    
}
