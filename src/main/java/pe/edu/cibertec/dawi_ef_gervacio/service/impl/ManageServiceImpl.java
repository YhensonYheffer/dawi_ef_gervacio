package pe.edu.cibertec.dawi_ef_gervacio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDetailDto;
import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDto;
import pe.edu.cibertec.dawi_ef_gervacio.entity.car;
import pe.edu.cibertec.dawi_ef_gervacio.repository.CarRepository;
import pe.edu.cibertec.dawi_ef_gervacio.service.ManageService;

import java.util.*;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;


    @Override
    public List<CarDto> getAllCars() {
        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<car> iterable = carRepository.findAll();
        iterable.forEach(c -> {
            cars.add(new CarDto(c.getCar_id(),
                    c.getMake(),
                    c.getModel(),
                    c.getYear()));
        });

        return cars;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
        Optional<car> optional = carRepository.findById(id);
        return optional.map(c -> new CarDetailDto(
                c.getCar_id(),
                c.getMake(),
                c.getModel(),
                c.getYear(),
                c.getVin(),
                c.getLicense_plate(),
                c.getOwner_name(),
                c.getOwner_contact(),
                c.getPurchase_date(),
                c.getMileage(),
                c.getEngine_type(),
                c.getColor(),
                c.getInsurance_company(),
                c.getInsurance_policy_number(),
                c.getRegistration_expiration_date(),
                c.getService_due_date()
        ));

    }

    @Override
    public Boolean updateCar(CarDetailDto carDetailDto) throws Exception {
        Optional<car> optional = carRepository.findById(carDetailDto.car_id());
        return optional.map(c -> {
            c.setCar_id(carDetailDto.car_id());
            c.setMake(carDetailDto.make());
            c.setModel(carDetailDto.model());
            c.setYear(carDetailDto.year());
            c.setVin(carDetailDto.vin());
            c.setLicense_plate(carDetailDto.license_plate());
            c.setOwner_name(carDetailDto.owner_name());
            c.setOwner_contact(carDetailDto.owner_contact());
            c.setPurchase_date(carDetailDto.purchase_date());
            c.setMileage(carDetailDto.mileage());
            c.setEngine_type(carDetailDto.engine_type());
            c.setColor(carDetailDto.color());
            c.setInsurance_company(carDetailDto.insurance_company());
            c.setInsurance_policy_number(carDetailDto.insurance_policy_number());
            c.setRegistration_expiration_date(carDetailDto.registration_expiration_date());
            c.setService_due_date(carDetailDto.service_due_date());
            carRepository.save(c);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean deleteCarById(int id) throws Exception {
        Optional<car> optional = carRepository.findById(id);
        return optional.map(c ->{
            carRepository.delete(c);
            return true;
        }) .orElse(false);
    }

    @Override
    public Boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Optional<car> optional = carRepository.findById(carDetailDto.car_id());
        if (optional.isPresent()) {
            return false;
        }else{
            car car = new car();
            car.setCar_id(carDetailDto.car_id());
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicense_plate(carDetailDto.license_plate());
            car.setOwner_name(carDetailDto.owner_name());
            car.setOwner_contact(carDetailDto.owner_contact());
            car.setPurchase_date(carDetailDto.purchase_date());
            car.setMileage(carDetailDto.mileage());
            car.setEngine_type(carDetailDto.engine_type());
            car.setColor(carDetailDto.color());
            car.setInsurance_company(carDetailDto.insurance_company());
            car.setInsurance_policy_number(carDetailDto.insurance_policy_number());
            car.setRegistration_expiration_date(carDetailDto.registration_expiration_date());
            car.setService_due_date(carDetailDto.service_due_date());
            carRepository.save(car);
            return true;
        }
    }
}
