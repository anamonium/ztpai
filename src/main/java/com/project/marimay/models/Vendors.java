package com.project.marimay.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Vendors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vendor")
    private String idVendor;
    @Basic
    @Column(name = "vendor_category")
    private String vendorCategory;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "vendorsByIdVendor")
    private Collection<VendorsAddresses> vendorsAddressesByIdVendor;

    public String getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(String idVendor) {
        this.idVendor = idVendor;
    }

    public String getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(String vendorCategory) {
        this.vendorCategory = vendorCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vendors vendors = (Vendors) o;

        if (idVendor != null ? !idVendor.equals(vendors.idVendor) : vendors.idVendor != null) return false;
        if (vendorCategory != null ? !vendorCategory.equals(vendors.vendorCategory) : vendors.vendorCategory != null)
            return false;
        if (name != null ? !name.equals(vendors.name) : vendors.name != null) return false;
        if (description != null ? !description.equals(vendors.description) : vendors.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVendor != null ? idVendor.hashCode() : 0;
        result = 31 * result + (vendorCategory != null ? vendorCategory.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<VendorsAddresses> getVendorsAddressesByIdVendor() {
        return vendorsAddressesByIdVendor;
    }

    public void setVendorsAddressesByIdVendor(Collection<VendorsAddresses> vendorsAddressesByIdVendor) {
        this.vendorsAddressesByIdVendor = vendorsAddressesByIdVendor;
    }
}
