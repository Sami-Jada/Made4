/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductDescription", query = "SELECT p FROM Products p WHERE p.productDescription = :productDescription"),
    @NamedQuery(name = "Products.findBystallTitle", query= "SELECT p FROM Products p JOIN stall USING (stallTitle) WHERE p.stallTitle = :stalltitle"),
    @NamedQuery(name = "Products.findByProductPrice", query = "SELECT p FROM Products p WHERE p.productPrice = :productPrice")})
    
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productID")
    private Long productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "productName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "productDescription")
    private String productDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productPrice")
    private int productPrice;
    @JoinColumn(name = "stallTitle", referencedColumnName = "stallTitle")
    @OneToOne(optional = false)
    private Stall stallTitle;

    public Products() {
    }

    public Products(Long productID) {
        this.productID = productID;
    }

    public Products(Long productID, String productName, String productDescription, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Stall getStallTitle() {
        return stallTitle;
    }

    public void setStallTitle(Stall stallTitle) {
        this.stallTitle = stallTitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Products[ productID=" + productID + " ]";
    }
    
}
