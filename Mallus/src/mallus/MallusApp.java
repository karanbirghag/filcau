/*
 * MallusApp.java
 */

package mallus;

import mallus.model.BookStoreCreator;
import mallus.model.GameStoreCreator;
import mallus.model.Mall;
import mallus.model.ShoeStoreCreator;
import mallus.model.Store;
import mallus.model.iterator.Enumeration;
import mallus.model.iterator.Iterator;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class MallusApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        MallusView mallusView = new MallusView(this);
        show(mallusView);
        StoreItemsObserver sio = new StoreItemsObserver(mallusView);
        Enumeration stores = Mall.getInstance().stores();
        for (Iterator<Store> it = stores.getIterator(); it.hasNext();) {
            Store store = it.next();
            store.addObserver(sio);
        }
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of MallusApp
     */
    public static MallusApp getApplication() {
        return Application.getInstance(MallusApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        Mall mall = Mall.getInstance();
        
        mall.addStore(new ShoeStoreCreator().createStore())
                .addStore(new GameStoreCreator().createStore())
                .addStore(new BookStoreCreator().createStore());

        // launch the interface;
        launch(MallusApp.class, args);
    }
}
