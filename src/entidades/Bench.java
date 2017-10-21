
package entidades;

import java.util.List;

public class Bench {
    
    private Integer tentativas;
    private Integer acertos;
    private Integer erros;
    private Integer resultadosIguais;
    private float time;
    private List<Cpf> listCpf;

    public Integer getTentativas() {
        return tentativas;
    }

    public void setTentativas(Integer tentativas) {
        this.tentativas = tentativas;
    }

    public Integer getAcertos() {
        return acertos;
    }

    public void setAcertos(Integer acertos) {
        this.acertos = acertos;
    }

    public Integer getErros() {
        return erros;
    }

    public void setErros(Integer erros) {
        this.erros = erros;
    }

    public Integer getResultadosIguais() {
        return resultadosIguais;
    }

    public void setResultadosIguais(Integer resultadosIguais) {
        this.resultadosIguais = resultadosIguais;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public List<Cpf> getListCpf() {
        return listCpf;
    }

    public void setListCpf(List<Cpf> listCpf) {
        this.listCpf = listCpf;
    }
    
    
    public Double getProporcaoAcerto(){
    
        return new Double ((100 * acertos.intValue()) / tentativas.intValue());
        
    }
    
    public Double getProporcaoErros(){
        
        return new Double((100 * erros.intValue()) / tentativas.intValue());
        
    }
    
    public Double getTentativasPSecond(){
        
        return tentativas/Double.parseDouble(Float.toString(time));
        
    }
    
    public Double getErrosPSecond(){
        
        return erros/Double.parseDouble(Float.toString(time));
        
    }
    
    public Double getAcertosPSecond(){
        
        return acertos/Double.parseDouble(Float.toString(time));
        
    }
    
}
