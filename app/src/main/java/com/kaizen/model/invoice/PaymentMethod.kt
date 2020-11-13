package com.kaizen.model.invoice

import com.google.gson.annotations.SerializedName

enum class PaymentMethod {
    @SerializedName("0")
    None,

    @SerializedName("1")
    Cash,

    @SerializedName("2")
    CreditCard,

    @SerializedName("3")
    BankDeposit
}
