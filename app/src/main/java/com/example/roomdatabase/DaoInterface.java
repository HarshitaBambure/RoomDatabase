package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoInterface {
    @Query("select * from EntryDetails")
    LiveData<List<EntryDetails>> getAllDetails();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRecordToDB(EntryDetails entryDetails);


}
