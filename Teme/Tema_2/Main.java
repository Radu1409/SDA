package pachet;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        System.out.println("Problema 1:\n");

        viteza_drum_1("zona rezidentiala");
        viteza_drum_2("DrUm ExPREss");
        viteza_drum_3("Oras");

        System.out.println();

        System.out.println("Problema 2:\n");
        Pacienti p = new Pacienti(Arrays.asList(37.0, 35.2, 37.2, 38.9, 34.7, 37.1, 36.9));

        System.out.println("Problema 3:\n");

        Adress adress = new Adress("Principala", "Intorsura Buzaului", 227);
        PaymentMethod pm = new PaymentMethod("Ramburs");
        Customer c = new Customer(adress, pm, "Radu", "Purecel", 21);

        c.getCompleteName();
        c.getAdress().getFullAdress();
        c.getPaymentMethod().getType();


    }

    private static int viteza_drum_1(String drum) {

        if (drum.compareToIgnoreCase("oras") == 0) {
            System.out.println("Oras: " + 50);
            return 50;
        } else if (drum.compareToIgnoreCase("zona rezidentiala") == 0) {
            System.out.println("Zona Rezidentiala: " + 30);
            return 30;
        } else if (drum.compareToIgnoreCase("drum express") == 0) {
            System.out.println("Drum Express: " + 100);
            return 100;
        } else if (drum.compareToIgnoreCase("autostrada") == 0) {
            System.out.println("Autostrada: " + 130);
            return 130;

        }
        return 0;
    }

    private static int viteza_drum_2(String drum) {
        if (drum.compareToIgnoreCase("oras") == 0) {
            System.out.println("Oras: " + 50);
            return 50;
        }
        if (drum.compareToIgnoreCase("zona rezidentiala") == 0) {
            System.out.println("Zona Rezidentiala: " + 30);
            return 50;
        }
        if (drum.compareToIgnoreCase("drum express") == 0) {
            System.out.println("Drum Express: " + 100);
            return 50;
        }
        if (drum.compareToIgnoreCase("autostrada") == 0) {
            System.out.println("Autostrada: " + 130);
            return 50;
        }
        return 0;
    }

    private static int viteza_drum_3(String drum) {
        drum = drum.toLowerCase();
        switch (drum) {

            case "oras":
                System.out.println("Oras: " + 50);
                return 50;

            case "zona rezidentiala":
                System.out.println("Zona Rezidentiala: " + 30);
                return 30;

            case "drum express":
                System.out.println("Drum Express: " + 100);
                return 100;

            case "autostrada":
                System.out.println("Autostrada: " + 130);
                return 130;

            default:
                return 0;
        }
    }
}
