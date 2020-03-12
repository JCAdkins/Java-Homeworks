
import java.util.ArrayList;

/*
Authoer: Jordan Adkins
Date: 4/22/18
Abstract: Pizza class that contains the size, toppings and crust of the pizza.
*/

public class Pizza {
    private String size;                        //variables needed for pizza class
    private ArrayList <String> toppings;
    private String crust;
    
    public Pizza(){             //pizza() constructor
        
    }
    
    public Pizza(String size, ArrayList <String> toppings, String crust){           //overloaded pizza constructor
        this.size = size;
        this.toppings = toppings;
        this.crust = crust;
    }
    
    public String getSize(){            //returns the size of the pizza
        return this.size;
    }
    
    public String getCrust(){           //returns the crust of the pizza
    return crust;
}
    public String  getToppings(){           //returns the toppings of the pizza
        String pizza = new String("<html>");
        for (String topping : toppings) {
            pizza = pizza + topping + "<br>";
        }
        return pizza +"</html>";
    }
    
    public float calculatePrice(){              //calculates float price of pizza
        float price=0;
        if (this.size!=null || this.toppings!=null || this.crust!=null){ //ensures all pizza variables are in place
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
                price = price + (toppings.size())*0.5f;    // adds $.50 for topping on individual, small, and medium pizza
            }else{
                price = price + (toppings.size())*0.75f; //ads $.75 for topping on large and x-large pizza
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
    
    public String getStringPrice(){             //converts pizza price to string and returns the string
        return "$" + Float.toString(calculatePrice());
    }
    
    public float calculateTax(){                    //calculates the tax on the pizza
        return (Math.round(calculatePrice()*100*.08f)/100.0f);
    }
    
    public String getStringTax(){                       //returns string of the tax
        return "$" + Float.toString(calculateTax());
    }
    
    public String getTotal(){                           //calculates the total and returns it in string form
        return "$" + Float.toString(Math.round((calculatePrice() + calculateTax())*100f)/100f);
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
