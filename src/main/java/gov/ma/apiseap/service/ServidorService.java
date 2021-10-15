package gov.ma.apiseap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gov.ma.apiseap.model.Servidor;

@Service
public class ServidorService {
    private List<Servidor> servidorRepository = new ArrayList<>();

    
    public void salva(Servidor servidor){
        this.servidorRepository.add(servidor);
    }
    public Servidor buscaPor(String matricula){
        for (Servidor servidor : servidorRepository) {
            if(servidor.getMatricula().equals(matricula)){
                return servidor;
            }
        }
        return null;
    }
}
