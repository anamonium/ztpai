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
@Entity(name = "BudgetItem")
@Table(name = "budget_item")
public class BudgetItem {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String name;
    @Basic
    @Column(name = "cost")
    private Double cost;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "budget_id",
            foreignKey = @ForeignKey(
                    name = "budget_id_fk"
            )
    )
    private Budget budget;

}
