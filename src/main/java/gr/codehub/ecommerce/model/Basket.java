package gr.codehub.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private int id;
    private Customer customer;
    private List<Product> products = new ArrayList<>();
    private List<Double> discountRates = new ArrayList<>();
    private boolean discountApplied;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) throws Exception{
        if(product == null)
            throw new Exception("no product");
        if(product.getName() == null)
            throw new Exception("no product name");
        if( product.getName().equals("Chicklets"))
            throw new Exception("no Chicklets are permitted");
        products.add(product);
    }

    public void addDiscount(double rate){
        if (rate>=0 && rate<1. && discountRates.stream().reduce(0., (a,b)->a+b)<1)
                discountRates.add(rate);
    }



    public void removeProduct(int index){
        if (index>=0 && index < products.size())
            products.remove(index);
    }

    public void getProducts(){
        /*
        for(int i=0;i<products.size();i++)
            System.out.println(products.get(i));


        for(Product product:products)
            System.out.println(product);

        products.forEach((product -> System.out.println(product)));
       */
        products.forEach(System.out::println);
    }



    public double calculateTotal(){
       /* double total = 0;
        for(Product product:products)
            total += product.getPrice();
        return total;
        */
        return products
                .stream()
                .map(product -> product.getPrice())
                .reduce(0.0, (a,b)-> a+b);
    }

    public void applyDiscount(double rate){

  //      for(Product product:products)
   //         product.setPrice( product.getPrice()*(1-rate));
        if (!discountApplied) {
            products.forEach(product -> product.setPrice(product.getPrice() * (1 - rate)));
            discountApplied = true;
        }
    }

    public void applyDiscount() {
        if (!discountApplied) {
            final double rate =
                    discountRates.stream().reduce(0.0,(a,b) -> a+b)>1?
                            1.0: discountRates.stream().reduce(0.0,(a,b) -> a+b);
             products.forEach(product -> product.setPrice(product.getPrice() * (1 - rate)));
            discountApplied = true;
        }
    }

}
