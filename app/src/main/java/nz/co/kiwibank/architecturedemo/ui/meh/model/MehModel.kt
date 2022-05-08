package nz.co.kiwibank.architecturedemo.ui.meh.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MehModel(val username: String, val password: String): Parcelable
