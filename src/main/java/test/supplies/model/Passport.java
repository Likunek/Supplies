package test.supplies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(schema = "public", name = "pts")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uin", nullable = false, updatable = false, unique = true)
    private Integer id;
    @Column(name = "unts", nullable = false, unique = true)
    private String number;

    @OneToOne
    @JoinColumn(name = "tid")
    private Type type;

    @OneToOne
    @JoinColumn(name = "firmid")
    private Firm firm;
    @Column(name = "grp", nullable = false)
    private double tonnage;
    @Column(name = "normt", nullable = false)
    private double normExpense;
    @Column(name = "datasp")
    private LocalDate dateEnd;
}
