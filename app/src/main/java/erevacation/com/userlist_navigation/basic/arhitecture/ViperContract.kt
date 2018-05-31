package erevacation.com.userlist_navigation.basic.arhitecture

import android.support.v4.app.LoaderManager

interface ViperContract {
    interface View<P : Presenter> : LoaderManager.LoaderCallbacks<P>

    interface Presenter {
        fun viewAttach(view: View<*>)

        fun viewDetach()

        fun onDestroyed()
    }

    interface UseCase

    interface DataManager
}