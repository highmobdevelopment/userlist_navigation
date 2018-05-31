package com.erevacation.networking

import com.erevacation.networking.networkmodel.ListNM
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("highmobdevelopment/userlist/master/contacts.json")
    fun getList(): Observable<MutableList<ListNM>>
}