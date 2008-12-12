/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marius.lazar
 */
public class StoresEnumeration<E> implements Enumeration<E> {
    private List<E> elements;

    public StoresEnumeration() {
        elements = new ArrayList<E>();
    }

    public StoresEnumeration(java.util.List<E> elements) {
        this.elements = elements;
    }

    public Iterator<E> getIterator() {
        Iterator<E> theIterator = new StoresIterator<E>(this);
        return theIterator;
    }

    public boolean add(E element) {
        return elements.add(element);
    }

    public boolean remove(E element) {
        return elements.remove(element);
    }

    public int indexOf(E element) {
        return elements.indexOf(element);
    }

    public E getElementAt(int index) {
        return elements.get(index);
    }

    public int size() {
        return elements.size();
    }

}
