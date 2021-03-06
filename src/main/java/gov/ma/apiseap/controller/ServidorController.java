package gov.ma.apiseap.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ma.apiseap.exception.MatriculaInvalidaException;
import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.model.Servidor;
import gov.ma.apiseap.service.ServidorService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/servidor")
public class ServidorController {
    @Autowired
    private ServidorService servidorService;
    @PostMapping
    public ResponseEntity<Servidor> cadastrarServidor(@RequestBody @Valid Servidor servidor) throws MatriculaInvalidaException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.servidorService.salva(servidor));
    }
    @GetMapping("matricula/{matricula}")
    public ResponseEntity<Servidor> buscaServidorPor(@PathVariable String matricula){
        Optional<Servidor> servidor = this.servidorService.buscaPor(matricula);
        if(servidor.isPresent()){
            return ResponseEntity.ok(servidor.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<Lotacao>> buscaLotacaoPor(@RequestParam String nome) {
        List<Lotacao> lotacaos = this.servidorService.lotacaoPor(nome);
        if(lotacaos.isEmpty()){
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(lotacaos);
    }
    @DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Integer id){
		Optional<Servidor> servidor = servidorService.buscaPor(id);
		if(servidor.isPresent()) {
			this.servidorService.deletePor(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
    @GetMapping("/{id}")
    public ResponseEntity<Servidor> buscaServidoroPor(@PathVariable Integer id){
        Optional<Servidor> optional = this.servidorService.buscaPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
