package com.example.animekarmalist_android.data.remote.responses

data class AnimeItem(
    val _id: String,
    val anilistId: Int,
    val anilistScore: String,
    val commentCount: Int,
    val commentLink: String,
    val episodeNumber: Int,
    val episodeTotal: Int,
    val genreTags: List<String>,
    val imagePath: String,
    val karma: Int,
    val karmaChange: Int,
    val malId: Int,
    val malScore: String,
    val name: String,
    val native: String,
    val postId: String,
    val rankChange: String,
    val romaji: String,
    val score: String,
    val streamLinks: List<String>,
    val studio: String,
    val subredditLink: String,
    val summary: String,
    val utcTime: String,
    val voteLink: String
)