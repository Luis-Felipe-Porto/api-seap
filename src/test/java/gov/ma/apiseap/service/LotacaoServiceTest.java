package gov.ma.apiseap.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.repository.LotacaoRepository;

@SpringBootTest
public class LotacaoServiceTest {
    @Autowired
    private LotacaoService lotacaoService;
    @Autowired
    private LotacaoRepository lotacaoRepository;

    private Lotacao lotacao;

    @BeforeEach
    public void init(){
        lotacao = new Lotacao("Descricao Teste Lotacao",LocalDate.of(2021, 10, 16));
    }

    @Test
    public void deveCadastrarUmaLotacao(){
        lotacaoService.salva(lotacao);
        List<Lotacao> contatos = lotacaoRepository.findAll();
		Assertions.assertEquals(1, contatos.size());		
    }
    @Test
    public void deveRetornarUmaLotacaoPorId(){
        Lotacao lotacaoSalva = lotacaoService.salva(lotacao);
        Lotacao lotacaoPorId = lotacaoService.buscaPor(lotacaoSalva.getId()).get();
        Assertions.assertEquals(lotacaoSalva.getId(), lotacaoPorId.getId());
    }
    @Test
    public void naoDeveRetornarUmaLotacaoComIdInvalido(){
        lotacaoService.salva(lotacao);
        Optional<Lotacao> lotacaoPorId = lotacaoService.buscaPor(-1000);
        Assertions.assertFalse(lotacaoPorId.isPresent());
    }  
    @AfterEach
    public void clean(){
        lotacaoRepository.deleteAll();
    }
}
