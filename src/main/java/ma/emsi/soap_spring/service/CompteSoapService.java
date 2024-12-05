package ma.emsi.soap_spring.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import ma.emsi.soap_spring.entities.Compte;
import ma.emsi.soap_spring.entities.TypeCompte;
import ma.emsi.soap_spring.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;
    @WebMethod
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }
    @WebMethod
    public Compte getCompteById(@WebParam(name = "id") Long id) {
        return compteRepository. findById(id).orElse (null);
    }
    @WebMethod
    public Compte createCompte(@WebParam(name = "solde") double solde,
                               @WebParam(name = "type") TypeCompte type) {
        Compte compte = new Compte(null, solde, new Date(), type);
        return compteRepository. save(compte);
    }

    @WebMethod
    public boolean deleteCompte(@WebParam(name = "id") Long id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            return true;
    }
        return false ;
    }
}
