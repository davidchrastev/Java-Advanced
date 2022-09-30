package DefiningClassesLab;

public class CarDemo {

    //get взимаме //set задаваме стойност
    //    public void setBrand(String brand) {
    //        this.brand = brand;
    //    }

    private String brand;

    //    public void setModel(String model) {
    //        this.model = model;
    //    }

    private String model;

    //    public void setHorsePower(int horsePower) {
    //        this.horsePower = horsePower;
    //    }

    private int horsePower;

    //конструктор
    public CarDemo(String brand, String model, int horsePower) {
        this.brand = brand;
        this.brand = model;
        this.horsePower = horsePower;
    }

    //конструктор чейнинг в двата конструктора
    //прави се на първа операция в конструктора
    //конструкор чейнинг се прави от конструктора с по-малко параметри
    //към конструктора с повече

    public CarDemo(String brand, String model) {
        this(brand,model,0);
    }



    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }

}
