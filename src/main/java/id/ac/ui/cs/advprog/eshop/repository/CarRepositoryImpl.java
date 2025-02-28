package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepositoryImpl implements CarRepository {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();

    @Override
    public Car create(Car car) {
        if(car.getCarId() == null) {
            car.setCarId(UUID.randomUUID().toString());
        }
        carData.add(car);
        return car;
    }
    @Override
    public Iterator<Car> findAll() {
        return carData.iterator();
    }
    @Override
    public Car findById(String id) {
        for (Car car : carData) {
            if (car.getCarId().equals(id)) {
                return car;
            }
        }
        return null;
    }
    @Override
    public void updateCarName(String id, Car updatedCar) {
        Car currentCar = findById(id);
        currentCar.setCarName(updatedCar.getCarName());
    }
    @Override
    public void updateCarColor(String id, Car updatedCar) {
        Car currentCar = findById(id);
        currentCar.setCarColor(updatedCar.getCarColor());
    }
    @Override
    public void updateCarQuantity(String id, Car updatedCar) {
        Car currentCar = findById(id);
        currentCar.setCarQuantity(updatedCar.getCarQuantity());
    }
    @Override
    public void delete(String id) {
        carData.removeIf(car -> car.getCarId().equals(id));
    }
}
