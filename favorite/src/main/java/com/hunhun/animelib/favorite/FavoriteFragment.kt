package com.hunhun.animelib.favorite

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.hunhun.animelib.core.ui.AnimeAdapter
import com.hunhun.animelib.core.utils.RvItemDecoration
import com.hunhun.animelib.databinding.FragmentFavoriteBinding
import com.hunhun.animelib.detail.AnimeDetailActivity
import com.hunhun.animelib.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels {
        factory
    }

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
    }

    private fun initData() {
        // Check the screen size and set the span count accordingly
        if (activity != null) {
            val spanCount = if (resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE) 4 else 3
            val gridLayoutManager = GridLayoutManager(activity, spanCount)
            val animeAdapter = AnimeAdapter()
            animeAdapter.onItemClick = { anime ->
                val intent = Intent(activity, AnimeDetailActivity::class.java)
                intent.putExtra(AnimeDetailActivity.EXTRA_ANIME, anime)
                startActivity(intent)
            }

            with(binding.animeRV) {
                layoutManager = gridLayoutManager
                adapter = animeAdapter
                setHasFixedSize(true)
                addItemDecoration(
                    RvItemDecoration(
                        spanCount,
                        16,
                        16,
                        false
                    )
                )
            }

            viewModel.favoriteAnime.observe(viewLifecycleOwner) { animeList ->
                animeAdapter.setData(animeList)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteComponent.builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context.applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}