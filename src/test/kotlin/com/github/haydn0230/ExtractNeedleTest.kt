package com.skybet.ksqludf

import com.github.haydn0230.ExtractNeedle
import io.kotest.assertions.asClue
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.apache.kafka.connect.data.Schema
import org.apache.kafka.connect.data.SchemaBuilder
import org.apache.kafka.connect.data.SchemaBuilder.struct
import org.apache.kafka.connect.data.Struct

class ExtractIdTest : StringSpec(){

    init {
        "when an array of structs are passed in then a struct should be returned " {
            val schema = SchemaBuilder
                    .struct()
                .name("com.github.Haydn0230.Haystack")
                .field("TYPE", Schema.STRING_SCHEMA)
                .field("ID", Schema.STRING_SCHEMA).build()

            val testData = listOf(
                Struct(schema).put("TYPE", "NEEDLE").put("ID", "2"),
                Struct(schema).put("TYPE", "HAY").put("ID", "1"),
            )

            ExtractNeedle().getNeedle(testData).asClue {
                it shouldNotBe null
                it.get("TYPE") shouldBe  "NEEDLE"
            }
        }
    }


}
