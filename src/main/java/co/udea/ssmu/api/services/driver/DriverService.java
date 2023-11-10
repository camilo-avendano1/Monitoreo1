package co.udea.ssmu.api.services.driver;

import co.udea.ssmu.api.model.jpa.model.Conductor;

public interface DriverService {
    public Conductor getDriverById(Long id);
    public Conductor createDriver(Conductor conductor);
}
