package com.antonioleiva.mymovies.ui.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

interface Scope : CoroutineScope {

    class Impl(override val uiDispatcher: CoroutineDispatcher) : Scope {
        override lateinit var job: Job
    }

    var job: Job
    val uiDispatcher: CoroutineDispatcher

    override val coroutineContext: CoroutineContext
        get() = uiDispatcher + job

    fun initScope() {
        job = SupervisorJob()
    }

    fun destroyScope() {
        job.cancel()
    }
}