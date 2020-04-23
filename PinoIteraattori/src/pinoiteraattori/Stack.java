/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinoiteraattori;

/**
 *
 * @author kamaj
 */
public class Stack {
        private ListItem[] stack;

        private int size;
        private final int MAX_SIZE = 1000;
        protected ListItem top;

        public Stack() {
                size = 0;
                stack = new ListItem[MAX_SIZE];
                top = stack[0];
        }
        //  palautetaan pino-iteraattori
        public StackIterator iterator() {
            return new StackIterator(this);
        }
        // muodostetaan uusi alkio ja viedään se huipulle
        public void push(String aData) {
                ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
                
                if(size == MAX_SIZE-1) {
                    System.out.println("Pino on täynnä.");
                    return;
                }
                
                newItem.setData(aData);
                stack[size] = newItem;
                
                if(size == 0) {
                    top = stack[0];
                } else {
                    stack[size-1].setLink(stack[size]);
                }
                
                size++;
                
        }
        // poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
        public ListItem pop() {
                ListItem takeAway;
                if (stack[0] == null) {
                        takeAway = null; // pino on tyhjä
                }
                else
                {
                        size--;
                        takeAway = stack[size];
                        stack[size] = null;
                        //top = top.getLink();
                }
                return takeAway;
        }
        // palautetaan pinottujen alkioiden lukumäärä
        public int getSize() {
                return size;
        }
        // listataan sisältö
        public void printItems() {
                for(int i = 0; i < size; ++i) {
                    System.out.println(stack[i]);
                }
        }
}

