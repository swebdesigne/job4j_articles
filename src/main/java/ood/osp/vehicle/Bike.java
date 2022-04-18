package ood.osp.vehicle;

import java.util.Objects;

public class Bike {
    private int id;
    private String model;

    public Bike(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bike bike = (Bike) o;
        return id == bike.id && Objects.equals(model, bike.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model);
    }

    @Override
    public String toString() {
        return "Bike{"
                + "id=" + id
                + ", model='" + model + '\''
                + '}';
    }
}
