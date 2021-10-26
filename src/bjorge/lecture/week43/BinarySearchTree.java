package bjorge.lecture.week43;

import org.w3c.dom.Node;

public class BinarySearchTree {
    class Node {
        Node parent;
        Node left_child;
        Node right_child;
        int value;

        /**
         * Lager en node med null som for
         * @param value
         */
        Node(int value){
            this.value = value;
            this.parent = null;
            this.left_child = null;
            this.right_child = null;
        }

        Node(int value, Node parent){
            this.value = value;
            this.parent = parent;
            this.left_child = null;
            this.right_child = null;
        }
        Node(int value, Node parent, Node left_child, Node right_child){
            this.value = value;
            this.parent = parent;
            this.left_child = left_child;
            this.right_child = right_child;
        }

        public void printPreorderRecursive() {
            System.out.print(this.value + ", ");
            if (left_child != null  ){
                left_child.printPreorderRecursive();
            }
            if (right_child != null){
                right_child.printPreorderRecursive();
            }
        }

    }
    /**
     * Binary search tree (BST)-klasse
     * om vårt søketre. Har også metoden BST
     */
    public static
    class BST {
        Node root;

        /**
         * Denne funksjonen søker etter veriene i sketreet,
         * men returenerer null om den ikkje finnes
         * @param value
         * @return
         */
        Node search(int value){
            Node p = root;

            // Inntil vi er utenfor treet, elelr har funnet venstere
            while (p != null || p.value == value){
                // Verdien er større enn p => gå til høyre
                if (value >= p.value){
                    p = p.right_child;
                }
                // veriden er mindre enn p => gå til venstre
                else if (value < p.value){
                    p = p.left_child;
                }
                // veriden er lik p => returnerer
                else {
                    break;
                }
            }
            return p;
        }
        /* Error i koden
        void insert(int value){
            // Treet vårt er tomt
            if (root == null){
                root = new Node(value);
                return;
            }
            else {
                // Initialiserer og setter noden
                Node p = root;
                Node q = null; // Parrent
                while (p != null){
                    q = p; // Oppdaterer at nåverende p blir nye q;
                    if (value >= p.value){
                        p = p.right_child;
                    } else {
                        p = p.left_child;
                    }
                }

                // Nå har vi funnet kor den nye noden skal ligge!
                // Nye noden skal vere høgre eller venstre barn av q.
                if (value >= q.value) {
                    q.right_child = new Node(value, q);
                }
                else {
                    q.left_child = new Node(value,  q);
                }
            }

        }

         */
    } // class BST
/*
    public static void main(String[] args) {

        BST tree = new BST();
        int[] values = {9, 7, 1, 3, 5, 11, 13, 10, 8};

        for (int i = 0; i< values.length; ++i){
            tree(values[i]);
            tree.print();
            System.out.println("");
        }


    }

 */


}
