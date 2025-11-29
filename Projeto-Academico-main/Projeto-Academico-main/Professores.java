
import java.util.List;

public class Professores {
    private int matricula;
    private String nome;
    private List<Disciplinas> disciplina;
    private Cursos curso;

    public Professores(int matricula, String nome, List<Disciplinas> disciplina, Cursos curso){
        this.matricula = matricula;
        this.nome = nome;
        this.disciplina = disciplina;
        this.curso = curso;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNome(){
        return nome;
    }

    public List<Disciplinas> getDisciplina(){
        return disciplina;
    }

    public Cursos getCurso(){
        return curso;
    }

    @Override
    public String toString(){
        return matricula + " | " + nome + " | " + disciplina + " | " + curso;
    }

}
