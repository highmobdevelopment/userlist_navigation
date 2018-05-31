package erevacation.com.userlist_navigation.datamanager

import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract
import erevacation.com.userlist_navigation.datamodel.ListDM
import io.reactivex.Observable

interface ListDataManagerContract : ViperContract.DataManager {

    fun getList(): Observable<MutableList<ListDM>>
}