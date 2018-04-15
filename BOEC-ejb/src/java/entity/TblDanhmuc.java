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
@Table(name = "tbl_danhmuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDanhmuc.findAll", query = "SELECT t FROM TblDanhmuc t")
    , @NamedQuery(name = "TblDanhmuc.findByDanhmucId", query = "SELECT t FROM TblDanhmuc t WHERE t.danhmucId = :danhmucId")
    , @NamedQuery(name = "TblDanhmuc.findByMadanhmuc", query = "SELECT t FROM TblDanhmuc t WHERE t.madanhmuc = :madanhmuc")
    , @NamedQuery(name = "TblDanhmuc.findByTendanhmuc", query = "SELECT t FROM TblDanhmuc t WHERE t.tendanhmuc = :tendanhmuc")})
public class TblDanhmuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DANHMUC_ID")
    private Integer danhmucId;
    @Size(max = 50)
    @Column(name = "MADANHMUC")
    private String madanhmuc;
    @Size(max = 100)
    @Column(name = "TENDANHMUC")
    private String tendanhmuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "danhmucId")
    private Collection<TblSach> tblSachCollection;

    public TblDanhmuc() {
    }

    public TblDanhmuc(Integer danhmucId) {
        this.danhmucId = danhmucId;
    }

    public Integer getDanhmucId() {
        return danhmucId;
    }

    public void setDanhmucId(Integer danhmucId) {
        this.danhmucId = danhmucId;
    }

    public String getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(String madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    @XmlTransient
    public Collection<TblSach> getTblSachCollection() {
        return tblSachCollection;
    }

    public void setTblSachCollection(Collection<TblSach> tblSachCollection) {
        this.tblSachCollection = tblSachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (danhmucId != null ? danhmucId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDanhmuc)) {
            return false;
        }
        TblDanhmuc other = (TblDanhmuc) object;
        if ((this.danhmucId == null && other.danhmucId != null) || (this.danhmucId != null && !this.danhmucId.equals(other.danhmucId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblDanhmuc[ danhmucId=" + danhmucId + " ]";
    }
    
}
