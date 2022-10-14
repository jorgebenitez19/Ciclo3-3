package com.mintic.usa.AlquilerCines.modelo;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="cinema_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private cinema cinema;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}
