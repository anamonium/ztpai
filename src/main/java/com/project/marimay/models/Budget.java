package com.project.marimay.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Budget")
@Table(name = "budget")
public class Budget {
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "budget_spend")
    private Double budgetSpend;
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
            mappedBy = "budget",
            fetch = FetchType.LAZY
    )
    private Collection<BudgetItem> budgetItems;

}
