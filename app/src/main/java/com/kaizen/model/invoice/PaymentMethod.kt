package com.kaizen.model.invoice

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class PaymentMethod : Serializable {
    @SerializedName("0")
    None,

    @SerializedName("1")
    Cash,

    @SerializedName("2")
    CreditCard,

    @SerializedName("3")
    BankDeposit
}
