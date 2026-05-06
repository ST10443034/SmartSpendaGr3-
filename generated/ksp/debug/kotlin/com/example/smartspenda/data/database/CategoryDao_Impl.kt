package com.example.smartspenda.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.smartspenda.`data`.entities.Category
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class CategoryDao_Impl(
  __db: RoomDatabase,
) : CategoryDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfCategory: EntityInsertAdapter<Category>

  private val __deleteAdapterOfCategory: EntityDeleteOrUpdateAdapter<Category>

  private val __updateAdapterOfCategory: EntityDeleteOrUpdateAdapter<Category>
  init {
    this.__db = __db
    this.__insertAdapterOfCategory = object : EntityInsertAdapter<Category>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `categories` (`categoryId`,`userId`,`name`,`iconRes`,`color`) VALUES (nullif(?, 0),?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Category) {
        statement.bindLong(1, entity.categoryId)
        statement.bindLong(2, entity.userId)
        statement.bindText(3, entity.name)
        statement.bindLong(4, entity.iconRes.toLong())
        statement.bindText(5, entity.color)
      }
    }
    this.__deleteAdapterOfCategory = object : EntityDeleteOrUpdateAdapter<Category>() {
      protected override fun createQuery(): String = "DELETE FROM `categories` WHERE `categoryId` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Category) {
        statement.bindLong(1, entity.categoryId)
      }
    }
    this.__updateAdapterOfCategory = object : EntityDeleteOrUpdateAdapter<Category>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `categories` SET `categoryId` = ?,`userId` = ?,`name` = ?,`iconRes` = ?,`color` = ? WHERE `categoryId` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Category) {
        statement.bindLong(1, entity.categoryId)
        statement.bindLong(2, entity.userId)
        statement.bindText(3, entity.name)
        statement.bindLong(4, entity.iconRes.toLong())
        statement.bindText(5, entity.color)
        statement.bindLong(6, entity.categoryId)
      }
    }
  }

  public override suspend fun insertCategory(category: Category): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfCategory.insert(_connection, category)
  }

  public override suspend fun deleteCategory(category: Category): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfCategory.handle(_connection, category)
  }

  public override suspend fun updateCategory(category: Category): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfCategory.handle(_connection, category)
  }

  public override suspend fun getCategoriesForUser(userId: Long): List<Category> {
    val _sql: String = "SELECT * FROM categories WHERE userId = ? ORDER BY name"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfIconRes: Int = getColumnIndexOrThrow(_stmt, "iconRes")
        val _columnIndexOfColor: Int = getColumnIndexOrThrow(_stmt, "color")
        val _result: MutableList<Category> = mutableListOf()
        while (_stmt.step()) {
          val _item: Category
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpUserId: Long
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpIconRes: Int
          _tmpIconRes = _stmt.getLong(_columnIndexOfIconRes).toInt()
          val _tmpColor: String
          _tmpColor = _stmt.getText(_columnIndexOfColor)
          _item = Category(_tmpCategoryId,_tmpUserId,_tmpName,_tmpIconRes,_tmpColor)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
