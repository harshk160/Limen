package io.github.harshk160.limen.data.source.local

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import io.github.harshk160.limen.util.Constants

class DatabaseProviderImpl(private val context: Context) : DatabaseProvider {
    override fun provideAppDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(Constants.LOCAL_DB_STORAGE_NAME)
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath,
        ).setDriver(BundledSQLiteDriver())
    }
}
