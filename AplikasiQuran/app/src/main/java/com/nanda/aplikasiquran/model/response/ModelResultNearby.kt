package com.nanda.aplikasiquran.model.response

import com.google.gson.annotations.SerializedName
import com.nanda.aplikasiquran.model.nearby.ModelResults

class ModelResultNearby {
    @SerializedName("results")
    lateinit var modelResults: List<ModelResults>
}