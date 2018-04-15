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
import javax.persistence.ManyToOne;
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
@Table(name = "electronic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electronic.findAll", query = "SELECT e FROM Electronic e")
    , @NamedQuery(name = "Electronic.findByWarrantyPeriod", query = "SELECT e FROM Electronic e WHERE e.warrantyPeriod = :warrantyPeriod")
    , @NamedQuery(name = "Electronic.findByScreenSize", query = "SELECT e FROM Electronic e WHERE e.screenSize = :screenSize")
    , @NamedQuery(name = "Electronic.findByCpu", query = "SELECT e FROM Electronic e WHERE e.cpu = :cpu")
    , @NamedQuery(name = "Electronic.findByRoom", query = "SELECT e FROM Electronic e WHERE e.room = :room")
    , @NamedQuery(name = "Electronic.findByRam", query = "SELECT e FROM Electronic e WHERE e.ram = :ram")
    , @NamedQuery(name = "Electronic.findByGpu", query = "SELECT e FROM Electronic e WHERE e.gpu = :gpu")
    , @NamedQuery(name = "Electronic.findByOperaSystem", query = "SELECT e FROM Electronic e WHERE e.operaSystem = :operaSystem")
    , @NamedQuery(name = "Electronic.findByCameraFont", query = "SELECT e FROM Electronic e WHERE e.cameraFont = :cameraFont")
    , @NamedQuery(name = "Electronic.findBySrceenResolation", query = "SELECT e FROM Electronic e WHERE e.srceenResolation = :srceenResolation")
    , @NamedQuery(name = "Electronic.findByItemID", query = "SELECT e FROM Electronic e WHERE e.itemID = :itemID")})
public class Electronic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WarrantyPeriod")
    private float warrantyPeriod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ScreenSize")
    private float screenSize;
    @Size(max = 255)
    @Column(name = "Cpu")
    private String cpu;
    @Size(max = 255)
    @Column(name = "Room")
    private String room;
    @Size(max = 255)
    @Column(name = "Ram")
    private String ram;
    @Size(max = 255)
    @Column(name = "Gpu")
    private String gpu;
    @Size(max = 255)
    @Column(name = "OperaSystem")
    private String operaSystem;
    @Size(max = 255)
    @Column(name = "CameraFont")
    private String cameraFont;
    @Size(max = 255)
    @Column(name = "SrceenResolation")
    private String srceenResolation;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ItemID")
    private String itemID;
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Category categoryID;
    @JoinColumn(name = "CompanyID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Company companyID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Electronic() {
    }

    public Electronic(String itemID) {
        this.itemID = itemID;
    }

    public Electronic(String itemID, float warrantyPeriod, float screenSize) {
        this.itemID = itemID;
        this.warrantyPeriod = warrantyPeriod;
        this.screenSize = screenSize;
    }

    public float getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(float warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getOperaSystem() {
        return operaSystem;
    }

    public void setOperaSystem(String operaSystem) {
        this.operaSystem = operaSystem;
    }

    public String getCameraFont() {
        return cameraFont;
    }

    public void setCameraFont(String cameraFont) {
        this.cameraFont = cameraFont;
    }

    public String getSrceenResolation() {
        return srceenResolation;
    }

    public void setSrceenResolation(String srceenResolation) {
        this.srceenResolation = srceenResolation;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
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
        if (!(object instanceof Electronic)) {
            return false;
        }
        Electronic other = (Electronic) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Electronic[ itemID=" + itemID + " ]";
    }
    
}
