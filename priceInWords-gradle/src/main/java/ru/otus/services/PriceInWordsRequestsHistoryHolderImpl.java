package ru.otus.services;


import ru.otus.api.services.PriceInWordsRequestsHistoryHolder;
import ru.otus.domain.PriceInWordsConversionResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriceInWordsRequestsHistoryHolderImpl implements PriceInWordsRequestsHistoryHolder {
    private final List<PriceInWordsConversionResult> requestsHistoryList;

    public PriceInWordsRequestsHistoryHolderImpl() {
        requestsHistoryList = new ArrayList<>();
    }

    @Override
    public void addPriceInWordsConversionResult(PriceInWordsConversionResult result) {
        requestsHistoryList.add(result);
    }

    @Override
    public List<PriceInWordsConversionResult> getRequestsList() {
        return Collections.unmodifiableList(requestsHistoryList);
    }
}
