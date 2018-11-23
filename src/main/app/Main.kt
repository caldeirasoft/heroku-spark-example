package app

import spark.Spark.*

open class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            port(getHerokuAssignedPort())
            get("/hello") { req, res -> "Hello Heroku from Spark" }
        }

        fun getHerokuAssignedPort(): Int {
            val processBuilder = ProcessBuilder()
            processBuilder.environment().get("PORT").let {
                return if (it != null) Integer.parseInt(it) else 7000
            }
        }
    }
}