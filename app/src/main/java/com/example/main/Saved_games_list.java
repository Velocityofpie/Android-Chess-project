package com.example.main;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.service.wallpaper.WallpaperService;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import chess.Board;

public class Saved_games_list {


    /*
    if (moved) {
        moves.add(output);
        printButtons(imageButtons, game.newboard);
    }
    output = "";



     */
//    private ListView matchListView;
//    private String[] matches;
//
//    private Button btnSortByDate;
//    private Button btnSortByTitle;
//
//    private boolean noMatches;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.match_list);
//
//        matchListView = (ListView)findViewById(R.id.match_list);
//
//        btnSortByDate = (Button)findViewById(R.id.btnSortByDate);
//
//        btnSortByTitle = (Button)findViewById(R.id.btnSortByTitle);
//
//        updateListView(true);
//
//        btnSortByTitle.setEnabled(false);
//
//        matchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                if(noMatches){
//                    return;
//                }
//
//                Matches(position);
//
//            }});
//
//    }
//
//    public void Matches(int index){
//
//        Bundle bundle = new Bundle();
//        bundle.putInt("Match", index);
//        Intent intent = new Intent(this, watch_game.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
//    }
//
//    private void updateListView(boolean titles){
//        if(titles){
//            matches = Engine.getSortedTitles().toArray(new String[0]);
//        } else {
//            matches = Engine.getSortedDates().toArray(new String[0]);
//        }
//        if(matches.length == 0){
//            matches = getResources().getStringArray(R.array.menu_array);
//            noMatches = true;
//        } else {
//            noMatches = false;
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.menu_item, matches);
//        matchListView.setAdapter(adapter);
//    }
//
//    public void onSortClick(View v){
//        Button clicked = (Button) v;
//        btnSortByTitle.setEnabled(!btnSortByTitle.isEnabled());
//        btnSortByDate.setEnabled(!btnSortByDate.isEnabled());
//        if(clicked == btnSortByDate){
//            updateListView(false);
//        } else {
//            updateListView(true);
//        }
//    }
//

}
