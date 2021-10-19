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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.model.Servidor;
import gov.ma.apiseap.repository.ServidorRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServidorControllerTest {
    @Autowired
	private TestRestTemplate testRestTemplate;
    private Servidor servidor;
    private Lotacao lotacao;
    @Autowired
    private ServidorRepository servidorRepository;
    
    @BeforeEach
	public void start() {
        lotacao = new Lotacao("Desc Lotacao Para Sevidor HTTP",LocalDate.of(2021, 10, 16));
        servidor = new Servidor("Felipe", "GOVMA2021", LocalDate.of(2020, 02, 13), lotacao);
        servidorRepository.save(servidor);
	}

	@AfterEach
	public void end() {
		servidorRepository.deleteAll();     
	}
    @Test
    public void status200quandoBuscarServidorMatricula(){
        ResponseEntity<Servidor> resposta =
        testRestTemplate.exchange("/servidor/matricula/{matricula}",HttpMethod.GET,null, Servidor.class,servidor.getMatricula());
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(resposta.getHeaders().getContentType(),MediaType.parseMediaType("application/json"));
        assertTrue(resposta.getBody().getMatricula().equals(servidor.getMatricula()));
    }
    @Test
    public void staus404QuandoNaoEncontrarServidor(){
        String matriculaInexitente = "MA2007";
        ResponseEntity<Servidor> resposta =
        testRestTemplate.exchange("/servidor/matricula/{matricula}",HttpMethod.GET,null, Servidor.class,matriculaInexitente);
        assertEquals(HttpStatus.NOT_FOUND, resposta.getStatusCode());
    }

}
