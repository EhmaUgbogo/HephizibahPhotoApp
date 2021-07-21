package com.ehmaugbogo.hephizibahapp.view.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ehmaugbogo.hephizibahapp.R
import com.ehmaugbogo.hephizibahapp.dataStoreAchitecture.PhotoViewModel
import com.ehmaugbogo.hephizibahapp.utils.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG = "HomeFragment"
    private val viewModel: PhotoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPhotosWithLimit(1).observe(viewLifecycleOwner){ result ->
            when(result){
                is Result.Failure -> logMsg(result.error.localizedMessage)
                is Result.Loading -> {}
                is Result.Success -> logMsg(result.data.toString())
            }
        }
    }

    private fun logMsg(msg: String?) {
        Log.d(TAG, "onViewCreated: $msg")
    }
}