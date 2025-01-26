package com.lfs.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.lfs.common.BaseResponse;
import com.lfs.common.ResultUtils;
import com.lfs.exception.ApiException;
import com.lfs.exception.ErrorCode;
import com.lfs.model.params.*;
import com.lfs.model.response.NameResponse;
import com.lfs.model.response.RandomWallpaperResponse;
import com.lfs.model.response.ResultResponse;
import com.lfs.sentinel.SentinelConstant;
import com.lfs.service.inner.AIChatService;
import com.lfs.utils.RequestUtils;
import com.lfs.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Author: 西尾ink
 * @Date: 2024年08月16日 11:29
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/")
@Slf4j
public class ServiceController {

    @DubboReference
    private AIChatService chatService;

    /**
     * AI聊天
     *
     * @param message 聊天信息
     * @return
     */
    @GetMapping("/chat")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public String getAIChat(String message) {
        if (StringUtils.isBlank(message)) {
            return "发送消息为空";
        }
        String chatInfo = chatService.chat(message);
        log.info(chatInfo);
        return chatInfo;
//        return baseResponse("https://api.vvhan.com/api/weather", weatherParams);
    }

    /**
     * 获取自己的姓名
     *
     * @param nameParams
     * @return
     */
    @GetMapping("/name")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public NameResponse getName(NameParams nameParams) {
        return JSONUtil.toBean(JSONUtil.toJsonStr(nameParams), NameResponse.class);
    }

    /**
     * 土爱情话
     *
     * @return
     */
    @GetMapping("/loveTalk")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public String randomLoveTalk() {
        return RequestUtils.get("https://api.vvhan.com/api/love");
    }

    /**
     * 随机毒鸡汤
     *
     * @return
     */
    @GetMapping("/poisonousChickenSoup")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public String getPoisonousChickenSoup() {
        return RequestUtils.get("https://api.btstu.cn/yan/api.php?charset=utf-8&encode=json");
    }

    /**
     * 随机壁纸
     *
     * @param randomWallpaperParams
     * @return
     * @throws ApiException
     */
    @GetMapping("/randomWallpaper")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public RandomWallpaperResponse randomWallpaper(RandomWallpaperParams randomWallpaperParams) throws ApiException {
        String baseUrl = "https://api.btstu.cn/sjbz/api.php";
        String url = RequestUtils.buildUrl(baseUrl, randomWallpaperParams);
        if (StringUtils.isAllBlank(randomWallpaperParams.getLx(), randomWallpaperParams.getMethod())) {
            url = url + "?format=json";
        } else {
            url = url + "&format=json";
        }
        return JSONUtil.toBean(RequestUtils.get(url), RandomWallpaperResponse.class);
    }


    @PostMapping("/randomWallpaper")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public RandomWallpaperResponse postAndomWallpaper(@RequestBody RandomWallpaperParams randomWallpaperParams) throws ApiException {
        String baseUrl = "https://api.btstu.cn/sjbz/api.php";
        String url = RequestUtils.buildUrl(baseUrl, randomWallpaperParams);
        if (StringUtils.isAllBlank(randomWallpaperParams.getLx(), randomWallpaperParams.getMethod())) {
            url = url + "?format=json";
        } else {
            url = url + "&format=json";
        }
        return JSONUtil.toBean(RequestUtils.get(url), RandomWallpaperResponse.class);
    }

    /**
     * 星座运势
     *
     * @param horoscopeParams
     * @return
     * @throws ApiException
     */
    @GetMapping("/horoscope")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public ResultResponse getHoroscope(HoroscopeParams horoscopeParams) throws ApiException {
        String response = RequestUtils.get("https://api.vvhan.com/api/horoscope", horoscopeParams);
        Map<String, Object> fromResponse = ResponseUtils.responseToMap(response);
        if (fromResponse == null) {
            ResultResponse baseResponse = new ResultResponse();
            baseResponse.setData(fromResponse);
            return baseResponse;
        }
//        boolean success = (boolean) fromResponse.get("success");
//        if (!success) {
//
//        }
        return JSONUtil.toBean(response, ResultResponse.class);
    }

    /**
     * ip信息
     *
     * @param ipInfoParams
     * @return
     */
    @GetMapping("/ipInfo")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public ResultResponse getIpInfo(IpInfoParams ipInfoParams) throws ApiException {
        return ResponseUtils.baseResponse("https://api.vvhan.com/api/getIpInfo", ipInfoParams);
    }

    /**
     * 天气信息
     *
     * @param weatherParams
     * @return
     */
    @GetMapping("/weather")
    @SentinelResource(value = SentinelConstant.apiInterface,
            blockHandler = "handleBlockException",
            fallback = "handleFallback")
    public ResultResponse getWeatherInfo(WeatherParams weatherParams) throws ApiException {
        return ResponseUtils.baseResponse("https://api.vvhan.com/api/weather", weatherParams);
    }

    /**
     * 限流：提示“系统压力过大，请耐心等待”
     * 熔断：执行降级操作
     */
    public BaseResponse handleBlockException(String message, BlockException ex) {
        // 降级操作
        if (ex instanceof DegradeException) {
            return handleFallback(message, ex);
        }
        // 限流操作
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统压力过大，请耐心等待");
    }

    /**
     * listQuestionBankVOByPage 降级操作：直接返回本地数据（此处为了方便演示，写在同一个类中）
     */
    public BaseResponse handleFallback(String message, BlockException ex) {
        // 可以返回本地数据或空数据
        return ResultUtils.success(null);
    }

}
