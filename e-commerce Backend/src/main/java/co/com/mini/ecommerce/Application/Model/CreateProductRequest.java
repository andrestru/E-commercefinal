package co.com.mini.ecommerce.Application.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;

import java.util.Objects;

public class CreateProductRequest implements ApplicationRequest {

    private int identificationNumber;
    private String Name;
    private String Description;
    private double Base_Price;
    private double Tax_Rate;
    private String Productstatus;
    private int Inventory;

    public CreateProductRequest() {
    }

    public CreateProductRequest(int identificationNumber, String name, String description, double base_Price, double tax_Rate, String productstatus, int inventory) {
        this.identificationNumber = identificationNumber;
        Name = name;
        Description = description;
        Base_Price = base_Price;
        Tax_Rate = tax_Rate;
        Productstatus = productstatus;
        Inventory = inventory;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getBase_Price() {
        return Base_Price;
    }

    public void setBase_Price(double base_Price) {
        Base_Price = base_Price;
    }

    public double getTax_Rate() {
        return Tax_Rate;
    }

    public void setTax_Rate(double tax_Rate) {
        Tax_Rate = tax_Rate;
    }

    public String getProductstatus() {
        return Productstatus;
    }

    public void setProductstatus(String productstatus) {
        Productstatus = productstatus;
    }

    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int inventory) {
        Inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return identificationNumber == that.identificationNumber && Double.compare(that.Base_Price, Base_Price) == 0 && Double.compare(that.Tax_Rate, Tax_Rate) == 0 && Inventory == that.Inventory && Objects.equals(Name, that.Name) && Objects.equals(Description, that.Description) && Objects.equals(Productstatus, that.Productstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationNumber, Name, Description, Base_Price, Tax_Rate, Productstatus, Inventory);
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "identificationNumber=" + identificationNumber +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Base_Price=" + Base_Price +
                ", Tax_Rate=" + Tax_Rate +
                ", Productstatus='" + Productstatus + '\'' +
                ", Inventory=" + Inventory +
                '}';
    }
}
