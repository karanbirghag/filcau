/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model.iterator;

/**
 *
 * @author marius.lazar
 */
public class Iterator<E> {
    private Aggregate<E> aggregate;
    private E currentElement = null;
    private int currentIndex = 0;

    Iterator (Aggregate<E> aggregate) {
        this.aggregate = aggregate;
        if (aggregate.size() > 0) {
            currentElement = aggregate.getElementAt(0);
        }
    }

    public E next() {
        int nextIndex = currentIndex + 1;
        currentElement = aggregate.getElementAt(nextIndex);
        currentIndex = nextIndex;
        return currentElement;
    }

    public E previous() {
        int previousIndex = currentIndex - 1;
        currentElement = aggregate.getElementAt(previousIndex);
        currentIndex = previousIndex;
        return currentElement;
    }

    public E current() {
        return currentElement;
    }
    
    public boolean hasNext() {
       if (aggregate.size() <= currentIndex + 1) {
           return false;
       } else {
           return true;
       }
    }
}
