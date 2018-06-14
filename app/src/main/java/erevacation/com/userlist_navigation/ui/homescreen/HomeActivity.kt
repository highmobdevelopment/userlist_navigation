package erevacation.com.userlist_navigation.ui.homescreen

import androidx.navigation.findNavController
import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.BasicActivity
import erevacation.com.userlist_navigation.databinding.ActivityHomeBinding


class HomeActivity : BasicActivity<HomeContract.HomePresenter, ActivityHomeBinding>(), HomeContract.HomeView {
    private val TAG: String = HomeActivity::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun onSupportNavigateUp()
            = findNavController(R.id.my_nav_host_fragment).navigateUp()

}