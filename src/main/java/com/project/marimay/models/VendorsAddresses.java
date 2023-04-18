package com.project.marimay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors_addresses", schema = "public", catalog = "postgres")
public class VendorsAddresses {

    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "id_vendor")
    private String idVendor;
    @Basic
    @Column(name = "id_address")
    private String idAddress;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "id_vendor", insertable = false, updatable = false)
    private Vendors vendorsByIdVendor;
    @ManyToOne
    @JoinColumn(name = "id_address", insertable = false, updatable = false)
    private Address addressByIdAddress;

    public String getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(String idVendor) {
        this.idVendor = idVendor;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendorsAddresses that = (VendorsAddresses) o;

        if (idVendor != null ? !idVendor.equals(that.idVendor) : that.idVendor != null) return false;
        if (idAddress != null ? !idAddress.equals(that.idAddress) : that.idAddress != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVendor != null ? idVendor.hashCode() : 0;
        result = 31 * result + (idAddress != null ? idAddress.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Vendors getVendorsByIdVendor() {
        return vendorsByIdVendor;
    }

    public void setVendorsByIdVendor(Vendors vendorsByIdVendor) {
        this.vendorsByIdVendor = vendorsByIdVendor;
    }

    public Address getAddressByIdAddress() {
        return addressByIdAddress;
    }

    public void setAddressByIdAddress(Address addressByIdAddress) {
        this.addressByIdAddress = addressByIdAddress;
    }
}
