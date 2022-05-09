package nz.co.kiwibank.architecturedemo.ui.meh.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MehModel(var username: String, var password: String): Parcelable
