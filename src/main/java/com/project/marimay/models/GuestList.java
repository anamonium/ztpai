package com.project.marimay.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "guest_list", schema = "public", catalog = "postgres")
public class GuestList {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_guest_list")
    private String idGuestList;
    @Basic
    @Column(name = "invited")
    private Integer invited;
    @Basic
    @Column(name = "accepted")
    private Integer accepted;
    @OneToOne
    @JoinColumn(name = "id_guest_list", referencedColumnName = "id_wedding_details", nullable = false)
    private WeddingDetails weddingDetailsByIdGuestList;
    @OneToMany(mappedBy = "guestListByIdGuestlist")
    private Collection<Guests> guestsByIdGuestList;

    public String getIdGuestList() {
        return idGuestList;
    }

    public void setIdGuestList(String idGuestList) {
        this.idGuestList = idGuestList;
    }

    public Integer getInvited() {
        return invited;
    }

    public void setInvited(Integer invited) {
        this.invited = invited;
    }

    public Integer getAccepted() {
        return accepted;
    }

    public void setAccepted(Integer accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestList guestList = (GuestList) o;

        if (idGuestList != null ? !idGuestList.equals(guestList.idGuestList) : guestList.idGuestList != null)
            return false;
        if (invited != null ? !invited.equals(guestList.invited) : guestList.invited != null) return false;
        if (accepted != null ? !accepted.equals(guestList.accepted) : guestList.accepted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGuestList != null ? idGuestList.hashCode() : 0;
        result = 31 * result + (invited != null ? invited.hashCode() : 0);
        result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
        return result;
    }

    public WeddingDetails getWeddingDetailsByIdGuestList() {
        return weddingDetailsByIdGuestList;
    }

    public void setWeddingDetailsByIdGuestList(WeddingDetails weddingDetailsByIdGuestList) {
        this.weddingDetailsByIdGuestList = weddingDetailsByIdGuestList;
    }

    public Collection<Guests> getGuestsByIdGuestList() {
        return guestsByIdGuestList;
    }

    public void setGuestsByIdGuestList(Collection<Guests> guestsByIdGuestList) {
        this.guestsByIdGuestList = guestsByIdGuestList;
    }
}
