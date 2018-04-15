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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tbl_giohang_sach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGiohangSach.findAll", query = "SELECT t FROM TblGiohangSach t")
    , @NamedQuery(name = "TblGiohangSach.findById", query = "SELECT t FROM TblGiohangSach t WHERE t.id = :id")
    , @NamedQuery(name = "TblGiohangSach.findBySoluong", query = "SELECT t FROM TblGiohangSach t WHERE t.soluong = :soluong")
    , @NamedQuery(name = "TblGiohangSach.findByGiaban", query = "SELECT t FROM TblGiohangSach t WHERE t.giaban = :giaban")})
public class TblGiohangSach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SOLUONG")
    private Integer soluong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GIABAN")
    private Float giaban;
    @JoinColumn(name = "GIOHANG_ID", referencedColumnName = "GIOHANG_ID")
    @ManyToOne(optional = false)
    private TblGiohang giohangId;
    @JoinColumn(name = "SACH_ID", referencedColumnName = "SACH_ID")
    @ManyToOne(optional = false)
    private TblSach sachId;

    public TblGiohangSach() {
    }

    public TblGiohangSach(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Float getGiaban() {
        return giaban;
    }

    public void setGiaban(Float giaban) {
        this.giaban = giaban;
    }

    public TblGiohang getGiohangId() {
        return giohangId;
    }

    public void setGiohangId(TblGiohang giohangId) {
        this.giohangId = giohangId;
    }

    public TblSach getSachId() {
        return sachId;
    }

    public void setSachId(TblSach sachId) {
        this.sachId = sachId;
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
        if (!(object instanceof TblGiohangSach)) {
            return false;
        }
        TblGiohangSach other = (TblGiohangSach) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblGiohangSach[ id=" + id + " ]";
    }
    
}
