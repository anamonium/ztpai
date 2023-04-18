package com.project.marimay.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Checklist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_checklist")
    private String idChecklist;
    @Basic
    @Column(name = "subtask_done")
    private Integer subtaskDone;
    @Basic
    @Column(name = "all_subtask")
    private Integer allSubtask;
    @OneToOne
    @JoinColumn(name = "id_checklist", referencedColumnName = "id_wedding_details", nullable = false)
    private WeddingDetails weddingDetailsByIdChecklist;
    @OneToMany(mappedBy = "checklistByIdChecklist")
    private Collection<Task> tasksByIdChecklist;

    public String getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(String idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Integer getSubtaskDone() {
        return subtaskDone;
    }

    public void setSubtaskDone(Integer subtaskDone) {
        this.subtaskDone = subtaskDone;
    }

    public Integer getAllSubtask() {
        return allSubtask;
    }

    public void setAllSubtask(Integer allSubtask) {
        this.allSubtask = allSubtask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Checklist checklist = (Checklist) o;

        if (idChecklist != null ? !idChecklist.equals(checklist.idChecklist) : checklist.idChecklist != null)
            return false;
        if (subtaskDone != null ? !subtaskDone.equals(checklist.subtaskDone) : checklist.subtaskDone != null)
            return false;
        if (allSubtask != null ? !allSubtask.equals(checklist.allSubtask) : checklist.allSubtask != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idChecklist != null ? idChecklist.hashCode() : 0;
        result = 31 * result + (subtaskDone != null ? subtaskDone.hashCode() : 0);
        result = 31 * result + (allSubtask != null ? allSubtask.hashCode() : 0);
        return result;
    }

    public WeddingDetails getWeddingDetailsByIdChecklist() {
        return weddingDetailsByIdChecklist;
    }

    public void setWeddingDetailsByIdChecklist(WeddingDetails weddingDetailsByIdChecklist) {
        this.weddingDetailsByIdChecklist = weddingDetailsByIdChecklist;
    }

    public Collection<Task> getTasksByIdChecklist() {
        return tasksByIdChecklist;
    }

    public void setTasksByIdChecklist(Collection<Task> tasksByIdChecklist) {
        this.tasksByIdChecklist = tasksByIdChecklist;
    }
}
