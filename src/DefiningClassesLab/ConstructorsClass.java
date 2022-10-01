package DefiningClassesLab;

public class ConstructorsClass {
    String brand;
    String model;
    int horsePower;


    public ConstructorsClass(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }
    public ConstructorsClass(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }
}
