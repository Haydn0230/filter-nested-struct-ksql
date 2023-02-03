package com.github.haydn0230

import io.confluent.ksql.function.udf.Udf
import io.confluent.ksql.function.udf.UdfDescription
import io.confluent.ksql.function.udf.UdfParameter
import org.apache.kafka.connect.data.Struct


@UdfDescription(
    name = "EXTRACT_NEEDLE",
    category = "SCALAR",
    author = "Haydn Brierley-Jones",
    version = "1.6.0",
    description = "Extracts a needle from a haystack"
)
class ExtractNeedle {
    private val TYPE_TO_FILTER_BY = "NEEDLE"

    @Udf(
        description = "Removes a needle from a haystack",
        schema = "STRUCT<TYPE STRING, ID STRING>"
    )
    fun getNeedle(
        @UdfParameter(
            schema = "ARRAY<STRUCT<TYPE STRING, ID STRING>>",
            value = "HAYSTACK"
        ) haystack: List<Struct>
    ) = haystack.first() { it.get("TYPE") == TYPE_TO_FILTER_BY }

}



