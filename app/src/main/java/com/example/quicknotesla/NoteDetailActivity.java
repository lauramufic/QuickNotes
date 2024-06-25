package com.example.quicknotesla;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoteDetailActivity extends AppCompatActivity {

    private EditText titleEditText, descEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        initWidgets();
    }

    private void initWidgets() {
        titleEditText = findViewById(R.id.titleEditText);
        descEditText = findViewById(R.id.descriptionEditText);
    }

    public void saveNote(View view) {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDataBase(this);
        String title = titleEditText.getText().toString();
        String desc = descEditText.getText().toString();

        if (!title.isEmpty() && !desc.isEmpty()) {
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, title, desc);
            Note.noteArrayList.add(newNote);
            sqLiteManager.addNoteToDatabase(newNote);
            finish();  // Završi aktivnost nakon spremanja bilješke
        } else {
            Toast.makeText(this, "Molimo ispunite oba polja.", Toast.LENGTH_SHORT).show();
        }
    }
}
