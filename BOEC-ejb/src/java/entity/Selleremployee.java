/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "selleremployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Selleremployee.findAll", query = "SELECT s FROM Selleremployee s")
    , @NamedQuery(name = "Selleremployee.findByBuySuccess", query = "SELECT s FROM Selleremployee s WHERE s.buySuccess = :buySuccess")
    , @NamedQuery(name = "Selleremployee.findByPersonID", query = "SELECT s FROM Selleremployee s WHERE s.personID = :personID")})
public class Selleremployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BuySuccess")
    private int buySuccess;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PersonID")
    private String personID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerEmployeePersonID")
    private Collection<Bill> billCollection;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Selleremployee() {
    }

    public Selleremployee(String personID) {
        this.personID = personID;
    }

    public Selleremployee(String personID, int buySuccess) {
        this.personID = personID;
        this.buySuccess = buySuccess;
    }

    public int getBuySuccess() {
        return buySuccess;
    }

    public void setBuySuccess(int buySuccess) {
        this.buySuccess = buySuccess;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Selleremployee)) {
            return false;
        }
        Selleremployee other = (Selleremployee) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Selleremployee[ personID=" + personID + " ]";
    }
    
}
