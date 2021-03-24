package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var input1 = new Scanner(System.in);
        var input2 = new Scanner(System.in);

        System.out.println("\nIntroduceti primul numar intreg: ");
        int num_1 = input1.nextInt();

        System.out.println("\nIntroduceti al doilea numar intreg: ");
        int num_2 = input2.nextInt();

        int sum = Arrays.stream(new int[]{num_1, num_2}).sum();
        int dif = Arrays.stream(new int[]{num_1, num_2}).reduce((a, b) -> a - b).getAsInt();
        int product = Arrays.stream(new int[]{num_1, num_2}).reduce((a,b) -> a * b).getAsInt();
        double average = Arrays.stream(new int[]{num_1, num_2}).average().getAsDouble();

        int distanta = Math.max(num_1, num_2) - Math.min(num_1, num_2);
        int max = Arrays.stream(new int[]{num_1, num_2}).max().getAsInt();


        System.out.println("Suma celor doua numere este: " + sum);
        System.out.println("Diferenta celor doua numere este: " + dif);
        System.out.println("Produsul celor doua numere este: " + product);
        System.out.println("Media dintre cele doua numere este: " + average);

        System.out.println("\nDistanta intre cele doua numere este: " + distanta);
        System.out.println("Maximul dintre cele doua numere este: " + max);

    }
}
