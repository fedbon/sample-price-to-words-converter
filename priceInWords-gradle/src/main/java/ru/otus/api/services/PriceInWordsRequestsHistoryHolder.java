package ru.otus.api.services;

import ru.otus.domain.PriceInWordsConversionResult;

import java.util.List;

public interface PriceInWordsRequestsHistoryHolder {
    void addPriceInWordsConversionResult(PriceInWordsConversionResult result);
    List<PriceInWordsConversionResult> getRequestsList();
}
