package com.diest.simplenotes.view.listofnodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.diest.simplenotes.databinding.FragmentListNodesBinding
import com.diest.simplenotes.model.note.entity.NoteModel
import com.diest.simplenotes.view.NodesViewModel

class ListOfNodesFragment : Fragment(), NoteClickListener {

    private var _binding: FragmentListNodesBinding? = null

    private val binding get() = _binding!!
    private val vm: NodesViewModel by viewModels()
    var adapter = ListOfNodesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListNodesBinding.inflate(inflater, container, false)

        vm.getAllNote().observe(this.viewLifecycleOwner){
            adapter.setNodes(it)
        }
        adapter.setNodes(vm.getAllNote().value ?: listOf())
        binding.rvNodesList.layoutManager = LinearLayoutManager(this.context)
        binding.rvNodesList.adapter = adapter

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(note: NoteModel) {
        Toast.makeText(this.context, "Click on ${note.text}", Toast.LENGTH_LONG).show()
    }

    override fun onLongClick(note: NoteModel): Boolean {
        //Toast.makeText(this.context, "Loooong click on ${note.text}", Toast.LENGTH_LONG).show()
        vm.removeNote(note)
        return true
    }
}