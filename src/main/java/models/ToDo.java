package models;

public class ToDo {
    private int id;
    private String description;
    private boolean status;

    public ToDo(int id, String description, boolean status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
    
    public ToDo(String description, boolean status) {
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
