/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparatorlambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Osku
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        
        Iterator itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("Järjestetään liput.");
        Collections.sort(cardUsers, Comparator.comparing(TrafficCard::getTravellerNumber));
        System.out.println("Järjestettynä:");
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("Järjestetään liput nimen mukaan");
        Collections.sort(cardUsers, Comparator.comparing(card -> card.getOwnerName()));
        System.out.println("Järjestettynä:");
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("Järjestetään liput saldon mukaan");
        Collections.sort(cardUsers, Comparator.comparing(card -> card.getBalance()));
        System.out.println("Järjestettynä:");
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
