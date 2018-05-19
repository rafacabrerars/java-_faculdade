/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectionFactory;


/**
 *
 * @author internet
 */
public class UsuarioDAO {

    // Variável para receber a conexão do banco de dados
    private final Connection conexao;

    /**
     * Método construtor da classe que recebe uma conexão ao ser instanciada
     *
     * @throws java.sql.SQLException
     */
    public UsuarioDAO() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

    /**
     * Método inserir - Insere um novo registro no banco de dados
     *
     * @param p Objeto Pessoa
     * @return String Mensagem de sucesso ou erro na inclusão
     * @throws SQLException
     */
    public String inserir(Usuario u) throws SQLException {

        // Instrução SQL para inclusão do registro
        String sql = "INSERT INTO pessoa (nome, telefone) VALUES (?, ?)";

        try {
            try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                    PreparedStatement ps = conexao.prepareStatement(sql)) {

                // Inclui os valores a serem atribuidos à instrução SQL
                ps.setString(1, u.getNome());
                ps.setString(2, u.getSenha());
                ps.setString(3, u.getCsenha());
                ps.setString(4, u.getEmail());
                

                // Executa a instrução de inclusão do registro
                ps.execute();
            }

            // Fecha a conexão
            conexao.close();

            // Retorna uma mensagem de sucesso
            return "Registro incluído com sucesso!";

        } catch (SQLException e) {

            // Retorna uma mensagem de erro
            return e.getMessage();
        }
    }

    /**
     * Método editar - Retorna o registro solicitado para edição
     *
     * @param p Objeto Pessoa
     * @return List Lista o registro encontrado
     * @throws java.sql.SQLException
     */
    public List<Usuario> editar(Usuario u) throws SQLException {

        // Instrução SQL para recuperar o registro
        String sql = "SELECT * FROM pessoa "
                + "WHERE id = ?;";

        // Lista para receber o registro recuperado
        List lstUsuario = new ArrayList();

        try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                PreparedStatement ps = conexao.prepareStatement(sql)) {

            // Inclui o id informado à instrução SQL
            ps.setInt(1, u.getId());

            // Avança o registro para recuperar os dados retornados do banco de dados
            try ( // Objeto que armazenará os dados recuperados (ResultSet)
                    ResultSet rs = ps.executeQuery()) {

                /**
                 * Avança o registro para recuperar os dados retornados do banco
                 * de dados
                 */
                rs.next();

                // Cria um objeto Pessoa
                u = new Usuario();

                // Atribui ao objeto Pessoa os valores retornados do banco
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setCsenha(rs.getString("csenha"));
                u.setEmail(rs.getString("email"));

                // Adiciona o objeto pessoa na lista
                lstUsuario.add(u);
            }
        }

        // Fecha a conexão
        conexao.close();

        // Retorna a lista com o registro solicitado
        return lstUsuario;
    }

    /**
     * Método excluir - Realiza a exclusão de um registro pelo ID informado
     *
     * @param p Objeto Pessoa
     * @return String Mensagem de sucesso ou erro na exclusão
     * @throws java.sql.SQLException
     */
    public String excluir(Usuario u) throws SQLException {

        // Instrução SQL para recuperar os registros
        String sql = "DELETE FROM pessoa "
                + "WHERE id = ?;";

        try {
            try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                    PreparedStatement ps = conexao.prepareStatement(sql)) {

                // Inclui o valor informado a ser atribuido à instrução SQL
                ps.setInt(1, u.getId());

                // Executa a exclusão
                ps.executeUpdate();
            }

            // Fecha a conexão
            conexao.close();

            // Retorna a mensagem de exclusão
            return "Registro excluído com sucesso!";

        } catch (SQLException e) {

            // Retorna o erro ocorrido caso ão consiga excluir
            return e.getMessage();
        }

    }

    /**
     * Método alterar - Realiza a gravação (alteração) do registro no banco de
     * dados
     *
     * @param p Objeto Pessoa
     * @return Mensagem de sucesso ou erro na alteração (salvamento do registro)
     */
    public String alterar(Usuario u) {
        // Instrução SQL para atualização do registro
        String sql = "UPDATE pessoa SET "
                + "nome = ?, telefone = ? "
                + "WHERE id = ?;";

        try {
            try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                    PreparedStatement ps = conexao.prepareStatement(sql)) {

                // Inclui os valores a serem atribuidos à instrução SQL
                ps.setString(1, u.getNome());
                ps.setString(2, u.getSenha());
                ps.setString(3, u.getCsenha());
                ps.setString(4, u.getEmail());
                ps.setInt(5, u.getId());

                // Executa a instrução de atualização do registro
                ps.executeUpdate();
            }

            // Fecha a conexão
            conexao.close();

            // Retorna uma mensagem de sucesso
            return "Registro alterado com sucesso!";

        } catch (SQLException e) {

            // Retorna uma mensagem de erro
            return e.getMessage();
        }
    }

    /**
     * Método Pesquisar - Realiza a pesquisa de um registro específico pelo ID
     *
     * @param p Objeto Pessoa
     * @return List Lista com registros encontrados
     * @throws java.sql.SQLException
     */
    public List<Usuario> pesquisar(Usuario u) throws SQLException {

        // Instrução SQL para recuperar os registros
        String sql = "SELECT * FROM pessoa "
                + "WHERE nome like ? ORDER BY nome ASC;";

        // Lista para receber os registros recuperados
        List lstUsuarios = new ArrayList();

        try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            // Inclui o valor informado a ser atribuido à instrução SQL
            ps.setString(1, u.getNome());

            try ( // Objeto que armazenará os dados recuperados (recordSet)
                    ResultSet rs = ps.executeQuery()) {
                /**
                 * Percorre os registros retornados do banco e coloca em uma
                 * lista
                 */
                while (rs.next()) {
                    // Cria um objeto Pessoa (bean)
                    u = new Usuario();

                    // Atribui ao objeto Pessoa os valores retornados do banco
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setSenha(rs.getString("senha"));
                    u.setCsenha(rs.getString("csenha"));
                    u.setEmail(rs.getString("email"));

                    // Adiciona o objeto Pessoa na lista de pessoas
                    lstUsuarios.add(u);
                }
            }
        }

        // Fecha a conexão
        conexao.close();

        // Retorna a lista com as pessoas encontradas
        return lstUsuarios;
    }

    /**
     * Método listar - Recupera todos os registros no banco de dados
     *
     * @return List Retorna todos os registros contidos no banco de dados
     * @throws java.sql.SQLException
     *
     */
    public List<Usuario> listar() throws SQLException {

        // Instrução SQL para recuperar os registros
        String sql = "SELECT * FROM pessoa ORDER BY nome ASC;";

        // Lista para receber os registros recuperados
        List lstUsuarios = new ArrayList();

        try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                PreparedStatement ps = conexao.prepareStatement(sql);
                // Objeto que armazenará os dados recuperados (ResultSet)
                ResultSet rs = ps.executeQuery()) {
            /**
             * Percorre os registros retornados do banco de dados e coloca em
             * uma lista (lstPessoas)
             */
            while (rs.next()) {
                // Cria um objeto Pessoa
                Usuario u = new Usuario();

                // Atribui ao objeto Pessoa os valores retornados do banco
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setCsenha(rs.getString("csenha"));
                u.setEmail(rs.getString("email"));

                // Adiciona o objeto Pessoa na lista de pessoas
                lstUsuarios.add(u);
            }
        }

        // Fecha a conexão
        conexao.close();

        // Retorna a lista com as pessoas encontradas
        return lstUsuarios;
    }
}
