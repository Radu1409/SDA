package pachet;


public class Customer {

    private Adress adress;
    private PaymentMethod pm;
    private String last_name;
    private String first_name;
    private int age;


    Customer(Adress adress, PaymentMethod pm, String last_name, String first_name, int age) {
        this.adress = adress;
        this.pm = pm;
        this.last_name = last_name;
        this.first_name = first_name;
        this.age = age;

    }

    public Adress getAdress() {
        return adress;
    }

    public PaymentMethod getPaymentMethod() {
        return pm;
    }

    public String getCompleteName() {
        System.out.println(first_name + " " + last_name);
        return first_name + " " + last_name;
    }
}

class Adress {
    private String street;
    private String city;
    private int number;

    Adress(String street, String city, int number) {

        this.street = street;
        this.city = city;
        this.number = number;
    }


    public String getFullAdress() {
        System.out.println(city + ", " + street + ", " + number);
        return city + ", " + street + ", " + ", " + number;
    }

}

class PaymentMethod {
    private String type;

    PaymentMethod(String type) {
        this.type = type;
    }

    public String getType() {
        System.out.println(type);
        return type;
    }


}
