/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.petsi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "tbl_historiaclinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiaclinica.findAll", query = "SELECT h FROM Historiaclinica h")
    , @NamedQuery(name = "Historiaclinica.findByHcId", query = "SELECT h FROM Historiaclinica h WHERE h.hcId = :hcId")
    , @NamedQuery(name = "Historiaclinica.findByHcIdmascota", query = "SELECT h FROM Historiaclinica h WHERE h.hcIdmascota = :hcIdmascota")
    , @NamedQuery(name = "Historiaclinica.findByHcDescripcion", query = "SELECT h FROM Historiaclinica h WHERE h.hcDescripcion = :hcDescripcion")
    , @NamedQuery(name = "Historiaclinica.findByHcFechanacimiento", query = "SELECT h FROM Historiaclinica h WHERE h.hcFechanacimiento = :hcFechanacimiento")
    , @NamedQuery(name = "Historiaclinica.findByHcDescripvacunas", query = "SELECT h FROM Historiaclinica h WHERE h.hcDescripvacunas = :hcDescripvacunas")
    , @NamedQuery(name = "Historiaclinica.findByHcTratamientos", query = "SELECT h FROM Historiaclinica h WHERE h.hcTratamientos = :hcTratamientos")
    , @NamedQuery(name = "Historiaclinica.findByHcSintomas", query = "SELECT h FROM Historiaclinica h WHERE h.hcSintomas = :hcSintomas")
    , @NamedQuery(name = "Historiaclinica.findByHcRecetas", query = "SELECT h FROM Historiaclinica h WHERE h.hcRecetas = :hcRecetas")})
public class Historiaclinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hc_id")
    private Integer hcId;
    @Size(max = 45)
    @Column(name = "hc_idmascota")
    private String hcIdmascota;
    @Size(max = 45)
    @Column(name = "hc_descripcion")
    private String hcDescripcion;
    @Column(name = "hc_fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date hcFechanacimiento;
    @Size(max = 45)
    @Column(name = "hc_descripvacunas")
    private String hcDescripvacunas;
    @Size(max = 45)
    @Column(name = "hc_tratamientos")
    private String hcTratamientos;
    @Size(max = 45)
    @Column(name = "hc_sintomas")
    private String hcSintomas;
    @Size(max = 45)
    @Column(name = "hc_recetas")
    private String hcRecetas;
    @ManyToMany(mappedBy = "historiaclinicaCollection", fetch = FetchType.LAZY)
    private Collection<Mascotas> mascotasCollection;

    public Historiaclinica() {
    }

    public Historiaclinica(Integer hcId) {
        this.hcId = hcId;
    }

    public Integer getHcId() {
        return hcId;
    }

    public void setHcId(Integer hcId) {
        this.hcId = hcId;
    }

    public String getHcIdmascota() {
        return hcIdmascota;
    }

    public void setHcIdmascota(String hcIdmascota) {
        this.hcIdmascota = hcIdmascota;
    }

    public String getHcDescripcion() {
        return hcDescripcion;
    }

    public void setHcDescripcion(String hcDescripcion) {
        this.hcDescripcion = hcDescripcion;
    }

    public Date getHcFechanacimiento() {
        return hcFechanacimiento;
    }

    public void setHcFechanacimiento(Date hcFechanacimiento) {
        this.hcFechanacimiento = hcFechanacimiento;
    }

    public String getHcDescripvacunas() {
        return hcDescripvacunas;
    }

    public void setHcDescripvacunas(String hcDescripvacunas) {
        this.hcDescripvacunas = hcDescripvacunas;
    }

    public String getHcTratamientos() {
        return hcTratamientos;
    }

    public void setHcTratamientos(String hcTratamientos) {
        this.hcTratamientos = hcTratamientos;
    }

    public String getHcSintomas() {
        return hcSintomas;
    }

    public void setHcSintomas(String hcSintomas) {
        this.hcSintomas = hcSintomas;
    }

    public String getHcRecetas() {
        return hcRecetas;
    }

    public void setHcRecetas(String hcRecetas) {
        this.hcRecetas = hcRecetas;
    }

    @XmlTransient
    public Collection<Mascotas> getMascotasCollection() {
        return mascotasCollection;
    }

    public void setMascotasCollection(Collection<Mascotas> mascotasCollection) {
        this.mascotasCollection = mascotasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hcId != null ? hcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiaclinica)) {
            return false;
        }
        Historiaclinica other = (Historiaclinica) object;
        if ((this.hcId == null && other.hcId != null) || (this.hcId != null && !this.hcId.equals(other.hcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.adsi2025316.Historiaclinica[ hcId=" + hcId + " ]";
    }
    
}
