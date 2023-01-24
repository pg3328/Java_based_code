package poly.stu;

/**
 * This class can compute the derivative of a polynomial.
 *
 * @author RIT CS
 * @author Pradeep Kumar Gontla
 */
public class PolyDerive {

    /**
     * Unused constructor, made private to avoid javadoc generation.
     */
    private PolyDerive() {
    }

    /**
     * Computes the derivative for a polynomial.  For example:
     * <pre>
     * poly=[1]: [0]
     * poly=[3, -1]: [-1]
     * poly=[0, 3]: [3]
     * poly=[2, -1, -2, 1]: [-1, -4, 3]
     * poly=[-5, 0, 0, 3, 3, 1]: [0, 0, 9, 12, 5]
     * </pre>
     *
     * @param poly A native array representing the polynomial, in reverse order.
     * @return A polynomial as a native array in reverse order.
     * @rit.pre poly is not an empty array.  Minimally it will contain
     * a constant term.
     */
    public static int[] computeDerivative(int[] poly) {
        int[] deriv = new int[poly.length];
        if (poly.length==1){
            // Computes the derivative of the constant polynomial(3).
         deriv[0]=0;
         return deriv;
        }
        else
            // Comuptes the derivate of non-constant polynomial (Ex: x+3)
        for (int i = 1; i < poly.length; i++) {
            deriv[i-1] = poly[i] * i;}
        return deriv;
    }
}
