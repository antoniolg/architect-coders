package com.antonioleiva.mymovies.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.databinding.FragmentDetailBinding
import com.antonioleiva.mymovies.model.server.MoviesRepository
import com.antonioleiva.mymovies.ui.common.app
import com.antonioleiva.mymovies.ui.common.bindingInflate
import com.antonioleiva.mymovies.ui.common.getViewModel

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private var binding: FragmentDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_detail, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel {
            DetailViewModel(args.id, MoviesRepository(app))
        }

        binding?.apply {
            viewmodel = viewModel
            lifecycleOwner = this@DetailFragment
        }
    }
}
