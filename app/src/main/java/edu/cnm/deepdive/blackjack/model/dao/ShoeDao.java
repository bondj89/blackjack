package edu.cnm.deepdive.blackjack.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.blackjack.model.entity.Shoe;
import java.util.Collection;
import java.util.List;

@Dao
public interface ShoeDao {

  @Insert
  long insert(Shoe shoe);      // this returns the shoe Id from the database.

  @Insert
  long[] insert(Shoe...shoes);     // ... compiler turns this into an array

  @Insert
  List<Long> insert(Collection<Shoe> shoes);      // list are only object not primitives

  @Query("SELECT * FROM Shoe ORDER BY shoe_id ASC") // ASC ascending
  LiveData<List<Shoe>> getAll();

  @Query("SELECT * FROM Shoe WHERE shoe_id = :shoeId")
  LiveData<Shoe> getById(long shoeId);


  @Update
  int update(Shoe...shoes);

  @Delete
  int delete(Shoe...shoe);




}
