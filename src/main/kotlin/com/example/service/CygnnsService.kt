package com.example.service

import com.example.models.CsvData
import com.opencsv.CSVReaderBuilder
import java.io.FileReader

class CygnnsService {

    fun readCsvFile(filePath: String): List<CsvData> {
        val reader = CSVReaderBuilder(FileReader(filePath))
            .withSkipLines(1) // Skip header row
            .build()

        val csvDataList = mutableListOf<CsvData>()
        var line: Array<String>?
        while (reader.readNext().also { line = it } != null) {
            val csvData = CsvData(line!![1].toFloat(), line!![2].toFloat(), line!![3].toFloat())
            csvDataList.add(csvData)
        }
        return csvDataList
    }
}

val cygnnsService = CygnnsService()
