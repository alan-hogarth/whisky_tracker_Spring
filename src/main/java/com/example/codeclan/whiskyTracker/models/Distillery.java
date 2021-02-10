package com.example.codeclan.whiskyTracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="distilleries")
public class Distillery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String region;

    @OneToMany(mappedBy = "distillery")
    @JsonIgnoreProperties({"distillery"})
    private List<Whisky> whiskyList;

    public Distillery(String name, String region) {
        this.name = name;
        this.region = region;
        this.whiskyList = new ArrayList<>();
    }

    public Distillery() {
    }

    public void addWhiskyToDistillery(Whisky whisky){
        this.whiskyList.add(whisky);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Whisky> getWhiskyList() {
        return whiskyList;
    }

    public void setWhiskyList(List<Whisky> whiskyList) {
        this.whiskyList = whiskyList;
    }
}
