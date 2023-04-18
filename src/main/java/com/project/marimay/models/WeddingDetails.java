package com.project.marimay.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "wedding_details", schema = "public", catalog = "postgres")
public class WeddingDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_wedding_details")
    private String idWeddingDetails;
    @Basic
    @Column(name = "wedding_date")
    private Date weddingDate;
    @OneToOne(mappedBy = "weddingDetailsByIdBudget")
    private Budget budgetByIdWeddingDetails;
    @OneToOne(mappedBy = "weddingDetailsByIdChecklist")
    private Checklist checklistByIdWeddingDetails;
    @OneToOne(mappedBy = "weddingDetailsByIdGuestList")
    private GuestList guestListByIdWeddingDetails;
    @OneToOne
    @JoinColumn(name = "id_wedding_details", referencedColumnName = "id_user", nullable = false)
    private Users usersByIdWeddingDetails;

    public String getIdWeddingDetails() {
        return idWeddingDetails;
    }

    public void setIdWeddingDetails(String idWeddingDetails) {
        this.idWeddingDetails = idWeddingDetails;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeddingDetails that = (WeddingDetails) o;

        if (idWeddingDetails != null ? !idWeddingDetails.equals(that.idWeddingDetails) : that.idWeddingDetails != null)
            return false;
        if (weddingDate != null ? !weddingDate.equals(that.weddingDate) : that.weddingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWeddingDetails != null ? idWeddingDetails.hashCode() : 0;
        result = 31 * result + (weddingDate != null ? weddingDate.hashCode() : 0);
        return result;
    }

    public Budget getBudgetByIdWeddingDetails() {
        return budgetByIdWeddingDetails;
    }

    public void setBudgetByIdWeddingDetails(Budget budgetByIdWeddingDetails) {
        this.budgetByIdWeddingDetails = budgetByIdWeddingDetails;
    }

    public Checklist getChecklistByIdWeddingDetails() {
        return checklistByIdWeddingDetails;
    }

    public void setChecklistByIdWeddingDetails(Checklist checklistByIdWeddingDetails) {
        this.checklistByIdWeddingDetails = checklistByIdWeddingDetails;
    }

    public GuestList getGuestListByIdWeddingDetails() {
        return guestListByIdWeddingDetails;
    }

    public void setGuestListByIdWeddingDetails(GuestList guestListByIdWeddingDetails) {
        this.guestListByIdWeddingDetails = guestListByIdWeddingDetails;
    }

    public Users getUsersByIdWeddingDetails() {
        return usersByIdWeddingDetails;
    }

    public void setUsersByIdWeddingDetails(Users usersByIdWeddingDetails) {
        this.usersByIdWeddingDetails = usersByIdWeddingDetails;
    }
}
