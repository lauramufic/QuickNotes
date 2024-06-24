package com.example.quicknotesla;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    private void initWidgets()
    {
        titleEditText = findViewById(R.id.titleEditText);
        descEditText = findViewById(R.id.descriptionEditText);
    }

    public void saveNote(View view)
    {
        String title = String.valueOf(titleEditText.getText());
        String desc = String.valueOf(descEditText.getText());

        int id = Note.noteArrayList.size();
        Note newNote = new Note(id, title, desc);
        Note.noteArrayList.add(newNote);
        finish();
    }

}