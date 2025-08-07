package test.supplies.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "vidtc")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vidt", nullable = false, updatable = false, unique = true)
    private Integer id;
    @Column(name = "shname", nullable = false, unique = true)
    private String name;
    @Column(name = "fullname", nullable = false, unique = true)
    private String fullName;
}
