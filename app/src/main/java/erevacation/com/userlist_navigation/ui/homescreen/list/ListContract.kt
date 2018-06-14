package erevacation.com.userlist_navigation.ui.homescreen.list

import android.view.View
import erevacation.com.userlist_navigation.basic.arhitecture.ViperContract

interface ListContract {
    interface ListView : ViperContract.View<ListPresenter> {

    }

    interface ListPresenter : ViperContract.Presenter {

    }
}