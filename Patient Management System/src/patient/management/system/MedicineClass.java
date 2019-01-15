/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient.management.system;

/**
 *
 * @author jflet
 */
public class MedicineClass {
    protected String name;
    protected String dosage;
    protected int stockLevel;
    public MedicineClass(String name, String dosage, int stockLevel){
    
    this.name = name;
    this.dosage = dosage;
    this.stockLevel = stockLevel;
    
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    
    
}
