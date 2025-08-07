package test.supplies.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(schema = "public", name = "dmapr")
public class ListTrailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "uin_pts")
    private Passport pts;
    @Column(name = "pergr")
    private double CargoVolume;
    @ManyToOne
    @JoinColumn(name = "dml_id")
    private Waybill waybill;
}
