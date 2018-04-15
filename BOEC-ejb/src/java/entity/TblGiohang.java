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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tbl_giohang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGiohang.findAll", query = "SELECT t FROM TblGiohang t")
    , @NamedQuery(name = "TblGiohang.findByGiohangId", query = "SELECT t FROM TblGiohang t WHERE t.giohangId = :giohangId")
    , @NamedQuery(name = "TblGiohang.findByMagiohang", query = "SELECT t FROM TblGiohang t WHERE t.magiohang = :magiohang")})
public class TblGiohang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GIOHANG_ID")
    private Integer giohangId;
    @Size(max = 50)
    @Column(name = "MAGIOHANG")
    private String magiohang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giohangId")
    private Collection<TblDonhang> tblDonhangCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giohangId")
    private Collection<TblGiohangSach> tblGiohangSachCollection;

    public TblGiohang() {
    }

    public TblGiohang(Integer giohangId) {
        this.giohangId = giohangId;
    }

    public Integer getGiohangId() {
        return giohangId;
    }

    public void setGiohangId(Integer giohangId) {
        this.giohangId = giohangId;
    }

    public String getMagiohang() {
        return magiohang;
    }

    public void setMagiohang(String magiohang) {
        this.magiohang = magiohang;
    }

    @XmlTransient
    public Collection<TblDonhang> getTblDonhangCollection() {
        return tblDonhangCollection;
    }

    public void setTblDonhangCollection(Collection<TblDonhang> tblDonhangCollection) {
        this.tblDonhangCollection = tblDonhangCollection;
    }

    @XmlTransient
    public Collection<TblGiohangSach> getTblGiohangSachCollection() {
        return tblGiohangSachCollection;
    }

    public void setTblGiohangSachCollection(Collection<TblGiohangSach> tblGiohangSachCollection) {
        this.tblGiohangSachCollection = tblGiohangSachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (giohangId != null ? giohangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGiohang)) {
            return false;
        }
        TblGiohang other = (TblGiohang) object;
        if ((this.giohangId == null && other.giohangId != null) || (this.giohangId != null && !this.giohangId.equals(other.giohangId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblGiohang[ giohangId=" + giohangId + " ]";
    }
    
}
