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
@Entity(name = "Task")
@Table(name = "task")
public class Task {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id_task")
    private UUID id;
    @Column(name = "status")
    private Boolean status;

    @Column(
            name = "content",
            columnDefinition = "TEXT"
    )
    private String content;

    @Column(name = "title")
    private String title;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "checklist_id",
            foreignKey = @ForeignKey(
                    name = "checklist_id_fk"
            )
    )
    private Checklist checklist;

}
