package lab_4;

import java.util.Random;
import java.util.Scanner;

public class Problema_5 {

    private Scanner scan;
    private int[][] arr;
    private int column, row;

    Problema_5() {

        scan = new Scanner(System.in);

        try {
            System.out.println("Introduceti numarul de randuri: ");
            row = scan.nextInt();
            if (row <= 0) {
                System.out.println("Nu ati introdus un numar mai mare ca 0. Programul isi va termina executia.");
                System.exit(1);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Nu ati introdus un numar. Programul isi va termina executia.");
            System.exit(1);
        }

        try {
            System.out.println("Introduceti numarul de coloane: ");
            column = scan.nextInt();
            if (column <= 0) {
                System.out.println("Nu ati introdus un numar mai mare ca 0. Programul isi va termina executia.");
                System.exit(1);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Nu ati introdus un numar. Programul isi va termina executia.");
            System.exit(1);
        }

        arr = new int[row][column];

        System.out.println();

        createArray(row, column);
        modify(row, column);
        afisareArray(row, column);

        scan.close();
    }

    private void createArray(int rows, int columns) {

        System.out.println("Sirul bidimensional cu elemente aleatoare: \n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                arr[i][j] = new Random().nextInt(255);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void afisareArray(int rows, int columns) {

        System.out.println("Noul sir bidimensional este: \n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void modify(int rows, int columns) {

        int r = 0;
        int c = 0;

        int r_3 = 3;
        int c_3 = 3;

        int new_row = r_3;
        int new_col = c_3;

        int arithmetic = 0;
        int next_rows = 0;
        boolean checked = false;
        int count;

        System.out.println();

          while (!checked) {

            new_row = (new_row < rows) ? r_3 : arr.length;

            if (new_col < columns) { new_col = c_3; }
            else {
                new_col = arr[0].length;
                next_rows = 1;
            }

            count = 0;
            for (int i = r; i < new_row; i++) {
                for (int j = c; j < new_col; j++) {
                    System.out.print(arr[i][j] + " ");
                    arithmetic += arr[i][j];
                    count += 1;
                }
            }

            arithmetic = arithmetic / count;

            for (int i = r; i < new_row; i++) {
                for (int j = c; j < new_col; j++) {
                    arr[i][j] = arithmetic;
                }
            }

            arithmetic = 0;
            System.out.print(" | ");

            if (new_row == arr.length && new_col == arr[0].length) { checked = true; }

            c += 3;
            c_3 += 3;

            new_col = (new_col < columns) ? c_3 : arr[0].length;

            if (c >= new_col) { c = 0; }

            if (next_rows == 1) {
                r += 3;
                r_3 += 3;
                new_row = (new_row + 3 < rows) ? r_3 : arr.length;

                if (r >= new_row) { r = 0; }
                next_rows = 0;

                c = 0;
                c_3 = 3;
                new_col = 3;
            }
        }
        System.out.println("\n");
    }
}
