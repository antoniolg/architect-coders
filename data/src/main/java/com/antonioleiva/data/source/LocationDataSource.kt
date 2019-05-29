package com.antonioleiva.data.source

interface LocationDataSource {
    suspend fun findLastRegion(): String?
}