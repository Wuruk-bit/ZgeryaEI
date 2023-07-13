package ru.ZgeryaEI.telegrambot.model;

import javax.persistence.*;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Product product;

    @Column(nullable = false)
    private Long countProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(long countProduct) {
        this.countProduct = countProduct;
    }

}