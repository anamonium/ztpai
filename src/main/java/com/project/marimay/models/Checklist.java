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
@Entity(name = "Checklist")
@Table(name = "check_list")
public class Checklist {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "subtask_done")
    private Integer subtaskDone;
    @Basic
    @Column(name = "all_subtask")
    private Integer allSubtask;
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
            mappedBy = "checklist",
            fetch = FetchType.LAZY
    )
    private Collection<Task> tasks;

}
