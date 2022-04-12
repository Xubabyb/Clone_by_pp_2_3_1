package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Mazda", "RX6", 230126));
        cars.add(new Car("Mazda", "RX8", 650826));
        cars.add(new Car("Toyota", "LandCruiser", 111987));
        cars.add(new Car("Nissan", "Patrol", 45559872));
        cars.add(new Car("Toyota", "Corolla", 621036));
    }

    @Override
    public List<Car> getCarList(Integer count) {
        if (count != null && count <= cars.size() && count >= 0) {
            return cars.stream().limit(count).collect(Collectors.toList());
            //cars.subList(0,count);
        }
        return cars;
    }
}
