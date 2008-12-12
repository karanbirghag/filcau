/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

/**
 *
 * @author marius.lazar
 */
public class Aggregate<E> {
    private java.util.List<E> elements;

    public Aggregate() {
        elements = new java.util.ArrayList<E>();
    }

    public Aggregate(java.util.List<E> elements) {
        this.elements = elements;
    }

    public Iterator<E> getIterator() {
        Iterator<E> theIterator = new Iterator<E>(this);
        return theIterator;
    }

    public void add(E element) {
        elements.add(element);
    }

    public void remove(E element) {
        elements.remove(element);
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
