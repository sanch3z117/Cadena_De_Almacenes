package co.edu.uptc.model;

import java.util.Iterator;

import co.edu.uptc.model.structures.MyList;

public class WerehouseChain {

    private MyList<Werehouse> werehouses;

    public WerehouseChain() {
        werehouses = new MyList<>();
    }

    public boolean registeWerehouse(Werehouse werehouse) {
        return werehouses.add(werehouse);
    }

    public float totalInventoryValueChain() {
        Iterator<Werehouse> it = werehouses.iterator();
        float value = 0;
        while (it.hasNext()) {
            value = it.next().totalInventoryValue();
        }
        return value;
    }

    public Werehouse searchWerehouse(String name) {
        Iterator<Werehouse> it = werehouses.iterator();
        while (it.hasNext()) {
            Werehouse werehouse = it.next();
            if (werehouse.getName().equals(name)) {
                return werehouse;
            }
        }
        return null;
    }

    public String showWerehouses() {
        Iterator<Werehouse> it = werehouses.iterator();
        String message = "";
        while (it.hasNext()) {
            message += it.next().toString() + "\n";
        }
        return message;
    }
}
