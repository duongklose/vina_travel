package com.example.vinatravel.ui.home.search;

import com.example.vinatravel.api.ApiService;
import com.example.vinatravel.api.RetrofitClient;

public class SearchPresenter implements SearchContract.Presenter{

    private SearchContract.View view;
    ApiService api = RetrofitClient.getInstance().create(ApiService.class);

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void getListProvince() {

    }
}
