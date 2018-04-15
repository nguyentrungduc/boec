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
import javax.persistence.ManyToOne;
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
@Table(name = "store")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findById", query = "SELECT s FROM Store s WHERE s.id = :id")
    , @NamedQuery(name = "Store.findByName", query = "SELECT s FROM Store s WHERE s.name = :name")
    , @NamedQuery(name = "Store.findByDiscription", query = "SELECT s FROM Store s WHERE s.discription = :discription")
    , @NamedQuery(name = "Store.findByAddress", query = "SELECT s FROM Store s WHERE s.address = :address")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Discription")
    private String discription;
    @Column(name = "Address")
    private Integer address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "store")
    private Caugiaystore caugiaystore;
    @JoinColumn(name = "AddressID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Address addressID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "store")
    private Hotungmaustore hotungmaustore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeID")
    private Collection<Person> personCollection;

    public Store() {
    }

    public Store(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Caugiaystore getCaugiaystore() {
        return caugiaystore;
    }

    public void setCaugiaystore(Caugiaystore caugiaystore) {
        this.caugiaystore = caugiaystore;
    }

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
    }

    public Hotungmaustore getHotungmaustore() {
        return hotungmaustore;
    }

    public void setHotungmaustore(Hotungmaustore hotungmaustore) {
        this.hotungmaustore = hotungmaustore;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
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
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Store[ id=" + id + " ]";
    }
    
}
