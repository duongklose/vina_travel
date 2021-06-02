package com.example.vinatravel.ui.book_ticket.choose_departure_location;

public class ChooseDepartureLocationPresenter implements ChooseDepartureLocationContract.Presenter{
    private ChooseDepartureLocationContract.View view;

    public ChooseDepartureLocationPresenter(ChooseDepartureLocationContract.View view) {
        this.view = view;
    }
}
