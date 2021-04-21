package dk.kea.carstorejpa.repository;

import dk.kea.carstorejpa.model.Brand;
import org.springframework.data.repository.CrudRepository;


public interface BrandRepository extends CrudRepository<Brand, Long> {
}
