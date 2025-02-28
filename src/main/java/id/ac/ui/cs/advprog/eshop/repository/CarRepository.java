package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.Iterator;
import java.util.List;

public interface CarRepository {
    public Car create(Car car);
    public Iterator<Car> findAll();
    public Car findById(String id);
    public void updateCarName(String id, Car updatedCar);
    public void updateCarColor(String id, Car updatedCar);
    public void updateCarQuantity(String id, Car updatedCar);
    public void delete(String id);
}
