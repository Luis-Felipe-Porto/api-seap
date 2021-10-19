package gov.ma.apiseap.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gov.ma.apiseap.exception.MatriculaInvalidaException;
import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.model.Servidor;
import gov.ma.apiseap.repository.ServidorRepository;

@SpringBootTest
public class ServidorServiceTest {
    @Autowired
    private ServidorService servidorService;
    @Autowired
    private ServidorRepository servidorRepository;

    private Servidor servidor;
    private Lotacao lotacao;
    @BeforeEach
    public void init(){
        lotacao = new Lotacao("Descricao Lotacao Para Sevidor",LocalDate.of(2021, 10, 16));
        servidor = new Servidor("Felipe", "GOVMA2021", LocalDate.of(2020, 02, 13), lotacao);
    }

    @Test
    public void deveCadastrarUmServidor() throws MatriculaInvalidaException{
        servidorService.salva(servidor);
        List<Servidor> servidor = servidorRepository.findAll();
		Assertions.assertEquals(1, servidor.size());
    }
    @Test
    public void deveBuscarServidorPorMatricula() throws MatriculaInvalidaException{
        Servidor servidorSalvo = servidorService.salva(servidor);
        Servidor servidorMatricula = servidorService.buscaPor(servidor.getMatricula()).get();
        Assertions.assertTrue(servidorSalvo.getMatricula().equals(servidorMatricula.getMatricula()));
    }
    @Test
    public void deveBuscarLotacaoPorNome() throws MatriculaInvalidaException{
        Servidor servidorFelipe = servidorService.salva(servidor);    
        List<Lotacao> lotacaos = servidorService.lotacaoPor("Felipe");
       Assertions.assertFalse(lotacaos.isEmpty());
       Assertions.assertEquals(servidorFelipe.getTipoLotacao().getId(),lotacaos.get(0).getId());

    }
    @AfterEach
    public void clean(){
        this.servidorRepository.deleteAll();
    }

}
