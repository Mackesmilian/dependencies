package at.wolf.dependencies.entity;

import at.wolf.dependencies.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Customers")
public class Customer {
    @Id
    private Integer id;
    @JsonView({View.Public.Info.class, View.Public.Balance.class})
    private String name;
    @JsonView(View.Public.Info.class)
    private String address;
    private LocalDate dateOfBirth;
    @JsonView(View.Public.Info.class)
    private String email;
    @JsonView(View.Public.Info.class)
    private Boolean statusFl;

    @ManyToMany(targetEntity = FinancialProduct.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "customerFinancialProduct",
            joinColumns = { @JoinColumn(name = "customerId") },
            inverseJoinColumns = { @JoinColumn(name = "financialProductId") })
    private List<FinancialProduct> financialProducts;

    @Formula(value = "select sum(f.balance) from customerFinancialProduct f where f.customerId = " +
            "id")
    @JsonView(View.Public.Balance.class)
    private Long aggregatedBalance;

    public Customer() {
    }

    public Customer(Integer id, String name, String address, LocalDate dateOfBirth, String email, Boolean statusFl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.statusFl = statusFl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatusFl() {
        return statusFl;
    }

    public void setStatusFl(Boolean statusFl) {
        this.statusFl = statusFl;
    }

    public List<FinancialProduct> getFinancialProducts() {
        return financialProducts;
    }

    public void setFinancialProducts(List<FinancialProduct> financialProducts) {
        this.financialProducts = financialProducts;
    }

    public Long getAggregatedBalance() {
        return aggregatedBalance;
    }

    public void setAggregatedBalance(Long aggregatedBalance) {
        this.aggregatedBalance = aggregatedBalance;
    }
}
