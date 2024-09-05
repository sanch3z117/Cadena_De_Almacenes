package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Iterator;

public class WerehouseChain {

    private ArrayList<Werehouse> werehouses;

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
}
