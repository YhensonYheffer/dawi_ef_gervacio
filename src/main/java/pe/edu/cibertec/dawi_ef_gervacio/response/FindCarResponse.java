package pe.edu.cibertec.dawi_ef_gervacio.response;

import pe.edu.cibertec.dawi_ef_gervacio.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto car) {
}
