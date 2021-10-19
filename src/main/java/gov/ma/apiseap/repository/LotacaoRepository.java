package gov.ma.apiseap.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ma.apiseap.model.Lotacao;


@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao,Integer>{
    
    Page<Lotacao> findByDescricaoContainingIgnoreCase(String descricao,Pageable pageable);
}
