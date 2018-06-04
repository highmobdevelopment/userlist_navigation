package erevacation.com.userlist_navigation.ui.homescreen.profile

import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.BasicFragment
import erevacation.com.userlist_navigation.databinding.FragmentProfileBinding
import erevacation.com.userlist_navigation.ui.homescreen.list.ListFragmentPresenter

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
        , ProfileContract.ProfileView {
    var name: String? = ""
    var surname: String? = ""
    var imageUrl: String? = ""
    var profileListInfo: ArrayList<String>? = arrayListOf()

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onStart() {
        super.onStart()
        name = arguments?.getString(ListFragmentPresenter.NAME)
        surname = arguments?.getString(ListFragmentPresenter.SURNAME)
        imageUrl = arguments?.getString(ListFragmentPresenter.IMAGEURL)
        profileListInfo = arguments?.getStringArrayList(ListFragmentPresenter.PROFILEINFOLIST)
    }
}