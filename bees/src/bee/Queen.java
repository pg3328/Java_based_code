package bee;

import util.RandomBee;
import world.BeeHive;

/**
 * The queen is the master of the bee hive and the only bee that is allowed
 * to mate with the drones.  The way the queen works is she will try to
 * mate with a drone if these two conditions are met:<br>
 * <br>
 * <ul>
 *     <li>The bee hive has 1 unit of nectar and 1 unit of pollen</li>
 *     <li>There is a drone available and ready to do the wild thing</li>
 * </ul>
 * <br>
 * After the stimulating mating session which takes one unit of time,
 * the queen produces between 1 and 4 new bees (if resources exist).
 * Finally, the queen takes a break and smokes a cigarette and puts on some
 * netflix before she chills with her next drone.
 *
 * @author RIT CS
 * @author Arya Girisha Rao, Pradeep Kumar Gontla.
 */
public class Queen extends Bee {
    /**
     * the amount of time the queen waits after performing a task, whether she mated
     * this specific time or not.
     */
    public final static int SLEEP_TIME_MS = 1000;
    /**
     * the time it takes for the queen and the drone to mate
     */
    public final static int MATE_TIME_MS = 1000;
    /**
     * the minimum number of new bees that will be created by one mating session
     */
    public final static int MIN_NEW_BEES = 1;
    /**
     * the maximum number of new bees that will be created by one mating session
     */
    public final static int MAX_NEW_BEES = 4;

    /**
     * Status of Queen bee based on whether she's available for mating or not.
     */
    public enum Status {
        NOT_AVAILABLE,
        AVAILABLE
    }

    /**
     * Status to indicate if the Queen is Available for Mating.
     */
    public static Status matingStatus;

    /**
     * Create the queen.  She should get the queen's chamber from the bee hive.
     *
     * @param beeHive the bee hive
     */
    protected Queen(BeeHive beeHive) {
        super(Role.QUEEN, beeHive);
        matingStatus = Status.NOT_AVAILABLE;
    }

    /**
     * The queen will continue performing her task of mating until the bee hive
     * becomes inactive. Each time she tries to mate, whether successful or not,
     * she will sleep for the required time.
     * The queen will first check that both conditions are met (see the class
     * level description).  If so, the queen will summon the next drone,
     * and sleep to simulate the mating time.  Next,
     * the queen will roll the dice to see how many bees she should
     * try and create, between the min and max inclusive.  Each time there are
     * enough resources a new bee is created.  The bees are created based on
     * another random dice roll - a nectar worker bee has a 20% chance
     * of being created, a pollen bee has a 20% change of being created,
     * and a drone has a 60% change of being created.  After all the bees
     * are created for a single mating message, you should display:<br>
     * <br>
     * <tt>*Q* Queen birthed # children</tt><br>
     * <br>
     * <br>
     * When the simulation is over and before the queen can retire, she needs
     * to make sure that she individually dismisses each drone that is
     * still waiting in her chamber.
     */
    public void run() {

        try {
            while (beeHive.isActive()) {
                setMatingStatus(Status.NOT_AVAILABLE);

                if (checkIfReadyForMating()) {
                    setMatingStatus(Status.AVAILABLE);
                    beeHive.getQueensChamber().summonDrone();
                    sleep(MATE_TIME_MS);
                    createNewBees();
                }
                setMatingStatus(Status.NOT_AVAILABLE);
                sleep(SLEEP_TIME_MS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (beeHive.getQueensChamber().hasDrone()) {
            setMatingStatus(Status.AVAILABLE);
            beeHive.getQueensChamber().dismissDrone();
        }
    }

    /**
     * Setter method to update the status of the Queen
     *
     * @param status New status of the Queen.
     */
    public static void setMatingStatus(Status status) {
        matingStatus = status;
    }

    /**
     * Method to check if the beeHive has resources and drones to mate.
     *
     * @return boolean to indicate if the beeHive has resources and Drone to mate.
     */
    private boolean checkIfReadyForMating() {
        return beeHive.hasResources() && beeHive.getQueensChamber().hasDrone();
    }

    /**
     * Method to create New random Bee based on the assigned randomness of 20% to each worker and 60% to Drone.
     */
    private void createNewRandomBee() {
        int randomNum = RandomBee.nextInt(1, 5);
        if (randomNum == 1) beeHive.addBee(Bee.createBee(Role.WORKER, Worker.Resource.NECTAR, beeHive));
        else if (randomNum == 2) beeHive.addBee(Bee.createBee(Role.WORKER, Worker.Resource.POLLEN, beeHive));
        else beeHive.addBee(Bee.createBee(Role.DRONE, null, beeHive));

    }

    /**
     * Creates New bees with random number of offsprings chosen if the resources are available.
     */
    private void createNewBees() {
        int numOfBees = RandomBee.nextInt(MIN_NEW_BEES, MAX_NEW_BEES);
        int count = 0;
        for (int i = 0; i < numOfBees; i++) {
            if (beeHive.hasResources()) {
                count++;
                createNewRandomBee();
                beeHive.claimResources();
            }
        }
        System.out.printf("*Q* Queen birthed %d children%n", count);
    }
}