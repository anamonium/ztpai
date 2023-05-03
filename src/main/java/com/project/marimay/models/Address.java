//package com.project.marimay.models;
//
//import jakarta.persistence.*;
//
//import java.util.Collection;
//
//@Entity(name = "Address")
//@Table(name = "address")
//public class Address {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "id_address")
//    private String idAddress;
//    @Basic
//    @Column(name = "id_state")
//    private String idState;
//    @Basic
//    @Column(name = "street")
//    private String street;
//    @Basic
//    @Column(name = "building_number")
//    private String buildingNumber;
//    @Basic
//    @Column(name = "postal_code")
//    private String postalCode;
//    @Basic
//    @Column(name = "city")
//    private String city;
//    @ManyToOne
//    @JoinColumn(name = "id_state", insertable = false, updatable = false)
//    private State stateByIdState;
//    @OneToMany(mappedBy = "addressByIdAddress")
//    private Collection<VendorsAddresses> vendorsAddressesByIdAddress;
//
//    public String getIdAddress() {
//        return idAddress;
//    }
//
//    public void setIdAddress(String idAddress) {
//        this.idAddress = idAddress;
//    }
//
//    public String getIdState() {
//        return idState;
//    }
//
//    public void setIdState(String idState) {
//        this.idState = idState;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getBuildingNumber() {
//        return buildingNumber;
//    }
//
//    public void setBuildingNumber(String buildingNumber) {
//        this.buildingNumber = buildingNumber;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Address address = (Address) o;
//
//        if (idAddress != null ? !idAddress.equals(address.idAddress) : address.idAddress != null) return false;
//        if (idState != null ? !idState.equals(address.idState) : address.idState != null) return false;
//        if (street != null ? !street.equals(address.street) : address.street != null) return false;
//        if (buildingNumber != null ? !buildingNumber.equals(address.buildingNumber) : address.buildingNumber != null)
//            return false;
//        if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
//        if (city != null ? !city.equals(address.city) : address.city != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = idAddress != null ? idAddress.hashCode() : 0;
//        result = 31 * result + (idState != null ? idState.hashCode() : 0);
//        result = 31 * result + (street != null ? street.hashCode() : 0);
//        result = 31 * result + (buildingNumber != null ? buildingNumber.hashCode() : 0);
//        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
//        result = 31 * result + (city != null ? city.hashCode() : 0);
//        return result;
//    }
//
//    public State getStateByIdState() {
//        return stateByIdState;
//    }
//
//    public void setStateByIdState(State stateByIdState) {
//        this.stateByIdState = stateByIdState;
//    }
//
//    public Collection<VendorsAddresses> getVendorsAddressesByIdAddress() {
//        return vendorsAddressesByIdAddress;
//    }
//
//    public void setVendorsAddressesByIdAddress(Collection<VendorsAddresses> vendorsAddressesByIdAddress) {
//        this.vendorsAddressesByIdAddress = vendorsAddressesByIdAddress;
//    }
//}
