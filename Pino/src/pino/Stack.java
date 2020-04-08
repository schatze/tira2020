/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pino;

/**
 *
 * @author Osku
 */
public class Stack {
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
    // poista ja palauta alkio pinon huipulta, 
    // jos pino tyhjä palauta null
    public ListItem pop(){
        if(top == null)
            return null;
        
        ListItem item = top;
        top = top.getNext();
        return item;
    }
    // tulosta pinon sisältö muuttamatta pinoa
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
