package nz.co.kiwibank.networklibrary

import io.reactivex.rxjava3.core.Observable

interface ApiConnection {

    fun login(username: String, password: String ): Observable<Response>
    fun logout()
}