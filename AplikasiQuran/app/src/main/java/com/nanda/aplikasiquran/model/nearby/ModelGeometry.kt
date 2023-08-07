package com.nanda.aplikasiquran.model.nearby

import com.google.gson.annotations.SerializedName
import com.nanda.aplikasiquran.model.nearby.ModelLocation


class ModelGeometry {
    @SerializedName("location")
    lateinit var modelLocation: ModelLocation
}