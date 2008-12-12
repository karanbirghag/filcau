/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model;

/**
 *
 * @author marius.lazar
 */
public class Iterator<E> {
    private Aggregate<E> aggregate;
    private E currentElement = null;
    private int currentIndex = 0;

    public Iterator (Aggregate<E> aggregate) {
        this.aggregate = aggregate;
        if (aggregate.size() > 0) {
            currentElement = aggregate.getElementAt(0);
        }
    }

    E next() {
        int nextIndex = currentIndex + 1;
        currentElement = aggregate.getElementAt(nextIndex);
        currentIndex = nextIndex;
        return currentElement;
    }
    E previous() {
        int previousIndex = currentIndex - 1;
        currentElement = aggregate.getElementAt(previousIndex);
        currentIndex = previousIndex;
        return currentElement;
    }
    E current() {
        return currentElement;
    }
    boolean hasNext() {
       if (aggregate.size() <= currentIndex + 1) {
           return false;
       } else {
           return true;
       }
    }
}
