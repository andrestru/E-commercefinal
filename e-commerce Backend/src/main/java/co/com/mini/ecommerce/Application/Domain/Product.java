package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.NonEmptyDescription;
import co.com.mini.ecommerce.Common.NonEmptyName;


public class Product {

    IdentificationNumber identificationNumber;
    NonEmptyName Name;
    NonEmptyDescription Description;
    CheckPrice Base_Price;
    CheckTaxRate Tax_Rate;
    ProductStatus Productstatus;
    CheckInventory Inventory;

    public Product(IdentificationNumber identificationNumber, NonEmptyName name, NonEmptyDescription description, CheckPrice base_Price, CheckTaxRate tax_Rate, ProductStatus productstatus, CheckInventory inventory) {
        this.identificationNumber = identificationNumber;
        Name = name;
        Description = description;
        Base_Price = base_Price;
        Tax_Rate = tax_Rate;
        Productstatus = productstatus;
        Inventory = inventory;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public NonEmptyName getName() {
        return Name;
    }

    public NonEmptyDescription getDescription() {
        return Description;
    }

    public CheckPrice getBase_Price() {
        return Base_Price;
    }

    public CheckTaxRate getTax_Rate() {
        return Tax_Rate;
    }

    public ProductStatus getProductstatus() {
        return Productstatus;
    }

    public CheckInventory getInventory() {
        return Inventory;
    }


}
