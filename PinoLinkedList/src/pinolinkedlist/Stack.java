/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinolinkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Osku
 */
public class Stack {
    private List <ListItem> stack = new LinkedList();
    
    
    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData){
        ListItem item = new ListItem();
        item.setData(aData);
        stack.add(item);
    }
    // poista ja palauta alkio pinon huipulta, 
    // jos pino tyhjä palauta null
    public ListItem pop(){
        if(stack.size() > 0) {
            ListItem item = stack.get(0);
            stack.remove(0);
            return item;
        } else {
            return null;
        }
    }
    
    // tulosta pinon sisältö muuttamatta pinoa
    public void printItems() {
        Iterator iterator = stack.iterator();
        
        while(iterator.hasNext()) {
            ListItem item = (ListItem)iterator.next();
            System.out.println(item.getData());
        }
    }
    public int getSize() {
        return stack.size();
    }
    
}
