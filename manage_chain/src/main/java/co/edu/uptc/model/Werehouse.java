package co.edu.uptc.model;

import java.util.Iterator;

import co.edu.uptc.model.structures.MyList;

public class Werehouse {

    private String name;
    private String address;

    private MyList<Product> products;

    public Werehouse(String name, String address) {
        this.name = name;
        this.address = address;
        products = new MyList<>();
    }

    public boolean registerProduct(Product product) {
        return products.add(product);
    }

    public Product showProduct(int code) {
        Iterator<Product> it = products.iterator();
        Product aux = it.next();
        while (it.hasNext()) {
            if (aux.getCode() == code) {
                return aux;
            }
        }
        return null;
    }

    public int countDifferentProducts() {
        Iterator<Product> it = products.iterator();
        int count = 0;
        while (it.hasNext()) {
            count = it.next().getAmount();
        }
        return count;
    }

    public float totalInventoryValue() {
        Iterator<Product> it = products.iterator();
        Product aux = it.next();
        float value = 0;
        while (it.hasNext()) {
            value = aux.getAmount() * aux.getUnitValue();
        }
        return value;
    }

    public void registerSale(int code, int amount) {
        Product aux = showProduct(code);
        aux.updateQuantity(amount);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    

    @Override
    public String toString() {
        Iterator<Product> it = products.iterator();
        String message = "Bodega: " + name + " Direccion: " + address + "\n";
        while (it.hasNext()) {
            message += it.next().toString() + "\n";
        }
        return message;
    }

}
