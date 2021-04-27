package com.example.a108590027_hw7_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private final LinkedList<String> mTitleList;
    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordTitleView;
        public final TextView wordItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordTitleView = itemView.findViewById(R.id.word_title);
            wordItemView = itemView.findViewById(R.id.word_content);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element_title = mTitleList.get(mPosition);
            String element_content = mWordList.get(mPosition);
            // Change the word in the mWordList.
            //mWordList.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
            Intent intent = new Intent(view.getContext(), MainActivity2.class);
            intent.putExtra("Title", element_title);
            intent.putExtra("Content", element_content);
            view.getContext().startActivity(intent);
        }
    }

    public WordListAdapter(Context context, LinkedList<String> wordList_title, LinkedList<String> wordList_content) {
        mInflater = LayoutInflater.from(context);
        this.mTitleList = wordList_title;
        this.mWordList = wordList_content;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent_title = mTitleList.get(position);
        String mCurrent_content = mWordList.get(position);
        holder.wordTitleView.setText(mCurrent_title);
        holder.wordItemView.setText(mCurrent_content);
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }
}
