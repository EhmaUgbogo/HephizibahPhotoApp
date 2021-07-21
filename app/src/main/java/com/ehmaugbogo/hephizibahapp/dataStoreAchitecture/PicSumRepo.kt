package com.ehmaugbogo.hephizibahapp.dataStoreAchitecture

import com.ehmaugbogo.hephizibahapp.api.PicSumApi
import com.ehmaugbogo.hephizibahapp.api.model.Photo
import com.ehmaugbogo.hephizibahapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @company ..: GIGM
 * @author ..: Ehma Ugbogo
 * @email ..: ehmaugbogo@gmail.com
 * @created ..: 04-07-2021
 */

@Singleton
class PicSumRepo @Inject constructor(private val picSumApi: PicSumApi) {

    fun getAllPhotos(): Flow<Result<List<Photo>>> {
        return flow<Result<List<Photo>>> {
            val list = picSumApi.getAllPhotos()
            emit(Result.Success(list))
        }.flowOn(Dispatchers.IO)
    }

    fun getPhotosWithLimit(page: Int, limit: Int = 10) =
            flow<Result<List<Photo>>> {
                val list = picSumApi.getPhotosWithLimit(page, limit)
                emit(Result.Success(list))
                emit(Result.Loading(false))
            }.handleRest()

















    fun <T> Flow<Result<T>>.handleRest(): Flow<Result<T>> {
        return this.flowOn(Dispatchers.IO)
                .catch { emit(Result.Failure(it)) }
                .onStart { emit(Result.Loading(true)) }
                .onCompletion {
                    emit(Result.Loading(false))
                }
    }


}