/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "hotungmaustore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotungmaustore.findAll", query = "SELECT h FROM Hotungmaustore h")
    , @NamedQuery(name = "Hotungmaustore.findByStoreID", query = "SELECT h FROM Hotungmaustore h WHERE h.storeID = :storeID")})
public class Hotungmaustore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "StoreID")
    private String storeID;
    @JoinColumn(name = "StoreID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Store store;

    public Hotungmaustore() {
    }

    public Hotungmaustore(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeID != null ? storeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotungmaustore)) {
            return false;
        }
        Hotungmaustore other = (Hotungmaustore) object;
        if ((this.storeID == null && other.storeID != null) || (this.storeID != null && !this.storeID.equals(other.storeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hotungmaustore[ storeID=" + storeID + " ]";
    }
    
}
