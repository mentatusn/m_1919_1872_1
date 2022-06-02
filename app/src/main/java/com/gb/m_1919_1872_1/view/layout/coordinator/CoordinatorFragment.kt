package com.gb.m_1919_1872_1.view.layout.coordinator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.gb.m_1919_1872_1.databinding.FragmentCoordinatorBinding
import com.gb.m_1919_1872_1.view.layout.coordinator.behavior.ButtonBehavior


class CoordinatorFragment : Fragment() {


    private var _binding: FragmentCoordinatorBinding? = null
    private val binding: FragmentCoordinatorBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val params = (binding.button.layoutParams as CoordinatorLayout.LayoutParams)
        params.behavior = ButtonBehavior(requireContext())
        binding.button.layoutParams = params
    }


    companion object {
        @JvmStatic
        fun newInstance() = CoordinatorFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}