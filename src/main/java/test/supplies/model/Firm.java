package test.supplies.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "v_firm")
public class Firm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "firmid", nullable = false, updatable = false, unique = true)
    private Integer id;
    @Column(name = "tlgr", nullable = false, unique = true)
    private String name;
    @Column(name = "disloc", nullable = false, unique = true)
    private String location;
}
