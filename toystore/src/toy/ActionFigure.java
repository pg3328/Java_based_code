package toy;

public class ActionFigure extends Toy {
    private String eyeColor;
    private String hairColor;
    private boolean gripStatus;
    static int productCode = 5000000;

    public ActionFigure(String name, double msrp, String hairColor, String eyeColor, boolean KungFuGrip) {
        super(name, productCode, msrp);
        productCode += 1;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.gripStatus = KungFuGrip;
    }

    public void play() {
        degradationLevel = (degradationLevel >90 ? 100 : degradationLevel + 10);
        condition = Condition.get(degradationLevel);
        productCode += 1;
        System.out.println("After play, " + name + "'s condition is " + condition);
    }

    public String toString() {
        return name + " [product code=" + getProductCode() + ", MSRP=" + String.format("%.2f", msrp) + ", degradation level=" + degradationLevel +
                "%, condition=" + condition + ", resale value=" + String.format("%.2f", getResaleValue()) + ", hair color=" + hairColor + ", eye color=" + eyeColor +
                ", kung-fu grip=" + this.gripStatus + "]";
    }
}
