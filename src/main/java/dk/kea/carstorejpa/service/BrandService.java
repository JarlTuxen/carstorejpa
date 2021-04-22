package dk.kea.carstorejpa.service;

import dk.kea.carstorejpa.model.Brand;
import dk.kea.carstorejpa.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public Set<Brand> findAll(){
        }
        return brands;
    }

    public Brand findById(Long id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        return optionalBrand.get();
    }

    public Brand create(Brand brand){
        return brandRepository.save(brand);
    }

    public Brand update(Brand brand){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return brandRepository.save(brand);
    }

    public void deleteById(Long id){
        brandRepository.deleteById(id);
    }


}
