package erevacation.com.userlist_navigation.ui.homescreen.profile

import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.BasicFragment
import erevacation.com.userlist_navigation.databinding.FragmentProfileBinding

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
        , ProfileContract.ProfileView {

    override fun getLayoutId(): Int = R.layout.fragment_profile

}