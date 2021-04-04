package application;


import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        Integer contractNumber = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract Value: ");
        Double contractValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber,date,contractValue);
        ContractService cs = new ContractService(new PaypalService());

        System.out.print("Enter number of installments: ");
        Integer installments = sc.nextInt();

        cs.processContract(contract,installments);

        System.out.println("Instalments: ");

        for(Installment it : contract.getInstallment()){
            System.out.println(it);
        }

        sc.close();






    }




}
