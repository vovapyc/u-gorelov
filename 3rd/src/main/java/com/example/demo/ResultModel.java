package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double ele;
    private String result;

    protected ResultModel() {
    }

    public ResultModel(double ele, String result) {
        this.ele = ele;
        this.result = result;
    }

//    @Override
//    public String toString() {
//        return String.format(
//                "Model[id=%d, lat='%s', lon='%s']",
//                id, lat, lon);
//    }

    public Long getId() {
        return id;
    }

    public double getEle() {
        return ele;
    }

    public String getResult() {
        return result;
    }
}