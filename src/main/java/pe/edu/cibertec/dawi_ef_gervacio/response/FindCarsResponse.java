package pe.edu.cibertec.dawi_ef_gervacio.response;

import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
