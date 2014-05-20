/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plura;

import com.rits.cloning.Cloner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Kandit
 */


class Elem {

    Class type;
    Object val;

    public Elem(Object val) {
        this.val = val;
        this.type = val.getClass();
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Elem == false) || (((Elem) o).val.getClass() != this.type)) {
            return false;
        }
        return val.equals(o);

    }

    @Override
    public int hashCode() {
        return this.val.hashCode();

    }

    @Override
    public String toString() {
        return this.val.toString();
    }

}

abstract class Plurality implements Iterable<Elem> {

    Collection<Elem> storage;

    abstract boolean isEmpty();

    abstract boolean add(Elem el);

    abstract boolean contains(Elem el);

    abstract boolean containsAll(Plurality pl);

    abstract Collection<String> printAll();

    abstract Plurality join(Plurality l);

    abstract Plurality intersection(Plurality l);
}

class arrayBasedPlur extends Plurality {

    arrayBasedPlur() {
        storage = new ArrayList<Elem>();

    }

    @Override
    boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    boolean add(Elem el) {
        if (storage.contains(el)) {
            return false;
        }
        storage.add(el);
        return true;
    }

    @Override
    boolean contains(Elem el) {
        return storage.contains(el);
    }

    @Override
    boolean containsAll(Plurality pl) {
        for (Object el : pl) {
            if (!this.contains((Elem) el)) {
                return false;
            }
        }
        return true;
    }

    @Override
    Collection<String> printAll() {
        ArrayList<String> sl = new ArrayList();
        storage.stream().forEach((el) -> {
            sl.add(el.toString());
        });
        return sl;
    }

    @Override
    public Iterator<Elem> iterator() {
        return storage.iterator();
    }

    @Override
    Plurality join(Plurality l) {
        Cloner cloner = new Cloner();
        Plurality res = cloner.deepClone(this);
        for (Elem el : l) {
            res.add(el);
        }
        return res;
    }

    @Override
    Plurality intersection(Plurality l) {
        Plurality plur = new arrayBasedPlur();
        for (Elem el : l) {
            if(this.contains(el)){
                plur.add(el);
            }
        }
        return plur;
    }

    // Deep clone member fields here
}

