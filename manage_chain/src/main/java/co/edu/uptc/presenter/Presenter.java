package co.edu.uptc.presenter;

import java.util.Iterator;

import co.edu.uptc.model.Product;
import co.edu.uptc.model.Werehouse;
import co.edu.uptc.model.WerehouseChain;
import co.edu.uptc.view.View;

public class Presenter {
    private WerehouseChain werehouseChain;
    private View view;

    public Presenter() {
        werehouseChain = new WerehouseChain();
        view = new View("Gestion de inventario");
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.start();
    }

    private void start() {
        while (true) {
            String[] options = { "1. Registrar bodega", "2. Registrar producto", "3. Consultar inventario",
                    "4. Consultar valor total del inventario", "5. Registrar venta", "6. mostrar todas las bodegas",
                    "7. Salir" };
            int option = view.optionMenu(options);
            switch (option) {
                case 1:
                    registerWerehouse();
                    break;
                case 2:
                    registerProduct();
                    break;
                case 3:
                    showInventory();
                    break;
                case 4:
                    showTotalInventoryValue();
                    break;
                case 5:
                    registerSale();
                    break;
                case 6:
                    showWerehouses();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    private void registerWerehouse() {
        String name = view.readInfo("Ingrese el nombre de la bodega");
        String address = view.readInfo("Ingrese la direccion de la bodega");
        werehouseChain.registeWerehouse(new Werehouse(name, address));
    }

    private void registerProduct() {
        String nameWerehouse = view.readInfo("Ingrese el nombre de la bodega donde quiere registrar el producto");
        Werehouse werehouse = werehouseChain.searchWerehouse(nameWerehouse);
        if (werehouse == null) {
            view.showMessage("La bodega no existe");
        } else {
            String name = view.readInfo("Ingrese el nombre del producto");
            int code = Integer.parseInt(view.readInfo("Ingrese el codigo del producto"));
            int amount = Integer.parseInt(view.readInfo("Ingrese la cantidad del producto"));
            float unitValue = Float.parseFloat(view.readInfo("Ingrese el valor unitario del producto"));
            werehouse.registerProduct(new Product(name, code, amount, unitValue));
        }
    }

    private void showInventory() {
        String name = view.readInfo("Ingrese el nombre de la bodega");
        Werehouse werehouse = werehouseChain.searchWerehouse(name);
        if (werehouse != null) {
            view.showMessage("La bodega " + name + " tiene " + werehouse.countDifferentProducts() + " productos"
                    + werehouse.toString());
        } else {
            view.showMessage("La bodega no existe");
        }
    }

    private void showTotalInventoryValue() {
        view.showMessage("El valor total del inventario es " + werehouseChain.totalInventoryValueChain());
    }

    private void registerSale() {
        String nameWerehouse = view.readInfo("Ingrese el nombre de la bodega donde quiere registrar la venta");
        Werehouse werehouse = werehouseChain.searchWerehouse(nameWerehouse);
        if (werehouse == null) {
            view.showMessage("La bodega no existe");

        } else {
            int code = Integer.parseInt(view.readInfo("Ingrese el codigo del producto"));
            int amount = Integer.parseInt(view.readInfo("Ingrese la cantidad del producto"));
            werehouse.registerSale(code, amount);
        }
    }

    private void showWerehouses() {
        view.showMessage(werehouseChain.showWerehouses());
    }
}
