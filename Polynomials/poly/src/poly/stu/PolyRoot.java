package poly.stu;

/**
 * This class can compute the root of a polynomial (whose derivative is
 * non-zero), using Newton's method of successive approximation.
 *
 * @author RIT CS
 * @author Pradeep Kumar Gontla
 */
public class PolyRoot {
    /**
     * The degree of acceptable error for the root
     */
    public static final double EPSILON = 0.000001;

    /**
     * The initial guess for the root
     */
    public static final double INITIAL_GUESS = 0.1;

    /**
     * The maximum number of iterations to perform for root finding
     */
    public static final int MAX_ITERATIONS = 100;

    /**
     * Compute an estimate for a root of the polynomial, using  Newton's
     * method.  For example:
     * <pre>
     * poly=[3, -1], x=4.5: 3.0
     * poly=[0, 3], x=-2.0: -1.3877787807814457E-17
     * poly=[2, -1, -2, 1], x=2.0: 2.0000000358875707
     * poly=[-5, 0, 0, 3, 3, 1], x=-3.9: 0.9128983495621411
     * </pre>
     *
     * @param poly A native array representing the polynomial, in reverse order.
     * @return An estimated root for the polynomial.
     * @rit.pre poly is not an empty array.  Minimally it will contain
     * a constant term.
     * @rit.pre The derivative of poly is non-zero
     * @rit.pre The evaluation of the derivative of the polynomial at a guessed
     * root is non-zero.
     */
    public static double computeRoot(int[] poly) {
        return newtonsMethod(poly, INITIAL_GUESS, 1);
    }

    /**
     * Compute an estimate for a root of the polynomial, using Newton's
     * method.
     *
     * @param poly A native array representing the polynomial, in reverse order.
     * @param x0   The current guess for the root.
     * @param iter The current iteration being performed
     * @return An estimated root for the polynomial.
     * @rit.pre poly is not an empty array.  Minimally it will contain
     * a constant term.
     * @rit.pre The derivative of poly is non-zero
     * @rit.pre The evaluation of the derivative of the polynomial at a guessed
     * root is non-zero.
     */
    private static double newtonsMethod(int[] poly, double x0, int iter) {
        double value=(PolyEval.evaluate(poly, x0));
        if ((value<= EPSILON && value >= (-1 * EPSILON))||iter==MAX_ITERATIONS) {
            return x0;}
        int[] deriv = PolyDerive.computeDerivative(poly);
        x0 = x0 - (PolyEval.evaluate(poly, x0) / PolyEval.evaluate(deriv, x0));
        return newtonsMethod(poly,x0,iter);
    }
}
