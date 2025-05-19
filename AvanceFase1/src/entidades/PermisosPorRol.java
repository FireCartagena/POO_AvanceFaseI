/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class PermisosPorRol {

    private Integer id;
    private Privilegios codigoPrivilegio;
    private Rol codigoRol;

    public PermisosPorRol() {
    }

    public PermisosPorRol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Privilegios getCodigoPrivilegio() {
        return codigoPrivilegio;
    }

    public void setCodigoPrivilegio(Privilegios codigoPrivilegio) {
        this.codigoPrivilegio = codigoPrivilegio;
    }

    public Rol getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(Rol codigoRol) {
        this.codigoRol = codigoRol;
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
        if (!(object instanceof PermisosPorRol)) {
            return false;
        }
        PermisosPorRol other = (PermisosPorRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PermisosPorRol[ id=" + id + " ]";
    }
    
}
