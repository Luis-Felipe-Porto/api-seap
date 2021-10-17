package gov.ma.apiseap.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ma.apiseap.model.Lotacao;


@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao,Integer>{
    List<Lotacao> findByDescricao(String descricao);
    Page<Lotacao> findByDescricao(String descricao,Pageable pageable);
}
