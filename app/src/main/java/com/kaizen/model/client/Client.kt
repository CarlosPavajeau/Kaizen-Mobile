package com.kaizen.model.client

import com.google.gson.annotations.SerializedName
import com.kaizen.model.applicationuser.ApplicationUser
import java.io.Serializable

data class Client(
    @SerializedName("id") val id: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String
) : Serializable {
    @SerializedName("secondName")
    lateinit var secondName: String

    @SerializedName("secondLastName")
    lateinit var secondLastName: String

    @SerializedName("userId")
    lateinit var userId: String

    @SerializedName("user")
    lateinit var user: ApplicationUser

    @SerializedName("clientType")
    lateinit var clientType: String

    @SerializedName("nit")
    lateinit var nit: String

    @SerializedName("businessName")
    lateinit var businessName: String

    @SerializedName("tradeName")
    lateinit var tradeName: String

    @SerializedName("firstPhoneNumber")
    lateinit var firstPhoneNumber: String

    @SerializedName("secondPhoneNumber")
    lateinit var secondPhoneNumber: String

    @SerializedName("firstLandLine")
    lateinit var firstLandLine: String

    @SerializedName("secondLandLine")
    lateinit var secondLandLine: String

    @SerializedName("contactPeople")
    lateinit var contactPeople: List<ContactPerson>

    @SerializedName("clientAddress")
    lateinit var clientAddress: ClientAddress

    @SerializedName("state")
    lateinit var state: ClientState
}
