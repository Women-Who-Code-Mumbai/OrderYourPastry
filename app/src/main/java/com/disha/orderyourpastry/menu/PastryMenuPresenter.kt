package com.disha.orderyourpastry.menu

class PastryMenuPresenter(private val view: MenuContract.View) :
    MenuContract.Presenter, MenuContract.AdapterPresenter {

    private val pastryList: List<PastryDataModel> by lazy { PastryMenuModel().getPastryList() }

    override fun getAdapterCount(): Int = pastryList.size

    override fun getAdapterEntity(position: Int): PastryDataModel = pastryList[position]

    override fun itemClicked(position: Int) {
        view.showPastryOrderScreen(getAdapterEntity(position))
    }

}