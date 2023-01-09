package ru.otus.services;


import ru.otus.api.services.PriceRequestsHistoryHolder;
import ru.otus.domain.CurrencyConnectionResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceRequestsHistoryHolderImpl implements PriceRequestsHistoryHolder {
    private final List<CurrencyConnectionResult> historyList;

    public PriceRequestsHistoryHolderImpl() {
        historyList = new ArrayList<>();
    }

    @Override
    public void addPriceInWordsPrinterResult(CurrencyConnectionResult result) {
        historyList.add(result);
    }

    @Override
    public List<CurrencyConnectionResult> getHistoryList() {
        return Collections.unmodifiableList(historyList);
    }
}
