package id.co.mii.serverapp.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private LocalDate expired;

    @ManyToOne
    @JoinColumn(name = "current_status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employee;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "survey", cascade = CascadeType.ALL)
    private Result result;
}