package com.project.marimay.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Budget {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_budget")
    private String idBudget;
    @Basic
    @Column(name = "beggining_budget")
    private Double begginingBudget;
    @Basic
    @Column(name = "budget_letf")
    private Double budgetLetf;
    @OneToOne
    @JoinColumn(name = "id_budget", referencedColumnName = "id_wedding_details", nullable = false)
    private WeddingDetails weddingDetailsByIdBudget;
    @OneToMany(mappedBy = "budgetByIdBudget")
    private Collection<BudgetItem> budgetItemsByIdBudget;

    public String getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(String idBudget) {
        this.idBudget = idBudget;
    }

    public Double getBegginingBudget() {
        return begginingBudget;
    }

    public void setBegginingBudget(Double begginingBudget) {
        this.begginingBudget = begginingBudget;
    }

    public Double getBudgetLetf() {
        return budgetLetf;
    }

    public void setBudgetLetf(Double budgetLetf) {
        this.budgetLetf = budgetLetf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Budget budget = (Budget) o;

        if (idBudget != null ? !idBudget.equals(budget.idBudget) : budget.idBudget != null) return false;
        if (begginingBudget != null ? !begginingBudget.equals(budget.begginingBudget) : budget.begginingBudget != null)
            return false;
        if (budgetLetf != null ? !budgetLetf.equals(budget.budgetLetf) : budget.budgetLetf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBudget != null ? idBudget.hashCode() : 0;
        result = 31 * result + (begginingBudget != null ? begginingBudget.hashCode() : 0);
        result = 31 * result + (budgetLetf != null ? budgetLetf.hashCode() : 0);
        return result;
    }

    public WeddingDetails getWeddingDetailsByIdBudget() {
        return weddingDetailsByIdBudget;
    }

    public void setWeddingDetailsByIdBudget(WeddingDetails weddingDetailsByIdBudget) {
        this.weddingDetailsByIdBudget = weddingDetailsByIdBudget;
    }

    public Collection<BudgetItem> getBudgetItemsByIdBudget() {
        return budgetItemsByIdBudget;
    }

    public void setBudgetItemsByIdBudget(Collection<BudgetItem> budgetItemsByIdBudget) {
        this.budgetItemsByIdBudget = budgetItemsByIdBudget;
    }
}
