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
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
    , @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id")
    , @NamedQuery(name = "Bill.findByAmount", query = "SELECT b FROM Bill b WHERE b.amount = :amount")
    , @NamedQuery(name = "Bill.findByDate", query = "SELECT b FROM Bill b WHERE b.date = :date")
    , @NamedQuery(name = "Bill.findByOrder", query = "SELECT b FROM Bill b WHERE b.order = :order")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private float amount;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Order")
    private Integer order;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billID")
    private Collection<Order1> order1Collection;
    @JoinColumn(name = "SellerEmployeePersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Selleremployee sellerEmployeePersonID;
    @JoinColumn(name = "ShipperEmployeePersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Shipperemployee shipperEmployeePersonID;

    public Bill() {
    }

    public Bill(String id) {
        this.id = id;
    }

    public Bill(String id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public Selleremployee getSellerEmployeePersonID() {
        return sellerEmployeePersonID;
    }

    public void setSellerEmployeePersonID(Selleremployee sellerEmployeePersonID) {
        this.sellerEmployeePersonID = sellerEmployeePersonID;
    }

    public Shipperemployee getShipperEmployeePersonID() {
        return shipperEmployeePersonID;
    }

    public void setShipperEmployeePersonID(Shipperemployee shipperEmployeePersonID) {
        this.shipperEmployeePersonID = shipperEmployeePersonID;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bill[ id=" + id + " ]";
    }
    
}
