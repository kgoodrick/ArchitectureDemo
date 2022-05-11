package nz.co.kiwibank.networklibrary.response

import nz.co.kiwibank.networklibrary.Error
import nz.co.kiwibank.networklibrary.Response
import nz.co.kiwibank.networklibrary.User

object Responses {

    enum class ErrorType {
        LOCKED,
        GENERAL,
        UNKNOWN,
        NONE
    }

    enum class UserStatus {
        ACTIVE,
        LOCKED,
        NEW
    }

    private val passwords: Map<String, String> = mutableMapOf(
        "kev" to "test01",
        "luke" to "test02",
        "dianyi" to "test03",
        "chee" to "test04",
        "taher" to "test05"
    )

    private val users: Map<String, User> = mapOf(
        "kev" to User("kev", "Kev", "Goodrick", UserStatus.ACTIVE.name),
        "luke" to User("luke", "Luke", "Catheral", UserStatus.ACTIVE.name),
        "dianyi" to User("dianyi", "Dianyi", "Jiang", UserStatus.LOCKED.name),
        "chee" to User("chee", "Chee", "Low", UserStatus.NEW.name),
        "taher" to User("taher", "Taher", "Ismail", UserStatus.NEW.name)
    )

    private val errors: Map<ErrorType, Error?> = mapOf(
        ErrorType.LOCKED to Error("69", "Locked yo out"),
        ErrorType.GENERAL to Error("96", "A swift response"),
        ErrorType.UNKNOWN to Error("-1", "We don't know you"),
        ErrorType.NONE to null
    )

    fun checkUser(username: String, password: String): Response {
        val res = Response()
        val passwordCheck = passwords[username].equals(password)
        if (passwordCheck) {
            val user = users[username]
            res.user = user
            res.isSuccess = true
            res.error = when( user?.status ) {
                UserStatus.NEW.name -> errors[ErrorType.GENERAL]
                UserStatus.ACTIVE.name -> errors[ErrorType.NONE]
                UserStatus.LOCKED.name -> errors[ErrorType.LOCKED]
                else -> errors[ErrorType.UNKNOWN]
            }
        } else {
            res.user = null
            res.isSuccess = false
            res.error = errors[ErrorType.UNKNOWN]
        }
        return res
    }
}