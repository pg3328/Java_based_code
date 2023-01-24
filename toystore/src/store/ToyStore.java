package store;

import toy.IToy;

/**
 * Runs a simulation during which a toy store is stocked with toys and each
 * customer 1.) purchases a toy, 2.) plays with it (degrading its condition),
 * and 3.) sells it back to the store whereupon it is discarded if broken. The
 * simulation runs until the store is out of stock.
 */
public class ToyStore {
    /**
     * The main method. It checks the number of command line arguments,
     * then stocks the toy store and plays the simulation.
     *
     * @param args Specifies a number of toys (integer) for stocking the toy store and
     *             a seed (integer) for the toy's type random number generator
     */
    public static void main(String[] args) {
        //TODO YOUR CODE HERE
        if (args.length != 2) {
            System.out.println("Usage: ToyStore #_toys #_seed");
            System.exit(0);
        }
        int numberOfToys = Integer.parseInt(args[0]);
        int seed = Integer.parseInt(args[1]);
        AlsToyBarn in = new AlsToyBarn(numberOfToys, seed);
        while (in.availableStock() != 0) {
            IToy toy = in.purchaseToy();
            System.out.println("The next customer purchases " + toy.toString() + " and begins to play with it...");
            toy.play();
            in.addToy(toy);
            System.out.println("The customer grows bored with the toy and trades it in for $" + String.format("%.2f", toy.getResaleValue()));
        }
        System.out.println("The toy store is out of stock! Time to close!");

    }
}
