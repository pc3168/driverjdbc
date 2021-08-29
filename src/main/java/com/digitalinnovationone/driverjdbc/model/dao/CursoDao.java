package com.digitalinnovationone.driverjdbc.model.dao;

import com.digitalinnovationone.driverjdbc.db.connection.ConnectionFactory;
import com.digitalinnovationone.driverjdbc.model.Curso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class CursoDao {

    private ConnectionFactory connectionFactory;
    private java.sql.PreparedStatement pstmt;

    public CursoDao(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

    private String inserir(){
        return "insert into cursos (nome, duracao_horas) values (?,?)";
    }

    public void inserir(Curso entidade){
        try(Connection con = connectionFactory.connection()){
            pstmt = con.prepareStatement(inserir());
            pstmt.setString(1, entidade.getNome());
            pstmt.setTime(2, entidade.getDuracaoHoras());
            pstmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String deletar() {
        return "DELETE FROM cursos WHERE id = ?";
    }

    public void deletar(int id) {
        try (Connection con = connectionFactory.connection()){
            pstmt = con.prepareStatement(deletar());
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String atualizar() {
        return "UPDATE cursos set nome = ? , duracao_horas = ? WHERE id = ? ";
    }

    public void atualizar(Curso entidade){
        try(Connection con = connectionFactory.connection()) {
            pstmt = con.prepareStatement(atualizar());
            pstmt.setString( 1, entidade.getNome());
            pstmt.setTime(2, entidade.getDuracaoHoras());
            pstmt.setInt(3, entidade.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String select(){
        return "SELECT * from cursos order by id";
    }

    public List<Curso> pesquisar(){
        List<Curso> lista = null;
        try (Connection con = connectionFactory.connection()){
            pstmt = con.prepareStatement(select());
            lista = resultado(pstmt.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private List<Curso> resultado(ResultSet rs) throws java.sql.SQLException{
        List<Curso> lista = new java.util.ArrayList<>();
        Curso entidade;
        while(rs.next()){
            entidade = new Curso();
            entidade.setId(rs.getInt("id"));
            entidade.setNome(rs.getString("nome"));
            entidade.setDuracaoHoras(rs.getTime("duracao_horas"));
            lista.add(entidade);
        }
        return lista;
    }

}
