public class Cursos {
    private int codigo;
    private String nome;

    public Cursos(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return codigo + " | " + nome;
    }
}
//System.out.println("Código: " + codigo + " | nome -> " + nome);