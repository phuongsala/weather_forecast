package com.phuongsala.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phuongsala.presentation.common.OnItemClickListener

abstract class BaseItemViewModel<T: BaseItemModel> : ViewModel() {

     var liveData: MutableLiveData<T> = MutableLiveData()
     var onItemClickListener: OnItemClickListener? = null

    open fun getData(): T? {
        return liveData.value
    }

    open fun onItemClicked(data: BaseItemModel) {
        onItemClickListener?.onItemClicked(data)
    }
}