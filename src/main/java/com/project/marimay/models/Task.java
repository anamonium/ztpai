package com.project.marimay.models;

import jakarta.persistence.*;

@Entity
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_task")
    private String idTask;
    @Basic
    @Column(name = "id_checklist")
    private String idChecklist;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_checklist", insertable = false, updatable = false)
    private Checklist checklistByIdChecklist;

    public String getIdTask() {
        return idTask;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    public String getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(String idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (idTask != null ? !idTask.equals(task.idTask) : task.idTask != null) return false;
        if (idChecklist != null ? !idChecklist.equals(task.idChecklist) : task.idChecklist != null) return false;
        if (status != null ? !status.equals(task.status) : task.status != null) return false;
        if (content != null ? !content.equals(task.content) : task.content != null) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTask != null ? idTask.hashCode() : 0;
        result = 31 * result + (idChecklist != null ? idChecklist.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Checklist getChecklistByIdChecklist() {
        return checklistByIdChecklist;
    }

    public void setChecklistByIdChecklist(Checklist checklistByIdChecklist) {
        this.checklistByIdChecklist = checklistByIdChecklist;
    }
}
