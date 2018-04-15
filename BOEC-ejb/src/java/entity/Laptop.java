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
@Table(name = "laptop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laptop.findAll", query = "SELECT l FROM Laptop l")
    , @NamedQuery(name = "Laptop.findByIsDVD", query = "SELECT l FROM Laptop l WHERE l.isDVD = :isDVD")
    , @NamedQuery(name = "Laptop.findByIsKeyBoardLight", query = "SELECT l FROM Laptop l WHERE l.isKeyBoardLight = :isKeyBoardLight")
    , @NamedQuery(name = "Laptop.findByItemID", query = "SELECT l FROM Laptop l WHERE l.itemID = :itemID")})
public class Laptop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsDVD")
    private int isDVD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsKeyBoardLight")
    private int isKeyBoardLight;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ItemID")
    private String itemID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Laptop() {
    }

    public Laptop(String itemID) {
        this.itemID = itemID;
    }

    public Laptop(String itemID, int isDVD, int isKeyBoardLight) {
        this.itemID = itemID;
        this.isDVD = isDVD;
        this.isKeyBoardLight = isKeyBoardLight;
    }

    public int getIsDVD() {
        return isDVD;
    }

    public void setIsDVD(int isDVD) {
        this.isDVD = isDVD;
    }

    public int getIsKeyBoardLight() {
        return isKeyBoardLight;
    }

    public void setIsKeyBoardLight(int isKeyBoardLight) {
        this.isKeyBoardLight = isKeyBoardLight;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laptop)) {
            return false;
        }
        Laptop other = (Laptop) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Laptop[ itemID=" + itemID + " ]";
    }
    
}
