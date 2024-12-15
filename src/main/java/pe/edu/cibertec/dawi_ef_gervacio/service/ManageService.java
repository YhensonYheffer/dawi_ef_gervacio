package pe.edu.cibertec.dawi_ef_gervacio.service;

import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDetailDto;
import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto>getAllCars();

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    Boolean updateCar(CarDetailDto carDetailDto)throws Exception;

    Boolean deleteCarById(int id)throws Exception;

    Boolean addCar(CarDetailDto carDetailDto)throws Exception;
}
