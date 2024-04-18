import java.text.DecimalFormat;
import java.util.Scanner;
 
public class LoanInterests {
 
    public static void main(String[] args) {
        // Declare variables and constants
        final double SIMPLE_INTEREST = 0.15, COMPOUND_INTEREST = 0.10;
        String output = "";
        double principalAmount, interestRate, interest, time, simpleInterest = 0, compoundInterest = 0;
        
        // Instantiate --> Create the Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        // Instantiate --> Create the DecimalFormat object
        DecimalFormat df = new DecimalFormat("0.00");
        
        // Prompt for user to enter the principal amount
        System.out.print("Enter the principal: R");
        
        // Read a double from the keyboard, and store in principalAmount
        principalAmount = keyboard.nextDouble();
        
        // Prompt for user to enter the loan period in years
        System.out.print("Enter the loan period in years: ");
        
        // Read a double from the keyboard, and store in time
        time = keyboard.nextDouble();
        
        // Prompt for user to enter the  compounding frequency per annum
        System.out.print("Enter compounding frequency: ");
        
        // Read a double from the keyboard, and store in interestRate
        interestRate = keyboard.nextDouble();
        
        // Initial principal amount is nonzero and nonnegative
        if(principalAmount >= 0){
            // Loan period in years is non-negative and less than 20 years
            if(time >= 0 && time < 21){
                // Check to validate that the interest yielded is greater than zero
                if(interestRate > 0)
                    // Calculate the simple interest loan yielded amount 
                    simpleInterest = principalAmount * SIMPLE_INTEREST * time;
                     
                    // Validate the loan frequency, the loan frequency must be between 1 and 12 months in a year.
                    if(interestRate >= 1 && interestRate <= 12){
                        // Calculate the compound interest yielded amount
                        compoundInterest = principalAmount * Math.pow(1 + (COMPOUND_INTEREST / interestRate) , (time * interestRate));
                        compoundInterest = compoundInterest - principalAmount;
                        
                        // Determine which option provides the best interest rate between simple and compound interest
                        if(compoundInterest > simpleInterest){
                            output = "Compounding interest is the better interest.";
                        }
                        // Display the loan input data and the loan yield amounts 
                        System.out.println("============ Loan input data ============" + "\n" +
                                           "Principal: R" + principalAmount + "\n" +
                                           "Time Duration: " + time + "\n" +
                                           "Compounding frequency: " + interestRate + "\n" + 
                                           "============ Loan yield amounts ============" + "\n" + 
                                           "Simple Interest yield: R" + df.format(simpleInterest) + "\n" +
                                           "Compound Interest yield: R" + df.format(compoundInterest) + "\n" +
                                           output);
                    }else{
                        System.out.println("Compounding frequency cannot be zero or less or greater than 12");
                    }
                
            }else{
                System.out.println("The load period is undefined, program exiting!");
            }
        }else{
            System.out.println("The principal is invalid, program exiting!");
        }
       
    }
    
}
