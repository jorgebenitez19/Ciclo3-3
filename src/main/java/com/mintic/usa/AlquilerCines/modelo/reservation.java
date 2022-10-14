package com.mintic.usa.AlquilerCines.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name="cinema_id")
    @JsonIgnoreProperties("reservations")
    private cinema cinema;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"reservations", "messages"})
    private client client;

    @OneToOne
    @JsonIgnoreProperties("reservation")
    private score score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public cinema getCinema() {
        return cinema;
    }

    public void setCinema(cinema cinema) {
        this.cinema = cinema;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }

    public score getScore() {
        return score;
    }

    public void setScore(score score) {
        this.score = score;
    }
}
