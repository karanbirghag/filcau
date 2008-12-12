/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mallus.model.iterator;

/**
 *
 * @author marius.lazar
 */
public interface Iterator<E> {

    public E next();

    public E previous();

    public E current();

    public boolean hasNext();

}
