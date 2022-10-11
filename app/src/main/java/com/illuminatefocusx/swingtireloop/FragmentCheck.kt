package com.illuminatefocusx.swingtireloop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_check.*

class FragmentCheck : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_check,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        checkRecyclerView.layoutManager = GridLayoutManager(context, 2)

        val data = ArrayList<ItemsViewModel>(

        )
        val data2 = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel(R.drawable.avokado, "Авокадо"))
        data.add(ItemsViewModel(R.drawable.banans, "Бананы"))
        data.add(ItemsViewModel(R.drawable.chechevica, "Чечевица"))
        data.add(ItemsViewModel(R.drawable.gorowek_green, "Горошек"))
        data.add(ItemsViewModel(R.drawable.goviadina, "Говядина"))
        data.add(ItemsViewModel(R.drawable.gre4ka, "Гречка"))
        data.add(ItemsViewModel(R.drawable.iaico, "Яйца"))
        data.add(ItemsViewModel(R.drawable.kartofel, "Картофель"))
        data.add(ItemsViewModel(R.drawable.klubnika, "Клубника"))
        data.add(ItemsViewModel(R.drawable.kobachek, "Кабачок"))
        data.add(ItemsViewModel(R.drawable.kukuruza, "Кукуруза"))
        data.add(ItemsViewModel(R.drawable.kurica, "Курица"))
        data.add(ItemsViewModel(R.drawable.mindal, "Миндаль"))
        data.add(ItemsViewModel(R.drawable.pomidors, "Помидоры"))
        data.add(ItemsViewModel(R.drawable.ris_white, "Рис"))
        data.add(ItemsViewModel(R.drawable.spagetti, "Спагетти"))
        data.add(ItemsViewModel(R.drawable.tikva, "Тыква"))

        for (i in 1..10) {
            val kick = data.random()
            data2.add(kick)
            data.remove(kick)
        }

        val adapter = CustomAdapter(data2)

        checkRecyclerView.adapter = adapter


    }

}
