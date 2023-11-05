package com.zensar.tp.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_token")
public class BlackListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String auth;
    private LocalDate date;
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAuth() {
        return auth;
    }
    public void setAuth(String auth) {
        this.auth = auth;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate localDate) {
        this.date = localDate;
    }
    
    public BlackListEntity(String auth, LocalDate date) {
        super();
        this.auth = auth;
        this.date = date;
    }
    
    
    public BlackListEntity(int id, String auth, LocalDate date) {
        super();
        this.id = id;
        this.auth = auth;
        this.date = date;
    }
    public BlackListEntity() {
        super();
    }


}