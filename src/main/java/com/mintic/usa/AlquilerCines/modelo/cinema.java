package com.mintic.usa.AlquilerCines.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.bridge.Message;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cinema")
public class cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String owner;
    private Number capacity;
    private Number category_id;
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("cinemas")
    private category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema", "client"})
    private List<message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinema", "messages"})
    private List<reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Number getCapacity() {
        return capacity;
    }

    public void setCapacity(Number capacity) {
        this.capacity = capacity;
    }

    public Number getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Number category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public List<message> getMessages() {
        return messages;
    }

    public void setMessages(List<message> messages) {
        this.messages = messages;
    }

    public List<reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<reservation> reservations) {
        this.reservations = reservations;
    }
}
