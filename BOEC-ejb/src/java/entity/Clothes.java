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
@Table(name = "clothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c")
    , @NamedQuery(name = "Clothes.findByName", query = "SELECT c FROM Clothes c WHERE c.name = :name")
    , @NamedQuery(name = "Clothes.findBySize", query = "SELECT c FROM Clothes c WHERE c.size = :size")
    , @NamedQuery(name = "Clothes.findByColor", query = "SELECT c FROM Clothes c WHERE c.color = :color")
    , @NamedQuery(name = "Clothes.findByStyles", query = "SELECT c FROM Clothes c WHERE c.styles = :styles")
    , @NamedQuery(name = "Clothes.findByDescription", query = "SELECT c FROM Clothes c WHERE c.description = :description")
    , @NamedQuery(name = "Clothes.findByMaterial", query = "SELECT c FROM Clothes c WHERE c.material = :material")
    , @NamedQuery(name = "Clothes.findByItemID", query = "SELECT c FROM Clothes c WHERE c.itemID = :itemID")})
public class Clothes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Size")
    private String size;
    @Size(max = 255)
    @Column(name = "Color")
    private String color;
    @Size(max = 255)
    @Column(name = "Styles")
    private String styles;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @Size(max = 255)
    @Column(name = "Material")
    private String material;
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

    public Clothes() {
    }

    public Clothes(String itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Clothes[ itemID=" + itemID + " ]";
    }
    
}
