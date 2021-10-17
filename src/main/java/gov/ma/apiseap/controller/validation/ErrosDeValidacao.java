package gov.ma.apiseap.controller.validation;

public class ErrosDeValidacao {
    private String compo;
    private String mensagem;
    public ErrosDeValidacao(String compo, String mensagem) {
        this.compo = compo;
        this.mensagem = mensagem;
    }
    public String getCompo() {
        return compo;
    }
    public String getMensagem() {
        return mensagem;
    }

}
