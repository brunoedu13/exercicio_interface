package model.services;



public interface OnlinePaymentService {

    Double paymentFee(Double amaunt);
    Double interest(Double amaunt, Integer months);

}
