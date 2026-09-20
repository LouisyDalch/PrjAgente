import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import io.github.cdimascio.dotenv.Dotenv;

public class App {

    public static void main(String[] args) {

        // 1. Carrega o ficheiro .env da raiz do projeto[cite: 7]
        Dotenv dotenv = Dotenv.load();

        // 2. Obtém os valores das variáveis[cite: 7]
        String url = dotenv.get("URL");
        String user = dotenv.get("USER");
        String password = dotenv.get("SENHA");


        ArrayList<Aluno> listaAlu = new ArrayList<>();
        ArrayList<Matricula> listaMat = new ArrayList<>();

        Aluno aluno1 = new Aluno(0, "Louisy Tomazi", "Sistemas de Informação");
        listaAlu.add(aluno1);
        Aluno aluno2 = new Aluno(1, "Luana Brito", "Sistemas de Informação");
        listaAlu.add(aluno2);
        Aluno aluno3 = new Aluno(2, "Gabriel Silva", "Ciências da Computação");
        listaAlu.add(aluno3);

        Matricula matricula1 = new Matricula(0, 3, aluno1);
        listaMat.add(matricula1);
        Matricula matricula2 = new Matricula(1, 4, aluno2);
        listaMat.add(matricula2);
        Matricula matricula3 = new Matricula(2, 6, aluno3);
        listaMat.add(matricula3);

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            
            //INSERÇÃO (Create)
            String sqlInsert = "INSERT INTO aluno (id, nome, curso) VALUES (?, ?, ?)";
            PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);

            for(Aluno a:listaAlu){
                pstmtInsert.setInt(1, a.getId());
                pstmtInsert.setString(2, a.getNome());
                pstmtInsert.setString(3, a.getCurso());
                
                int linhasInseridas = pstmtInsert.executeUpdate();
                if (linhasInseridas > 0) {
                    System.out.println("Registro inserido com sucesso!");
                }
            }

            sqlInsert = "INSERT INTO matricula (id, id_aluno, semestre) VALUES (?, ?, ?)";
            pstmtInsert = con.prepareStatement(sqlInsert);

            for(Matricula m:listaMat){
                pstmtInsert.setInt(1, m.getIdMatricula());
                pstmtInsert.setInt(2, m.getAluno().getId());
                pstmtInsert.setInt(3, m.getSemestres());
                
                int linhasInseridas = pstmtInsert.executeUpdate();
                if (linhasInseridas > 0) {
                    System.out.println("Registro inserido com sucesso!");
                }
            }
            
            // 2. ATUALIZAÇÃO (Update)
            aluno2.setCurso("Psicologia");

            String sqlUpdate = "UPDATE aluno SET CURSO = ? WHERE ID = ?";
            PreparedStatement pstmtUpdate = con.prepareStatement(sqlUpdate);
            pstmtUpdate.setString(1, aluno2.getCurso());
            pstmtUpdate.setInt(2, aluno2.getId()); // ID do registro que deseja atualizar
            
            int linhasAtualizadas = pstmtUpdate.executeUpdate();
            if (linhasAtualizadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            }
            
            //REMOÇÃO (Delete)
            String sqlDelete = "DELETE FROM matricula WHERE ID = ?";
            PreparedStatement pstmtDelete = con.prepareStatement(sqlDelete);
            pstmtDelete.setInt(1, matricula1.getIdMatricula()); // ID do registro que deseja remover
            listaMat.remove(matricula1);
            if(listaMat.get(0)==matricula1){
                System.out.println("Matricula não removida");
            }else{
                System.out.println("Matricula removida!");
            }
            
            int linhasRemovidas = pstmtDelete.executeUpdate();
            if (linhasRemovidas > 0) {
                System.out.println("Registro removido com sucesso!");
            }

            sqlDelete = "DELETE FROM aluno WHERE ID = ?";
            pstmtDelete = con.prepareStatement(sqlDelete);
            pstmtDelete.setInt(1, aluno1.getId()); // ID do registro que deseja remover
            listaAlu.remove(aluno1);
            if(listaAlu.get(0)==aluno1){
                System.out.println("Aluno não removido");
            }else{
                System.out.println("Aluno removido!");
            }
            
            linhasRemovidas = pstmtDelete.executeUpdate();
            if (linhasRemovidas > 0) {
                System.out.println("Registro removido com sucesso!");
            }

            //LISTAGEM 
            System.out.println("\n--- LISTA DE REGISTROS ---");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *,(select nome from aluno where id = m.id_aluno) from matricula as m");

            while (rs.next()) {
                int id = rs.getInt("ID");
                int idAluno = rs.getInt("id_aluno");
                int seme = rs.getInt("semestre");
                String nomeAluno = rs.getString("nome");
                System.out.println("idMatricula: " + id + " | idAluno: " + idAluno + " | semestre: " + seme+ " | nomeAluno: " + nomeAluno);
            }
            con.close();

        } catch (Exception e) {
            System.err.println("Erro na execução: " + e.getMessage());
            e.printStackTrace();
        }
    }
}