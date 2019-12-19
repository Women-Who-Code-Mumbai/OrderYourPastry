package com.disha.orderyourpastry.menu

interface MenuContract {
    interface View {
        fun showPastryList(show: Boolean)
        fun showPastryOrderScreen(pastryDataModel: PastryDataModel)
    }

    interface Presenter

    interface AdapterPresenter {
        fun getAdapterCount(): Int
        fun getAdapterEntity(position: Int): PastryDataModel
        fun itemClicked(position: Int)
    }

    interface Model {
        fun getPastryList(): List<PastryDataModel>
    }
}