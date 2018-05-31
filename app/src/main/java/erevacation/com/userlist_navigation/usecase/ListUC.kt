package erevacation.com.userlist_navigation.usecase

import erevacation.com.userlist_navigation.datamanager.ListDataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListUC @Inject constructor(val listDManager: ListDataManager) : ListUCContract {


    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val TAG: String = ListUC::class.java.simpleName

    private var listUCOut: ListUCContract.ListUCOut? = null
    private val subscribeOn = Schedulers.io()
    private val observeOn = AndroidSchedulers.mainThread()

    override fun setListUCOut(ListUCOut: ListUCContract.ListUCOut) {
        this.listUCOut = ListUCOut
    }

    override fun getList() {
        compositeDisposable.add(listDManager.getList()
                .subscribeOn(subscribeOn)
                .observeOn(observeOn)
                .doOnComplete { }
                .subscribe({ res ->
                    listUCOut?.publishListResults(res)
                }, { e ->
                    //LoggerManager.e(TAG, "Get request list error", e)
                }))
    }

    override fun clearRequests() {
        compositeDisposable.clear()
    }

}