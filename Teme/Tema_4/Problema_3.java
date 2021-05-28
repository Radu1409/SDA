package lab_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problema_3 {

    private int[] arr;
    private Random random;
    private Scanner scan;

    Problema_3() {

        scan = new Scanner(System.in);
        random = new Random();

        System.out.println("Cate elemente doriti sa aiba sirul de numere? ");
        try {
            arr = new int[scan.nextInt()];
        } catch (java.util.InputMismatchException e) {
            System.out.println("Nu ati introdus un numar sau ati introdus un numar egal cu 0. " +
                                "Programul isi va termina executia!");
            System.exit(1);
        }

        arraySort(arr);
        cautareBinara(arr, 7);

        //scan.close();
    }

    private void arraySort(int[] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = random.nextInt(8);

        }
        System.out.println("Elementele din sir sunt: " + Arrays.toString(arrays) + "\n");


        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                int temp = 0;
                if (arrays[i] > arrays[j]) {
                    temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        System.out.println("Elementele din sir sortate: " + Arrays.toString(arrays) + "\n");
    }

    private boolean cautareBinara(int[] array, int value) {

        int first = 0;
        int last = array.length - 1;
        int middle = (first + last) / 2;

        while (first <= last) {

            if (array[first] == value) {
                System.out.println("S-a gasit valoarea " + value + "!\n");
                return true;
            }
            if (array[last] == value) {
                System.out.println("S-a gasit valoarea " + value + "!\n");
                return true;
            }

            if (array[middle] < value) {
                first = middle + 1;
            } else if (array[middle] == value) {
                System.out.println("S-a gasit valoarea " + value + "!\n");
                return true;
            } else if (array[middle] > value) {
                last = middle - 1;
            }

            middle = (first + last) / 2;
        }
        System.out.println("Valoarea " + value + " nu a fost gasita!\n");
        return false;
    }
}
