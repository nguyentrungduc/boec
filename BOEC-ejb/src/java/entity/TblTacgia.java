/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tbl_tacgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTacgia.findAll", query = "SELECT t FROM TblTacgia t")
    , @NamedQuery(name = "TblTacgia.findByTacgiaId", query = "SELECT t FROM TblTacgia t WHERE t.tacgiaId = :tacgiaId")
    , @NamedQuery(name = "TblTacgia.findByTen", query = "SELECT t FROM TblTacgia t WHERE t.ten = :ten")
    , @NamedQuery(name = "TblTacgia.findByDiachi", query = "SELECT t FROM TblTacgia t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblTacgia.findByTrinhdochuyenmon", query = "SELECT t FROM TblTacgia t WHERE t.trinhdochuyenmon = :trinhdochuyenmon")
    , @NamedQuery(name = "TblTacgia.findByCmnd", query = "SELECT t FROM TblTacgia t WHERE t.cmnd = :cmnd")
    , @NamedQuery(name = "TblTacgia.findByNgaysinh", query = "SELECT t FROM TblTacgia t WHERE t.ngaysinh = :ngaysinh")
    , @NamedQuery(name = "TblTacgia.findByGioitinh", query = "SELECT t FROM TblTacgia t WHERE t.gioitinh = :gioitinh")
    , @NamedQuery(name = "TblTacgia.findByEmail", query = "SELECT t FROM TblTacgia t WHERE t.email = :email")
    , @NamedQuery(name = "TblTacgia.findBySodienthoai", query = "SELECT t FROM TblTacgia t WHERE t.sodienthoai = :sodienthoai")})
public class TblTacgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TACGIA_ID")
    private Integer tacgiaId;
    @Size(max = 50)
    @Column(name = "TEN")
    private String ten;
    @Size(max = 100)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 100)
    @Column(name = "TRINHDOCHUYENMON")
    private String trinhdochuyenmon;
    @Size(max = 50)
    @Column(name = "CMND")
    private String cmnd;
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "GIOITINH")
    private Integer gioitinh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "SODIENTHOAI")
    private String sodienthoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tacgiaId")
    private Collection<TblSach> tblSachCollection;

    public TblTacgia() {
    }

    public TblTacgia(Integer tacgiaId) {
        this.tacgiaId = tacgiaId;
    }

    public Integer getTacgiaId() {
        return tacgiaId;
    }

    public void setTacgiaId(Integer tacgiaId) {
        this.tacgiaId = tacgiaId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTrinhdochuyenmon() {
        return trinhdochuyenmon;
    }

    public void setTrinhdochuyenmon(String trinhdochuyenmon) {
        this.trinhdochuyenmon = trinhdochuyenmon;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
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
        hash += (tacgiaId != null ? tacgiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTacgia)) {
            return false;
        }
        TblTacgia other = (TblTacgia) object;
        if ((this.tacgiaId == null && other.tacgiaId != null) || (this.tacgiaId != null && !this.tacgiaId.equals(other.tacgiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblTacgia[ tacgiaId=" + tacgiaId + " ]";
    }
    
}
