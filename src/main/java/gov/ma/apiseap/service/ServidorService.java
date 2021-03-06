package gov.ma.apiseap.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ma.apiseap.exception.MatriculaInvalidaException;
import gov.ma.apiseap.model.Lotacao;
import gov.ma.apiseap.model.Servidor;
import gov.ma.apiseap.repository.ServidorRepository;

@Service
public class ServidorService {
    @Autowired
    private ServidorRepository servidorRepository;

    @Transactional
    public Servidor salva(Servidor servidor) throws MatriculaInvalidaException{
        Optional<Servidor> servidorComMatricula = buscaPor(servidor.getMatricula());
        if(!servidorComMatricula.isPresent()){
            return servidorRepository.save(servidor);
        }
        throw new MatriculaInvalidaException("Já existe uma Matricula com mesmo código");
    }
    public Optional<Servidor> buscaPor(String matricula){
        return this.servidorRepository.findByMatricula(matricula);
    }
    public List<Lotacao> lotacaoPor(String nome) {
        List<Servidor> listServidor = 
         this.servidorRepository.findByNome(nome);

        return listServidor.stream().map(Servidor::getTipoLotacao)
        .collect(Collectors.toList());       
    }
    public Optional<Servidor> buscaPor(Integer id) {
        if(id > 0){
            return this.servidorRepository.findById(id);
        }
        return Optional.empty();     
    }
    @Transactional
	public void deletePor(Integer id) {
		this.servidorRepository.deleteById(id);
	}
}
