package com.antonioleiva.mymovies.ui.main

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.antonioleiva.mymovies.PermissionRequester
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.databinding.FragmentMainBinding
import com.antonioleiva.mymovies.model.server.MoviesRepository
import com.antonioleiva.mymovies.ui.common.EventObserver
import com.antonioleiva.mymovies.ui.common.app
import com.antonioleiva.mymovies.ui.common.bindingInflate
import com.antonioleiva.mymovies.ui.common.getViewModel

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MoviesAdapter
    private val coarsePermissionRequester by lazy {
        PermissionRequester(
            requireActivity(),
            ACCESS_COARSE_LOCATION
        )
    }

    private lateinit var navController: NavController
    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_main, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        viewModel = getViewModel { MainViewModel(MoviesRepository(app)) }

        viewModel.navigateToMovie.observe(viewLifecycleOwner, EventObserver { id ->
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(id)
            navController.navigate(action)
        })

        viewModel.requestLocationPermission.observe(viewLifecycleOwner, EventObserver {
            coarsePermissionRequester.request {
                viewModel.onCoarsePermissionRequested()
            }
        })

        binding?.apply {
            viewmodel = viewModel
            lifecycleOwner = this@MainFragment

            adapter = MoviesAdapter(viewModel::onMovieClicked)
            recycler.adapter = adapter
        }
    }
}