package com.kaizen.model.servicerequest

import java.io.Serializable

enum class ServiceRequestState : Serializable {
    Pending,
    Accepted,
    Rejected,
    PendingSuggestedDate
}
