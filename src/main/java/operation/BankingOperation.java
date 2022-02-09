package operation;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BankingOperation {

   String operatorName;
   String operationType;
   String operationDate;
   String operationValue;
   BankingAccount bankingAccount;

   public String calculateFinalBalance(){
      if(operationType.equalsIgnoreCase("SAQUE")){
         bankingAccount.balance -= Double.parseDouble(operationValue);
      }else {
         bankingAccount.balance += Double.parseDouble(operationValue);
      }

      return "\nValor após " + operationType + ": " +bankingAccount.balance + "\n";
   }
}
