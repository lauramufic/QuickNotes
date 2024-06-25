package com.example.quicknotesla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView noteListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        loadFromDBToMemory();
        setNoteAdapter();
    }

    private void loadFromDBToMemory() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDataBase(this);
        Note.noteArrayList.clear();  // Očisti listu prije populacije
        sqLiteManager.populateNoteListArray();
    }

    private void setNoteAdapter() {
        NoteAdapter noteAdapter = new NoteAdapter(getApplicationContext(), Note.noteArrayList);
        noteListView.setAdapter(noteAdapter);
    }

    private void initWidgets() {
        noteListView = findViewById(R.id.noteListView);
    }

    public void newNote(View view) {
        Intent newNoteIntent = new Intent(this, NoteDetailActivity.class);
        startActivity(newNoteIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFromDBToMemory();  // Ponovno učitavanje bilješki nakon povratka u glavnu aktivnost
        setNoteAdapter();      // Osvježavanje adaptera kako bi prikazao nove bilješke
    }
}
