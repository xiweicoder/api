package com.lfs.service.impi;

import com.lfs.model.request.*;
import com.lfs.model.response.ResultResponse;
import com.lfs.client.ApiClient;
import com.lfs.exception.ApiException;
import com.lfs.model.response.LoveResponse;
import com.lfs.model.response.PoisonousChickenSoupResponse;
import com.lfs.model.response.RandomWallpaperResponse;
import com.lfs.service.ApiService;
import com.lfs.service.BaseService;
import lombok.extern.slf4j.Slf4j;


/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:42
 * @Version: 1.0
 * @Description:
 */
@Slf4j
public class ApiServiceImpl extends BaseService implements ApiService {

    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() throws ApiException {
        PoisonousChickenSoupRequest request = new PoisonousChickenSoupRequest();
        return request(request);
    }

    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup(ApiClient apiClient) throws ApiException {
        PoisonousChickenSoupRequest request = new PoisonousChickenSoupRequest();
        return request(apiClient, request);
    }

    @Override
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public RandomWallpaperResponse getRandomWallpaper(ApiClient apiClient, RandomWallpaperRequest request) throws ApiException {
        return request(apiClient, request);
    }

    @Override
    public LoveResponse randomLoveTalk() throws ApiException {
        LoveRequest request = new LoveRequest();
        return request(request);
    }

    @Override
    public LoveResponse randomLoveTalk(ApiClient apiClient) throws ApiException {
        LoveRequest request = new LoveRequest();
        return request(apiClient, request);
    }

    @Override
    public ResultResponse horoscope(HoroscopeRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public ResultResponse horoscope(ApiClient apiClient, HoroscopeRequest request) throws ApiException {
        return request(apiClient, request);
    }

    @Override
    public ResultResponse getIpInfo(ApiClient apiClient, IpInfoRequest request) throws ApiException {
        return request(apiClient, request);
    }

    @Override
    public ResultResponse getIpInfo(IpInfoRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public ResultResponse getWeatherInfo(ApiClient apiClient, WeatherRequest request) throws ApiException {
        return request(apiClient, request);
    }

    @Override
    public ResultResponse getWeatherInfo(WeatherRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public ResultResponse getChat(ApiClient apiClient, ChatRequest request) throws ApiException {
        return request(apiClient, request);
    }

    @Override
    public ResultResponse getChat(ChatRequest request) throws ApiException {
        return request(request);
    }
}
