package com.project.marimay.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Guests")
@Table(name = "guests")
public class Guests {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "plus_one")
    private Boolean plusOne;

    @Column(name = "status")
    private Boolean status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "guestlist_id",
            foreignKey = @ForeignKey(
                    name = "guestlist_id_fk"
            )
    )
    private GuestList guestList;

}
