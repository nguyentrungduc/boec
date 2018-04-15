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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNhanvien.findAll", query = "SELECT t FROM TblNhanvien t")
    , @NamedQuery(name = "TblNhanvien.findByNhanvienId", query = "SELECT t FROM TblNhanvien t WHERE t.nhanvienId = :nhanvienId")
    , @NamedQuery(name = "TblNhanvien.findByManhanvien", query = "SELECT t FROM TblNhanvien t WHERE t.manhanvien = :manhanvien")
    , @NamedQuery(name = "TblNhanvien.findByHoten", query = "SELECT t FROM TblNhanvien t WHERE t.hoten = :hoten")
    , @NamedQuery(name = "TblNhanvien.findByDiachi", query = "SELECT t FROM TblNhanvien t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblNhanvien.findByVitricongtac", query = "SELECT t FROM TblNhanvien t WHERE t.vitricongtac = :vitricongtac")
    , @NamedQuery(name = "TblNhanvien.findBySonamkinhnghiem", query = "SELECT t FROM TblNhanvien t WHERE t.sonamkinhnghiem = :sonamkinhnghiem")
    , @NamedQuery(name = "TblNhanvien.findByLuongcoban", query = "SELECT t FROM TblNhanvien t WHERE t.luongcoban = :luongcoban")
    , @NamedQuery(name = "TblNhanvien.findByHesoluong", query = "SELECT t FROM TblNhanvien t WHERE t.hesoluong = :hesoluong")
    , @NamedQuery(name = "TblNhanvien.findByNgaysinh", query = "SELECT t FROM TblNhanvien t WHERE t.ngaysinh = :ngaysinh")
    , @NamedQuery(name = "TblNhanvien.findByCmnd", query = "SELECT t FROM TblNhanvien t WHERE t.cmnd = :cmnd")
    , @NamedQuery(name = "TblNhanvien.findByEmail", query = "SELECT t FROM TblNhanvien t WHERE t.email = :email")
    , @NamedQuery(name = "TblNhanvien.findByGioitinh", query = "SELECT t FROM TblNhanvien t WHERE t.gioitinh = :gioitinh")
    , @NamedQuery(name = "TblNhanvien.findBySodienthoai", query = "SELECT t FROM TblNhanvien t WHERE t.sodienthoai = :sodienthoai")})
public class TblNhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NHANVIEN_ID")
    private Integer nhanvienId;
    @Size(max = 50)
    @Column(name = "MANHANVIEN")
    private String manhanvien;
    @Size(max = 50)
    @Column(name = "HOTEN")
    private String hoten;
    @Size(max = 50)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 50)
    @Column(name = "VITRICONGTAC")
    private String vitricongtac;
    @Column(name = "SONAMKINHNGHIEM")
    private Integer sonamkinhnghiem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LUONGCOBAN")
    private Float luongcoban;
    @Column(name = "HESOLUONG")
    private Float hesoluong;
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "CMND")
    private Integer cmnd;
    @Column(name = "EMAIL")
    private Integer email;
    @Column(name = "GIOITINH")
    private Integer gioitinh;
    @Size(max = 55)
    @Column(name = "SODIENTHOAI")
    private String sodienthoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanviengiaohangId")
    private Collection<TblHoadon> tblHoadonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanvienbanhangId")
    private Collection<TblHoadon> tblHoadonCollection1;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false)
    private TblAccount accountId;
    @JoinColumn(name = "CHINHANH_ID", referencedColumnName = "CHINHANH_ID")
    @ManyToOne(optional = false)
    private TblChinhanh chinhanhId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoicapnhatId")
    private Collection<TblDonhang> tblDonhangCollection;

    public TblNhanvien() {
    }

    public TblNhanvien(Integer nhanvienId) {
        this.nhanvienId = nhanvienId;
    }

    public Integer getNhanvienId() {
        return nhanvienId;
    }

    public void setNhanvienId(Integer nhanvienId) {
        this.nhanvienId = nhanvienId;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getVitricongtac() {
        return vitricongtac;
    }

    public void setVitricongtac(String vitricongtac) {
        this.vitricongtac = vitricongtac;
    }

    public Integer getSonamkinhnghiem() {
        return sonamkinhnghiem;
    }

    public void setSonamkinhnghiem(Integer sonamkinhnghiem) {
        this.sonamkinhnghiem = sonamkinhnghiem;
    }

    public Float getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(Float luongcoban) {
        this.luongcoban = luongcoban;
    }

    public Float getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(Float hesoluong) {
        this.hesoluong = hesoluong;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Integer getCmnd() {
        return cmnd;
    }

    public void setCmnd(Integer cmnd) {
        this.cmnd = cmnd;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    @XmlTransient
    public Collection<TblHoadon> getTblHoadonCollection() {
        return tblHoadonCollection;
    }

    public void setTblHoadonCollection(Collection<TblHoadon> tblHoadonCollection) {
        this.tblHoadonCollection = tblHoadonCollection;
    }

    @XmlTransient
    public Collection<TblHoadon> getTblHoadonCollection1() {
        return tblHoadonCollection1;
    }

    public void setTblHoadonCollection1(Collection<TblHoadon> tblHoadonCollection1) {
        this.tblHoadonCollection1 = tblHoadonCollection1;
    }

    public TblAccount getAccountId() {
        return accountId;
    }

    public void setAccountId(TblAccount accountId) {
        this.accountId = accountId;
    }

    public TblChinhanh getChinhanhId() {
        return chinhanhId;
    }

    public void setChinhanhId(TblChinhanh chinhanhId) {
        this.chinhanhId = chinhanhId;
    }

    @XmlTransient
    public Collection<TblDonhang> getTblDonhangCollection() {
        return tblDonhangCollection;
    }

    public void setTblDonhangCollection(Collection<TblDonhang> tblDonhangCollection) {
        this.tblDonhangCollection = tblDonhangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nhanvienId != null ? nhanvienId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNhanvien)) {
            return false;
        }
        TblNhanvien other = (TblNhanvien) object;
        if ((this.nhanvienId == null && other.nhanvienId != null) || (this.nhanvienId != null && !this.nhanvienId.equals(other.nhanvienId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblNhanvien[ nhanvienId=" + nhanvienId + " ]";
    }
    
}
