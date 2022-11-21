package at.wold.dependencies.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Customers")
public class Customer {
    @Id
    private Integer id;
    private String name;
    private String address;
    private LocalDate dateOfBirth;
    private String email;
    private Boolean statusFl;

    @ManyToMany(targetEntity = FinancialProduct.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "customerFinancialProduct",
            joinColumns = { @JoinColumn(name = "customerId") },
            inverseJoinColumns = { @JoinColumn(name = "financialProductId") })
    private List<FinancialProduct> financialProducts;

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
}
