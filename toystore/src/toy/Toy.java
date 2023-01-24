package toy;

public abstract class Toy implements IToy {
    protected String name;
    protected int productCode;
    protected double msrp;
    protected BatteryType type;
    protected Condition condition;
    protected int noOfBatteries;
    protected int degradationLevel;

    public Toy(String name, int productCode, double msrp) {
        this.name = name;
        this.productCode = productCode;
        this.msrp = msrp;
        this.degradationLevel = 0;
        this.condition = Condition.get(degradationLevel);
    }

    public Toy(String name, int productCode, double msrp, BatteryType type, int noOfBatteries) {
        this(name, productCode, msrp);
        this.degradationLevel = 0;
        this.condition = Condition.get(degradationLevel);
        this.type = type;
        this.noOfBatteries = noOfBatteries;
    }

    public int getProductCode() {
        return this.productCode;
    }

    public String getName() {
        return this.name;
    }

    public double getMSRP() {
        return this.msrp;
    }

    public double getResaleValue() {
        return (this.msrp * this.condition.getMultiplier());
    }

    public Condition getCondition() {
        return this.condition;
    }

    public int getDegradationLevel() {
        return this.degradationLevel;
    }

    public void play() {

    }

}
