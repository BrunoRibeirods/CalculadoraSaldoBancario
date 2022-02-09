package file;

import lombok.Getter;
import lombok.Setter;
import operation.BankingAccount;
import operation.BankingOperation;
import org.apache.commons.collections4.CollectionUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Getter
@Setter
public class BankOperationFileManager implements FileManager{

    public Set<BankingOperation> bankOperationsList = new LinkedHashSet<>();
    private int position = 0;
    String pathName;

    public BankOperationFileManager(String pathName){
        this.pathName = pathName;
    }

    @Override
    public void readFile() {

        ArrayList<BankingOperation> records = new ArrayList();
        try (Scanner scanner = new Scanner(new File(pathName));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        records.remove(0);
        CollectionUtils.addAll(bankOperationsList, records);
    }

    @Override
    public void generateFile(List<String> lines){
        try {
            FileWriter myWriter = new FileWriter("extrato.txt");
            for(String line : lines){
                myWriter.write(line);
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BankingOperation getRecordFromLine(String line) {
        ArrayList values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {

                values.add(rowScanner.next());
            }
        }
        return new BankingOperation(
                (String) values.get(5),
                (String) values.get(6),
                (String) values.get(0),
                (String) values.get(7),
                new BankingAccount(
                        (String) values.get(1),
                        (String) values.get(2),
                        (String) values.get(3),
                        (String) values.get(4),
                        0.0
                )
        );
    }
}
