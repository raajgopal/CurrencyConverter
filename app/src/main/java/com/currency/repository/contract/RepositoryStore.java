package com.currency.repository.contract;

import com.currency.entities.CurrencyValueResponse;
import io.reactivex.Single;

public interface RepositoryStore {
    Single<CurrencyValueResponse> getCurrencyRates(String base);
}
