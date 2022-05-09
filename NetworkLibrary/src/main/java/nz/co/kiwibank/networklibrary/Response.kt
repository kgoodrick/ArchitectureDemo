package nz.co.kiwibank.networklibrary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(var user: User = User(), var isSuccess: Boolean = false, var error: Error =  Error()): Parcelable

@Parcelize
data class User(var userName: String = "", var firstName: String = "", var surName: String = ""): Parcelable

@Parcelize
data class Error(var code: String = "", var message: String = ""): Parcelable