package com.diest.simplenotes.view.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.diest.simplenotes.R
import com.diest.simplenotes.databinding.FragmentAddNoteBinding
import com.diest.simplenotes.model.note.entity.NoteModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val model: AddNoteViewModel by viewModels()


        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        binding.btAddNote.setOnClickListener {
            model.addNote(NoteModel(binding.tvNoteTitle.text.toString(), binding.tvNoteText.text.toString())) }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btAddNote.setOnClickListener {

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}