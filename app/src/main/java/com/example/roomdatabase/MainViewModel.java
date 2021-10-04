package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    DBRepo mDBRepo;
    public MainViewModel() {
        mDBRepo = MyAppCreator.getRepoInstance();
    }
    public LiveData<List<EntryDetails>> getAllEntries(){
        return mDBRepo.getAllDetails();
    }


    public void insertData(EntryDetails model) {


            mDBRepo.insertDataToDB(model);

    }
}
