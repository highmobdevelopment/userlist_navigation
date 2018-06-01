package erevacation.com.userlist_navigation.ui.homescreen.list

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract
import erevacation.com.userlist_navigation.databinding.FragmentListBinding
import erevacation.com.userlist_navigation.datamodel.ListDM
import erevacation.com.userlist_navigation.ui.homescreen.HomeActivity
import erevacation.com.userlist_navigation.usecase.ListUC
import erevacation.com.userlist_navigation.usecase.ListUCContract
import javax.inject.Inject

class ListFragmentPresenter @Inject constructor(val listUC: ListUC) : ListContract.ListPresenter, ListUCContract.ListUCOut {


    private val listAdapter = ListRecyclerAdapter(this)
    private var view: ListContract.ListView? = null
    private var binding: FragmentListBinding? = null
    private lateinit var fragmentManager: FragmentManager

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ListContract.ListView
        this.binding = (this.view as? ListFragment)?.binding
        this.listUC.setListUCOut(this)
        fragmentManager = (binding?.root?.context as HomeActivity).supportFragmentManager
        listUC.getList()
        buildLayout()
    }

    override fun publishListResults(list: MutableList<ListDM>) {
        listAdapter.updateList(list)
    }

    override fun viewDetach() {
        this.view = null
        listUC.clearRequests()
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    override fun openProfileScreen(name: String, surname: String, image: String, profileInfoList: ArrayList<String>, view: View) {
        val bundle = Bundle()
        bundle.putString(NAME, name)
        bundle.putString(IMAGEURL, image)
        bundle.putString(SURNAME, surname)
        bundle.putStringArrayList(PROFILEINFOLIST, profileInfoList)
        Navigation.createNavigateOnClickListener(R.id.profileFragment, bundle)
        val options = NavOptions.Builder()
                .setEnterAnim(R.animator.right_in)
                .setExitAnim(R.animator.fui_slide_out_left)
                .setPopEnterAnim(R.animator.fui_slide_in_right)
                .setPopExitAnim(R.animator.right_out)
                .build()
        Navigation.findNavController(view).navigate(R.id.profileFragment, bundle, options)
    }

    private fun buildLayout() {
        binding?.listRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.listRecyclerView?.adapter = listAdapter
    }

    companion object {
        val NAME = "name"
        val SURNAME = "surname"
        val IMAGEURL = "image"
        val PROFILEINFOLIST = "profile_info_list"
    }

}