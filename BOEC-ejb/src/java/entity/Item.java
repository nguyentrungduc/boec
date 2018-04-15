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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id")
    , @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name")
    , @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price")})
public class Item implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Smartphone smartphone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Techbook techbook;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Literaturebook literaturebook;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Maleclothes maleclothes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Laptop laptop;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Tablet tablet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Electronic electronic;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Bookrank bookrank;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemID")
    private Collection<Cartitem> cartitemCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Femaleclothes femaleclothes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Clothes clothes;

    public Item() {
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, float price) {
        this.id = id;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Techbook getTechbook() {
        return techbook;
    }

    public void setTechbook(Techbook techbook) {
        this.techbook = techbook;
    }

    public Literaturebook getLiteraturebook() {
        return literaturebook;
    }

    public void setLiteraturebook(Literaturebook literaturebook) {
        this.literaturebook = literaturebook;
    }

    public Maleclothes getMaleclothes() {
        return maleclothes;
    }

    public void setMaleclothes(Maleclothes maleclothes) {
        this.maleclothes = maleclothes;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public void setTablet(Tablet tablet) {
        this.tablet = tablet;
    }

    public Electronic getElectronic() {
        return electronic;
    }

    public void setElectronic(Electronic electronic) {
        this.electronic = electronic;
    }

    public Bookrank getBookrank() {
        return bookrank;
    }

    public void setBookrank(Bookrank bookrank) {
        this.bookrank = bookrank;
    }

    @XmlTransient
    public Collection<Cartitem> getCartitemCollection() {
        return cartitemCollection;
    }

    public void setCartitemCollection(Collection<Cartitem> cartitemCollection) {
        this.cartitemCollection = cartitemCollection;
    }

    public Femaleclothes getFemaleclothes() {
        return femaleclothes;
    }

    public void setFemaleclothes(Femaleclothes femaleclothes) {
        this.femaleclothes = femaleclothes;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Item[ id=" + id + " ]";
    }
    
}
