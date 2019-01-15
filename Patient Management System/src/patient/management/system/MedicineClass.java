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
    
    
}
