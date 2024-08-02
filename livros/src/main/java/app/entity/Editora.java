package app.entity;

public class Editora {

    private long id;
    private String nome;
    private String endereco;


    public Editora(){

    }

    public Editora(long id, String nome, String endereco){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


