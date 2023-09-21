package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    private List<Car> cars;

    public CarServiceImp() {
        cars = new ArrayList<>();
        cars.add(new Car("KIA", "RIO", 2020));
        cars.add(new Car("Ford", "Mustang", 2021));
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("Chevrolet", "Cruze", 2019));
        cars.add(new Car("BMW", "X5", 2021));
    }

    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}

