package com.project.marimay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "budget_item", schema = "public", catalog = "postgres")
public class BudgetItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_budget_item")
    private String idBudgetItem;
    @Basic
    @Column(name = "id_budget")
    private String idBudget;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "cost")
    private Double cost;
    @ManyToOne
    @JoinColumn(name = "id_budget", insertable = false, updatable = false)
    private Budget budgetByIdBudget;

    public String getIdBudgetItem() {
        return idBudgetItem;
    }

    public void setIdBudgetItem(String idBudgetItem) {
        this.idBudgetItem = idBudgetItem;
    }

    public String getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(String idBudget) {
        this.idBudget = idBudget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetItem that = (BudgetItem) o;

        if (idBudgetItem != null ? !idBudgetItem.equals(that.idBudgetItem) : that.idBudgetItem != null) return false;
        if (idBudget != null ? !idBudget.equals(that.idBudget) : that.idBudget != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBudgetItem != null ? idBudgetItem.hashCode() : 0;
        result = 31 * result + (idBudget != null ? idBudget.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    public Budget getBudgetByIdBudget() {
        return budgetByIdBudget;
    }

    public void setBudgetByIdBudget(Budget budgetByIdBudget) {
        this.budgetByIdBudget = budgetByIdBudget;
    }
}
