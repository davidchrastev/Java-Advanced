package ExercisesDefiningClasses;


public class Car {
    private static final int TIRES_COUNT = 4;
    private final String model;
    private final Engine engine;
    private final Cargo cargo;
    private final Tire[] tires = new Tire[TIRES_COUNT];

    public Car(String[] data) {
        int counter = -1;
        this.model = data[++counter];
        this.engine = new Engine(
                Integer.parseInt(data[++counter]),
                Integer.parseInt(data[++counter]));
        this.cargo = new Cargo(
                Integer.parseInt(data[++counter]),
                data[++counter]);
        for (int i = 0; i < TIRES_COUNT; i++) {
            this.tires[i] = new Tire(
                    Double.parseDouble(data[++counter]),
                    Integer.parseInt(data[++counter]));
        }
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tire[] getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
