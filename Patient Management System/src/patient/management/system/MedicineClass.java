/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient.management.system;

/**
 *
 *   class that creates a medicine object with several functionalities:
     * Can be given to the patient as a prescription or as a medicine
     * Can be checked for stock and if low, replenished
     * Can be created by a doctor class
     * Has a name, dosage and stock level that defines the object upon creation
 * @author jflet
 */
public class MedicineClass {

    /**
     *name of the medicine, set at creation
     */
    protected String name;

    /**
     * dosage of the medicine, set at creation
     */
    protected String dosage;

    /**
     * how many of the medicine the surgery currently has, set at creation and can be edited by giving some to patients or restocking
     */
    protected int stockLevel;

    /**
     * constructor for the medicine class
     * @param name
     * @param dosage
     * @param stockLevel
     */
    public MedicineClass(String name, String dosage, int stockLevel){
    
    this.name = name;
    this.dosage = dosage;
    this.stockLevel = stockLevel;
    
    
    }

    /**
     * getter for the medicine name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter for medicine name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for dosage
     * @return
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * setter for dosage
     * @param dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /**
     * getter for the stock level
     * @return
     */
    public int getStockLevel() {
        return stockLevel;
    }

    /**
     * setter for the stock level
     * @param stockLevel
     */
    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    
    
}
