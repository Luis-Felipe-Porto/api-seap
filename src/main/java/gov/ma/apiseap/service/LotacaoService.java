package gov.ma.apiseap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.repository.LotacaoRepository;

@Service
public class LotacaoService {
    @Autowired
    private LotacaoRepository lotacaoRepository;
    
    @Transactional
    public Lotacao salva(Lotacao lotacao){
        return this.lotacaoRepository.save(lotacao);
    }
    public List<Lotacao> buscaPor(String nome){    
        return this.lotacaoRepository.findByDescricaoLike(nome);
    }
    public Page<Lotacao> buscaPor(String nome, Pageable pageable){
        return this.lotacaoRepository.findByDescricao(nome, pageable);
    }
    public Page<Lotacao> buscaCom(Pageable pageable){
        return this.lotacaoRepository.findAll(pageable);
    }
    public Optional<Lotacao> buscaPor(Integer id) {
        if(id > 0){
            return this.lotacaoRepository.findById(id);
        }
        return Optional.empty();     
    }
    @Transactional
	public void deletePor(Integer id) {
		this.lotacaoRepository.deleteById(id);
	}
}
