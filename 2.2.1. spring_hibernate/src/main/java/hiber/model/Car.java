package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "car")
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "series")
    private int series;
    @Column (name = "model")
    private String model;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series;
    }

    @Override
    public int hashCode() {
        return Objects.hash(series);
    }
}
