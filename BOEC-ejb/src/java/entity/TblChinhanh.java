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
@Table(name = "tbl_chinhanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChinhanh.findAll", query = "SELECT t FROM TblChinhanh t")
    , @NamedQuery(name = "TblChinhanh.findByChinhanhId", query = "SELECT t FROM TblChinhanh t WHERE t.chinhanhId = :chinhanhId")
    , @NamedQuery(name = "TblChinhanh.findByTenchinhanh", query = "SELECT t FROM TblChinhanh t WHERE t.tenchinhanh = :tenchinhanh")
    , @NamedQuery(name = "TblChinhanh.findByDiachi", query = "SELECT t FROM TblChinhanh t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblChinhanh.findByMota", query = "SELECT t FROM TblChinhanh t WHERE t.mota = :mota")})
public class TblChinhanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CHINHANH_ID")
    private Integer chinhanhId;
    @Size(max = 100)
    @Column(name = "TENCHINHANH")
    private String tenchinhanh;
    @Size(max = 100)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 100)
    @Column(name = "MOTA")
    private String mota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chinhanhId")
    private Collection<TblNhanvien> tblNhanvienCollection;

    public TblChinhanh() {
    }

    public TblChinhanh(Integer chinhanhId) {
        this.chinhanhId = chinhanhId;
    }

    public Integer getChinhanhId() {
        return chinhanhId;
    }

    public void setChinhanhId(Integer chinhanhId) {
        this.chinhanhId = chinhanhId;
    }

    public String getTenchinhanh() {
        return tenchinhanh;
    }

    public void setTenchinhanh(String tenchinhanh) {
        this.tenchinhanh = tenchinhanh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @XmlTransient
    public Collection<TblNhanvien> getTblNhanvienCollection() {
        return tblNhanvienCollection;
    }

    public void setTblNhanvienCollection(Collection<TblNhanvien> tblNhanvienCollection) {
        this.tblNhanvienCollection = tblNhanvienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chinhanhId != null ? chinhanhId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblChinhanh)) {
            return false;
        }
        TblChinhanh other = (TblChinhanh) object;
        if ((this.chinhanhId == null && other.chinhanhId != null) || (this.chinhanhId != null && !this.chinhanhId.equals(other.chinhanhId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblChinhanh[ chinhanhId=" + chinhanhId + " ]";
    }
    
}
