package erevacation.com.userlist_navigation.ui.homescreen.profile

import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract
import erevacation.com.userlist_navigation.databinding.FragmentProfileBinding
import erevacation.com.userlist_navigation.usecase.ListUC
import javax.inject.Inject

class ProfileFragmentPresenter @Inject constructor(val listUC: ListUC) : ProfileContract.ProfilePresenter {

    private var view: ProfileContract.ProfileView? = null
    private var binding: FragmentProfileBinding? = null
    private val profileAdapter = ProfileRecyclerAdapter(this)

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ProfileContract.ProfileView
        this.binding = (this.view as?ProfileFragment)?.binding
        view as ProfileFragment
        setUserNameAndImage(view.name ?: ""
                , view.surname ?: ""
                , view.imageUrl ?: ""
                , view.profileListInfo ?: arrayListOf())
        binding?.profileRecyclerView?.bringToFront()
        buildLayout()

    }

    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    private fun setUserNameAndImage(name: String, surname: String, image: String, profileInfoList: ArrayList<String>) {
        val fullName: String = "$name $surname"
        binding?.name?.text = fullName
        binding!!.profileImage.let { Glide.with(binding!!.root.context).load(image).apply(RequestOptions.circleCropTransform()).into(it) }
        profileAdapter.updateUserDetails(profileInfoList)
    }

    private fun buildLayout() {
        binding?.profileRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.profileRecyclerView?.adapter = profileAdapter
    }

}