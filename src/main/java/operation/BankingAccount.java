package operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BankingAccount {
   String id;
   String bankName;
   String agency;
   String accountNumber;
   Double balance = 0.0;
}
