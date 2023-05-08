package com.example.plugins

import com.example.models.Cygnns
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
        val connectionString = System.getenv("DATABASE_CONNECTION_STRING")
        val sqlUser = System.getenv("SQL_USER")
        val sqlPassword = System.getenv("SQL_PASSWORD")

        val database = Database.connect(connectionString, driver = driverClassName, user = sqlUser, sqlPassword)

        transaction(database) {
            SchemaUtils.create(Cygnns)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
