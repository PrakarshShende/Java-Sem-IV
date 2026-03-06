class Product {
    String name;
    double price;

    Product(String n, double p) {
        name = n;
        price = p;
    }

    void displayProduct() {
        System.out.println("Product: " + name);
        System.out.println("Price: " + price);
    }
}

class Customer {
    String customerName;

    Customer(String n) {
        customerName = n;
    }

    void displayCustomer() {
        System.out.println("Customer Name: " + customerName);
    }
}

class Order {
    int quantity;
    double price;

    Order(int q, double p) {
        quantity = q;
        price = p;
    }

    double calculateTotal() {
        return quantity * price;
    }
}

public class Ecommerce {
    public static void main(String[] args) {

        Product p = new Product("Laptop", 50000);
        Customer c = new Customer("Rahul");
        Order o = new Order(2, 50000);

        p.displayProduct();
        c.displayCustomer();
        System.out.println("Total Order Cost: " + o.calculateTotal());
    }
}