package gov.ma.apiseap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gov.ma.apiseap.model.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor,Integer>{
    Optional<Servidor> findByMatricula(String matricula); 
    List<Servidor> findByNome(String nome);
}
