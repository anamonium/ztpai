package com.project.marimay.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "WeddingDetails")
@Table(name = "wedding_details")
public class WeddingDetails {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "wedding_date")
    private LocalDate weddingDate;

    @Column(name = "wedding_budget")
    private Double weddingBudget;
    @OneToOne(
            mappedBy = "weddingDetails",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private Budget budget;
    @OneToOne(
            mappedBy = "weddingDetails",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private Checklist checklist;
    @OneToOne(
            mappedBy = "weddingDetails",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private GuestList guestlist;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    @MapsId
    private Users user;

}
