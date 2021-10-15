package gov.ma.apiseap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServidorController {
    @Autowired
    private ServidorService servidorService;

    public void cadastrarServidor(){

    }
    public void buscaServidorPor(String matricula){

    }
}
