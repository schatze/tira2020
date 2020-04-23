/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etsintäpuu;

/**
 *
 * @author Osku
 */
public class Main {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select, select1;
                BinaryTree tree = null, upDated = null;
                String data;
                do {

                        System.out.println("\n\t\t\t1. Luo juurisolmu.");
                        System.out.println("\t\t\t2. Päivitä uusi uusi solmu.");
                        System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t4. Lisää solmu ");
                        System.out.println("\t\t\t5. Etsi solmu ");
                        System.out.println("\t\t\t6. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna juuren sisältö (int)");
                            data = new String(Lue.rivi());
                            tree = new BinaryTree(data);
                            break;
                        case '2':
                            if (tree == null)
                                System.out.println("Et ole muodostanut juurisolmua.");
                            else {
                                System.out.println("Anna solmun sisältö (merkkijono)");
                                BinaryTree newTree = new BinaryTree(new String(Lue.rivi()));

                                tree.setNotFound();
                                tree.findWithPreOrder();
                                upDated = BinaryTree.getFound();
                                if (upDated==null) // ei valittu mitään
                                    break;
                                System.out.print("Kytke vasemmalle? (k/e)");
                                select1 = Lue.merkki();
                                if (select1=='k')
                                    upDated.setLeft(newTree);
                                else {
                                    System.out.print("Kytke oikealle? (k/e)");
                                    select1 = Lue.merkki();
                                    if (select1=='k')
                                        upDated.setRight(newTree);
                                }
                            }
                            break;
                        case '3':
                            if(tree == null) {
                                break;
                            }
                            System.out.println("Esijärjestyksessä:");
                            tree.preOrder();
                            
                            System.out.println("Paina enter jatkaaksesi");
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        
                        case '4':
                            System.out.println("Anna solmun sisältö (desimaali)");
                            
                            Node node = new Node(Lue.kluku());
                            if(tree == null) {
                                tree = new BinaryTree(node);
                            } else {
                                tree.addValue(node);
                            }
                            break;
                        
                        case '5':
                            if(tree == null)
                                break;
                            
                            System.out.println("Anna etsittävän solmun sisältö (desimaali)");
                            Node etsittynode = tree.findNodeByValue(Lue.kluku());
                            if(etsittynode != null)
                                System.out.println("Löytyi solmu arvolla " + etsittynode.getData() + ". Paina enter jatkaaksesi.");
                            else
                                System.out.println("Ei löytynyt arvoa. Paina enter jatkaaksesi.");
                            
                            Lue.merkki(); // pysäytetään kontrolli
                            break;
                            
                        case '6':
                            break;
                        }
                }
                while (select != '6');
        }
//printMenu loppuu ----------------------------------------------------------------
    
}
