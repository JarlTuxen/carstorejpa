package dk.kea.carstorejpa.service;

import dk.kea.carstorejpa.model.Mod;
import dk.kea.carstorejpa.repository.ModRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ModService {

    @Autowired
    ModRepository modRepository;

    public Set<Mod> findAll(){
        Set<Mod> mods = new HashSet<>();
        for (Mod mod : modRepository.findAll()){
            mods.add(mod);
        }
        return mods;
    }

    public Mod findById(Long id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Mod> optionalMod = modRepository.findById(id);
        if (!optionalMod.isPresent()){
            throw new RuntimeException("Mod " + id + " not found");
        }
        //returner indhold af optional vha. get()
        return optionalMod.get();
    }

    public Mod create(Mod mod){
        return modRepository.save(mod);
    }

    public Mod update(Mod mod){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return modRepository.save(mod);
    }

    public void deleteById(Long id){
        modRepository.deleteById(id);
    }

}
