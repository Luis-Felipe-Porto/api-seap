package gov.ma.apiseap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ma.apiseap.model.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor,Integer>{
    
}
