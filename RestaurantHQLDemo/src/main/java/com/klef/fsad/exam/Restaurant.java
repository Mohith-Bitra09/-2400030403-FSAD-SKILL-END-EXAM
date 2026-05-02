package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    public Restaurant() {}

    public Restaurant(String name, Date date, String status) {
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDate(Date date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
}