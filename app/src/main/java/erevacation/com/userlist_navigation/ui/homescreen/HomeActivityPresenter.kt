package erevacation.com.userlist_navigation.ui.homescreen

import android.app.Activity
import android.app.FragmentManager
import android.content.res.Resources
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract
import erevacation.com.userlist_navigation.databinding.ActivityHomeBinding
import erevacation.com.userlist_navigation.ui.homescreen.list.ListFragment
import javax.inject.Inject

class HomeActivityPresenter @Inject constructor() : HomeContract.HomePresenter {


    private val TAG: String = "HomeActivityPresenter"
    private var view: HomeContract.HomeView? = null
    private var binding: ActivityHomeBinding? = null
    private lateinit var fragmentManager: FragmentManager

    // overrides that every presenter have
    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as HomeContract.HomeView
        this.binding = (this.view as? HomeActivity)?.binding
        fragmentManager = (this.view as HomeActivity).fragmentManager
        buildLayout()
    }

    override fun viewDetach() {
        this.view = null
        this.binding = null
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    override fun buildLayout() {
        val host: NavHostFragment = fragmentManager
                .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController

        setupBottomNavMenu(navController)

        navController.addOnNavigatedListener { _, destination ->
            val dest: String = try {
                binding!!.root.context.resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }
        }
    }


    private fun setupBottomNavMenu(navController: NavController) {
        binding?.bottomNavView?.let { bottomNavView ->
            NavigationUI.setupWithNavController(bottomNavView, navController)
        }
    }

}