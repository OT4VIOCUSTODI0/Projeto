public class Aluno {
    private int matricula;
    private String nome;
    private Cursos curso;

    public Aluno(int matricula, String nome, Cursos curso){
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNome(){
        return nome;
    }

    public Cursos getCurso(){
        return curso;
    }
    @Override
    public String toString(){
        return matricula + " - " + nome + " | " + curso;
    }
}