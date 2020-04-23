package com.issc.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apps {
    private int id;
    private String appName;
    private String url;
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
    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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

        Apps apps = (Apps) o;

        if (id != apps.id) return false;
        if (appName != null ? !appName.equals(apps.appName) : apps.appName != null) return false;
        if (url != null ? !url.equals(apps.url) : apps.url != null) return false;
        if (country != null ? !country.equals(apps.country) : apps.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Apps{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", url='" + url + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
