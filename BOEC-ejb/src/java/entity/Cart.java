/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findById", query = "SELECT c FROM Cart c WHERE c.id = :id")
    , @NamedQuery(name = "Cart.findByDateCreate", query = "SELECT c FROM Cart c WHERE c.dateCreate = :dateCreate")
    , @NamedQuery(name = "Cart.findByCodeCart", query = "SELECT c FROM Cart c WHERE c.codeCart = :codeCart")
    , @NamedQuery(name = "Cart.findByAmount", query = "SELECT c FROM Cart c WHERE c.amount = :amount")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Column(name = "DateCreate")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;
    @Size(max = 255)
    @Column(name = "CodeCart")
    private String codeCart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private float amount;
    @JoinColumn(name = "CustomerPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Customer customerPersonID;
    @JoinColumn(name = "OrderID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Order1 orderID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartID")
    private Collection<Cartitem> cartitemCollection;

    public Cart() {
    }

    public Cart(String id) {
        this.id = id;
    }

    public Cart(String id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getCodeCart() {
        return codeCart;
    }

    public void setCodeCart(String codeCart) {
        this.codeCart = codeCart;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Customer getCustomerPersonID() {
        return customerPersonID;
    }

    public void setCustomerPersonID(Customer customerPersonID) {
        this.customerPersonID = customerPersonID;
    }

    public Order1 getOrderID() {
        return orderID;
    }

    public void setOrderID(Order1 orderID) {
        this.orderID = orderID;
    }

    @XmlTransient
    public Collection<Cartitem> getCartitemCollection() {
        return cartitemCollection;
    }

    public void setCartitemCollection(Collection<Cartitem> cartitemCollection) {
        this.cartitemCollection = cartitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cart[ id=" + id + " ]";
    }
    
}
