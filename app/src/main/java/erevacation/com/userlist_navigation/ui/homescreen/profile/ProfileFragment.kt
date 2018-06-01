package erevacation.com.userlist_navigation.ui.homescreen.profile

import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.BasicFragment
import erevacation.com.userlist_navigation.databinding.FragmentProfileBinding

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
        , ProfileContract.ProfileView {
    var name: String? = ""
    var surname: String? = ""
    var imageUrl: String? = ""
    var profileListInfo: ArrayList<String>? = arrayListOf()

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onStart() {
        super.onStart()
        name = arguments?.getString(NAME)
        surname = arguments?.getString(SURNAME)
        imageUrl = arguments?.getString(IMAGEURL)
        profileListInfo = arguments?.getStringArrayList(PROFILEINFOLIST)
    }

    companion object {
        val NAME = "name"
        val SURNAME = "surname"
        val IMAGEURL = "image"
        val PROFILEINFOLIST = "profile_info_list"
    }
}