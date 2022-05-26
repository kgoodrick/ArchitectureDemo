package nz.co.kiwibank.networklibrary

import nz.co.kiwibank.networklibrary.contract.AuthenticationApi
import nz.co.kiwibank.networklibrary.mock.authentication.AuthenticationApiImpl

object DemoApiConnection {
    val authApi: AuthenticationApi by lazy { AuthenticationApiImpl() }
}