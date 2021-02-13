package com.randysoft.playfabtest.model.responses

data class LoginResponse(
    val code: Int,
    val `data`: Data,
    val status: String
)
data class Data(
    val EntityToken: EntityToken,
    val LastLoginTime: String,
    val NewlyCreated: Boolean,
    val PlayFabId: String,
    val SessionTicket: String,
    val SettingsForUser: SettingsForUser,
    val TreatmentAssignment: TreatmentAssignment
)
data class Entity(
    val Id: String,
    val Type: String,
    val TypeString: String
)
data class SettingsForUser(
    val GatherDeviceInfo: Boolean,
    val GatherFocusInfo: Boolean,
    val NeedsAttribution: Boolean
)

data class TreatmentAssignment(
    val Variables: List<Any>,
    val Variants: List<Any>
)
data class EntityToken(
    val Entity: Entity,
    val EntityToken: String,
    val TokenExpiration: String
)