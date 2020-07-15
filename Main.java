import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.math.BigDecimal;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);

    try {
        double purchasePrice = Double.parseDouble(in.readLine());
        double cash = Double.parseDouble(in.readLine());
        Main.calculateChange(purchasePrice, cash);
    } catch (Exception e) {
        System.out.println(e);
    }
  }

  public static void calculateChange(double purchasePrice, double cash) {
    Money obj = new Money(purchasePrice, cash);
    if (obj.purchasePrice > obj.cash){
        System.out.println("ERROR");
    }
    else if(obj.purchasePrice == obj.cash){
        System.out.println("Zero");
    }
    else{
        // double[][] finalList = obj.changeFromRegister();
        // for (int i=0; i<finalList.length; i++){
        //     for (int j=0; j<finalList[i].length;j++){
        //       System.out.println(finalList[i][j]);
        // }
        // }
        // for(int i=0;i<12;i++){
        //     while(finalList[1][i]>0.0){
        //         String newString = String.valueOf(finalList[0][i]);
        //         System.out.print(newString + ", ");
        //         finalList[1][i]-=1.0;
        //     }
        // }
        System.out.println(obj.changeFromRegister());
        
        
    }
  }
}

class Money {
    double purchasePrice;
    double cash;
    
    public Money(double purchasePrice, double cash){
        this.purchasePrice = purchasePrice;
        this.cash = cash;
    }
    public String changeFromRegister(){
        double changeAmount = cash - purchasePrice;
        StringBuilder change = new StringBuilder();
        
        for (Denomination d : Denomination.values()) {
        while (changeAmount >= d.getValue()) {
            changeAmount = SubtractUsingBigDecimalOperation(changeAmount, d.getValue());
            change.append(d).append(',');
        }
    }
    change.setLength(change.length() - 1);
 
    return change.toString();
        // double[] currencyDenominations = {50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01}; 
        // double[] denominationCounter = new double[12]; 
        // for (int i = 0; i < 12; i++) { 
        //     if (changeAmount >= currencyDenominations[i]) { 
        //         int temp = (int)(changeAmount / currencyDenominations[i]);
        //         denominationCounter[i] = temp;
        //         changeAmount = SubtractUsingBigDecimalOperation(changeAmount, denominationCounter[i] * currencyDenominations[i]); 
        //         System.out.println(changeAmount);
        //     } 
        // } 
        // double[][] finalList = {currencyDenominations, denominationCounter};
        // return (finalList);
    }
    
    
    
    public enum Denomination {
            Fifty_pounds( 50.00d),
            Twenty_pounds( 20.00d),
            Ten_pounds( 10.00d),
            Five_pounds(  5.00d),
            Two_pounds(  2.00d),
            One_pound(  1.00d),
            Fifty_pence(  0.50d),
            Twenty_pence(  0.20d),
            Ten_pence(  0.10d),
            Five_pence(  0.05d),
            Two_pence(0.02d),
            One_pence(  0.01d);

        private final double value;
        private final String description;
    
        Denomination(double value) {
            this.value = value;
            this.description = this.name().replace("_", " ");
        }
    
        public double getValue() {
            return this.value;
        }
        @Override
        public String toString() {
            return this.description;
        }
    }
    
    public double SubtractUsingBigDecimalOperation(double a, double b){
        BigDecimal c = BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b));
        return c.doubleValue();
    }
}