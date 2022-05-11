package nz.co.kiwibank.networklibrary

import io.reactivex.rxjava3.core.Observable
import nz.co.kiwibank.networklibrary.response.Responses
import org.json.JSONObject

object ApiConnectionImpl : ApiConnection {

    override fun login(username: String, password: String): Observable<Response> {
        return Observable.just(username, password).map {
            Responses.checkUser(username, password)
        }
    }

    override fun logout() {
        // Implement this
    }
}