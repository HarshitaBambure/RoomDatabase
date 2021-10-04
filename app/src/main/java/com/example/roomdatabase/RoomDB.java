package com.example.roomdatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EntryDetails.class},//tables yaha add krte hai jo project me use krna hai.
        version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract DaoInterface daoInterface (); //jo table ki operations rahenge(CRUD)
    // wo ise file me rahenge.table wise dao alag alag rehte hai.
    public static volatile RoomDB mRoomDB;
    public static RoomDB obtainTheDatabase(final Context context) {// context matlab kiske base pe databse banrai hai.
        if(mRoomDB==null) {
            synchronized (RoomDB.class) {
                if(mRoomDB==null) {
                    mRoomDB= Room.databaseBuilder(context, RoomDB.class, "Details_System")
                            .build();
                }
            }
        }
        return mRoomDB;
    }
}
