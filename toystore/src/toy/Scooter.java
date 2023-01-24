package toy;

import java.util.*;

public class Scooter extends Toy {
    private String color;
    private int wheels;
    private int odometer;
    static int productCode = 9000000;

    public Scooter(String name, double msrp, String color, int wheels) {
        super(name, productCode, msrp);
        productCode += 1;
        this.odometer = 0;
        this.color = color;
        this.wheels = wheels;
    }

    public void play() {
        this.odometer += 2;
        degradationLevel = (degradationLevel >95 ? 100 : degradationLevel + 5);
        condition = Condition.get(degradationLevel);
        System.out.println("After play, " + name + "'s condition is " + condition);
    }

    public String toString() {
        return name + " [product code=" + getProductCode() + ", MSRP=" + String.format("%.2f", msrp) + ", degradation level=" + degradationLevel + "%, " +
                "condition=" + condition + ", resale value=" + String.format("%.2f", getResaleValue()) + ", color=" + color + ", wheels=" + wheels +
                ", odometer=" + odometer + "]";
    }
}
