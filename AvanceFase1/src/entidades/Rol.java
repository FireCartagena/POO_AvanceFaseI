/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

public class Rol {

    private Integer id;

    private String rol;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoRol")
    private List<PermisosPorRol> permisosPorRolList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoRol")
    private List<Usuarios> usuariosList;

    public Rol() {
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Rol(Integer id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<PermisosPorRol> getPermisosPorRolList() {
        return permisosPorRolList;
    }

    public void setPermisosPorRolList(List<PermisosPorRol> permisosPorRolList) {
        this.permisosPorRolList = permisosPorRolList;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
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
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rol[ id=" + id + " ]";
    }
    
}
