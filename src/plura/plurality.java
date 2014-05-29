/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plura;

import com.rits.cloning.Cloner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

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
        if ((o instanceof Elem == false)
                || (((Elem) o).type != this.type)) {
            return false;
        } else {
        }
        return val.equals(((Elem) o).val);

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

    abstract boolean removeAll(Collection toRem);

    abstract boolean remove(Elem toRem);
}

class ListBasedPlur extends Plurality {

    ListBasedPlur() {
        storage = new ArrayList<>();

    }

    @Override
    boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    boolean remove(Elem el) {
        return storage.remove(el);
    }

    @Override
    boolean removeAll(Collection st) {
        return storage.removeAll(st);
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
        storage.stream().forEach(new Consumer<Elem>() {

            public void accept(Elem el) {
                sl.add(el.toString());
            }
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
        Plurality plur = new ListBasedPlur();
         Cloner cloner = new Cloner();
        for (Elem el : l) {
            if (this.contains(el)) {
                plur.add(cloner.deepClone(el));
            }
        }
        return plur;
    }

    // Deep clone member fields here
}
