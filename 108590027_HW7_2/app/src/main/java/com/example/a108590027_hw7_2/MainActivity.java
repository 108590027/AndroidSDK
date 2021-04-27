package com.example.a108590027_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList_title = new LinkedList<>();
    private final LinkedList<String> mWordList_content = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Put initial data into the word list.
        mWordList_title.addLast(getString(R.string.title1));
        mWordList_content.addLast(getString(R.string.content1));
        mWordList_title.addLast(getString(R.string.title2));
        mWordList_content.addLast(getString(R.string.content2));
        mWordList_title.addLast(getString(R.string.title3));
        mWordList_content.addLast(getString(R.string.content3));
        mWordList_title.addLast(getString(R.string.title4));
        mWordList_content.addLast(getString(R.string.content4));

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, mWordList_title, mWordList_content);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}