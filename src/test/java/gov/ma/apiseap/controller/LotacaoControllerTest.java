package gov.ma.apiseap.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.repository.LotacaoRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LotacaoControllerTest {
    @Autowired
	private TestRestTemplate testRestTemplate;
    private Lotacao lotacao;
    @Autowired
    private LotacaoRepository lotacaoRepository;
    
    @BeforeEach
	public void start() {
        lotacao = new Lotacao("Descricao Teste Lotacao Http",LocalDate.of(2021, 10, 16));
		lotacaoRepository.save(lotacao);
	}

	@AfterEach
	public void end() {
		lotacaoRepository.deleteAll();
	}
    @Test
    public void deveRetornarUmaListaPaginadaLotacao(){
        ResponseEntity<String> resposta =
				testRestTemplate.exchange("/lotacao/",HttpMethod.GET, null, String.class);
                System.out.println("######## " + resposta.getBody() );
		assertEquals(HttpStatus.OK, resposta.getStatusCode());      
        assertTrue(resposta.getBody().contains("\"totalElements\":1"));
    }
    @Test
    public void status200quandoBuscarComIdValido(){
        ResponseEntity<String> resposta =
				testRestTemplate.exchange("/lotacao/"+lotacao.getId(),HttpMethod.GET, null, String.class);
                System.out.println("######## " + resposta.getBody() );
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }
    @Test
    public void staus404QuandoBuscarLotacaoComIdInvalido(){
        ResponseEntity<String> resposta =
				testRestTemplate.exchange("/lotacao/-1",HttpMethod.GET, null, String.class);
        System.out.println("######## " + resposta.getBody() );
		assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
    }
}
