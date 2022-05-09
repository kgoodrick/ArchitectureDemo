package nz.co.kiwibank.networklibrary

import org.json.JSONObject

class ApiConnectionImpl : ApiConnection {

    override fun login(username: String, password: String): Response {
        val res = Response()

        return res
    }

    override fun logout() {
        // Implement this
    }
}