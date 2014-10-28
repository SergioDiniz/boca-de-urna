package classes;

/**
 *
 * @author Fatinha de Sousa
 */

public class Candidato {

    private String nome;
    private int numero;
    private int qtdVotos;
    
    public Candidato(){
    
    }
    
    public Candidato(String nome, int numero, int qtdVotos){
        this.nome = nome;
        this.numero = numero;
        this.qtdVotos = qtdVotos;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdVotos() {
        return qtdVotos;
    }

    public void setQtdVotos(int qtdVotos) {
        this.qtdVotos = qtdVotos;
    }
    
    
}
