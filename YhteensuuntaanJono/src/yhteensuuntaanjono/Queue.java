/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yhteensuuntaanjono;

/**
 *
 * @author Osku
 */
public class Queue {
    private ListItem top;
    private int size;
    
    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData){
        if(top == null) {
            top = new ListItem();
            top.setData(aData);
            size++;
        } else {
            ListItem item = new ListItem();
            item.setData(aData);
            item.setNext(top);
            top = item;
            size++;
        }
    }
    // poista ja palauta alkio jonon perältä
    // jos jono tyhjä palauta null
    public ListItem pop(){
        if(top == null)
            return null;
        
        ListItem iterator = top;
        ListItem lastIterator = top;
        while(iterator.getNext() != null) {
            lastIterator = iterator;
            iterator = iterator.getNext();
        }
        
        lastIterator.setNext(null);
        size--;
        if(size==0) {
            top = null;
        }
        return iterator;
    }
    
    // tulosta jonon sisältö muuttamatta pinoa
    public void printItems() {
        ListItem iterator = top;
        while(iterator != null) {
            System.out.println(iterator.getData());
            iterator = iterator.getNext();
        }
    }
    public int getSize() {
        return size;
    }
    
}
