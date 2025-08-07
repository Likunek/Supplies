package test.supplies.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "tiptr")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false, updatable = false, unique = true)
    private Integer id;
    @Column(name = "tname", nullable = false, unique = true)
    private String name;
    @OneToOne
    @JoinColumn(name = "vidt")
    private View view;
    @Column(name = "prizngr")
    private String sign;
}
