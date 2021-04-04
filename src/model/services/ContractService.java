package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++)
        {
            Date dueDate = addMonths(contract.getDate(), i);
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota,i);
            double fullQuota = basicQuota + onlinePaymentService.paymentFee(updatedQuota);


            contract.getInstallment().add(new Installment(dueDate,fullQuota));



        }
    }


    private Date addMonths(Date data, int N){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MONTH, N );
        return calendar.getTime();
    }
}



