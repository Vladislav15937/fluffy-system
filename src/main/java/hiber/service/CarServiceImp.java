package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    CarDao carDao;

    @Override
    @Transactional
    public User getUserForCar(Car car) {
        return carDao.getUserForCar(car);
    }
}
