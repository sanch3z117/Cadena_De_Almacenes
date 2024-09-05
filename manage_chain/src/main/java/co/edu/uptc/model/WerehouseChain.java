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
        Werehouse aux = it.next();
        float value = 0;
        while (it.hasNext()) {
            value = aux.totalInventoryValue();
        }
        return value;
    }

    public Werehouse searchWerehouse(String name) {
        Iterator<Werehouse> it = werehouses.iterator();
        Werehouse aux = it.next();
        while (it.hasNext()) {
            if (aux.getName().equals(name)) {
                return aux;
            }
        }
        return null;
    }
}
