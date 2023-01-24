package world;

import bee.Drone;
import bee.Queen;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Class for Representing Queen's chamber where mating happens between Queen and Drone.
 * Drones enter the Queens chamber, and mates with the queen if she's ready and resources are available in the BeeHive .
 * Mated drones will get notified that they have mated with the Queen.
 *
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */

public class QueensChamber {

    /**
     * Queue where drones wait to mate with Queen in FIFO manner.
     */
    private ConcurrentLinkedQueue<Drone> drones;


    /**
     * Construct a new Queen chamber.
     */
    public QueensChamber() {
        this.drones = new ConcurrentLinkedQueue<>();
    }

    /**
     * Drone enters the chamber to wait in the Queue to mate with the Queen.
     * @param drone  Drone requesting to enter the chamber.
     */
    public synchronized void enterChamber(Drone drone) {
        this.drones.add(drone);
        System.out.printf("*QC* %s enters chamber%n", drone);
        try {

            while (!drones.peek().equals(drone) || Queen.matingStatus != Queen.Status.AVAILABLE)
                wait();
            drones.remove();
            Queen.setMatingStatus(Queen.Status.NOT_AVAILABLE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("*QC* %s leaves chamber%n", drone);
    }

    /**
     * Method where Queen summons the first Drone bee in Queue to mate with her.
     */
    public synchronized void summonDrone() {
        System.out.printf("*QC* Queen mates with %s%n", drones.peek());
        drones.peek().setMated();
        notifyAll();

    }

    /**
     * Method to dismiss all the Drones waiting in the queue after the Beehive is inactive.
     */
    public synchronized void dismissDrone() {
        notifyAll();
    }

    /**
     * Method to check if the Queens chamber has any Drones waiting in the Queue.
     * @return Boolean indicating if there are any Drones in the queue.
     */
    public boolean hasDrone() {
        return drones.size() > 0;
    }

}
