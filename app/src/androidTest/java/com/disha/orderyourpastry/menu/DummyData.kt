package com.disha.orderyourpastry.menu

import com.disha.orderyourpastry.R

object DummyData {
    fun getPastryList(): List<PastryDataModel> =
        mutableListOf<PastryDataModel>().apply {
            add(PastryDataModel("Carrot Cake", R.drawable.carrot_cake, 30.00F))
            add(PastryDataModel("Faying Cake", R.drawable.flying_cake, 40.00F))
            add(PastryDataModel("Italian Galato", R.drawable.italian_galato, 50.00F))
            add(PastryDataModel("Almond Pastry", R.drawable.almond_pastry, 50.00F))
            add(PastryDataModel("Apple Roses", R.drawable.apple_roses, 50.00F))
            add(PastryDataModel("Apricot Jam", R.drawable.apricot_jam, 50.00F))
            add(PastryDataModel("Brown Sugar & Walnut", R.drawable.brown_sugar_and_walnut, 50.00F))
            add(
                PastryDataModel(
                    "Burch & Purchese Sweet studio",
                    R.drawable.burch_and_purchese_sweet_studio,
                    50.00F
                )
            )
            add(PastryDataModel("Cherry tartlets", R.drawable.cherry_tartlets, 50.00F))
            add(PastryDataModel("Chocolate Cream Pie", R.drawable.chocolate_cream_pie, 50.00F))
            add(PastryDataModel("Flor", R.drawable.flor, 50.00F))
            add(PastryDataModel("Full Unicorn", R.drawable.full_unicorn, 50.00F))
            add(
                PastryDataModel(
                    "Ginger Crusted Cranberry Orange Cheese Cake",
                    R.drawable.ginger_crusted_cranberry_orange_cheese_cake,
                    50.00F
                )
            )
            add(
                PastryDataModel(
                    "Guava Cream Cheese Puffs", R.drawable.guava_cream_cheese_puffs,
                    50.00F
                )
            )
            add(PastryDataModel("Mango Caramel Angel", R.drawable.mango_caramel_angel, 50.00F))
            add(
                PastryDataModel(
                    "Mini Cheese Cake Nests",
                    R.drawable.mini_cheese_cake_nests,
                    50.00F
                )
            )
            add(PastryDataModel("Puff Pastry", R.drawable.puff_pastry, 50.00F))
            add(PastryDataModel("Raspberry napoleon", R.drawable.raspberry_napoleon, 50.00F))
            add(PastryDataModel("Red Velvet", R.drawable.red_velvet, 50.00F))
            add(PastryDataModel("Rose Kaju Bon Bons", R.drawable.rose_kaju_bon_bons, 50.00F))
            add(PastryDataModel("Strawberry Ice Box", R.drawable.strawberry_ice_box, 50.00F))
            add(PastryDataModel("tartine", R.drawable.tartine, 50.00F))
            add(PastryDataModel("Ube Leche Flan", R.drawable.ube_leche_flan, 50.00F))
            add(PastryDataModel("Italian Galato", R.drawable.italian_galato, 50.00F))
        }
}