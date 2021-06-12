/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.petsi;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "tbl_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")
    , @NamedQuery(name = "Servicios.findBySvcId", query = "SELECT s FROM Servicios s WHERE s.svcId = :svcId")
    , @NamedQuery(name = "Servicios.findBySvcTiposervicio", query = "SELECT s FROM Servicios s WHERE s.svcTiposervicio = :svcTiposervicio")
    , @NamedQuery(name = "Servicios.findBySvcTiposervicioOtro", query = "SELECT s FROM Servicios s WHERE s.svcTiposervicioOtro = :svcTiposervicioOtro")
    , @NamedQuery(name = "Servicios.findBySvcDescripcion", query = "SELECT s FROM Servicios s WHERE s.svcDescripcion = :svcDescripcion")
    , @NamedQuery(name = "Servicios.findBySvcEncargado", query = "SELECT s FROM Servicios s WHERE s.svcEncargado = :svcEncargado")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "svc_id")
    private Integer svcId;
    @Size(max = 45)
    @Column(name = "svc_tiposervicio")
    private String svcTiposervicio;
    @Size(max = 45)
    @Column(name = "svc_tiposervicio_otro")
    private String svcTiposervicioOtro;
    @Size(max = 45)
    @Column(name = "svc_descripcion")
    private String svcDescripcion;
    @Size(max = 45)
    @Column(name = "svc_encargado")
    private String svcEncargado;
    @ManyToMany(mappedBy = "serviciosCollection", fetch = FetchType.LAZY)
    private Collection<Citas> citasCollection;

    public Servicios() {
    }

    public Servicios(Integer svcId) {
        this.svcId = svcId;
    }

    public Integer getSvcId() {
        return svcId;
    }

    public void setSvcId(Integer svcId) {
        this.svcId = svcId;
    }

    public String getSvcTiposervicio() {
        return svcTiposervicio;
    }

    public void setSvcTiposervicio(String svcTiposervicio) {
        this.svcTiposervicio = svcTiposervicio;
    }

    public String getSvcTiposervicioOtro() {
        return svcTiposervicioOtro;
    }

    public void setSvcTiposervicioOtro(String svcTiposervicioOtro) {
        this.svcTiposervicioOtro = svcTiposervicioOtro;
    }

    public String getSvcDescripcion() {
        return svcDescripcion;
    }

    public void setSvcDescripcion(String svcDescripcion) {
        this.svcDescripcion = svcDescripcion;
    }

    public String getSvcEncargado() {
        return svcEncargado;
    }

    public void setSvcEncargado(String svcEncargado) {
        this.svcEncargado = svcEncargado;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svcId != null ? svcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.svcId == null && other.svcId != null) || (this.svcId != null && !this.svcId.equals(other.svcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.adsi2025316.Servicios[ svcId=" + svcId + " ]";
    }
    
}
