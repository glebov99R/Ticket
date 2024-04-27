package com.example.ticket.state

import com.example.ticket.model.local.PlanTicketModelLocal

sealed class GetPlanOfAreaViewState {

    object Idle: GetPlanOfAreaViewState()

    object Loading: GetPlanOfAreaViewState()

    data class Success(
        val item: List<PlanTicketModelLocal>
    ) : GetPlanOfAreaViewState()

    data class Error(
        val message: String,
        val code: Int
    ): GetPlanOfAreaViewState()
}