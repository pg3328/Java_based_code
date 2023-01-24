package bee;

import world.BeeHive;
import world.QueensChamber;

/**
 * The male drone bee has a tough life.  His only job is to mate with the queen
 * by entering the queen's chamber and awaiting his royal highness for some
 * sexy time.  Unfortunately his reward from mating with the queen is his
 * endophallus gets ripped off and he perishes soon after mating.
 *
 * @author RIT CS
 * @author Arya Girisha Rao, Pradeep Kumar Gontla
 */
public class Drone extends Bee {

    /**
     * When the drone is created they should retrieve the queen's
     * chamber from the bee hive and initially the drone has not mated.
     *
     * @param beeHive the bee hive
     */
    protected Drone(BeeHive beeHive) {
        super(Role.DRONE, beeHive);
        mated = Mated.NOT_MATED;
    }

    /**
     * Status of the Drone to indicate if it's mated or not.
     */
    private Mated mated;

    /**
     * Enum for classification of whether the Drone is mated or not.
     */
    private enum Mated {
        MATED,
        NOT_MATED
    }

    /**
     * When the drone runs, they check if the bee hive is active.  If so,
     * they perform their sole task of entering the queen's chamber.
     * If they return from the chamber, it can mean only one of two
     * things.  If they mated with the queen, they sleep for the
     * required mating time, and then perish (the beehive should be
     * notified of this tragic event).  You should display a message:<br>
     * <br>
     * <tt>*D* {bee} has perished!</tt><br>
     * <br>
     * <br>
     * Otherwise if the drone has not mated it means they survived the
     * simulation and they should end their run without any
     * sleeping.
     */
    public void run() {
        if (beeHive.isActive()) {
            QueensChamber queensChamber = beeHive.getQueensChamber();
            queensChamber.enterChamber(this);
            if (mated == Mated.MATED) {
                try {
                    sleep(Queen.MATE_TIME_MS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                beeHive.beePerished(this);
                System.out.printf("*D* %s has perished!%n", this);
            }
        }
    }

    /**
     * Update the status of the Drone to indicate that the Drone has mated with the queen.
     */
    public void setMated() {
        mated = Mated.MATED;
    }
}