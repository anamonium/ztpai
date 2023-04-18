package com.project.marimay.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_country")
    private String idCountry;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "countryByIdCountry")
    private Collection<State> statesByIdCountry;

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

        Country country = (Country) o;

        if (idCountry != null ? !idCountry.equals(country.idCountry) : country.idCountry != null) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCountry != null ? idCountry.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<State> getStatesByIdCountry() {
        return statesByIdCountry;
    }

    public void setStatesByIdCountry(Collection<State> statesByIdCountry) {
        this.statesByIdCountry = statesByIdCountry;
    }
}
