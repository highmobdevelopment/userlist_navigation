package erevacation.com.userlist_navigation.basic.arhitecture


import android.content.Context
import android.support.v4.content.Loader

class ViperPresenterLoader<P : ViperContract.Presenter>(context: Context) : Loader<P>(context) {
    var presenter: P? = null


    override fun onStartLoading() {
        deliverResult(presenter)
    }

    override fun onForceLoad() {
        deliverResult(presenter)
    }

    override fun onReset() {
        presenter?.onDestroyed()
        presenter = null
    }
}