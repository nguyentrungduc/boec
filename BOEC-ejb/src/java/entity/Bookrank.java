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
@Table(name = "bookrank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookrank.findAll", query = "SELECT b FROM Bookrank b")
    , @NamedQuery(name = "Bookrank.findByRankPrice", query = "SELECT b FROM Bookrank b WHERE b.rankPrice = :rankPrice")
    , @NamedQuery(name = "Bookrank.findByRankSell", query = "SELECT b FROM Bookrank b WHERE b.rankSell = :rankSell")
    , @NamedQuery(name = "Bookrank.findByRankLove", query = "SELECT b FROM Bookrank b WHERE b.rankLove = :rankLove")
    , @NamedQuery(name = "Bookrank.findByItemID", query = "SELECT b FROM Bookrank b WHERE b.itemID = :itemID")})
public class Bookrank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RankPrice")
    private int rankPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RankSell")
    private int rankSell;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RankLove")
    private int rankLove;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ItemID")
    private String itemID;
    @JoinColumn(name = "ItemID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Item item;

    public Bookrank() {
    }

    public Bookrank(String itemID) {
        this.itemID = itemID;
    }

    public Bookrank(String itemID, int rankPrice, int rankSell, int rankLove) {
        this.itemID = itemID;
        this.rankPrice = rankPrice;
        this.rankSell = rankSell;
        this.rankLove = rankLove;
    }

    public int getRankPrice() {
        return rankPrice;
    }

    public void setRankPrice(int rankPrice) {
        this.rankPrice = rankPrice;
    }

    public int getRankSell() {
        return rankSell;
    }

    public void setRankSell(int rankSell) {
        this.rankSell = rankSell;
    }

    public int getRankLove() {
        return rankLove;
    }

    public void setRankLove(int rankLove) {
        this.rankLove = rankLove;
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
        if (!(object instanceof Bookrank)) {
            return false;
        }
        Bookrank other = (Bookrank) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bookrank[ itemID=" + itemID + " ]";
    }
    
}
