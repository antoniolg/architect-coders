package com.antonioleiva.mymovies.ui.common

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class ScopedViewModel : ViewModel(), Scope by Scope.Impl() {

    init {
        initScope()
    }

    @CallSuper
    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}