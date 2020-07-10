package com.example.watchlist.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.watchlist.R
import com.example.watchlist.SharedPrefs
import com.example.watchlist.databinding.FragmentLoginBinding
import com.example.watchlist.verifyPassword
import com.example.watchlist.verifyUsername

class LoginFragment : Fragment() {

    private lateinit var  binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        binding.login.setOnClickListener { login() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (SharedPrefs.status()) {
            this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMovieListFragment())
        }
    }

    fun login() {
        if (!verifyUsername(binding.usernameText.toString())) {
            binding.usernameText.setError("Username characters must be greater 5")

            if (!verifyPassword(binding.passwordEditText.toString())) {
                binding.passwordEditText.setError("Password characters must be greater 5")
            }
        }
        else {
            SharedPrefs.saveLoginStatus(true)
            this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMovieListFragment())
        }

    }
}