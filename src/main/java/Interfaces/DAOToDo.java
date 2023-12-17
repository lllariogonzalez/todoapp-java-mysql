package Interfaces;
import models.ToDo;
import java.util.List;

public interface DAOToDo {
    public List<ToDo> getTodoList();
    public void create(ToDo todo);
    public void update(ToDo todo);
    public void delete(int id);
}
