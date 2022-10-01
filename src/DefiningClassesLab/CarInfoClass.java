package DefiningClassesLab;

public class CarInfoClass {
    private String brand;
    private String model;
    private int horsePower;

    public CarInfoClass(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public CarInfoClass(String brand) {

        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }

}
