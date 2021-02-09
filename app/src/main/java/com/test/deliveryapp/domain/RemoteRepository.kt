package com.test.deliveryapp.domain

import io.reactivex.rxjava3.core.Single

interface RemoteRepository<T> {
   fun getData(): Single<T>
}