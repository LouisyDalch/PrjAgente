public class Matricula {
    private int idMatricula;
    private int semestres;
    private Aluno aluno;
    
    public Matricula(int idMatricula, int semestres, Aluno aluno) {
        this.idMatricula = idMatricula;
        this.semestres = semestres;
        this.aluno = aluno;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public int getSemestres() {
        return semestres;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setSemestres(int semestres) {
        this.semestres = semestres;
    }
   
}
