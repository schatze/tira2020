/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binäärihaku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Osku
 */
public class LajiteltuLista {

    private List<Integer> lista = new ArrayList();

    public void addValue(int arvo) {
        if (lista.size() == 0) {
            //System.out.println("Lista oli tyhjä lisätty arvo " + arvo + "indeksiin 0.");
            lista.add(arvo);
            return;
        }

        if (lista.size() == 1) {
            if (arvo < lista.get(0)) {
                lista.add(0, arvo);
                //System.out.println("Listassa oli 1 arvo. Lisätty arvo " + arvo + "indeksiin 0.");
                return;
            } else {
                lista.add(arvo);
                //System.out.println("Listassa oli 1 arvo. Lisätty arvo " + arvo + "indeksiin 1.");
                return;
            }
        }

        if (lista.size() == 2) {
            if (arvo < lista.get(0)) {
                lista.add(0, arvo);
                //System.out.println("Listassa oli 2 arvoa. Lisätty arvo " + arvo + "indeksiin 0.");
                return;
            } else if (arvo < lista.get(1) && arvo > lista.get(0)) {
                lista.add(1, arvo);
                //System.out.println("Listassa oli 2 arvoa. Lisätty arvo " + arvo + "indeksiin 1.");
                return;
            } else {
                lista.add(arvo);
                //System.out.println("Listassa oli 2 arvoa. Lisätty arvo " + arvo + "indeksiin 2.");
                return;
            }
        }

        int alku = 0;
        int loppu = lista.size() - 1;
        int keski = (alku + loppu) / 2;
        //System.out.println("Keskikohta on " + keski);

        while (alku <= loppu) {  // etsi oikea paikka lisättävälle alkiolle
            keski = (alku + loppu) / 2;
            if (lista.get(keski) == arvo) {
                lista.add(keski, arvo);
                //System.out.println("Listassa oli " + lista.size() + " arvoa. Lisätty arvo " + arvo + "indeksiin " + keski);
                return;
            } else if (lista.get(keski) > arvo) {
                loppu = keski - 1;
            } else {
                alku = keski + 1;
            }
        }

        //System.out.println("Päästiin loppuun indeksi on " + alku + " ja siihen lisättiin arvo " + arvo);
        lista.add(alku, arvo);

    }

    public int searchValue(int arvo) {
        int alku = 0, iteraatiot = 0;
        int loppu = lista.size() - 1;
        int keski = (alku + loppu) / 2;

        while (alku <= loppu) {  // etsi oikea paikka lisättävälle alkiolle
            iteraatiot++;
            keski = (alku + loppu) / 2;
            if (lista.get(keski) == arvo) {
                System.out.println("Arvo " + arvo + " löytyi. Hakuun meni " + iteraatiot + " iteraatiota.");
                return lista.get(keski);
            } else if (lista.get(keski) > arvo) {
                loppu = keski - 1;
            } else {
                alku = keski + 1;
            }
        }

        System.out.println("Arvoa " + arvo + " ei löytynyt listasta.");
        return -1;  // ei löytynyt
    }

    public int getValue(int index) {
        return lista.get(index);
    }

    public void tulostaArvot() {
        for (Integer i : lista) {
            System.out.print(i + " ");
        }
    }
    
    public int getSize() {
        return lista.size();
    }
}
