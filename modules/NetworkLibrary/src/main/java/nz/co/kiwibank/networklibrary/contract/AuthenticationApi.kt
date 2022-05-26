package nz.co.kiwibank.networklibrary.contract

import io.reactivex.rxjava3.core.Single
import nz.co.kiwibank.networklibrary.Response

interface AuthenticationApi {

    fun login(username: String, password: String ): Single<Response>
    fun logout()
}