//package at.wold.dependencies.entity;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//public class CustomerFinancialProduct {
//    @Id
//    private Integer id;
//    private BigDecimal balance;
//    @ManyToOne
//    @Column(name = "customerId")
//    private Customer customer;
//    @ManyToOne
//    @Column(name = "financialProductId")
//    private FinancialProduct financialProduct;
//
//    public CustomerFinancialProduct() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public FinancialProduct getFinancialProduct() {
//        return financialProduct;
//    }
//
//    public void setFinancialProduct(FinancialProduct financialProduct) {
//        this.financialProduct = financialProduct;
//    }
//}
