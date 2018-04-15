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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.id = :id")
    , @NamedQuery(name = "Category.findByCodeCategory", query = "SELECT c FROM Category c WHERE c.codeCategory = :codeCategory")
    , @NamedQuery(name = "Category.findByNameCategory", query = "SELECT c FROM Category c WHERE c.nameCategory = :nameCategory")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Size(max = 255)
    @Column(name = "CodeCategory")
    private String codeCategory;
    @Size(max = 255)
    @Column(name = "NameCategory")
    private String nameCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private Collection<Book> bookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private Collection<Electronic> electronicCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private Collection<Clothes> clothesCollection;

    public Category() {
    }

    public Category(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @XmlTransient
    public Collection<Electronic> getElectronicCollection() {
        return electronicCollection;
    }

    public void setElectronicCollection(Collection<Electronic> electronicCollection) {
        this.electronicCollection = electronicCollection;
    }

    @XmlTransient
    public Collection<Clothes> getClothesCollection() {
        return clothesCollection;
    }

    public void setClothesCollection(Collection<Clothes> clothesCollection) {
        this.clothesCollection = clothesCollection;
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ id=" + id + " ]";
    }
    
}
