/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author Sami Elias Jada
 */
@Entity
@Table(name = "stall")
@NamedQueries({
    @NamedQuery(name = "Stall.findAll", query = "SELECT s FROM Stall s"),
    @NamedQuery(name = "Stall.findByStallTitle", query = "SELECT s FROM Stall s WHERE s.stallTitle = :stallTitle"),
    @NamedQuery(name = "Stall.findByDescription", query = "SELECT s FROM Stall s WHERE s.description = :description")})
public class Stall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "stallTitle")
    private String stallTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @OneToOne(optional = false)
    private User username;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stallTitle")
    private Products products;

    public Stall() {
    }

    public Stall(String stallTitle) {
        this.stallTitle = stallTitle;
    }

    public Stall(String stallTitle, String description) {
        this.stallTitle = stallTitle;
        this.description = description;
    }

    public String getStallTitle() {
        return stallTitle;
    }

    public void setStallTitle(String stallTitle) {
        this.stallTitle = stallTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stallTitle != null ? stallTitle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stall)) {
            return false;
        }
        Stall other = (Stall) object;
        if ((this.stallTitle == null && other.stallTitle != null) || (this.stallTitle != null && !this.stallTitle.equals(other.stallTitle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Stall[ stallTitle=" + stallTitle + " ]";
    }
    
}
