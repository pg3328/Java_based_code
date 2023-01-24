package toy;

public class Robot extends Toy {
    static int productCode = 7000000;
    private String sound;
    private int batteryLevel = 100;

    public Robot(String name, double msrp, BatteryType type, int noOfBatteries, String sound) {
        super(name, productCode, msrp, type, noOfBatteries);
        productCode += 1;
        this.sound = sound;
    }

    private void replaceTheBatteries() {
        this.batteryLevel = 100;
    }

    public void play() {
        if (batteryLevel < 25) {
            System.out.println("The batteries are dead! Let's replace them...");
            replaceTheBatteries();
        }
        batteryLevel -= 25;
        degradationLevel = (degradationLevel >80 ? 100 : degradationLevel + 20);
        condition = Condition.get(degradationLevel);
        System.out.println(name + " goes '" + this.sound + "'");
        System.out.println("After play, " + name + "'s condition is " + condition);
    }

    public String toString() {
        return name + " [product code=" + getProductCode() + ", MSRP=" + String.format("%.2f", msrp) + ", degradation level=" + degradationLevel + "%, " +
                "condition=" + condition + ", resale value=" + String.format("%.2f", getResaleValue()) + ", battery type=" + type + ", number of batteries="
                + noOfBatteries + ", battery level=" + this.batteryLevel + "%, sound=" + this.sound + "]";
    }
}
