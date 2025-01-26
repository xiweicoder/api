package com.lfs.service;

import cn.hutool.http.HttpResponse;
import com.lfs.client.ApiClient;
import com.lfs.model.request.*;
import com.lfs.model.response.ResultResponse;
import com.lfs.exception.ApiException;
import com.lfs.model.response.LoveResponse;
import com.lfs.model.response.PoisonousChickenSoupResponse;
import com.lfs.model.response.RandomWallpaperResponse;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月17日 08:34
 * @Version: 1.0
 * @Description:
 */
public interface ApiService {
    /**
     * 通用请求
     *
     * @param request 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */

    <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException;

    /**
     * 通用请求
     *
     * @param apiClient qi api客户端
     * @param request   要求
     * @return {@link T}
     * @throws ApiException 业务异常
     */
    <O, T extends ResultResponse> T request(ApiClient apiClient, BaseRequest<O, T> request) throws ApiException;


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     * @throws ApiException 业务异常
     */
    PoisonousChickenSoupResponse getPoisonousChickenSoup() throws ApiException;

    /**
     * 喝毒鸡汤
     *
     * @param apiClient qi api客户端
     * @return {@link PoisonousChickenSoupResponse}
     * @throws ApiException 业务异常
     */
    PoisonousChickenSoupResponse getPoisonousChickenSoup(ApiClient apiClient) throws ApiException;

    /**
     * 获取随机壁纸
     *
     * @param request 要求
     * @return {@link RandomWallpaperResponse}
     * @throws ApiException 业务异常
     */
    RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException;

    /**
     * 获取随机壁纸
     *
     * @param apiClient qi api客户端
     * @param request   要求
     * @return {@link RandomWallpaperResponse}
     * @throws ApiException 业务异常
     */
    RandomWallpaperResponse getRandomWallpaper(ApiClient apiClient, RandomWallpaperRequest request) throws ApiException;

    /**
     * 随意情话
     *
     * @return {@link LoveResponse}
     * @throws ApiException 业务异常
     */
    LoveResponse randomLoveTalk() throws ApiException;

    /**
     * 随意情话
     *
     * @param apiClient qi api客户端
     * @return {@link LoveResponse}
     * @throws ApiException 业务异常
     */
    LoveResponse randomLoveTalk(ApiClient apiClient) throws ApiException;

    /**
     * 星座运势
     *
     * @param request 要求
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse horoscope(HoroscopeRequest request) throws ApiException;

    /**
     * 星座运势
     *
     * @param apiClient qi api客户端
     * @param request   要求
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse horoscope(ApiClient apiClient, HoroscopeRequest request) throws ApiException;

    /**
     * 获取ip信息
     *
     * @param apiClient qi api客户端
     * @param request   要求
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getIpInfo(ApiClient apiClient, IpInfoRequest request) throws ApiException;

    /**
     * 获取ip信息
     *
     * @param request 要求
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getIpInfo(IpInfoRequest request) throws ApiException;

    /**
     * 获取天气信息
     *
     * @param apiClient qi api客户端
     * @param request   要求
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getWeatherInfo(ApiClient apiClient, WeatherRequest request) throws ApiException;


    /**
     * 获取天气信息
     *
     * @param request 要求
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getWeatherInfo(WeatherRequest request) throws ApiException;


    ResultResponse getChat(ApiClient apiClient, ChatRequest request) throws ApiException;

    ResultResponse getChat(ChatRequest request) throws ApiException;
}
