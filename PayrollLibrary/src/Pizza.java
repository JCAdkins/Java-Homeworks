/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpizza;

/**
 *
 * @author jordanadkins
 */
public class Pizza {
    private String size;
    private String[] toppings;
    private String crust;
    
    public Pizza(){
        
    }
    
    public Pizza(String size, String toppings[], String crust){
        this.size = size;
        this.toppings = toppings;
        this.crust = crust;
    }
    
    public float calculatePrice(){
        float price=0;
        if (this.size!=null || this.toppings[0]!=null || this.crust!=null){ //ensures all pizza variables are in place
            switch (size) {         //sets the base price of the pizza
                case "individual": price = 4;
                break;
                case "small": price = 6;
                break;
                case "medium": price = 8;
                break;
                case "large": price = 10;
                break;
                case "extra-large": price = 12;
                break;
            }
            if ("individual".equals(this.size) || "small".equals(this.size) || "medium".equals(this.size)){
                price = price + (toppings.length)*0.5f;    // adds $.50 for topping on individual, small, and medium pizza
            }else{
                price = price + (toppings.length)*0.75f; //ads $.75 for topping on large and x-large pizza
            }
            if ("cheese stuffed".equals(this.crust)){       //checks to see if stuffed cheese crust was chosen
                switch (size) {         //if so add prices accordingly to size
                case "individual": price = price + .25f;
                break;
                case "small": price = price + .25f;
                break;
                case "medium": price = price + .45f;
                break;
                case "large": price = price + .45f;
                break;
                case "extra-large": price = price + .55f;
                break;
            }
            }
        }else{
            return 0;
        }
        return price;
    }
    
    public String displayData(){            //displays the data stored in the pizza class
        String pizza = "Size: " + size + "\nToppings:";
        for (String topping : toppings) {
            pizza = pizza + topping + "\n\t ";
        }
        pizza = pizza + "\nCrust: " + crust;
        return pizza;
        
     }
    
    
    
}
