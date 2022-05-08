package nz.co.kiwibank.architecturedemo.ui.authenticated.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val username: String, val firstName: String, val lastName: String): Parcelable
