package com.issc.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "access_log", schema = "smartpark", catalog = "")
public class AccessLog {
    private int aid;
    private int siteId;
    private int count;
    private Date date;

    @Id
    @Column(name = "aid")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "site_id")
    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessLog accessLog = (AccessLog) o;

        if (aid != accessLog.aid) return false;
        if (siteId != accessLog.siteId) return false;
        if (count != accessLog.count) return false;
        if (date != null ? !date.equals(accessLog.date) : accessLog.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + siteId;
        result = 31 * result + count;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
