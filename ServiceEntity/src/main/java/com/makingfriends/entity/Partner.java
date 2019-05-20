package com.makingfriends.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2019/4/27.
 */
@Data
@ToString
public class Partner {
    private Integer id;
    private Integer pid;
    private Integer ages;
    private Integer highs;
    private Integer marriages;
    private String incomes;
    private String educations;
    private String address;
    private String character;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    public Integer getHighs() {
        return highs;
    }

    public void setHighs(Integer highs) {
        this.highs = highs;
    }

    public Integer getMarriages() {
        return marriages;
    }

    public void setMarriages(Integer marriages) {
        this.marriages = marriages;
    }

    public String getIncomes() {
        return incomes;
    }

    public void setIncomes(String incomes) {
        this.incomes = incomes;
    }

    public String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
