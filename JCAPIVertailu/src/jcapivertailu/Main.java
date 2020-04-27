/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcapivertailu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Osku
 */
public class Main {

    
    public static void main(String[] args) {
        final int LUVUT_MÄÄRÄ = 5000;
        
        BinääriPuuTreeSet jcapiTree = new BinääriPuuTreeSet();
        BinaryTree omaTree = new BinaryTree();
        
        Random rand = new Random();
        
        Set<Integer> luvutSet = new HashSet();      // Settiin ei mene duplikaatteja
        while(luvutSet.size() < LUVUT_MÄÄRÄ) {
            luvutSet.add(rand.nextInt(999999));
        }
        
        System.out.println("Generoitu " + LUVUT_MÄÄRÄ + " arvoa settiin.");
        
        // Laitan setin arvot arraylistiin jotta voin helposti järjestää ne suuruusjärjestykseen
        List<Integer> luvutList = new ArrayList();
        
        for(Integer i : luvutSet) {
            luvutList.add(i);
        }
        
        System.out.println("Luvut lisätty listaan.");
        Collections.sort(luvutList);
        System.out.println("Luvut jäjestetty");
        
        System.out.println("Lisätään luvut omaan binääripuuimplementaatioon.");
        long aloitusAika = System.currentTimeMillis();
        
        for(Integer i : luvutList) {
            Node node = new Node(i);
            omaTree.addValue(node);
        }
        
        long loppuAika = System.currentTimeMillis();
        System.out.println("Omaan binääripuuimplementaatioon lisäykseen meni " + (loppuAika - aloitusAika) + " ms");
        
        
        // JCAPI lisäys
        
        System.out.println("\n\nLisätään luvut jcapi binääripuuimplementaatioon.");
        aloitusAika = System.currentTimeMillis();
        for(Integer i : luvutList) {
            jcapiTree.addValue(i);
        }
        
        loppuAika = System.currentTimeMillis();
        System.out.println("JCAPI binääripuuimplementaatioon lisäykseen meni " + (loppuAika - aloitusAika) + " ms");
        
        System.out.println("\n\nHaetaan luvut järjestyksessä...\n\n");
        
        System.out.println("Haetaan luvut omasta binääripuuimplementaatioon.");
        aloitusAika = System.currentTimeMillis();
        for(Integer i : luvutList) {
            omaTree.findNodeByValue(i);
        }
        
        loppuAika = System.currentTimeMillis();
        System.out.println("Omasta binääripuuimplementaatioon hakemiseen meni " + (loppuAika - aloitusAika) + " ms");
        
        System.out.println("\n\nHaetaan luvut jcapi binääripuuimplementaatiosta.");
        aloitusAika = System.currentTimeMillis();
        for(Integer i : luvutList) {
            jcapiTree.searchValue(i);
        }
        
        loppuAika = System.currentTimeMillis();
        System.out.println("JCAPI binääripuuimplementaatioon hakemiseen meni " + (loppuAika - aloitusAika) + " ms");
    }
    
}
