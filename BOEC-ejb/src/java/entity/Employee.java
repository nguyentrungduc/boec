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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findBySalaryBase", query = "SELECT e FROM Employee e WHERE e.salaryBase = :salaryBase")
    , @NamedQuery(name = "Employee.findByCoefficient", query = "SELECT e FROM Employee e WHERE e.coefficient = :coefficient")
    , @NamedQuery(name = "Employee.findByNumberExperience", query = "SELECT e FROM Employee e WHERE e.numberExperience = :numberExperience")
    , @NamedQuery(name = "Employee.findByPersonID", query = "SELECT e FROM Employee e WHERE e.personID = :personID")
    , @NamedQuery(name = "Employee.findByStoreID", query = "SELECT e FROM Employee e WHERE e.storeID = :storeID")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SalaryBase")
    private float salaryBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Coefficient")
    private float coefficient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumberExperience")
    private float numberExperience;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PersonID")
    private String personID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "StoreID")
    private String storeID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Employee() {
    }

    public Employee(String personID) {
        this.personID = personID;
    }

    public Employee(String personID, float salaryBase, float coefficient, float numberExperience, String storeID) {
        this.personID = personID;
        this.salaryBase = salaryBase;
        this.coefficient = coefficient;
        this.numberExperience = numberExperience;
        this.storeID = storeID;
    }

    public float getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(float salaryBase) {
        this.salaryBase = salaryBase;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public float getNumberExperience() {
        return numberExperience;
    }

    public void setNumberExperience(float numberExperience) {
        this.numberExperience = numberExperience;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ personID=" + personID + " ]";
    }
    
}
