package tw.dennis.todolist;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todolist {
    @Id
    private long id;
    private String title;
    private String description;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
