package com.issc.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Websites {
    private int id;
    private String name;
    private String url;
    private int alexa;
    private String country;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "alexa")
    public int getAlexa() {
        return alexa;
    }

    public void setAlexa(int alexa) {
        this.alexa = alexa;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Websites websites = (Websites) o;

        if (id != websites.id) return false;
        if (alexa != websites.alexa) return false;
        if (name != null ? !name.equals(websites.name) : websites.name != null) return false;
        if (url != null ? !url.equals(websites.url) : websites.url != null) return false;
        if (country != null ? !country.equals(websites.country) : websites.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + alexa;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
