package com.tlabs.eve.esi.impl;

import org.devfleet.esi.model.GetCharactersCharacterIdOrders200Ok;
import org.devfleet.esi.model.GetMarketsGroupsMarketGroupIdOk;
import org.devfleet.esi.model.GetMarketsPrices200Ok;
import org.devfleet.esi.model.GetMarketsRegionIdHistory200Ok;
import org.devfleet.esi.model.GetMarketsRegionIdOrders200Ok;
import org.devfleet.esi.model.GetMarketsStructuresStructureId200Ok;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;
//FUCKING FIX FOR ESI WITH SWAGGER PARAMS ALL MIXED UP (PATH PARAM VS QUERY)
public interface MarketApi2 {
  /**
   * List orders from a character
   * List market orders placed by a character  --- Alternate route: &#x60;/v1/characters/{character_id}/orders/&#x60;  Alternate route: &#x60;/legacy/characters/{character_id}/orders/&#x60;  Alternate route: &#x60;/dev/characters/{character_id}/orders/&#x60;  --- This route is cached for up to 3600 seconds
   * @param characterId An EVE character ID (required)
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param token Access token to use if unable to set a header (optional)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;List<GetCharactersCharacterIdOrders200Ok>&gt;
   */

  @GET("characters/{character_id}/orders/")
  Call<List<GetCharactersCharacterIdOrders200Ok>> getCharactersCharacterIdOrders(
          @Path("character_id") Integer characterId, @Query("datasource") String datasource, @Query("token") String token, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

  /**
   * Get item groups
   * Get a list of item groups  --- Alternate route: &#x60;/v1/markets/groups/&#x60;  Alternate route: &#x60;/legacy/markets/groups/&#x60;  Alternate route: &#x60;/dev/markets/groups/&#x60;  --- This route expires daily at 11:05
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;List<Integer>&gt;
   */

  @GET("markets/groups/")
  Call<List<Integer>> getMarketsGroups(
          @Query("datasource") String datasource, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

  /**
   * Get item group information
   * Get information on an item group  --- Alternate route: &#x60;/v1/markets/groups/{market_group_id}/&#x60;  Alternate route: &#x60;/legacy/markets/groups/{market_group_id}/&#x60;  Alternate route: &#x60;/dev/markets/groups/{market_group_id}/&#x60;  --- This route expires daily at 11:05
   * @param marketGroupId An Eve item group ID (required)
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param language Language to use in the response (optional, default to en-us)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;GetMarketsGroupsMarketGroupIdOk&gt;
   */

  @GET("markets/groups/{market_group_id}/")
  Call<GetMarketsGroupsMarketGroupIdOk> getMarketsGroupsMarketGroupId(
          @Path("market_group_id") Integer marketGroupId, @Query("datasource") String datasource, @Query("language") String language, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

  /**
   * List market prices
   * Return a list of prices  --- Alternate route: &#x60;/v1/markets/prices/&#x60;  Alternate route: &#x60;/legacy/markets/prices/&#x60;  Alternate route: &#x60;/dev/markets/prices/&#x60;  --- This route is cached for up to 3600 seconds
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;List<GetMarketsPrices200Ok>&gt;
   */

  @GET("markets/prices/")
  Call<List<GetMarketsPrices200Ok>> getMarketsPrices(
          @Query("datasource") String datasource, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

  /**
   * List historical market statistics in a region
   * Return a list of historical market statistics for the specified type in a region  --- Alternate route: &#x60;/v1/markets/{region_id}/history/&#x60;  Alternate route: &#x60;/legacy/markets/{region_id}/history/&#x60;  Alternate route: &#x60;/dev/markets/{region_id}/history/&#x60;  --- This route is cached for up to 3600 seconds
   * @param regionId Return statistics in this region (required)
   * @param typeId Return statistics for this type (required)
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;List<GetMarketsRegionIdHistory200Ok>&gt;
   */

  @GET("markets/{region_id}/history/")
  Call<List<GetMarketsRegionIdHistory200Ok>> getMarketsRegionIdHistory(
          @Path("region_id") Integer regionId, @Query("type_id") Integer typeId, @Query("datasource") String datasource, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

  /**
   * List orders in a region
   * Return a list of orders in a region  --- Alternate route: &#x60;/v1/markets/{region_id}/orders/&#x60;  Alternate route: &#x60;/legacy/markets/{region_id}/orders/&#x60;  Alternate route: &#x60;/dev/markets/{region_id}/orders/&#x60;  --- This route is cached for up to 300 seconds
   * @param orderType Filter buy/sell orders, return all orders by default. If you query without type_id, we always return both buy and sell orders. (required)
   * @param regionId Return orders in this region (required)
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param page Which page of results to return (optional, default to 1)
   * @param typeId Return orders only for this type (optional)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;List<GetMarketsRegionIdOrders200Ok>&gt;
   */

  @GET("markets/{region_id}/orders/")
  Call<List<GetMarketsRegionIdOrders200Ok>> getMarketsRegionIdOrders(
          @Path("region_id") Integer regionId, @Query("order_type") String orderType, @Query("datasource") String datasource, @Query("page") Integer page, @Query("type_id") Integer typeId, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

  /**
   * List orders in a structure
   * Return all orders in a structure  --- Alternate route: &#x60;/v1/markets/structures/{structure_id}/&#x60;  Alternate route: &#x60;/legacy/markets/structures/{structure_id}/&#x60;  Alternate route: &#x60;/dev/markets/structures/{structure_id}/&#x60;  --- This route is cached for up to 300 seconds
   * @param structureId Return orders in this structure (required)
   * @param datasource The server name you would like data from (optional, default to tranquility)
   * @param page Which page of results to return (optional, default to 1)
   * @param token Access token to use if unable to set a header (optional)
   * @param userAgent Client identifier, takes precedence over headers (optional)
   * @param xUserAgent Client identifier, takes precedence over User-Agent (optional)
   * @return Call&lt;List<GetMarketsStructuresStructureId200Ok>&gt;
   */

  @GET("markets/structures/{structure_id}/")
  Call<List<GetMarketsStructuresStructureId200Ok>> getMarketsStructuresStructureId(
          @Path("structure_id") Long structureId, @Query("datasource") String datasource, @Query("page") Integer page, @Query("token") String token, @Query("user_agent") String userAgent, @Header("X-User-Agent") String xUserAgent
  );

}
