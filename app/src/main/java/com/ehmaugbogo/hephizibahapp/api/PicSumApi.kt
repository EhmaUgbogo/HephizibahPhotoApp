package com.ehmaugbogo.hephizibahapp.api

import com.ehmaugbogo.hephizibahapp.api.model.Photo
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * @company ..: GIGM
 * @author ..: Ehma Ugbogo
 * @email ..: ehmaugbogo@gmail.com
 * @created ..: 04-07-2021
 */


interface PicSumApi {

    @GET("list")
    suspend fun getPhotos(): List<Photo>

    @GET("list")
    suspend fun getPhotos(@Query("page") page: Int, @Query("limit") limit: Int = 10): List<Photo>

}