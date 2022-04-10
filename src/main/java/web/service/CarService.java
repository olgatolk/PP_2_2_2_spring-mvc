package web.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarService {
    private static int count;
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++count, "model1", "a"));
        cars.add(new Car(++count, "model2", "a"));
        cars.add(new Car(++count, "model3", "a"));
        cars.add(new Car(++count, "model4", "a"));
        cars.add(new Car(++count, "model5", "a"));
    }

    public List<Car> show(Integer count) {
        Collections.shuffle(cars);
        List<Car> newCars;
        if (count == null) {
            newCars = cars;
        } else {
            newCars = count <= 4 ? cars.subList(0, count) : cars;
        }
        return newCars;
    }
}
