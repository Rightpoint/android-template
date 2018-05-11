package {{ cookiecutter.package_name }}.cache.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import {{ cookiecutter.package_name }}.cache.room.model.ToBeDeleted

@Database(entities = [
    ToBeDeleted::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
}