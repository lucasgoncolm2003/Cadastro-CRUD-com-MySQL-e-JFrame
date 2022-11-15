package DAO;
import DTO.UsuarioDTO;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();
    public void cadastrarFuncionario(UsuarioDTO objusuariodto){
        String sql = "INSERT INTO funcionario (nome_funcionario, endereco_funcionario, cargo_funcionario, cel_funcionario, cnh_funcionario, contrato_funcionario, cpf_funcionario, email_funcionario, idade_funcionario, rg_funcionario, setor_funcionario, sexo_funcionario, tel_funcionario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        conn = new ConexaoDAO().conectaBD();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_funcionario());
            pstm.setString(2, objusuariodto.getEndereco_funcionario());
            pstm.setString(3, objusuariodto.getCargo_funcionario());
            pstm.setString(4, objusuariodto.getCel_funcionario());
            pstm.setString(5, objusuariodto.getCnh_funcionario());
            pstm.setString(6, objusuariodto.getContrato_funcionario());
            pstm.setString(7, objusuariodto.getCpf_funcionario());
            pstm.setString(8, objusuariodto.getEmail_funcionario());
            pstm.setString(9, objusuariodto.getIdade_funcionario());
            pstm.setString(10, objusuariodto.getRg_funcionario());
            pstm.setString(11, objusuariodto.getSetor_funcionario());
            pstm.setString(12, objusuariodto.getSexo_funcionario());
            pstm.setString(13, objusuariodto.getTel_funcionario());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Cadastrar:" + erro);
        }
    }
    private Statement st;
    public ArrayList<UsuarioDTO> PesquisarFuncionario(){
        String sql = "SELECT * FROM funcionario";
        conn = new ConexaoDAO().conectaBD();
        try{
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                UsuarioDTO objusuarioDTO = new UsuarioDTO();
                objusuarioDTO.setId(rs.getInt("id"));
                objusuarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objusuarioDTO.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                objusuarioDTO.setCargo_funcionario(rs.getString("cargo_funcionario"));
                objusuarioDTO.setCel_funcionario(rs.getString("cel_funcionario"));
                objusuarioDTO.setCnh_funcionario(rs.getString("cnh_funcionario"));
                objusuarioDTO.setContrato_funcionario(rs.getString("contrato_funcionario"));
                objusuarioDTO.setCpf_funcionario(rs.getString("cpf_funcionario"));
                objusuarioDTO.setEmail_funcionario(rs.getString("email_funcionario"));
                objusuarioDTO.setIdade_funcionario(rs.getString("idade_funcionario"));
                objusuarioDTO.setRg_funcionario(rs.getString("rg_funcionario"));
                objusuarioDTO.setSetor_funcionario(rs.getString("setor_funcionario"));
                objusuarioDTO.setSexo_funcionario(rs.getString("sexo_funcionario"));
                objusuarioDTO.setTel_funcionario(rs.getString("tel_funcionario"));
                lista.add(objusuarioDTO);
            }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "UsuarioDAO Pesquisar: " + erro);
        }
        return lista;
    }
    public void alterarFuncionario(UsuarioDTO objusuariodto){
        String sql = "UPDATE funcionario SET endereco_funcionario = ?, cargo_funcionario = ?, cel_funcionario = ?, cnh_funcionario = ?, contrato_funcionario = ?, cpf_funcionario = ?, email_funcionario = ?, idade_funcionario = ?, rg_funcionario = ?, setor_funcionario = ?, sexo_funcionario = ?, tel_funcionario = ? WHERE nome_funcionario = ?;";
        conn = new ConexaoDAO().conectaBD();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getEndereco_funcionario());
            pstm.setString(2, objusuariodto.getCargo_funcionario());
            pstm.setString(3, objusuariodto.getCel_funcionario());
            pstm.setString(4, objusuariodto.getCnh_funcionario());
            pstm.setString(5, objusuariodto.getContrato_funcionario());
            pstm.setString(6, objusuariodto.getCpf_funcionario());
            pstm.setString(7, objusuariodto.getEmail_funcionario());
            pstm.setString(8, objusuariodto.getIdade_funcionario());
            pstm.setString(9, objusuariodto.getRg_funcionario());
            pstm.setString(10, objusuariodto.getSetor_funcionario());
            pstm.setString(11, objusuariodto.getSexo_funcionario());
            pstm.setString(12, objusuariodto.getTel_funcionario());
            pstm.setString(13, objusuariodto.getNome_funcionario());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Alterar: " + erro);
        }
    }
    public void excluirFuncionario(UsuarioDTO objusuariodto){
        String sql = "DELETE FROM funcionario WHERE nome_funcionario = ?;";
        conn = new ConexaoDAO().conectaBD();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_funcionario());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Excluir: " + erro);
        }
    }
    public void excluirTudo(UsuarioDTO objusuariodto){
        String sql = "DELETE FROM funcionario;";
        conn = new ConexaoDAO().conectaBD();
        try{
            pstm = conn.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Excluir Tudo: " + erro);
        }
    }
}
