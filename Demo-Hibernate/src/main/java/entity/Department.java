package entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="Department")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name="name", length = 50,nullable = false,unique = true)
    private String name;

    public Department() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
