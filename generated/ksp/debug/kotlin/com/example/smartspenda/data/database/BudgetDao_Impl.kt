package com.example.smartspenda.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.smartspenda.`data`.entities.Budget
import javax.`annotation`.processing.Generated
import kotlin.Double
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
public class BudgetDao_Impl(
  __db: RoomDatabase,
) : BudgetDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfBudget: EntityInsertAdapter<Budget>

  private val __updateAdapterOfBudget: EntityDeleteOrUpdateAdapter<Budget>
  init {
    this.__db = __db
    this.__insertAdapterOfBudget = object : EntityInsertAdapter<Budget>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `budgets` (`budgetId`,`userId`,`month`,`year`,`categoryId`,`maxAmount`,`minAmount`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Budget) {
        statement.bindLong(1, entity.budgetId)
        statement.bindLong(2, entity.userId)
        statement.bindLong(3, entity.month.toLong())
        statement.bindLong(4, entity.year.toLong())
        val _tmpCategoryId: Long? = entity.categoryId
        if (_tmpCategoryId == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpCategoryId)
        }
        statement.bindDouble(6, entity.maxAmount)
        statement.bindDouble(7, entity.minAmount)
      }
    }
    this.__updateAdapterOfBudget = object : EntityDeleteOrUpdateAdapter<Budget>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `budgets` SET `budgetId` = ?,`userId` = ?,`month` = ?,`year` = ?,`categoryId` = ?,`maxAmount` = ?,`minAmount` = ? WHERE `budgetId` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Budget) {
        statement.bindLong(1, entity.budgetId)
        statement.bindLong(2, entity.userId)
        statement.bindLong(3, entity.month.toLong())
        statement.bindLong(4, entity.year.toLong())
        val _tmpCategoryId: Long? = entity.categoryId
        if (_tmpCategoryId == null) {
          statement.bindNull(5)
        } else {
          statement.bindLong(5, _tmpCategoryId)
        }
        statement.bindDouble(6, entity.maxAmount)
        statement.bindDouble(7, entity.minAmount)
        statement.bindLong(8, entity.budgetId)
      }
    }
  }

  public override suspend fun insertBudget(budget: Budget): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfBudget.insert(_connection, budget)
  }

  public override suspend fun updateBudget(budget: Budget): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfBudget.handle(_connection, budget)
  }

  public override suspend fun getTotalMonthlyBudget(
    userId: Long,
    month: Int,
    year: Int,
  ): Budget? {
    val _sql: String = "SELECT * FROM budgets WHERE userId = ? AND month = ? AND year = ? AND categoryId IS NULL"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        _argIndex = 2
        _stmt.bindLong(_argIndex, month.toLong())
        _argIndex = 3
        _stmt.bindLong(_argIndex, year.toLong())
        val _columnIndexOfBudgetId: Int = getColumnIndexOrThrow(_stmt, "budgetId")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfMonth: Int = getColumnIndexOrThrow(_stmt, "month")
        val _columnIndexOfYear: Int = getColumnIndexOrThrow(_stmt, "year")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfMaxAmount: Int = getColumnIndexOrThrow(_stmt, "maxAmount")
        val _columnIndexOfMinAmount: Int = getColumnIndexOrThrow(_stmt, "minAmount")
        val _result: Budget?
        if (_stmt.step()) {
          val _tmpBudgetId: Long
          _tmpBudgetId = _stmt.getLong(_columnIndexOfBudgetId)
          val _tmpUserId: Long
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId)
          val _tmpMonth: Int
          _tmpMonth = _stmt.getLong(_columnIndexOfMonth).toInt()
          val _tmpYear: Int
          _tmpYear = _stmt.getLong(_columnIndexOfYear).toInt()
          val _tmpCategoryId: Long?
          if (_stmt.isNull(_columnIndexOfCategoryId)) {
            _tmpCategoryId = null
          } else {
            _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          }
          val _tmpMaxAmount: Double
          _tmpMaxAmount = _stmt.getDouble(_columnIndexOfMaxAmount)
          val _tmpMinAmount: Double
          _tmpMinAmount = _stmt.getDouble(_columnIndexOfMinAmount)
          _result = Budget(_tmpBudgetId,_tmpUserId,_tmpMonth,_tmpYear,_tmpCategoryId,_tmpMaxAmount,_tmpMinAmount)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getCategoryBudget(
    userId: Long,
    month: Int,
    year: Int,
    categoryId: Long,
  ): Budget? {
    val _sql: String = "SELECT * FROM budgets WHERE userId = ? AND month = ? AND year = ? AND categoryId = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        _argIndex = 2
        _stmt.bindLong(_argIndex, month.toLong())
        _argIndex = 3
        _stmt.bindLong(_argIndex, year.toLong())
        _argIndex = 4
        _stmt.bindLong(_argIndex, categoryId)
        val _columnIndexOfBudgetId: Int = getColumnIndexOrThrow(_stmt, "budgetId")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfMonth: Int = getColumnIndexOrThrow(_stmt, "month")
        val _columnIndexOfYear: Int = getColumnIndexOrThrow(_stmt, "year")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfMaxAmount: Int = getColumnIndexOrThrow(_stmt, "maxAmount")
        val _columnIndexOfMinAmount: Int = getColumnIndexOrThrow(_stmt, "minAmount")
        val _result: Budget?
        if (_stmt.step()) {
          val _tmpBudgetId: Long
          _tmpBudgetId = _stmt.getLong(_columnIndexOfBudgetId)
          val _tmpUserId: Long
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId)
          val _tmpMonth: Int
          _tmpMonth = _stmt.getLong(_columnIndexOfMonth).toInt()
          val _tmpYear: Int
          _tmpYear = _stmt.getLong(_columnIndexOfYear).toInt()
          val _tmpCategoryId: Long?
          if (_stmt.isNull(_columnIndexOfCategoryId)) {
            _tmpCategoryId = null
          } else {
            _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          }
          val _tmpMaxAmount: Double
          _tmpMaxAmount = _stmt.getDouble(_columnIndexOfMaxAmount)
          val _tmpMinAmount: Double
          _tmpMinAmount = _stmt.getDouble(_columnIndexOfMinAmount)
          _result = Budget(_tmpBudgetId,_tmpUserId,_tmpMonth,_tmpYear,_tmpCategoryId,_tmpMaxAmount,_tmpMinAmount)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAllBudgetsForMonth(
    userId: Long,
    month: Int,
    year: Int,
  ): List<Budget> {
    val _sql: String = "SELECT * FROM budgets WHERE userId = ? AND month = ? AND year = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        _argIndex = 2
        _stmt.bindLong(_argIndex, month.toLong())
        _argIndex = 3
        _stmt.bindLong(_argIndex, year.toLong())
        val _columnIndexOfBudgetId: Int = getColumnIndexOrThrow(_stmt, "budgetId")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfMonth: Int = getColumnIndexOrThrow(_stmt, "month")
        val _columnIndexOfYear: Int = getColumnIndexOrThrow(_stmt, "year")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfMaxAmount: Int = getColumnIndexOrThrow(_stmt, "maxAmount")
        val _columnIndexOfMinAmount: Int = getColumnIndexOrThrow(_stmt, "minAmount")
        val _result: MutableList<Budget> = mutableListOf()
        while (_stmt.step()) {
          val _item: Budget
          val _tmpBudgetId: Long
          _tmpBudgetId = _stmt.getLong(_columnIndexOfBudgetId)
          val _tmpUserId: Long
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId)
          val _tmpMonth: Int
          _tmpMonth = _stmt.getLong(_columnIndexOfMonth).toInt()
          val _tmpYear: Int
          _tmpYear = _stmt.getLong(_columnIndexOfYear).toInt()
          val _tmpCategoryId: Long?
          if (_stmt.isNull(_columnIndexOfCategoryId)) {
            _tmpCategoryId = null
          } else {
            _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          }
          val _tmpMaxAmount: Double
          _tmpMaxAmount = _stmt.getDouble(_columnIndexOfMaxAmount)
          val _tmpMinAmount: Double
          _tmpMinAmount = _stmt.getDouble(_columnIndexOfMinAmount)
          _item = Budget(_tmpBudgetId,_tmpUserId,_tmpMonth,_tmpYear,_tmpCategoryId,_tmpMaxAmount,_tmpMinAmount)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getCategoryBudgetsForMonth(
    userId: Long,
    month: Int,
    year: Int,
  ): List<Budget> {
    val _sql: String = "SELECT * FROM budgets WHERE userId = ? AND month = ? AND year = ? AND categoryId IS NOT NULL"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        _argIndex = 2
        _stmt.bindLong(_argIndex, month.toLong())
        _argIndex = 3
        _stmt.bindLong(_argIndex, year.toLong())
        val _columnIndexOfBudgetId: Int = getColumnIndexOrThrow(_stmt, "budgetId")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfMonth: Int = getColumnIndexOrThrow(_stmt, "month")
        val _columnIndexOfYear: Int = getColumnIndexOrThrow(_stmt, "year")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfMaxAmount: Int = getColumnIndexOrThrow(_stmt, "maxAmount")
        val _columnIndexOfMinAmount: Int = getColumnIndexOrThrow(_stmt, "minAmount")
        val _result: MutableList<Budget> = mutableListOf()
        while (_stmt.step()) {
          val _item: Budget
          val _tmpBudgetId: Long
          _tmpBudgetId = _stmt.getLong(_columnIndexOfBudgetId)
          val _tmpUserId: Long
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId)
          val _tmpMonth: Int
          _tmpMonth = _stmt.getLong(_columnIndexOfMonth).toInt()
          val _tmpYear: Int
          _tmpYear = _stmt.getLong(_columnIndexOfYear).toInt()
          val _tmpCategoryId: Long?
          if (_stmt.isNull(_columnIndexOfCategoryId)) {
            _tmpCategoryId = null
          } else {
            _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          }
          val _tmpMaxAmount: Double
          _tmpMaxAmount = _stmt.getDouble(_columnIndexOfMaxAmount)
          val _tmpMinAmount: Double
          _tmpMinAmount = _stmt.getDouble(_columnIndexOfMinAmount)
          _item = Budget(_tmpBudgetId,_tmpUserId,_tmpMonth,_tmpYear,_tmpCategoryId,_tmpMaxAmount,_tmpMinAmount)
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
