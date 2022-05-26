package nz.co.kiwibank.architecturedemo.ui.authentication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthenticationModel(var username: String, var password: String): Parcelable
