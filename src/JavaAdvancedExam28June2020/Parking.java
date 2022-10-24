package JavaAdvancedExam28June2020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Parking {
    private Collection<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar() {
        if (data.size() > 0) {
            return data.stream().max(Comparator.comparing(Car::getYear)).get();
        } else {
            return null;
        }
    }
    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The cars are parked in ").append(type).append(":").append(System.lineSeparator());
        for (Car car : data) {
            stringBuilder.append(car).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
