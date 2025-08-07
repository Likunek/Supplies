package test.supplies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Entity
@Table(schema = "public", name = "dmlavt")
public class Waybill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "uin")
    private Passport pts;
    @Column(name = "serpl", nullable = false, unique = true)
    private String data;
    @Column(name = "data", nullable = false)
    private LocalDate dateOfIssue;
    @Column(name = "dataret", nullable = false)
    private LocalDate dateOfDelivery;
    @Column(name = "timebeg", nullable = false)
    private LocalTime timeBegin;
    @Column(name = "timeend", nullable = false)
    private LocalTime timeEnd;
    @Column(name = "worktime", nullable = false)
    private double workTime;
    @Column(name = "prostoy", nullable = false)
    private double downtime;
    @Column(name = "prostoytpr")
    private double downtimeForThoseReasons;
    @Column(name = "prostoygr")
    private double downtimeDueToLoading;
    @Column(name = "speedb", nullable = false)
    private double exitSpeed;
    @Column(name = "speede", nullable = false)
    private double entranceSpeed;
    @Column(name = "topid", nullable = false)
    private String fuelType;
    @Column(name = "tostv", nullable = false)
    private double fuelQuantityAtDeparture;
    @Column(name = "tv", nullable = false)
    private double fuelIssued;
    @Column(name = "ts", nullable = false)
    private double fuelDeposited;
    @Column(name = "tovz", nullable = false)
    private double fuelQuantityAtEntrance;
    @Column(name = "pergr", nullable = false)
    private double CargoVolume;
    @Column(name = "pergrtkm")
    private double totalTransportedCargoVolume;
}






