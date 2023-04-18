package com.project.marimay.models;

import jakarta.persistence.*;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private String idUser;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "enabled")
    private Boolean enabled;
    @Basic
    @Column(name = "salt")
    private String salt;
    @Basic
    @Column(name = "created_at")
    private String createdAt;
    @OneToOne(mappedBy = "usersByIdUser")
    private Admins adminsByIdUser;
    @OneToOne(mappedBy = "usersByIdUser")
    private UserDetails userDetailsByIdUser;
    @OneToOne(mappedBy = "usersByIdWeddingDetails")
    private WeddingDetails weddingDetailsByIdUser;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (idUser != null ? !idUser.equals(users.idUser) : users.idUser != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (enabled != null ? !enabled.equals(users.enabled) : users.enabled != null) return false;
        if (salt != null ? !salt.equals(users.salt) : users.salt != null) return false;
        if (createdAt != null ? !createdAt.equals(users.createdAt) : users.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    public Admins getAdminsByIdUser() {
        return adminsByIdUser;
    }

    public void setAdminsByIdUser(Admins adminsByIdUser) {
        this.adminsByIdUser = adminsByIdUser;
    }

    public UserDetails getUserDetailsByIdUser() {
        return userDetailsByIdUser;
    }

    public void setUserDetailsByIdUser(UserDetails userDetailsByIdUser) {
        this.userDetailsByIdUser = userDetailsByIdUser;
    }

    public WeddingDetails getWeddingDetailsByIdUser() {
        return weddingDetailsByIdUser;
    }

    public void setWeddingDetailsByIdUser(WeddingDetails weddingDetailsByIdUser) {
        this.weddingDetailsByIdUser = weddingDetailsByIdUser;
    }
}
