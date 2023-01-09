package ru.otus.api.services;

import ru.otus.domain.CurrencyConnectionResult;

import java.util.List;

public interface PriceRequestsHistoryHolder {
    void addPriceInWordsPrinterResult(CurrencyConnectionResult result);
    List<CurrencyConnectionResult> getHistoryList();
}
