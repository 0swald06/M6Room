package com.example.m6room.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m6room.Model.TextoAdapter
import com.example.m6room.R
import com.example.m6room.ViewModel.TextoViewModel
import com.example.m6room.databinding.ActivityMainBinding
import com.example.m6room.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var mbinding:ActivityMainBinding? = null
    private val viewModel: TextoViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*


                val newTask= Task(

                    title="BD59",
                    descripcion = "PRUEBA 059 20:32",
                    date="20/07/2023",
                    priority = 7,
                    state = true

                )
        */

        //viewModel.inserTask(newTask)


        // referencia al adapter

        val adapter = TextoAdapter()

        binding.recyclerview.adapter=adapter
        binding.recyclerview.layoutManager= LinearLayoutManager(context)

        binding.recyclerview.addItemDecoration(

            DividerItemDecoration(

                context,
                DividerItemDecoration.VERTICAL
            )
        )


        // button para ir y agregar una nueva tarea

        mbinding?.fab?.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

        }






        // cargar las tareas al RecyclerView
        viewModel.allTask.observe( viewLifecycleOwner,{

            it?.let {
                adapter.update(it)
            }
        }
        )

        adapter.selectedItem().observe(viewLifecycleOwner,{

            it?.let {

                viewModel.selected(it)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}