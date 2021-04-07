package pachet;

import java.util.ArrayList;
import java.util.List;

public class Pacienti {
    private List<Double> temp;

    Pacienti(List<Double> c) {

        temp = new ArrayList<Double>();
        temp.addAll(c);
        System.out.println("Temperaturile pacientilor sunt: \n" + temp + "\n");
        temp_norm(temp);
        temp_anorm(temp);

    }
    private void temp_norm (List<Double> temp_n) {
        temp_n = new ArrayList<Double>();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) <= 37.0 ) {
                temp_n.add(temp.get(i));
            }

        }
        System.out.println("Temperaturile normale sunt: " + temp_n + "\n");

        for (int i = 0; i < temp_n.size(); i++) {

            System.out.println("id - " + i + ", temperatura - " + temp_n.get(i));
        }
        System.out.println();

    }

    private void temp_anorm (List<Double> temp_an) {
        temp_an = new ArrayList<Double>();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) > 37.0 ) {
                temp_an.add(temp.get(i));
            }

        }
        System.out.println("Temperaturile anormale sunt: " + temp_an + "\n");

        for (int i = 0; i < temp_an.size(); i++) {

            System.out.println("id - " + i + ", temperatura - " + temp_an.get(i));
        }
        System.out.println();
    }
}
