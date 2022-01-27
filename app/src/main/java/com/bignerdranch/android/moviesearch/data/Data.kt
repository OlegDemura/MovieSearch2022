package com.bignerdranch.android.moviesearch.data

import com.bignerdranch.android.moviesearch.R
import com.bignerdranch.android.moviesearch.model.Film

class Data {
    private val film1 = Film(
        "Убийца",
        "Безлюдные пустоши, по которым проходит граница между " +
                "Мексикой и США, – это территория без правил, поле битвы между мексиканскими наркокартелями " +
                "и американскими спецслужбами. Агент ФБР Кейт Мэйсер, которая работает в приграничных районах," +
                "старается придерживаться собственных идеалов, хотя и начинает ощущать, что исход войны с " +
                "наркотрафиком складывается не в пользу служителей закона. Однажды ей предоставляется шанс принять " +
                "участие в работе элитного подразделения по борьбе с наркотиками, возглавляемого агентом Мэттом Грейвером. " +
                "Самый загадочный участник команды – местный консультант, человек без имени, привычек, и, кажется, без прошлого. " +
                "Его истинное лицо откроется только в ходе рискованной операции, во время которой " +
                "Кейт будет вынуждена поступиться собственными принципами, чтобы остаться в живых.",
        R.drawable.sicario
    )


    private val film2 = Film(
        "Джон Уик",
        "Джон Уик - на первый взгляд, самый обычный среднестатистический американец, " +
                "который ведет спокойную мирную жизнь. Однако мало кто знает, что он был наёмным убийцей, " +
                "причём одним из лучших профессионалов в своём деле.\n\n" +
                "После того как сынок главы бандитской группы со своими приятелями угоняет его любимый " +
                "«Мустанг» 1969 года выпуска, при этом убив его собаку Дейзи, которая была подарком недавно " +
                "почившей супруги, Джон вынужден вернуться к своему прошлому. " +
                "Теперь Уик начинает охоту за теми, кто имел неосторожность перейти ему дорогу, и он готов на всё, чтобы отомстить.",
        R.drawable.john_wick
    )


    private val film3 = Film(
        "Бойцовский клуб",
        "Сотрудник страховой компании страдает хронической бессонницей и отчаянно пытается " +
                "вырваться из мучительно скучной жизни. Однажды в очередной командировке он встречает " +
                "некоего Тайлера Дёрдена — харизматического торговца мылом с извращенной философией. " +
                "Тайлер уверен, что самосовершенствование — удел слабых, а единственное, ради чего стоит жить — саморазрушение.\n\n" +
                "Проходит немного времени, и вот уже новые друзья лупят друг друга почем зря на стоянке перед баром, " +
                "и очищающий мордобой доставляет им высшее блаженство. Приобщая других мужчин " +
                "к простым радостям физической жестокости, они основывают тайный Бойцовский клуб, " +
                "который начинает пользоваться невероятной популярностью.",
        R.drawable.boytsovskiy_klub
    )

    val list: Array<Film> = arrayOf(film1, film2, film3)

}
