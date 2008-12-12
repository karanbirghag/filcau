/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model.iterator;

/**
 *
 * @author marius.lazar
 */
public interface Collection<E> {

    public Iterator<E> getIterator();

    public void add(E element);

    public void remove(E element);

    public int indexOf(E element);

    public E getElementAt(int index);

    public int size();
}
