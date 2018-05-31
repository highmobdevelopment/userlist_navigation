package erevacation.com.userlist_navigation.usecase

import erevacation.com.userlist_navigation.datamodel.ListDM

interface ListUCContract {
    fun getList()
    fun setListUCOut(ListUCOut: ListUCOut)
    fun clearRequests()
    interface ListUCOut {
        fun publishListResults(list: MutableList<ListDM>)
    }
}