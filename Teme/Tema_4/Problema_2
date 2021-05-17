package lab_4;

import java.util.Arrays;
import java.util.Scanner;


public class Problema_2 {

    private int[] arr, arr_new;
    private int rand_int;
    private Scanner scan;

    Problema_2(){
        scan = new Scanner(System.in);
        arr = new int[10];
        arr_new = new int[arr.length];

        array(arr);
        addOnIndex(arr, arr_new);

       // scan.close();
    }

    private int[] array (int [] arr){

        System.out.println("Introduceti 10 elemente pentru sirul de numere: \n");
        try {
            for (int i = 0; i < arr.length; i++) {
                rand_int = scan.nextInt();
                arr[i] = rand_int;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Nu ati introdus un numar! Programul isi va incheia executia!");
            System.exit(1);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private int[] addOnIndex(int[] arr, int[] arr_new){
        System.out.println("Vreti sa stergeti un numar din sir: (DA sau NU)  ");
        scan.nextLine();
        String alegere;
        int index_ = 0;

        try {
            alegere = scan.nextLine();

            if (alegere.compareToIgnoreCase("nu") == 0) {

                for (int i = 0; i < arr.length; i++) {
                    arr_new[i] = arr[i];
                }

                System.out.println(Arrays.toString(arr));
                System.out.println();
                return arr;
            } else if (alegere.compareToIgnoreCase("da") == 0) {

                System.out.println("De pe ce pozitie doriti sa stergeti numarul? ");
                try {
                    index_ = scan.nextInt();
                }   catch (java.util.InputMismatchException e) {
                    System.out.println("Ati introdus o litera sau un numar care depaseste lungimea sirului. " +
                                        "Programul isi va termina executia!");
                }

                for (int i = 0; i < index_; i++) {
                    arr_new[i] = arr[i];
                }

                for (int i = index_ + 1; i < arr_new.length; i++) {
                    arr_new[i - 1] = arr[i];
                }
                scan.nextLine();

            } else {
                System.out.println("Nu ati raspuns cu DA sau NU!");
                System.exit(1);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Nu ati raspuns cu DA sau NU!");
            System.exit(1);
        }

        System.out.println(Arrays.toString(arr_new));
        System.out.println();
        return arr_new;
    }

    private void addOn (int p) {
        System.out.println("Va rugam introduceti numarul: ");
        arr_new[p] = scan.nextInt();
        scan.nextLine();
        recursive(p);
    }

    private int[] recursive (int index) {
        System.out.println("Doriti sa introduceti alt numar? (DA sau NU)  ");

        String alegere_noua;
        alegere_noua = scan.nextLine();

        if (alegere_noua.compareToIgnoreCase("nu") == 0) {
            return arr_new;
        }

        if (alegere_noua.compareToIgnoreCase("da") == 0) {

            addOn(index);
        }
        return arr_new;
    }
}
