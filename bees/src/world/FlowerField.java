package world;

import bee.Worker;

/**
 * Class for representing Flower field where Bees collect Pollen and Nectar.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class FlowerField {
    /**
     * Maximum number of worker bees allowed collecting resources at a time.
     */
    public static final int MAX_WORKERS = 10;

    /**
     * Number of workers present currently in the field collecting the resources.
     */
    private int numberOfWorkersInField;

    /**
     * Method to request entry to the Flower field.
     * @param worker Worker bee requesting access to enter the Flower Field.
     */
    public synchronized void enterField(Worker worker) {
        System.out.printf("*FF* %s enters field%n", worker);
        while (this.numberOfWorkersInField == MAX_WORKERS){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberOfWorkersInField++;
    }

    /**
     * Method to exit the Flower Field after collecting the resources.
     * @param worker Worker bee exiting the Flower field after collecting the resources.
     */
    public synchronized void exitField(Worker worker) {
        numberOfWorkersInField--;
        System.out.printf("*FF* %s leaves field%n", worker);
        this.notify();
    }

}
