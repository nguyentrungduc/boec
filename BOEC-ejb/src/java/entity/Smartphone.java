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
@Table(name = "smartphone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smartphone.findAll", query = "SELECT s FROM Smartphone s")
    , @NamedQuery(name = "Smartphone.findByBattery", query = "SELECT s FROM Smartphone s WHERE s.battery = :battery")
    , @NamedQuery(name = "Smartphone.findByCameraAfter", query = "SELECT s FROM Smartphone s WHERE s.cameraAfter = :cameraAfter")
    , @NamedQuery(name = "Smartphone.findByItemID", query = "SELECT s FROM Smartphone s WHERE s.itemID = :itemID")})
public class Smartphone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Battery")
    private float battery;
    @Size(max = 255)
    @Column(name = "CameraAfter")
    private String cameraAfter;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ItemID")
    private String itemID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Smartphone() {
    }

    public Smartphone(String itemID) {
        this.itemID = itemID;
    }

    public Smartphone(String itemID, float battery) {
        this.itemID = itemID;
        this.battery = battery;
    }

    public float getBattery() {
        return battery;
    }

    public void setBattery(float battery) {
        this.battery = battery;
    }

    public String getCameraAfter() {
        return cameraAfter;
    }

    public void setCameraAfter(String cameraAfter) {
        this.cameraAfter = cameraAfter;
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
        if (!(object instanceof Smartphone)) {
            return false;
        }
        Smartphone other = (Smartphone) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Smartphone[ itemID=" + itemID + " ]";
    }
    
}
