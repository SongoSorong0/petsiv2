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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "tbl_citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByCitId", query = "SELECT c FROM Citas c WHERE c.citId = :citId")
    , @NamedQuery(name = "Citas.findByCitUsuarioid", query = "SELECT c FROM Citas c WHERE c.citUsuarioid = :citUsuarioid")
    , @NamedQuery(name = "Citas.findByCitIdmascota", query = "SELECT c FROM Citas c WHERE c.citIdmascota = :citIdmascota")
    , @NamedQuery(name = "Citas.findByCitHorallegada", query = "SELECT c FROM Citas c WHERE c.citHorallegada = :citHorallegada")
    , @NamedQuery(name = "Citas.findByCitHorasalida", query = "SELECT c FROM Citas c WHERE c.citHorasalida = :citHorasalida")
    , @NamedQuery(name = "Citas.findByCitHorainicio", query = "SELECT c FROM Citas c WHERE c.citHorainicio = :citHorainicio")
    , @NamedQuery(name = "Citas.findByCitHorafinalizacion", query = "SELECT c FROM Citas c WHERE c.citHorafinalizacion = :citHorafinalizacion")
    , @NamedQuery(name = "Citas.findByCitEstado", query = "SELECT c FROM Citas c WHERE c.citEstado = :citEstado")
    , @NamedQuery(name = "Citas.findByCitMotivoanulacion", query = "SELECT c FROM Citas c WHERE c.citMotivoanulacion = :citMotivoanulacion")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cit_id")
    private Integer citId;
    @Size(max = 45)
    @Column(name = "cit_usuarioid")
    private String citUsuarioid;
    @Size(max = 45)
    @Column(name = "cit_idmascota")
    private String citIdmascota;
    @Column(name = "cit_horallegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citHorallegada;
    @Column(name = "cit_horasalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citHorasalida;
    @Column(name = "cit_horainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citHorainicio;
    @Column(name = "cit_horafinalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citHorafinalizacion;
    @Size(max = 45)
    @Column(name = "cit_estado")
    private String citEstado;
    @Size(max = 45)
    @Column(name = "cit_motivoanulacion")
    private String citMotivoanulacion;
    @JoinTable(name = "tbl_citas_has_tbl_servicios", joinColumns = {
        @JoinColumn(name = "tbl_citas_cit_id", referencedColumnName = "cit_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tbl_servicios_svc_id", referencedColumnName = "svc_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Servicios> serviciosCollection;
    @ManyToMany(mappedBy = "citasCollection", fetch = FetchType.LAZY)
    private Collection<Mascotas> mascotasCollection;
    @JoinTable(name = "tbl_citas_has_tbl_estados", joinColumns = {
        @JoinColumn(name = "tbl_citas_cit_id", referencedColumnName = "cit_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tbl_estados_est_id", referencedColumnName = "est_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Estados> estadosCollection;

    public Citas() {
    }

    public Citas(Integer citId) {
        this.citId = citId;
    }

    public Integer getCitId() {
        return citId;
    }

    public void setCitId(Integer citId) {
        this.citId = citId;
    }

    public String getCitUsuarioid() {
        return citUsuarioid;
    }

    public void setCitUsuarioid(String citUsuarioid) {
        this.citUsuarioid = citUsuarioid;
    }

    public String getCitIdmascota() {
        return citIdmascota;
    }

    public void setCitIdmascota(String citIdmascota) {
        this.citIdmascota = citIdmascota;
    }

    public Date getCitHorallegada() {
        return citHorallegada;
    }

    public void setCitHorallegada(Date citHorallegada) {
        this.citHorallegada = citHorallegada;
    }

    public Date getCitHorasalida() {
        return citHorasalida;
    }

    public void setCitHorasalida(Date citHorasalida) {
        this.citHorasalida = citHorasalida;
    }

    public Date getCitHorainicio() {
        return citHorainicio;
    }

    public void setCitHorainicio(Date citHorainicio) {
        this.citHorainicio = citHorainicio;
    }

    public Date getCitHorafinalizacion() {
        return citHorafinalizacion;
    }

    public void setCitHorafinalizacion(Date citHorafinalizacion) {
        this.citHorafinalizacion = citHorafinalizacion;
    }

    public String getCitEstado() {
        return citEstado;
    }

    public void setCitEstado(String citEstado) {
        this.citEstado = citEstado;
    }

    public String getCitMotivoanulacion() {
        return citMotivoanulacion;
    }

    public void setCitMotivoanulacion(String citMotivoanulacion) {
        this.citMotivoanulacion = citMotivoanulacion;
    }

    @XmlTransient
    public Collection<Servicios> getServiciosCollection() {
        return serviciosCollection;
    }

    public void setServiciosCollection(Collection<Servicios> serviciosCollection) {
        this.serviciosCollection = serviciosCollection;
    }

    @XmlTransient
    public Collection<Mascotas> getMascotasCollection() {
        return mascotasCollection;
    }

    public void setMascotasCollection(Collection<Mascotas> mascotasCollection) {
        this.mascotasCollection = mascotasCollection;
    }

    @XmlTransient
    public Collection<Estados> getEstadosCollection() {
        return estadosCollection;
    }

    public void setEstadosCollection(Collection<Estados> estadosCollection) {
        this.estadosCollection = estadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citId != null ? citId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.citId == null && other.citId != null) || (this.citId != null && !this.citId.equals(other.citId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.adsi2025316.Citas[ citId=" + citId + " ]";
    }
    
}
