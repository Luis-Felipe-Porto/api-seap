package gov.ma.apiseap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gov.ma.apiseap.model.Lotacao;

@Service
public class LotacaoService {
    private List<Lotacao> lotacaoRepository = new ArrayList<>();
    
    public void salva(Lotacao lotacao){
        this.lotacaoRepository.add(lotacao);
    }
    public Lotacao buscaPor(String nome){
        for (Lotacao lotacao : lotacaoRepository) {
            if(lotacao.getNome().equals(nome)){
                return lotacao;
            }
        }
        return null;
    }
}
