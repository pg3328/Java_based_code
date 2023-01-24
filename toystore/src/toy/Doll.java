package toy;

public class Doll extends Toy {
    static int productCode = 3000000;
    private String hairColor;
    private String eyeColor;

    public Doll(String name, double msrp, String hairColor, String eyeColor) {
        super(name, productCode, msrp);
        productCode += 1;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public void play() {
        degradationLevel = (degradationLevel >=85 ? 100 : degradationLevel + 17);
        condition = Condition.get(this.degradationLevel);
        System.out.println("After play, " + name + "'s condition is " + condition);
    }

    public String toString() {
        return name + " [product code=" + getProductCode() + ", MSRP=" + String.format("%.2f", msrp) + ", degradation level=" + degradationLevel +
                "%, condition=" + condition + ", resale value=" + String.format("%.2f", getResaleValue()) + ", hair color=" + hairColor + ", eye color=" + eyeColor + "]";

    }
}
