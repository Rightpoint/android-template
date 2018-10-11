package {{ cookiecutter.package_name }}.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import {{ cookiecutter.package_name }}.cache.room.model.ToBeDeleted

@Database(entities = [
    ToBeDeleted::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
}