package gov.ma.apiseap.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.service.LotacaoService;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    @Autowired
    private LotacaoService lotacaoService;

    @PostMapping
    public ResponseEntity<Lotacao> cadastrarLotacao(@RequestBody @Valid Lotacao lotacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.lotacaoService.salva(lotacao));
    }
    @GetMapping()
    public Page<Lotacao> lista(
        @RequestParam(required = false) String descricao,
        @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5)
        Pageable paginacao){
            if(descricao == null){
                Page<Lotacao> pageLotacao = this.lotacaoService.buscaCom(paginacao);
                return pageLotacao;
            }else{
                Page<Lotacao> pageLotacaoSemNome = this.lotacaoService.buscaPor(descricao,paginacao);
                return pageLotacaoSemNome;
            }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lotacao> buscaLotacaoPor(@PathVariable Integer id){
        Optional<Lotacao> optional = this.lotacaoService.buscaPor(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Integer id){
		Optional<Lotacao> lotacao = lotacaoService.buscaPor(id);
		if(lotacao.isPresent()) {
			this.lotacaoService.deletePor(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
