package com.project.marimay.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class State {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_state")
    private String idState;
    @Basic
    @Column(name = "id_country")
    private String idCountry;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "stateByIdState")
    private Collection<Address> addressesByIdState;
    @ManyToOne
    @JoinColumn(name = "id_country", insertable = false, updatable = false)
    private Country countryByIdCountry;

    public String getIdState() {
        return idState;
    }

    public void setIdState(String idState) {
        this.idState = idState;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (idState != null ? !idState.equals(state.idState) : state.idState != null) return false;
        if (idCountry != null ? !idCountry.equals(state.idCountry) : state.idCountry != null) return false;
        if (name != null ? !name.equals(state.name) : state.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idState != null ? idState.hashCode() : 0;
        result = 31 * result + (idCountry != null ? idCountry.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Address> getAddressesByIdState() {
        return addressesByIdState;
    }

    public void setAddressesByIdState(Collection<Address> addressesByIdState) {
        this.addressesByIdState = addressesByIdState;
    }

    public Country getCountryByIdCountry() {
        return countryByIdCountry;
    }

    public void setCountryByIdCountry(Country countryByIdCountry) {
        this.countryByIdCountry = countryByIdCountry;
    }
}
