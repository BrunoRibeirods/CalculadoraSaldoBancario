package app;

import file.BankOperationFileManager;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String pathName = "operacoes.csv";
        BankOperationFileManager bankOperation = new BankOperationFileManager(pathName);

        bankOperation.readFile();

        ArrayList<String> extractLines = new ArrayList<>();

        bankOperation.bankOperationsList.forEach(operation -> {
            extractLines.add("\nConta bancária de: " + operation.getOperatorName());
            extractLines.add(operation.calculateFinalBalance());
        });

        bankOperation.generateFile(extractLines);

    }
}
