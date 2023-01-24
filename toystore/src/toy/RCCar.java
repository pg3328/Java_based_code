package toy;

public class RCCar extends Toy {
    static int productCode = 6000000;
    private int scaleSpeed;
    private int batteryLevel = 100;

    public RCCar(String name, double msrp, int scaleSpeed, BatteryType type, int noofBatteries) {
        super(name, productCode, msrp, type, noofBatteries);
        productCode += 1;
        this.scaleSpeed = scaleSpeed;
    }

    private void replaceTheBatteries() {
        this.batteryLevel = 100;
    }

    public void play() {
        if (batteryLevel <= 0) {
            System.out.println("The batteries are dead! Let's replace them...");
            replaceTheBatteries();
        }
        batteryLevel = (batteryLevel == 10 ? batteryLevel - 10 : batteryLevel - 30);
        degradationLevel = (degradationLevel>85 ? 100 : degradationLevel + 15);
        condition = Condition.get(degradationLevel);
        System.out.println(name + " races in circles at " + this.scaleSpeed + " mph!");
        System.out.println("After play, " + name + "'s condition is " + condition);
    }

    public String toString() {
        return name + " [product code=" + getProductCode() + ", MSRP=" + String.format("%.2f", msrp) + ", degradation level=" + degradationLevel + "%, " +
                "condition=" + condition + ", resale value=" + String.format("%.2f", getResaleValue()) + ", battery type=" + type + ", number of batteries="
                + noOfBatteries + ", battery level=" + this.batteryLevel + "%, speed=" + this.scaleSpeed + "]";
    }
}
