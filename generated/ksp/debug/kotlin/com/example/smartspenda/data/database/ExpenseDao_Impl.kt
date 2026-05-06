package com.example.smartspenda.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.smartspenda.`data`.entities.Expense
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
public class ExpenseDao_Impl(
  __db: RoomDatabase,
) : ExpenseDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfExpense: EntityInsertAdapter<Expense>

  private val __deleteAdapterOfExpense: EntityDeleteOrUpdateAdapter<Expense>

  private val __updateAdapterOfExpense: EntityDeleteOrUpdateAdapter<Expense>
  init {
    this.__db = __db
    this.__insertAdapterOfExpense = object : EntityInsertAdapter<Expense>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `expenses` (`expenseId`,`userId`,`categoryId`,`amount`,`date`,`startTime`,`endTime`,`description`,`receiptPath`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Expense) {
        statement.bindLong(1, entity.expenseId)
        statement.bindLong(2, entity.userId)
        statement.bindLong(3, entity.categoryId)
        statement.bindDouble(4, entity.amount)
        statement.bindLong(5, entity.date)
        val _tmpStartTime: Long? = entity.startTime
        if (_tmpStartTime == null) {
          statement.bindNull(6)
        } else {
          statement.bindLong(6, _tmpStartTime)
        }
        val _tmpEndTime: Long? = entity.endTime
        if (_tmpEndTime == null) {
          statement.bindNull(7)
        } else {
          statement.bindLong(7, _tmpEndTime)
        }
        statement.bindText(8, entity.description)
        val _tmpReceiptPath: String? = entity.receiptPath
        if (_tmpReceiptPath == null) {
          statement.bindNull(9)
        } else {
          statement.bindText(9, _tmpReceiptPath)
        }
      }
    }
    this.__deleteAdapterOfExpense = object : EntityDeleteOrUpdateAdapter<Expense>() {
      protected override fun createQuery(): String = "DELETE FROM `expenses` WHERE `expenseId` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Expense) {
        statement.bindLong(1, entity.expenseId)
      }
    }
    this.__updateAdapterOfExpense = object : EntityDeleteOrUpdateAdapter<Expense>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `expenses` SET `expenseId` = ?,`userId` = ?,`categoryId` = ?,`amount` = ?,`date` = ?,`startTime` = ?,`endTime` = ?,`description` = ?,`receiptPath` = ? WHERE `expenseId` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Expense) {
        statement.bindLong(1, entity.expenseId)
        statement.bindLong(2, entity.userId)
        statement.bindLong(3, entity.categoryId)
        statement.bindDouble(4, entity.amount)
        statement.bindLong(5, entity.date)
        val _tmpStartTime: Long? = entity.startTime
        if (_tmpStartTime == null) {
          statement.bindNull(6)
        } else {
          statement.bindLong(6, _tmpStartTime)
        }
        val _tmpEndTime: Long? = entity.endTime
        if (_tmpEndTime == null) {
          statement.bindNull(7)
        } else {
          statement.bindLong(7, _tmpEndTime)
        }
        statement.bindText(8, entity.description)
        val _tmpReceiptPath: String? = entity.receiptPath
        if (_tmpReceiptPath == null) {
          statement.bindNull(9)
        } else {
          statement.bindText(9, _tmpReceiptPath)
        }
        statement.bindLong(10, entity.expenseId)
      }
    }
  }

  public override suspend fun insertExpense(expense: Expense): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfExpense.insert(_connection, expense)
  }

  public override suspend fun deleteExpense(expense: Expense): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfExpense.handle(_connection, expense)
  }

  public override suspend fun updateExpense(expense: Expense): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfExpense.handle(_connection, expense)
  }

  public override suspend fun getExpensesBetween(
    userId: Long,
    startDate: Long,
    endDate: Long,
  ): List<Expense> {
    val _sql: String = "SELECT * FROM expenses WHERE userId = ? AND date BETWEEN ? AND ? ORDER BY date DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        _argIndex = 2
        _stmt.bindLong(_argIndex, startDate)
        _argIndex = 3
        _stmt.bindLong(_argIndex, endDate)
        val _columnIndexOfExpenseId: Int = getColumnIndexOrThrow(_stmt, "expenseId")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfCategoryId: Int = getColumnIndexOrThrow(_stmt, "categoryId")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfStartTime: Int = getColumnIndexOrThrow(_stmt, "startTime")
        val _columnIndexOfEndTime: Int = getColumnIndexOrThrow(_stmt, "endTime")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfReceiptPath: Int = getColumnIndexOrThrow(_stmt, "receiptPath")
        val _result: MutableList<Expense> = mutableListOf()
        while (_stmt.step()) {
          val _item: Expense
          val _tmpExpenseId: Long
          _tmpExpenseId = _stmt.getLong(_columnIndexOfExpenseId)
          val _tmpUserId: Long
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId)
          val _tmpCategoryId: Long
          _tmpCategoryId = _stmt.getLong(_columnIndexOfCategoryId)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpStartTime: Long?
          if (_stmt.isNull(_columnIndexOfStartTime)) {
            _tmpStartTime = null
          } else {
            _tmpStartTime = _stmt.getLong(_columnIndexOfStartTime)
          }
          val _tmpEndTime: Long?
          if (_stmt.isNull(_columnIndexOfEndTime)) {
            _tmpEndTime = null
          } else {
            _tmpEndTime = _stmt.getLong(_columnIndexOfEndTime)
          }
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpReceiptPath: String?
          if (_stmt.isNull(_columnIndexOfReceiptPath)) {
            _tmpReceiptPath = null
          } else {
            _tmpReceiptPath = _stmt.getText(_columnIndexOfReceiptPath)
          }
          _item = Expense(_tmpExpenseId,_tmpUserId,_tmpCategoryId,_tmpAmount,_tmpDate,_tmpStartTime,_tmpEndTime,_tmpDescription,_tmpReceiptPath)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getTotalSpentForCategory(
    userId: Long,
    categoryId: Long,
    startDate: Long,
    endDate: Long,
  ): Double? {
    val _sql: String = "SELECT SUM(amount) FROM expenses WHERE userId = ? AND categoryId = ? AND date BETWEEN ? AND ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId)
        _argIndex = 2
        _stmt.bindLong(_argIndex, categoryId)
        _argIndex = 3
        _stmt.bindLong(_argIndex, startDate)
        _argIndex = 4
        _stmt.bindLong(_argIndex, endDate)
        val _result: Double?
        if (_stmt.step()) {
          val _tmp: Double?
          if (_stmt.isNull(0)) {
            _tmp = null
          } else {
            _tmp = _stmt.getDouble(0)
          }
          _result = _tmp
        } else {
          _result = null
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
