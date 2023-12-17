package Interfaces;

import Dao.MysqlDb;
import models.ToDo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOToDoImplement extends MysqlDb implements DAOToDo{

    @Override
    public List<ToDo> getTodoList(){
        
        List<ToDo> toDoList = new ArrayList<>();
        
        try{
            
            this.connect();
            String sql = "SELECT * FROM todolist;";
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                boolean status = rs.getBoolean("status");
                
                ToDo todo = new ToDo(id, description, status);
                toDoList.add(todo);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener las tareas");
        }finally{
            this.disconnect();
        }
        
        return toDoList;
    }

    @Override
    public void create(ToDo todo) {
        try{
            
            this.connect();
            String sql = "INSERT INTO todolist(description, status) VALUES(?,?);";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, todo.getDescription());
            st.setBoolean(2, todo.isStatus());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Tarea creada satisfactoriamente");
            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear la tarea");
        } finally {
            this.disconnect();
        }
    }

    @Override
    public void update(ToDo todo) {
        try{
            
            this.connect();
            String sql = "UPDATE todolist SET description= ?, status= ? WHERE id=?;";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, todo.getDescription());
            st.setBoolean(2, todo.isStatus());
            st.setInt(3, todo.getId());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Tarea actualizada satisfactoriamente");
            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar la tarea");
        } finally {
            this.disconnect();
        }
    }

    @Override
    public void delete(int id) {
        try{
            
            this.connect();
            String sql = "DELETE FROM todolist WHERE id=?;";
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Tarea eliminada satisfactoriamente");
            
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar la tarea");
        } finally {
            this.disconnect();
        }
    }
    
    
}
