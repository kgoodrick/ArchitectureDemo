package nz.co.kiwibank.networklibrary.mock.authentication

import io.reactivex.rxjava3.core.Single
import nz.co.kiwibank.networklibrary.Response
import nz.co.kiwibank.networklibrary.contract.AuthenticationApi
import nz.co.kiwibank.networklibrary.mock.response.Responses

class AuthenticationApiImpl : AuthenticationApi {

    override fun login(username: String, password: String): Single<Response> {
        return Single.just(username).map { un ->
            Responses.checkUser(un, password)
        }.cache()
    }

    override fun logout() {
        // Implement this
    }
}