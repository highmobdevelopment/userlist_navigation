package erevacation.com.userlist_navigation.ui.homescreen.list

import erevacation.com.userlist_navigation.R
import erevacation.com.userlist_navigation.basic.BasicFragment
import erevacation.com.userlist_navigation.databinding.FragmentListBinding

class ListFragment : BasicFragment<ListContract.ListPresenter, FragmentListBinding>(), ListContract.ListView {

    override fun getLayoutId(): Int = R.layout.fragment_list

}