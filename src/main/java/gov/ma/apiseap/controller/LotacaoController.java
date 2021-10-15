package gov.ma.apiseap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotacaoController {

    @Autowired
    private LotacaoService lotacaoService;

    public void cadastrarLotacao(){

    }
    public void buscaLotacaoPor(String nome){
        
    }
}
