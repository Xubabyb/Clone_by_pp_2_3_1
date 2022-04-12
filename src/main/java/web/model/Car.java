package web.model;

public class Car {
    private String make;
    private String model;
    private int serial;

    public Car() {
    }

    public Car(String make, String model, int serial) {
        this.make = make;
        this.model = model;
        this.serial = serial;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
