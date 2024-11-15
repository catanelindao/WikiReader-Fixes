package org.nsh07.wikireader.network

import org.nsh07.wikireader.data.WikiApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_QUERY =
    "w/api.php?format=json&action=query&prop=extracts|pageimages|pageterms&piprop=original&pilicense=any&explaintext&generator=search&gsrlimit=1&redirects=1&formatversion=2"

interface WikipediaApiService {
    @GET(API_QUERY)
    suspend fun searchWikipedia(@Query("gsrsearch") query: String): WikiApiResponse
}
