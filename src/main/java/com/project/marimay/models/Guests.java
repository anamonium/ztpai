package com.project.marimay.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Guests {
    public Guests(){}
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_guest")
    private String idGuest;
    @Basic
    @Column(name = "id_guestlist")
    private String idGuestlist;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "plus_one")
    private Boolean plusOne;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_guestlist", insertable = false, updatable = false)
    private GuestList guestListByIdGuestlist;

    public String getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(String idGuest) {
        this.idGuest = idGuest;
    }

    public String getIdGuestlist() {
        return idGuestlist;
    }

    public void setIdGuestlist(String idGuestlist) {
        this.idGuestlist = idGuestlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(Boolean plusOne) {
        this.plusOne = plusOne;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guests guests = (Guests) o;

        if (idGuest != null ? !idGuest.equals(guests.idGuest) : guests.idGuest != null) return false;
        if (idGuestlist != null ? !idGuestlist.equals(guests.idGuestlist) : guests.idGuestlist != null) return false;
        if (name != null ? !name.equals(guests.name) : guests.name != null) return false;
        if (surname != null ? !surname.equals(guests.surname) : guests.surname != null) return false;
        if (phone != null ? !phone.equals(guests.phone) : guests.phone != null) return false;
        if (plusOne != null ? !plusOne.equals(guests.plusOne) : guests.plusOne != null) return false;
        if (status != null ? !status.equals(guests.status) : guests.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGuest != null ? idGuest.hashCode() : 0;
        result = 31 * result + (idGuestlist != null ? idGuestlist.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (plusOne != null ? plusOne.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public GuestList getGuestListByIdGuestlist() {
        return guestListByIdGuestlist;
    }

    public void setGuestListByIdGuestlist(GuestList guestListByIdGuestlist) {
        this.guestListByIdGuestlist = guestListByIdGuestlist;
    }

    @Override
    public String toString(){
        return "{id_guest: " + idGuest + ", name: " + name + ", surname: " + surname + ", phone: " + phone + ", plusOne: " + plusOne + ", status: " + status + "}";
    }
}
