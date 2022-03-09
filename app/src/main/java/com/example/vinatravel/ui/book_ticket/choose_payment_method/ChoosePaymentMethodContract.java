package com.example.vinatravel.ui.book_ticket.choose_payment_method;

public interface ChoosePaymentMethodContract {
    interface View{
        void receiveIdDepartureLocation(int idDepartureLocation);
        void receiveIdArrivalLocation(int idArrivalLocation);
        void bookTicketSuccess();
        void completeBookTicket(int idTicket);
    }

    interface Presenter{
        void addTicket(int idTrip, int idUser, int idSeat, String detailDepartureLocation, String detailArrivalLocation);
        void getIdLocation(String departureLocation);
        void getIdArrivalLocation(String arrivalLocation);
        void comleteBookTicket(int idSeat, int idTrip, int idTicket);
    }
}
