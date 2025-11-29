public class Disciplinas {
    private int codigo;
    private String nome;

    public Disciplinas(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString(){
        return codigo + " | " + nome;
    }
}