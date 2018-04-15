/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByCodeBook", query = "SELECT b FROM Book b WHERE b.codeBook = :codeBook")
    , @NamedQuery(name = "Book.findByYear", query = "SELECT b FROM Book b WHERE b.year = :year")
    , @NamedQuery(name = "Book.findByNumberPage", query = "SELECT b FROM Book b WHERE b.numberPage = :numberPage")
    , @NamedQuery(name = "Book.findBySizeBook", query = "SELECT b FROM Book b WHERE b.sizeBook = :sizeBook")
    , @NamedQuery(name = "Book.findByTypeBook", query = "SELECT b FROM Book b WHERE b.typeBook = :typeBook")
    , @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description")
    , @NamedQuery(name = "Book.findByQuantity", query = "SELECT b FROM Book b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "Book.findByItemID", query = "SELECT b FROM Book b WHERE b.itemID = :itemID")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "CodeBook")
    private String codeBook;
    @Column(name = "Year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumberPage")
    private int numberPage;
    @Size(max = 255)
    @Column(name = "SizeBook")
    private String sizeBook;
    @Size(max = 255)
    @Column(name = "TypeBook")
    private String typeBook;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ItemID")
    private String itemID;
    @JoinColumn(name = "PublisherID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Publisher publisherID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Category categoryID;
    @JoinColumn(name = "AuthorPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Author authorPersonID;

    public Book() {
    }

    public Book(String itemID) {
        this.itemID = itemID;
    }

    public Book(String itemID, int numberPage, int quantity) {
        this.itemID = itemID;
        this.numberPage = numberPage;
        this.quantity = quantity;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public String getSizeBook() {
        return sizeBook;
    }

    public void setSizeBook(String sizeBook) {
        this.sizeBook = sizeBook;
    }

    public String getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(String typeBook) {
        this.typeBook = typeBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Publisher getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Publisher publisherID) {
        this.publisherID = publisherID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public Author getAuthorPersonID() {
        return authorPersonID;
    }

    public void setAuthorPersonID(Author authorPersonID) {
        this.authorPersonID = authorPersonID;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Book[ itemID=" + itemID + " ]";
    }
    
}
