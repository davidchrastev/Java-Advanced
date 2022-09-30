package DefiningClassesLab;

public class Car {
    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

    public void setModel(String model) {
        this.model = model;
    }

    private String model;

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private int horsePower;



    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.%n", this.brand, this.model, this.horsePower);
    }
}
