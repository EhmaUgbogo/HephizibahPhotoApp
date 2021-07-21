package com.ehmaugbogo.hephizibahapp.dataStoreAchitecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ehmaugbogo.hephizibahapp.api.model.Photo
import com.ehmaugbogo.hephizibahapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject




@HiltViewModel
class PhotoViewModel @Inject constructor(private val repo: PicSumRepo): ViewModel() {

    fun getPhotosWithLimit(page: Int, limit: Int = 10) =
        repo.getPhotosWithLimit(page, limit).asLiveData()

}