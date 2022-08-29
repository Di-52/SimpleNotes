package com.diest.simplenotes.view.editnote

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.diest.simplenotes.R
import com.diest.simplenotes.databinding.FragmentEditNoteBinding
import com.diest.simplenotes.model.note.entity.NoteModel
import com.diest.simplenotes.view.NodesViewModel

class EditNoteFragment (): Fragment() {

    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!
    private val vm: NodesViewModel by viewModels()
    private lateinit var note: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        note = getNoteFromBundle()
        binding.tvNoteTitle.setText(note.title)
        binding.tvNoteText.setText(note.text)
        binding.btDeleteNote.setOnClickListener { vm.removeNote(note = note)
        findNavController().navigate(R.id.action_editNoteFragment_to_FirstFragment)}
        binding.btSaveNote.setOnClickListener {
            vm.updateNote(id = note.id,
                title = binding.tvNoteTitle.text.toString(),
                text = binding.tvNoteText.text.toString())
            findNavController().navigate(R.id.action_editNoteFragment_to_FirstFragment)}
        return binding.root
    }

    private fun getNoteFromBundle(): NoteModel =
        NoteModel(id = arguments?.getInt("KEY_NOTE_ID", 0),
            title = arguments?.getString("KEY_NOTE_TITLE","def_title")?: "no title",
            text = arguments?.getString("KEY_NOTE_TEXT","def_text"))

}