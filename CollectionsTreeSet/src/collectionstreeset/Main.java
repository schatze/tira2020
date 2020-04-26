/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionstreeset;

/**
 *
 * @author Osku
 */
public class Main {
        private static BinääriPuuTreeSet tree = new BinääriPuuTreeSet();

//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select, select1;
                int luku = 0;
                do {

                        System.out.println("\n\t\t\t1. Lisää solmu.");
                        System.out.println("\t\t\t2. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t3. Etsi solmu ");
                        System.out.println("\t\t\t4. Poista solmu ");
                        System.out.println("\t\t\t5. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna juuren sisältö (int)");
                            luku = Lue.kluku();
                            if(tree.addValue(luku))
                                System.out.println("Lisätty luku " + luku);
                            break;
                        case '2':
                            System.out.println("Puun sisältö esijärjestyksessä: ");
                            tree.printValues();
                            break;
                        case '3':
                            System.out.println("Anna etsittävän juuren sisältö (int)");
                            luku = Lue.kluku();
                            if(tree.searchValue(luku))
                                System.out.println("Puusta löytyi luku " + luku);
                            else
                                System.out.println("Puusta ei löytynyt lukua " + luku);
                            break;
                        
                        case '4':
                            System.out.println("Anna poistettavan juuren sisältö (int)");
                            luku = Lue.kluku();
                            if(tree.removeValue(luku))
                                System.out.println("Puusta poistettu luku " + luku);
                            else
                                System.out.println("Puusta ei poistettu lukua " + luku);
                            break;
                        
                        case '5':
                            
                            break;
                            
                        }
                }
                while (select != '5');
        }
//printMenu loppuu ----------------------------------------------------------------
}
