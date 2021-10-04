package com.example.roomdatabase;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DBRepo {

    DaoInterface mDaoInterface; // ise ko property bolte hai
    Application mApplication; // m stands for member variable property banate hai to woska nam m se start hota hai
    // m then woska orignal name.
    Context mContext;

    public DBRepo(Application appInstance,Context context){ // constructor jo class ke nam se same method bani ho.
        mDaoInterface = RoomDB.obtainTheDatabase(context).daoInterface();
        mApplication = appInstance;
        mContext = context;
    }
    LiveData<List<EntryDetails>> getAllDetails(){
        return mDaoInterface.getAllDetails();
    }
    public void insertDataToDB(EntryDetails entryDetails){

        new InsertDataAsyncTask(mContext, mDaoInterface, entryDetails).execute();
    }

    class InsertDataAsyncTask extends AsyncTask<Void, Void, Void> {

        Context mContext;
        DaoInterface mDaoInterface;
        EntryDetails mEntryDetails;

        public InsertDataAsyncTask(Context context,DaoInterface daoInterface, EntryDetails entryDetails) {
            mContext = context;
            mDaoInterface = daoInterface;
            mEntryDetails = entryDetails;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDaoInterface.insertRecordToDB(mEntryDetails);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(mContext, "Data Inserted...", Toast.LENGTH_SHORT).show();
        }
    }
}

