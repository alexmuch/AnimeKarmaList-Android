package com.example.animekarmalist_android.repository

import com.example.animekarmalist_android.data.remote.responses.AnimeItemsList
import com.example.animekarmalist_android.data.remote.responses.AnimeItem
import com.example.animekarmalist_android.util.Resource

class TestRepository : Repository {
    private val dummyResponse: AnimeItemsList = AnimeItemsList()

    private val item = AnimeItem(
        _id = "1q2w3e4r",
        postId = "af8o9s",
        name = "Kaguya-sama: Love is War",
        episodeNumber = 1,
        commentLink = "https://www.reddit.com/r/anime/comments/af8o9s/kaguyasama_wa_kokurasetai_tensaitachi_no_renai/",
        utcTime = "2021-05-17T16:33:22.000+00:00",
        karma = 8185,
        commentCount = 1541,
        voteLink = "https://youpoll.me/56912/",
        imagePath = "/2020fall/s1kaguya.webp",
        subredditLink = "https://www.reddit.com/r/FumetsuNoAnataE",
        streamLinks = listOf(
            "http://crunchyroll.com/to-your-eternity",
            "https://vrv.co/series/GG5H5XMWV"
        ),
        episodeTotal = 20,
        romaji = "Fumetsu no Anata e",
        native = "不滅のあなたへ",
        genreTags = listOf(
            "Adventure",
            "Drama",
            "Fantasy",
            "Psychological",
            "Supernatural",
            "Tragedy",
            "Shapeshifting"
        ),
        studio = "Brain's Base",
        summary = "A lonely boy wandering the Arctic regions of North America meets a wolf, and the two become fast friends, depending on each other to survive the harsh environment. But the boy has a history, and the wolf is more than meets the eye as well...\n<br><br>\n(Source: Kodansha USA)",
        score = "4.61",
        anilistId = 114535,
        anilistScore = "84",
        malId = 41025,
        malScore = "8.66",
        karmaChange = 123,
        rankChange = "+"
    )

    private val item2 = AnimeItem(
        _id = "9z2w3eyv",
        postId = "nilvi3",
        name = "JUJUTSU KAISEN",
        episodeNumber = 1,
        commentLink = "https://www.reddit.com/r/anime/comments/af8o9s/kaguyasama_wa_kokurasetai_tensaitachi_no_renai/",
        utcTime = "2021-05-17T16:33:22.000+00:00",
        karma = 7380,
        commentCount = 788,
        voteLink = "https://youpoll.me/56912/",
        imagePath = "/2021winter/jujutsu.webp",
        subredditLink = "https://www.reddit.com/r/FumetsuNoAnataE",
        streamLinks = listOf(
            "http://crunchyroll.com/to-your-eternity",
            "https://vrv.co/series/GG5H5XMWV"
        ),
        episodeTotal = 13,
        romaji = "Fumetsu no Anata e",
        native = "不滅のあなたへ",
        genreTags = listOf(
            "Adventure",
            "Drama",
            "Fantasy",
            "Psychological",
            "Supernatural",
            "Tragedy",
            "Shapeshifting"
        ),
        studio = "Brain's Base",
        summary = "A lonely boy wandering the Arctic regions of North America meets a wolf, and the two become fast friends, depending on each other to survive the harsh environment. But the boy has a history, and the wolf is more than meets the eye as well...\n<br><br>\n(Source: Kodansha USA)",
        score = "4.61",
        anilistId = 114535,
        anilistScore = "84",
        malId = 41025,
        malScore = "8.66",
        karmaChange = 123,
        rankChange = "+"
    )

    private val item3 = AnimeItem(
        _id = "9z2w3eyv",
        postId = "nekvs8",
        name = "To Your Eternity",
        episodeNumber = 1,
        commentLink = "https://www.reddit.com/r/anime/comments/nekvs8/fumetsu_no_anata_e_episode_6_discussion/",
        utcTime = "2021-05-17T16:33:22.000+00:00",
        karma = 5210,
        commentCount = 515,
        voteLink = "https://youpoll.me/56912/",
        imagePath = "/2021spring/toyoureternity.webp",
        subredditLink = "https://www.reddit.com/r/FumetsuNoAnataE",
        streamLinks = listOf(
            "http://crunchyroll.com/to-your-eternity",
            "https://vrv.co/series/GG5H5XMWV"
        ),
        episodeTotal = 13,
        romaji = "Fumetsu no Anata e",
        native = "不滅のあなたへ",
        genreTags = listOf(
            "Adventure",
            "Drama",
            "Fantasy",
            "Psychological",
            "Supernatural",
            "Tragedy",
            "Shapeshifting"
        ),
        studio = "Brain's Base",
        summary = "A lonely boy wandering the Arctic regions of North America meets a wolf, and the two become fast friends, depending on each other to survive the harsh environment. But the boy has a history, and the wolf is more than meets the eye as well...\n<br><br>\n(Source: Kodansha USA)",
        score = "4.61",
        anilistId = 114535,
        anilistScore = "84",
        malId = 41025,
        malScore = "8.66",
        karmaChange = 123,
        rankChange = "+"
    )

    private val item4 = AnimeItem(
        _id = "9z2w3eyv",
        postId = "nilvi2",
        name = "Vivy -Fluorite Eye's Song-",
        episodeNumber = 1,
        commentLink = "https://www.reddit.com/r/anime/comments/nekvs8/fumetsu_no_anata_e_episode_6_discussion/",
        utcTime = "2021-05-17T16:33:22.000+00:00",
        karma = 5098,
        commentCount = 734,
        voteLink = "https://youpoll.me/56912/",
        imagePath = "/2021spring/vivy.webp",
        subredditLink = "https://www.reddit.com/r/FumetsuNoAnataE",
        streamLinks = listOf(
            "http://crunchyroll.com/to-your-eternity",
            "https://vrv.co/series/GG5H5XMWV"
        ),
        episodeTotal = 13,
        romaji = "Fumetsu no Anata e",
        native = "不滅のあなたへ",
        genreTags = listOf(
            "Adventure",
            "Drama",
            "Fantasy",
            "Psychological",
            "Supernatural",
            "Tragedy",
            "Shapeshifting"
        ),
        studio = "Brain's Base",
        summary = "A lonely boy wandering the Arctic regions of North America meets a wolf, and the two become fast friends, depending on each other to survive the harsh environment. But the boy has a history, and the wolf is more than meets the eye as well...\n<br><br>\n(Source: Kodansha USA)",
        score = "4.61",
        anilistId = 114535,
        anilistScore = "84",
        malId = 41025,
        malScore = "8.66",
        karmaChange = 123,
        rankChange = "+"
    )

    init {
        dummyResponse.addAll(
            listOf(
                item,
                item2,
                item3,
                item4,
                item,
                item2,
                item3,
                item4,
                item,
                item2,
                item3,
                item4
            )
        )
    }

    override suspend fun getWeekList(
        start: String,
        end: String,
        offset: Int
    ): Resource<AnimeItemsList> {
        return Resource.Success(dummyResponse)
    }

    override suspend fun getSearchList(
        search: String,
        offset: Int
    ): Resource<AnimeItemsList> {
        return Resource.Success(dummyResponse)
    }
}