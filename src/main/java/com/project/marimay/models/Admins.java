package com.project.marimay.models;

import jakarta.persistence.*;

@Entity
public class Admins {
    @Basic
    @Column(name = "role")
    private Integer role;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private String idUser;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private Users usersByIdUser;

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admins admins = (Admins) o;

        if (role != null ? !role.equals(admins.role) : admins.role != null) return false;
        if (idUser != null ? !idUser.equals(admins.idUser) : admins.idUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = role != null ? role.hashCode() : 0;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        return result;
    }

    public Users getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(Users usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }
}
