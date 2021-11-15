package gr.codehub.ecommerce;

import gr.codehub.ecommerce.model.Basket;
import gr.codehub.ecommerce.model.Customer;
import gr.codehub.ecommerce.model.Product;

import java.util.Date;

public class MainApplication {
    private static final int ID = 2;
    private static final String NAME = "chips";
    private static final double PRICE = 5;

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer(1,
                "Thomas", "Diam", "Ath",
                new Date(100, 9, 1), 0);

        Product product = new Product(ID, NAME, PRICE);
        Product anotherProduct = new Product(ID + 1,
                NAME + " paprica", PRICE);
        Product thirdProduct = new Product(ID + 2,
                NAME + " salt", PRICE);

        Basket basket = new Basket();
        basket.setCustomer(customer);
        basket.setId(15);
        basket.addProduct(anotherProduct);
        basket.addProduct(thirdProduct);

        basket.getProducts();
        System.out.println( "Total cost= "+basket.calculateTotal());
        basket.applyDiscount(0.1);
        System.out.println( "Total cost= "+basket.calculateTotal());

    }

    private static void extracted() {
        boolean isActive = true;
        Boolean isA = isActive;
        byte myByte = 13;
        char a = 'A';
        Character a1 = a;
        short t = 12000;
        int x = 1;
        Integer i = x;
        long myLong = 32L;
        float f = 5.4e2F;
        double d = 4.6e-5;


        System.out.println("hello" + x);
    }
}
