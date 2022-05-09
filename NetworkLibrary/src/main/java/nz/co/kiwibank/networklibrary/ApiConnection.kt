package nz.co.kiwibank.networklibrary

interface ApiConnection {

    fun login(username: String, password: String ): Response
    fun logout()
}