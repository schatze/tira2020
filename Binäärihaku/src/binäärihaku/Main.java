/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binäärihaku;

import java.util.Random;

/**
 *
 * @author Osku
 */
public class Main {
    
    public static Random rand = new Random();

    public static void main(String[] args) {
        LajiteltuLista lista = new LajiteltuLista();
        
        for(int i = 0; i < 100000; ++i) {
            int lisättäväLuku = rand.nextInt(9999);
            //System.out.println("Lisätään luku " + lisättäväLuku);
            lista.addValue(lisättäväLuku);
            //lista.tulostaArvot();
            //Lue.merkki();
        }
        
        //System.out.println("Listassa ovat arvot:");
        //lista.tulostaArvot();
        
        System.out.println("Listassa on " + lista.getSize() + " alkiota. (välillä 0-9999)");
        
        for(int i = 0; i < 15; ++i) {
            int haettavaluku = rand.nextInt(9999);
            System.out.println("Haetaan luku " + haettavaluku);
            int indeksi = lista.searchValue(haettavaluku);
            if(indeksi != -1) {
                System.out.println("Luku löytyi indeksistä " + indeksi);
            }
        }
        
        int indeksi = lista.searchValue(55555); // Ei voi löytyä koska listan alkioiden maksimiarvo on 9999
        if(indeksi == -1) {
            System.out.println("Arvoa 55555 ei löytynyt.");
        } else {
            System.out.println("Arvo 55555 löytyi indeksistä " + indeksi);
        }
    }
    
}
