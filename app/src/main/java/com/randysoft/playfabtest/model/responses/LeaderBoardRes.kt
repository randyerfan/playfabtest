package com.randysoft.playfabtest.model.responses

data class LeaderBoardRes(
    val code: Int,
    val `data`: LeaderBoardData,
    val status: String
)
data class Profile(
    val DisplayName: String,
    val PlayerId: String,
    val PublisherId: String,
    val TitleId: String
)
data class LeaderBoardData(
    val Leaderboard: List<Leaderboard>,
    val Version: Int
)
data class Leaderboard(
    val DisplayName: String,
    val PlayFabId: String,
    val Position: Int,
    val Profile: Profile,
    val StatValue: Int
)