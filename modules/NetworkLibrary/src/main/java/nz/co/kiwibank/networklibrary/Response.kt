package nz.co.kiwibank.networklibrary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(var user: User? = null, var isSuccess: Boolean = false, var error: Error? =  null): Parcelable

@Parcelize
data class User(var userName: String = "", var firstName: String = "", var surName: String = "", var status: String = ""): Parcelable

@Parcelize
data class Error(var code: String = "", var message: String = ""): Parcelable