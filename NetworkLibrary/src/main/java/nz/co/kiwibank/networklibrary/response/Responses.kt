package nz.co.kiwibank.networklibrary.response

object Responses {
    val successResponse1 = "{\"user\": {\"userName\": \"kev\",\"firstName\": \"Kev\",\"surName\": \"Goodrick\" },\"isSuccess\": true,\"error\": null"
    val successResponse2 = "{\"user\": {\"userName\": \"luke\",\"firstName\": \"Luke\",\"surName\": \"Catherall\" },\"isSuccess\": true,\"error\": null"
    val lockedResponse = "{\"user\": {\"userName\": \"dianyi\",\"firstName\": \"Dianyi\",\"surName\": \"Jiang\" },\"isSuccess\": False,\"error\": {\"code\": \"69\",\"message\": \"Locked yo ass out\"}}"
    val errorResponse1 = "{\"user\": {\"userName\": \"chee\",\"firstName\": \"Chee\",\"surName\": \"Low\" },\"isSuccess\": False,\"error\": {\"code\": \"96\",\"message\": \"A swift response\"}}"
    val errorResponse2 = "{\"user\": {\"userName\": \"taher\",\"firstName\": \"Taher\",\"surName\": \"Ismail\" },\"isSuccess\": False,\"error\": {\"code\": \"96\",\"message\": \"A swift response\"}}"

}