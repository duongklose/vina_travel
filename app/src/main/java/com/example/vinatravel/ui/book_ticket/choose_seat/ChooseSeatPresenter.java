package com.example.vinatravel.ui.book_ticket.choose_seat;

public class ChooseSeatPresenter implements ChooseSeatContract.Presenter{

    private ChooseSeatContract.View view;

    public ChooseSeatPresenter(ChooseSeatContract.View view) {
        this.view = view;
    }
}
