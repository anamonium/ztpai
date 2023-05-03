package com.project.marimay.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GuestList")
@Table(name = "guest_list")
public class GuestList {
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "invited")
    private Integer invited;
    @Basic
    @Column(name = "accepted")
    private Integer accepted;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "wedding_details",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "wedding_details_id_fk"
            )
    )
    @MapsId
    private WeddingDetails weddingDetails;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "guestList",
            fetch = FetchType.LAZY
    )
    private List<Guests> guests;

}
