package com.currency.dependencyinjection

import com.currency.network.service.NetworkClientService
import com.currency.respository.ApiStore
import com.currency.respository.NetworkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    internal fun providesRateRestDatastore(rateService: NetworkClientService): ApiStore {
        return ApiStore(rateService)
    }

    @Singleton
    @Provides
    internal fun providesRateRepository(rateRestDatastore: ApiStore): NetworkRepository {
        return NetworkRepository(rateRestDatastore)
    }
}