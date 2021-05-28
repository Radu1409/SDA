package lab5;

import java.util.*;

public class Main {

    private static HashMap<String, StudentDetails> hsmp;
    private static LinkedHashMap<String, StudentDetails> linkhsmp;
    private static Scanner scan;
    private static long CNP;

    private static String[] lastNames;
    private static String[] firstNames;
    private static String[] cnp;


    public static void main(String[] args) {

        scan = new Scanner(System.in);
        hsmp = new HashMap<>();
        linkhsmp = new LinkedHashMap<>();
        lastNames = new String[]{"Mihai", "George", "Mihai", "Alexandra",
                "Radu", "Paul", "Cristi", "Adrian", "Raul", "Claudiu"};

        firstNames = new String[]{"Bobes", "Prundar", "Gaitan", "Olaru",
                "Pestrea", "Popica", "Bularca", "Banciu", "Ungureanu", "Munteanu"};

        cnp = new String[]{"1911211234143", "1980909021746", "1930403211021", "1961016252414", "2900813058398",
                "1900909226052", "2910124459268", "2940930109397", "2861106196284", "2991114516015"};

        insertStudents_HashMap(10);
        checkValidate();
        afisareStudenti_HashMap();
        insertStudents_LinkedHashMap(10);
        afisareStudenti_LinkedHashMap();
        insertSameCNP();
    }

    private static HashMap<String, StudentDetails> insertStudents_HashMap(int num) {

        for (int i = 0; i < num; i++) {
            hsmp.put(cnp[i], new StudentDetails(firstNames[i], lastNames[i],

                    new ArrayList<Double>(Arrays.asList(
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))))),

                    new ArrayList<Double>(Arrays.asList(
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0))))))));
        }
        return hsmp;
    }

    private static LinkedHashMap<String, StudentDetails> insertStudents_LinkedHashMap(int num) {

        for (int i = 0; i < num; i++) {
            linkhsmp.put(cnp[i], new StudentDetails(firstNames[i], lastNames[i],

                    new ArrayList<Double>(Arrays.asList(
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))))),

                    new ArrayList<Double>(Arrays.asList(
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                            Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0))))))));
        }
        return linkhsmp;
    }

    private static boolean checkValidate() {

        System.out.println("Va rugam sa introduceti CNP-ul unui student: ");

        try {
            CNP = scan.nextLong();
            if (Integer.parseInt(String.valueOf(Long.toString(CNP).charAt(0))) != 1 &&
                    Integer.parseInt(String.valueOf(Long.toString(CNP).charAt(0))) != 2) {
                System.out.println("CNP Invalid!!");
                return false;
            }
            if (Long.toString(CNP).length() != 13) {
                System.out.println("CNP Invalid!");
                return false;
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("CNP Invalid! Ati introdus un caracter ce nu reprezinta un numar!");
            System.exit(1);
        }

        String cnpStr = Long.toString(CNP);

        if (cnpStr.matches("^[1-9]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)(00[1-9]|0[1-9]\\d|[1-9]\\d\\d)\\d$")) {
            System.out.println("CNP-ul este valid!\n");
        } else {
            System.out.println("CNP Invalid!");
            return false;
        }

        for (int i = 0; i < cnp.length; i++) {
            if (cnp[i].equals(cnpStr)) {
                System.out.println();
                StudentDetails std = hsmp.get(cnp[i]);
                System.out.println("Studentul cu CNP-ul " + cnp[i] + " este: \n");
                std.checkStudent();

                return true;
            }
        }
        System.out.println("CNP-ul nu a fost identificat in lista!\n");
        return false;
    }

    private static void afisareStudenti_HashMap() {

        System.out.println("CNP-urile studentilor din lista HashMap: \n");

        for (Map.Entry<String, StudentDetails> val : hsmp.entrySet()) {
            System.out.println("CNP student: " + val.getKey());
        }
        System.out.println("\nOrdinea de intrare NU este aceeasi cu ordinea de iesire!\n");
    }

    private static void afisareStudenti_LinkedHashMap() {

        System.out.println("CNP-urile studentilor din lista LinkedHashMap: \n");

        for (Map.Entry<String, StudentDetails> val : linkhsmp.entrySet()) {
            System.out.println("CNP student: " + val.getKey());
        }
        System.out.println("\nOrdinea de intrare ESTE aceeasi cu ordinea de iesire!\n");
    }

    private static void insertSameCNP() {

        System.out.println("Introducem acelasi CNP! (De pe pozitia 0, si anume " + cnp[0] + "):\n");
        hsmp.put(cnp[0], new StudentDetails("Andrei", "Boriceanu",

                new ArrayList<Double>(Arrays.asList(
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))))),

                new ArrayList<Double>(Arrays.asList(
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0)))),
                        Double.parseDouble(String.format("%.1f", 1.0 + (new Random().nextDouble() * (9.0 - 0.0))))))));

        StudentDetails std = hsmp.get(cnp[0]);
        System.out.println("Studentul cu CNP-ul " + cnp[0] + " este: \n");
        std.checkStudent();

        System.out.println("\nOdata ce introducem acelasi CNP in HashMap, valoarea acestuia se modifica!\n");
    }
}
